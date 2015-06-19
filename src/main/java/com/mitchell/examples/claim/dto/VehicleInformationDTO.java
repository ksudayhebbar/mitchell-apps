package com.mitchell.examples.claim.dto;

import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

public class VehicleInformationDTO extends BaseClaimDTO
{

    protected int modelYear;

    protected String makeDescription;

    protected String modelDescription;

    protected String engineDescription;

    protected String exteriorColor;

    protected String vin;

    protected String licPlate;

    protected String licPlateState;

    protected Date licPlateExpDate;

    protected String damageDescription;

    protected Integer mileage;

    /**
     * Gets the value of the modelYear property.
     * 
     */
    public int getModelYear()
    {
        return modelYear;
    }

    /**
     * Sets the value of the modelYear property.
     * 
     */
    public void setModelYear(int value)
    {
        this.modelYear = value;
    }

    /**
     * Gets the value of the makeDescription property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getMakeDescription()
    {
        return makeDescription;
    }

    /**
     * Sets the value of the makeDescription property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setMakeDescription(String value)
    {
        this.makeDescription = value;
    }

    /**
     * Gets the value of the modelDescription property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getModelDescription()
    {
        return modelDescription;
    }

    /**
     * Sets the value of the modelDescription property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setModelDescription(String value)
    {
        this.modelDescription = value;
    }

    /**
     * Gets the value of the engineDescription property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getEngineDescription()
    {
        return engineDescription;
    }

    /**
     * Sets the value of the engineDescription property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setEngineDescription(String value)
    {
        this.engineDescription = value;
    }

    /**
     * Gets the value of the exteriorColor property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getExteriorColor()
    {
        return exteriorColor;
    }

    /**
     * Sets the value of the exteriorColor property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setExteriorColor(String value)
    {
        this.exteriorColor = value;
    }

    /**
     * Gets the value of the vin property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getVin()
    {
        return vin;
    }

    /**
     * Sets the value of the vin property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setVin(String value)
    {
        this.vin = value;
    }

    /**
     * Gets the value of the licPlate property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getLicPlate()
    {
        return licPlate;
    }

    /**
     * Sets the value of the licPlate property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setLicPlate(String value)
    {
        this.licPlate = value;
    }

    /**
     * Gets the value of the licPlateState property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getLicPlateState()
    {
        return licPlateState;
    }

    /**
     * Sets the value of the licPlateState property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setLicPlateState(String value)
    {
        this.licPlateState = value;
    }

    /**
     * Gets the value of the licPlateExpDate property.
     * 
     * @return possible object is {@link XMLGregorianCalendar }
     * 
     */
    public Date getLicPlateExpDate()
    {
        return licPlateExpDate;
    }

    /**
     * Sets the value of the licPlateExpDate property.
     * 
     * @param value
     *            allowed object is {@link XMLGregorianCalendar }
     * 
     */
    public void setLicPlateExpDate(Date value)
    {
        this.licPlateExpDate = value;
    }

    /**
     * Gets the value of the damageDescription property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getDamageDescription()
    {
        return damageDescription;
    }

    /**
     * Sets the value of the damageDescription property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setDamageDescription(String value)
    {
        this.damageDescription = value;
    }

    /**
     * Gets the value of the mileage property.
     * 
     * @return possible object is {@link Integer }
     * 
     */
    public Integer getMileage()
    {
        return mileage;
    }

    /**
     * Sets the value of the mileage property.
     * 
     * @param value
     *            allowed object is {@link Integer }
     * 
     */
    public void setMileage(Integer value)
    {
        this.mileage = value;
    }
    
    

}
