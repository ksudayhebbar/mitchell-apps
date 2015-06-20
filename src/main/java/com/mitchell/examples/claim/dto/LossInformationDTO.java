package com.mitchell.examples.claim.dto;

import java.util.Date;

public class LossInformationDTO
{

    protected String causeOfLoss;

    protected String lossDescription;

    protected Date reportedDate;

    public String getCauseOfLoss()
    {
        return causeOfLoss;
    }

    public void setCauseOfLoss(String value)
    {
        this.causeOfLoss = value;
    }

    public Date getReportedDate()
    {
        return reportedDate;
    }

    public void setReportedDate(Date value)
    {
        this.reportedDate = value;
    }

    public String getLossDescription()
    {
        return lossDescription;
    }

    public void setLossDescription(String value)
    {
        this.lossDescription = value;
    }

}
