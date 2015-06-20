package com.mitchell.examples.claim.dto;

import java.util.Date;

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

    public String getClaimantFirstName()
    {
        return claimantFirstName;
    }

    public void setClaimantFirstName(String value)
    {
        this.claimantFirstName = value;
    }

    public String getClaimantLastName()
    {
        return claimantLastName;
    }

    public void setClaimantLastName(String value)
    {
        this.claimantLastName = value;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String value)
    {
        this.status = value;
    }

    public Date getLossDate()
    {
        return lossDate;
    }

    public void setLossDate(Date value)
    {
        this.lossDate = value;
    }

    public LossInformationDTO getLossInfo()
    {
        return lossInfo;
    }

    public void setLossInfo(LossInformationDTO value)
    {
        this.lossInfo = value;
    }

    public VehicleInformationDTO getVehicles()
    {
        return vehicles;
    }

    public void setVehicles(VehicleInformationDTO value)
    {
        this.vehicles = value;
    }

}
