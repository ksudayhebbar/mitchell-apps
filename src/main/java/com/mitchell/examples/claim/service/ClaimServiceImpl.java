/**
 * 
 */
package com.mitchell.examples.claim.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mitchell.examples.claim.dto.ClaimRequestService;
import com.mitchell.examples.claim.dto.VehicleInformationDTO;
import com.mitchell.examples.common.ServiceStatus;
import com.mitchell.examples.dao.repository.ClaimRepository;
import com.mitchell.examples.entity.Claim;
import com.mitchell.examples.entity.Vehicle;
import com.mitchell.examples.exception.ServiceDAOException;
import com.mitchell.examples.exception.ServiceInputValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author uday
 *
 */
@Service
final class ClaimServiceImpl implements ClaimService
{

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private LookUpFactory lookUpFactory;

    @Override
    @Transactional
    public Map<String, String> create(ClaimRequestService requestData) throws ServiceDAOException
    {

        Map<String, String> responseObject = new HashMap<String, String>();
        try
        {

            Claim mitchellClaimEntity = buildMitchellClaimEntity(requestData);
            Claim savedClaim = claimRepository.saveAndFlush(mitchellClaimEntity);
            responseObject = buildResponseObject(savedClaim, ServiceStatus.SUCCESS.toString());
        } catch (Exception e)
        {
            responseObject.put("RecordStatus", ServiceStatus.ERROR.toString());

            throw new ServiceDAOException("Creating failed", e);
        }
        return responseObject;
    }

    private Claim buildMitchellClaimEntity(ClaimRequestService requestData)
    {
        Claim claim = null;
        String claimNumber = requestData.getClaimNumber();
        String causeOfLoss = requestData.getLossInfo().getCauseOfLoss();
        Integer causeCode = getCauseCode(causeOfLoss);

        if (claimNumber != null)
        {
            String firstName = requestData.getClaimantFirstName();
            String lastName = requestData.getClaimantLastName();
            Integer assignedAdjusterID = requestData.getAssignedAdjusterID();
            Date lossDate = requestData.getLossDate();
            String status = requestData.getStatus();
            Date reportedDate = requestData.getLossInfo().getReportedDate();

            Set<Vehicle> vehicle = buildVehicle(requestData.getVehicles(), claimNumber);
            claim = new Claim.ClaimBuilder().ClaimNumber(claimNumber).FirstName(firstName).CauseOfLossCode(causeCode)
                    .LastName(lastName).LossDate(lossDate).Status(status).ReportedDate(reportedDate).Vehicle(vehicle)
                    .AssignedAdjusterID(assignedAdjusterID).createClaim();
        } else
        {
            throw new ServiceInputValidationException("Claim number is mandatory  ");
        }

        return claim;
    }

    private Integer getCauseCode(String causeOfLoss)
    {
        Integer causeOfcode = null;
        for (Map.Entry<Integer, String> lookup : lookUpFactory.getLossInfoLookup().entrySet())
        {
            if (lookup.getValue().equalsIgnoreCase(causeOfLoss))
            {
                causeOfcode = lookup.getKey();
            }
        }
        return causeOfcode;
    }

    private Set<Vehicle> buildVehicle(VehicleInformationDTO vehicles, String claimNumber)
    {
        Set<Vehicle> tempVehicles = new HashSet<Vehicle>();

        String vin = vehicles.getVin();
        String engineDescription = vehicles.getEngineDescription();
        if (vin != null && engineDescription != null)
        {
            String damageDescription = vehicles.getDamageDescription();
            String exteriorColor = vehicles.getExteriorColor();
            String licPlate = vehicles.getLicPlate();
            Date licPlateExpDate = vehicles.getLicPlateExpDate();
            String licPlateState = vehicles.getLicPlateState();
            String makeDescription = vehicles.getMakeDescription();
            int modelYear = vehicles.getModelYear();
            String modelDescription = vehicles.getModelDescription();
            Integer mileage = vehicles.getMileage();

            Vehicle vehicle = new Vehicle.VehicleBuilder().DamageDescription(damageDescription)
                    .ClaimNumber(claimNumber).EngineDescription(engineDescription).ExteriorColor(exteriorColor)
                    .LicPlate(licPlate).LicPlateExpDate(licPlateExpDate).LicPlateState(licPlateState)
                    .MakeDescription(makeDescription).ModelYear(modelYear).Mileage(mileage)
                    .ModelDescription(modelDescription).Vin(vin).createVehicle();
            tempVehicles.add(vehicle);
        } else
        {
            throw new ServiceInputValidationException("Vin / Engine description is mandatory  ");

        }
        return tempVehicles;

    }

    private Map<String, String> buildResponseObject(Claim mitchellClaim, String recordStatus)
            throws JsonProcessingException
    {

        Map<String, String> result = new HashMap<String, String>();
        result.put("RecordStatus", recordStatus);
        result.put("ClaimID", mitchellClaim.getId());
        result.put("claimantFirstName", mitchellClaim.getClaimantFirstName());
        result.put("ClaimantLastName", mitchellClaim.getClaimantLastName());
        result.put("Status", mitchellClaim.getStatus());
        result.put("LossDate", mitchellClaim.getLossDate().toString());
        result.put("CauseOfLossCode", mitchellClaim.getInfo().getCauseOfLossCode().toString());
        result.put("LossDescription", mitchellClaim.getInfo().getLossDescription());
        result.put("LossDescription", mitchellClaim.getInfo().getReportedDate().toString());
        Set<Vehicle> vehicle = mitchellClaim.getVehicle();

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String vehicles = ow.writeValueAsString(vehicle);
        result.put("vehicles", vehicles);
        return result;
    }

    @Override
    public Map<String, String> findById(String id) throws ServiceDAOException
    {
        Map<String, String> responseObject = new HashMap<String, String>();

        try
        {

            Claim one = claimRepository.getOne(id);
            responseObject = buildResponseObject(one, ServiceStatus.READ.toString());
        } catch (Exception e)
        {

            responseObject.put("RecordStatus", ServiceStatus.ERROR.toString());
            throw new ServiceDAOException("Read failed", e);
        }

        return responseObject;
    }

    public List<HashMap<String, String>> findall()
    {

        List<Claim> claims = claimRepository.findAll();
        HashMap<String, String> responseObject = new HashMap<String, String>();
        List<HashMap<String, String>> claimList = new ArrayList<HashMap<String, String>>();
        for (Claim mclaims : claims)
        {
            try

            {

                responseObject = (HashMap<String, String>) buildResponseObject(mclaims,
                        ServiceStatus.SUCCESS.toString());
                claimList.add(responseObject);
            } catch (JsonProcessingException e)
            {
                responseObject.put("RecordStatus", ServiceStatus.ERROR.toString());
                throw new ServiceDAOException("Read failed", e);
            }
        }
        return claimList;
    }

    @Override
    @Transactional
    public Map<String, String> delete(String id) throws ServiceDAOException
    {

        Map<String, String> responseObject = new HashMap<String, String>();

        try
        {
            Claim one = claimRepository.getOne(id);
            claimRepository.delete(one);
            responseObject = buildResponseObject(one, ServiceStatus.DELTED.toString());
        } catch (Exception e)
        {

            responseObject.put("RecordStatus", ServiceStatus.ERROR.toString());
            throw new ServiceDAOException("Read failed", e);
        }

        return responseObject;
    }

    @Override
    public List<HashMap<String, String>> findByLossDate(Date date)
    {

        List<Claim> claims = claimRepository.findByLossDate(date);
        HashMap<String, String> responseObject = new HashMap<String, String>();
        List<HashMap<String, String>> claimList = new ArrayList<HashMap<String, String>>();
        for (Claim mclaims : claims)
        {
            try

            {

                responseObject = (HashMap<String, String>) buildResponseObject(mclaims,
                        ServiceStatus.SUCCESS.toString());
                claimList.add(responseObject);
            } catch (JsonProcessingException e)
            {
                responseObject.put("RecordStatus", ServiceStatus.ERROR.toString());
                throw new ServiceDAOException("Read failed", e);
            }
        }
        return claimList;

    }
}
