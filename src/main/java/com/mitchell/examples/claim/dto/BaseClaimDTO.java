package com.mitchell.examples.claim.dto;

public class BaseClaimDTO
{

    private String outputStatus;

    protected String claimNumber;

    protected Integer assignedAdjusterID;

    public BaseClaimDTO()
    {

    }

    public BaseClaimDTO(String status)
    {
        super();
        this.outputStatus = status;
    }

    public String getOutputStatus()
    {
        return outputStatus;
    }

    public String getClaimNumber()
    {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber)
    {
        this.claimNumber = claimNumber;
    }

    public Integer getAssignedAdjusterID()
    {
        return assignedAdjusterID;
    }

    public void setAssignedAdjusterID(Integer assignedAdjusterID)
    {
        this.assignedAdjusterID = assignedAdjusterID;
    }

}
