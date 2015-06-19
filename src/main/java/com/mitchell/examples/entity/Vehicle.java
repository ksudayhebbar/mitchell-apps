package com.mitchell.examples.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE")
public class Vehicle extends AbstractPersistable
{

    @Column(name = "CLAIM_NUMBER")
    protected String claimNumber;

    @Column(name = "MODEL_YEAR")
    protected int modelYear;

    @Column(name = "MAKE_DESC")
    protected String makeDescription;

    @Column(name = "MODEL_DESC")
    protected String modelDescription;

    @Column(name = "ENG_DESC")
    protected String engineDescription;

    @Column(name = "EXT_COLOR")
    protected String exteriorColor;

    @Column(name = "VIN")
    protected String vin;

    @Column(name = "LIC_PLATE")
    protected String licPlate;

    @Column(name = "LIC_PLATE_SATE")
    protected String licPlateState;

    @Column(name = "LIC_PLATE_EXP_DATE")
    protected Date licPlateExpDate;

    @Column(name = "DAMAGE_DESC")
    protected String damageDescription;

    @Column(name = "MILEAGE")
    protected Integer mileage;

    public Vehicle()
    {
        String uid = UUID.randomUUID().toString().replaceAll("-", "");
        setId(uid);
    }

    public Vehicle(String claimNumber, int modelYear, String makeDescription, String modelDescription,
            String engineDescription, String exteriorColor, String vin, String licPlate, String licPlateState,
            Date licPlateExpDate, String damageDescription, Integer mileage)
    {
        super();
        String uid = UUID.randomUUID().toString().replaceAll("-", "");
        setId(uid);
        this.claimNumber = claimNumber;
        this.modelYear = modelYear;
        this.makeDescription = makeDescription;
        this.modelDescription = modelDescription;
        this.engineDescription = engineDescription;
        this.exteriorColor = exteriorColor;
        this.vin = vin;
        this.licPlate = licPlate;
        this.licPlateState = licPlateState;
        this.licPlateExpDate = licPlateExpDate;
        this.damageDescription = damageDescription;
        this.mileage = mileage;
    }

    public String getClaimNumber()
    {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber)
    {
        this.claimNumber = claimNumber;
    }

    public int getModelYear()
    {
        return modelYear;
    }

    public void setModelYear(int modelYear)
    {
        this.modelYear = modelYear;
    }

    public String getMakeDescription()
    {
        return makeDescription;
    }

    public void setMakeDescription(String makeDescription)
    {
        this.makeDescription = makeDescription;
    }

    public String getModelDescription()
    {
        return modelDescription;
    }

    public void setModelDescription(String modelDescription)
    {
        this.modelDescription = modelDescription;
    }

    public String getEngineDescription()
    {
        return engineDescription;
    }

    public void setEngineDescription(String engineDescription)
    {
        this.engineDescription = engineDescription;
    }

    public String getExteriorColor()
    {
        return exteriorColor;
    }

    public void setExteriorColor(String exteriorColor)
    {
        this.exteriorColor = exteriorColor;
    }

    public String getVin()
    {
        return vin;
    }

    public void setVin(String vin)
    {
        this.vin = vin;
    }

    public String getLicPlate()
    {
        return licPlate;
    }

    public void setLicPlate(String licPlate)
    {
        this.licPlate = licPlate;
    }

    public String getLicPlateState()
    {
        return licPlateState;
    }

    public void setLicPlateState(String licPlateState)
    {
        this.licPlateState = licPlateState;
    }

    public Date getLicPlateExpDate()
    {
        return licPlateExpDate;
    }

    public void setLicPlateExpDate(Date licPlateExpDate)
    {
        this.licPlateExpDate = licPlateExpDate;
    }

    public String getDamageDescription()
    {
        return damageDescription;
    }

    public void setDamageDescription(String damageDescription)
    {
        this.damageDescription = damageDescription;
    }

    public Integer getMileage()
    {
        return mileage;
    }

    public void setMileage(Integer mileage)
    {
        this.mileage = mileage;
    }

    public static class VehicleBuilder
    {
        protected String claimNumber;
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

        public VehicleBuilder ClaimNumber(String claimNumber)
        {
            this.claimNumber = claimNumber;
            return this;
        }

        public VehicleBuilder ModelYear(int modelYear)
        {
            this.modelYear = modelYear;
            return this;
        }

        public VehicleBuilder MakeDescription(String makeDescription)
        {
            this.makeDescription = makeDescription;
            return this;
        }

        public VehicleBuilder ModelDescription(String modelDescription)
        {
            this.modelDescription = modelDescription;
            return this;
        }

        public VehicleBuilder EngineDescription(String engineDescription)
        {
            this.engineDescription = engineDescription;
            return this;
        }

        public VehicleBuilder ExteriorColor(String exteriorColor)
        {
            this.exteriorColor = exteriorColor;
            return this;
        }

        public VehicleBuilder Vin(String vin)
        {
            this.vin = vin;
            return this;
        }

        public VehicleBuilder LicPlate(String licPlate)
        {
            this.licPlate = licPlate;
            return this;
        }

        public VehicleBuilder LicPlateState(String licPlateState)
        {
            this.licPlateState = licPlateState;
            return this;
        }

        public VehicleBuilder LicPlateExpDate(Date licPlateExpDate)
        {
            this.licPlateExpDate = licPlateExpDate;
            return this;
        }

        public VehicleBuilder DamageDescription(String damageDescription)
        {
            this.damageDescription = damageDescription;
            return this;
        }

        public VehicleBuilder Mileage(Integer mileage)
        {
            this.mileage = mileage;
            return this;
        }

        public Vehicle createVehicle()
        {
            Vehicle vehicle = new Vehicle(claimNumber, modelYear, makeDescription, modelDescription, engineDescription,
                    exteriorColor, vin, licPlate, licPlateState, licPlateExpDate, damageDescription, mileage);
            return vehicle;

        }
    }
}
