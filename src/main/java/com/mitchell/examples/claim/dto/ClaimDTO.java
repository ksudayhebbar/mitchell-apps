package com.mitchell.examples.claim.dto;

import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

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

    /**
     * Gets the value of the claimantFirstName property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getClaimantFirstName()
    {
        return claimantFirstName;
    }

    /**
     * Sets the value of the claimantFirstName property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setClaimantFirstName(String value)
    {
        this.claimantFirstName = value;
    }

    /**
     * Gets the value of the claimantLastName property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getClaimantLastName()
    {
        return claimantLastName;
    }

    /**
     * Sets the value of the claimantLastName property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setClaimantLastName(String value)
    {
        this.claimantLastName = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return possible object is {@link StatusCode }
     * 
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *            allowed object is {@link StatusCode }
     * 
     */
    public void setStatus(String value)
    {
        this.status = value;
    }

    /**
     * Gets the value of the lossDate property.
     * 
     * @return possible object is {@link XMLGregorianCalendar }
     * 
     */
    public Date getLossDate()
    {
        return lossDate;
    }

    /**
     * Sets the value of the lossDate property.
     * 
     * @param value
     *            allowed object is {@link XMLGregorianCalendar }
     * 
     */
    public void setLossDate(Date value)
    {
        this.lossDate = value;
    }

    /**
     * Gets the value of the lossInfo property.
     * 
     * @return possible object is {@link LossInformationDTO }
     * 
     */
    public LossInformationDTO getLossInfo()
    {
        return lossInfo;
    }

    /**
     * Sets the value of the lossInfo property.
     * 
     * @param value
     *            allowed object is {@link LossInformationDTO }
     * 
     */
    public void setLossInfo(LossInformationDTO value)
    {
        this.lossInfo = value;
    }

    /**
     * Gets the value of the vehicles property.
     * 
     * @return possible object is {@link VehicleListType }
     * 
     */
    public VehicleInformationDTO getVehicles()
    {
        return vehicles;
    }

    /**
     * Sets the value of the vehicles property.
     * 
     * @param value
     *            allowed object is {@link VehicleListType }
     * 
     */
    public void setVehicles(VehicleInformationDTO value)
    {
        this.vehicles = value;
    }


}
