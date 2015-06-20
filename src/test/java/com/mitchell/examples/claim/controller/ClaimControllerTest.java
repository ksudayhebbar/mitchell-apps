package com.mitchell.examples.claim.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mitchell.examples.MitchellAppsApplication;
import com.mitchell.examples.claim.dto.ClaimDTO;
import com.mitchell.examples.claim.dto.LossInformationDTO;
import com.mitchell.examples.claim.dto.VehicleInformationDTO;
import com.mitchell.examples.claim.service.ClaimService;
import com.mitchell.examples.claim.service.VehicleService;
import com.mitchell.examples.dao.repository.ClaimRepository;
import com.mitchell.examples.entity.Claim;
import com.mitchell.examples.entity.Vehicle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MitchellAppsApplication.class)
public class ClaimControllerTest
{

    private MockMvc mockMvc;

    @Autowired
    ClaimController claimController;

    @Autowired
    private JdbcTemplate template;

    @Autowired
    public ClaimService claimService;

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private VehicleService vehicleServiceImpl;

    @org.junit.Before
    public void setUp() throws Exception
    {
        this.mockMvc = MockMvcBuilders.standaloneSetup(claimController).build();
        for (int i = 0; i < 5; i++)
        {
            ClaimDTO mitchellClaimTypeDTO = createClaimObject(i);
            String content = objectToJson(mitchellClaimTypeDTO);
            mockMvc.perform(
                    post("/claim/create").contentType(MediaType.APPLICATION_JSON).content(content)
                            .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        }

    }

    @Test
    @Transactional
    public void createTest() throws Exception
    {
        for (int i = 0; i < 5; i++)
        {
            ClaimDTO mitchellClaimTypeDTO = createClaimObject(i);
            String content = objectToJson(mitchellClaimTypeDTO);
            mockMvc.perform(
                    post("/claim/create").contentType(MediaType.APPLICATION_JSON).content(content)
                            .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        }

    }

    @Test
    @Transactional
    public void findByIDTest() throws Exception
    {

        for (int i = 0; i < 5; i++)
        {
            ClaimDTO mitchellClaimTypeDTO = createClaimObject(i);
            String claimNumber = mitchellClaimTypeDTO.getClaimNumber();
            Claim mitchellClaim = claimRepository.findOne(claimNumber);
            Map<String, String> singleClaim = claimService.findById(claimNumber);
            mockMvc.perform(
                    get("/claim/find/{id}", claimNumber).contentType(MediaType.APPLICATION_JSON).accept(
                            MediaType.APPLICATION_JSON)).andExpect(status().isOk());

            assertEquals(claimNumber, mitchellClaim.getId());
            String claimID = singleClaim.get("ClaimID");
            assertEquals(claimNumber, claimID);
        }

        assertEquals(new Integer(5), this.template.queryForObject("SELECT COUNT(*) from MICHELL_CLIAM", Integer.class));

    }

    @Test
    @Transactional
    public void findAllTest() throws Exception
    {

        mockMvc.perform(
                get("/claim/findall").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        List<Claim> repofindAll = claimRepository.findAll();
        assertEquals(5, repofindAll.size());

        List<HashMap<String, String>> serviceFindall = claimService.findall();
        assertEquals(5, serviceFindall.size());

        assertEquals(new Integer(5), this.template.queryForObject("SELECT COUNT(*) from MICHELL_CLIAM", Integer.class));

    }

    @Test
    @Transactional
    public void findByLossOfDateTest() throws Exception
    {
        List<Claim> repofindAll = claimRepository.findAll();
        assertEquals(5, repofindAll.size());

        for (Claim claim : repofindAll)
        {
            Date lossDate = claim.getLossDate();
            DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
            String format = dateFormat.format(lossDate);
            mockMvc.perform(
                    get("/claim/finddate?").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                            .param("date", format)).andExpect(status().isOk());
            List<HashMap<String, String>> findByLossDate = claimService.findByLossDate(lossDate);
            assertEquals(1, findByLossDate.size());
            List<Claim> findByLossDate2 = claimRepository.findByLossDate(lossDate);
            assertEquals(1, findByLossDate2.size());
        }

    }

    @Test
    @Transactional
    public void updateTest()
    {
        List<Claim> repofindAll = claimRepository.findAll();
        assertEquals(5, repofindAll.size());

        for (Claim claim : repofindAll)
        {
            String id = claim.getId();
            Integer assignedAdjusterID = claim.getAssignedAdjusterID();

            VehicleInformationDTO vehicleInfoDTO = new VehicleInformationDTO();
            vehicleInfoDTO.setAssignedAdjusterID(assignedAdjusterID);
            vehicleInfoDTO.setClaimNumber(id);
            vehicleInfoDTO.setExteriorColor("Deep Impact Blue");
            vehicleInfoDTO.setVin("1M8GDM9AXKP0427886666");
            Date date = new Date();
            vehicleInfoDTO.setLicPlateExpDate(date);
            vehicleServiceImpl.update(vehicleInfoDTO);
            Claim mitchellClaim = claimRepository.findOne(id);

            Set<Vehicle> vehicle = mitchellClaim.getVehicle();
            for (Vehicle v : vehicle)
            {
                String vin = v.getVin();
                assertEquals("1M8GDM9AXKP0427886666", vin);
            }

        }
    }

    @Test
    @Transactional
    public void deleteTest() throws Exception
    {
        List<Claim> repofindAll = claimRepository.findAll();
        assertEquals(5, repofindAll.size());

        for (Claim claim : repofindAll)
        {
            String id = claim.getId();
            mockMvc.perform(
                    delete("/claim/delete/{id}", id).contentType(MediaType.APPLICATION_JSON).accept(
                            MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        }
        repofindAll = claimRepository.findAll();
        assertEquals(0, repofindAll.size());

    }

    private ClaimDTO createClaimObject(int i)
    {
        ClaimDTO mitchellClaimTypeDTO = new ClaimDTO();
        mitchellClaimTypeDTO.setAssignedAdjusterID(12345);
        mitchellClaimTypeDTO.setClaimantFirstName("George");
        mitchellClaimTypeDTO.setClaimNumber("22c9c23bac142856018ce14a26b6c299" + i);
        mitchellClaimTypeDTO.setStatus("OPEN");

        // get current date time with Date()
        Date date = new Date();
        mitchellClaimTypeDTO.setLossDate(date);
        mitchellClaimTypeDTO.setClaimantLastName("Washington");
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
        vehicles.setLicPlateExpDate(date);
        vehicles.setMileage(123);
        vehicles.setDamageDescription("Frontend smashed in.apple dents in roof");
        mitchellClaimTypeDTO.setVehicles(vehicles);
        mitchellClaimTypeDTO.setLossInfo(lossInfo);
        return mitchellClaimTypeDTO;
    }

    private String objectToJson(Object m)
    {
        String json = null;
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try
        {
            json = ow.writeValueAsString(m);

        } catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }
        return json;
    }

}
