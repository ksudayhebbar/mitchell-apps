package com.mitchell.examples.claim.service;

import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import com.mitchell.examples.exception.ServiceDAOException;
import com.mitchell.examples.claim.dto.VehicleInformationDTO;
import com.mitchell.examples.dao.repository.VechileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService
{
    @Autowired
    public VechileRepository vechileRepository;

    @Override
    @Transactional
    public void update(VehicleInformationDTO vehicleInfoDTO)
    {
        try
        {
            vechileRepository.update(vehicleInfoDTO.getExteriorColor(), vehicleInfoDTO.getVin(),
                    vehicleInfoDTO.getLicPlateExpDate(), vehicleInfoDTO.getClaimNumber());
            
        } catch (Exception e)
        {

            throw new ServiceDAOException("Update the failed");
        }

    }

}
