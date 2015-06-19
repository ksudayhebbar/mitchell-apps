package com.mitchell.examples.claim.dto;

import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class ClaimDTO extends BaseClaimDTO implements ClaimRequestService
{

    protected String claimantFirstName;

    protected String claimantLastName;

    protected String status;

    protected Date lossDate;

    protected LossInformationDTO lossInfo;

    protected VehicleInformationDTO vehicles;

    public ClaimDTO()
    {

    }

    public ClaimDTO(String status)
    {
        super(status);

    }

    /**
     * Gets the value of the claimantFirstName property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getClaimantFirstName()
    {
        return claimantFirstName;
    }

    /**
     * Sets the value of the claimantFirstName property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setClaimantFirstName(String value)
    {
        this.claimantFirstName = value;
    }

    /**
     * Gets the value of the claimantLastName property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getClaimantLastName()
    {
        return claimantLastName;
    }

    /**
     * Sets the value of the claimantLastName property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setClaimantLastName(String value)
    {
        this.claimantLastName = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return possible object is {@link StatusCode }
     * 
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *            allowed object is {@link StatusCode }
     * 
     */
    public void setStatus(String value)
    {
        this.status = value;
    }

    /**
     * Gets the value of the lossDate property.
     * 
     * @return possible object is {@link XMLGregorianCalendar }
     * 
     */
    public Date getLossDate()
    {
        return lossDate;
    }

    /**
     * Sets the value of the lossDate property.
     * 
     * @param value
     *            allowed object is {@link XMLGregorianCalendar }
     * 
     */
    public void setLossDate(Date value)
    {
        this.lossDate = value;
    }

    /**
     * Gets the value of the lossInfo property.
     * 
     * @return possible object is {@link LossInformationDTO }
     * 
     */
    public LossInformationDTO getLossInfo()
    {
        return lossInfo;
    }

    /**
     * Sets the value of the lossInfo property.
     * 
     * @param value
     *            allowed object is {@link LossInformationDTO }
     * 
     */
    public void setLossInfo(LossInformationDTO value)
    {
        this.lossInfo = value;
    }

    /**
     * Gets the value of the vehicles property.
     * 
     * @return possible object is {@link VehicleListType }
     * 
     */
    public VehicleInformationDTO getVehicles()
    {
        return vehicles;
    }

    /**
     * Sets the value of the vehicles property.
     * 
     * @param value
     *            allowed object is {@link VehicleListType }
     * 
     */
    public void setVehicles(VehicleInformationDTO value)
    {
        this.vehicles = value;
    }

    public static void main(String[] args)
    {

        /*
         * { "claimNumber" : "22c9c23bac142856018ce14a26b6c299",
         * "claimantFirstName" : "George", "claimantLastName" : "Washington",
         * "status" : "OPEN", "lossDate" : 0, "lossInfo" : { "causeOfLoss" :
         * "Collision", "lossDescription" : "Crashed into an apple tree",
         * "reportedDate" : 1434290484700 }, "assignedAdjusterID" : 12345,
         * "vehicles" : { "modelYear" : 2015, "makeDescription" : "Ford",
         * "modelDescription" : "Mustang", "engineDescription" : "EcoBoost",
         * "exteriorColor" : "Deep Impact Blue", "vin" : "1M8GDM9AXKP042788",
         * "licPlate" : "NO1PRES", "licPlateState" : "VA", "licPlateExpDate" :
         * 1434290484700, "damageDescription" :
         * "Front end smashed in. Apple dents in roof", "mileage" : 123 } }
         */

        ClaimDTO m = new ClaimDTO();
        m.setAssignedAdjusterID(12345);
        m.setClaimantFirstName("George");
        m.setClaimNumber("22c9c23bac142856018ce14a26b6c299");
        m.setStatus("OPEN");
        m.setLossDate(new Date());
        m.setClaimantLastName("Washington");

        LossInformationDTO lossInfo = new LossInformationDTO();
        lossInfo.setCauseOfLoss("Collision");
        lossInfo.setLossDescription("Crashed into an apple tree");
        lossInfo.setReportedDate(new Date());
        VehicleInformationDTO vehicles = new VehicleInformationDTO();

        vehicles.setVin("1M8GDM9AXKP042788");
        vehicles.setModelYear(2015);
        vehicles.setMakeDescription("Ford");
        vehicles.setModelDescription("Mustang");
        vehicles.setEngineDescription("EcoBoost");
        vehicles.setExteriorColor("Deep Impact Blue");
        vehicles.setLicPlate("NO1PRES");
        vehicles.setLicPlateState("VA");
        vehicles.setLicPlateExpDate(new Date());
        vehicles.setMileage(123);
        vehicles.setDamageDescription("Frontend smashed in.apple dents in roof");
        m.setVehicles(vehicles);
        m.setLossInfo(lossInfo);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try
        {
            String json = ow.writeValueAsString(m);
            System.out.println(json);
        } catch (JsonProcessingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
