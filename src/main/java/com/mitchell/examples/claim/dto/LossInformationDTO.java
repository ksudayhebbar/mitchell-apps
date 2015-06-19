package com.mitchell.examples.claim.dto;

import java.util.Date;

public class LossInformationDTO
{

    protected String causeOfLoss;

    protected String lossDescription;

    protected Date reportedDate;

    /**
     * Gets the value of the causeOfLoss property.
     * 
     * @return possible object is {@link CauseOfLossCode }
     * 
     */
    public String getCauseOfLoss()
    {
        return causeOfLoss;
    }

    /**
     * Sets the value of the causeOfLoss property.
     * 
     * @param value
     *            allowed object is {@link CauseOfLossCode }
     * 
     */
    public void setCauseOfLoss(String value)
    {
        this.causeOfLoss = value;
    }

    /**
     * Gets the value of the reportedDate property.
     * 
     * @return possible object is {@link XMLGregorianCalendar }
     * 
     */
    public Date getReportedDate()
    {
        return reportedDate;
    }

    /**
     * Sets the value of the reportedDate property.
     * 
     * @param value
     *            allowed object is {@link XMLGregorianCalendar }
     * 
     */
    public void setReportedDate(Date value)
    {
        this.reportedDate = value;
    }

    /**
     * Gets the value of the lossDescription property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getLossDescription()
    {
        return lossDescription;
    }

    /**
     * Sets the value of the lossDescription property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setLossDescription(String value)
    {
        this.lossDescription = value;
    }

}
