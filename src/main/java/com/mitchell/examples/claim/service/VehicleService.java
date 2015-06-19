package com.mitchell.examples.claim.service;

import java.util.HashMap;
import java.util.List;

import com.mitchell.examples.claim.dto.VehicleInformationDTO;

public interface VehicleService
{
    public List<HashMap<String, String>> update(VehicleInformationDTO vehicleInfoTypeDTO);
}
