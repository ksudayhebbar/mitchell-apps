package com.mitchell.examples.claim.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mitchell.examples.claim.dto.VehicleInformationDTO;

import com.mitchell.examples.claim.service.VehicleService;
import com.mitchell.examples.claim.dto.ClaimDTO;
import com.mitchell.examples.claim.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("claim")
public class ClaimController
{
    @Autowired
    public ClaimService claimService;

    @Autowired
    public VehicleService vehicleService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json",
            produces = "application/json")
    public @ResponseBody Map<String, String> insertClaim(@RequestBody ClaimDTO mitchellClaimTypeDTO)
    {
        Map<String, String> create = claimService.create(mitchellClaimTypeDTO);
        return create;
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, String> findByID(@PathVariable("id") String id)
    {
        return claimService.findById(id);

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody Map<String, String> deleteId(@PathVariable("id") String id)
    {
        return claimService.delete(id);

    }

    @RequestMapping(value = "/findall", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<HashMap<String, String>> findAll()
    {
        return claimService.findall();
    }

    @RequestMapping(value = "/finddate", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<HashMap<String, String>> findByLossOfDate(@RequestParam(value = "date") @DateTimeFormat(
            pattern = "MM-dd-yyyy") Date dateOrNull)
    {
        return claimService.findByLossDate(dateOrNull);

    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody String update(@RequestBody VehicleInformationDTO vehicleInfoDTO)
    {
        vehicleService.update(vehicleInfoDTO);
        return "SUCESS";

    }
}
