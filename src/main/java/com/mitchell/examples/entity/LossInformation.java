package com.mitchell.examples.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LOSS_INFO")
public class LossInformation extends AbstractPersistable
{

    @Column(name = "CLAIM_NUMBER")
    protected String claimNumber;

    @Column(name = "CAUSE_OF_LOSS_CODE")
    protected Integer causeOfLossCode;

    @Column(name = "CAUSE_OF_LOSS_DESCRIPTION")
    protected String lossDescription;

    @Column(name = "REPORTED_DATE")
    protected Date reportedDate;
    
  

    public LossInformation()
    {
        String uid = UUID.randomUUID().toString().replaceAll("-", "");
        setId(uid);

    }

    public LossInformation(String claimNumber, Integer causeOfLossCode, String lossDescription, Date reportedDate)
    {
        super();
        this.claimNumber = claimNumber;
        this.causeOfLossCode = causeOfLossCode;
        this.lossDescription = lossDescription;
        this.reportedDate = reportedDate;
    }

    public String getClaimNumber()
    {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber)
    {
        this.claimNumber = claimNumber;
    }

    public Integer getCauseOfLossCode()
    {
        return causeOfLossCode;
    }

    public void setCauseOfLossCode(Integer causeOfLossCode)
    {
        this.causeOfLossCode = causeOfLossCode;
    }

    public String getLossDescription()
    {
        return lossDescription;
    }

    public void setLossDescription(String lossDescription)
    {
        this.lossDescription = lossDescription;
    }

    public Date getReportedDate()
    {
        return reportedDate;
    }

    public void setReportedDate(Date reportedDate)
    {
        this.reportedDate = reportedDate;
    }
}
