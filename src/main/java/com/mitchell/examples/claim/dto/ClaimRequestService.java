package com.mitchell.examples.claim.dto;

import java.util.Date;

public interface ClaimRequestService
{
    public String getClaimNumber();

    public String getClaimantFirstName();

    public String getClaimantLastName();

    public String getStatus();

    public Date getLossDate();

    public LossInformationDTO getLossInfo();

    public Integer getAssignedAdjusterID();

    public VehicleInformationDTO getVehicles();
}
