package com.mitchell.examples.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MICHELL_CLIAM")
public class Claim extends AbstractPersistable
{

    @Column(name = "FIRST_NAME")
    protected String claimantFirstName;

    @Column(name = "LAST_NAME")
    protected String claimantLastName;

    @Column(name = "STATUS")
    protected String status;

    @Column(name = "LOSS_DATE")
    protected Date lossDate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected LossInformation info = new LossInformation();

    @Column(name = "ASSIGNEDADJUSTER_ID")
    protected Integer assignedAdjusterID;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected Set<Vehicle> vehicle = new HashSet<Vehicle>();

    public Claim()
    {
        super();
    }

    public Claim(String id, String claimantFirstName, String claimantLastName, String status, Date lossDate,
            LossInformation info, Integer assignedAdjusterID, Set<Vehicle> vehicle)
    {
        super();
        setId(id);
        this.claimantFirstName = claimantFirstName;
        this.claimantLastName = claimantLastName;
        this.status = status;
        this.lossDate = lossDate;
        this.info = info;
        this.assignedAdjusterID = assignedAdjusterID;
        this.vehicle = vehicle;
    }

    public Integer getAssignedAdjusterID()
    {
        return assignedAdjusterID;
    }

    public void setAssignedAdjusterID(Integer assignedAdjusterID)
    {
        this.assignedAdjusterID = assignedAdjusterID;
    }

    public LossInformation getInfo()
    {
        return info;
    }

    public void setInfo(LossInformation info)
    {
        this.info = info;
    }

    public String getClaimantFirstName()
    {
        return claimantFirstName;
    }

    public void setClaimantFirstName(String claimantFirstName)
    {
        this.claimantFirstName = claimantFirstName;
    }

    public String getClaimantLastName()
    {
        return claimantLastName;
    }

    public void setClaimantLastName(String claimantLastName)
    {
        this.claimantLastName = claimantLastName;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public Date getLossDate()
    {
        return lossDate;
    }

    public void setLossDate(Date lossDate)
    {
        this.lossDate = lossDate;
    }

    public Set<Vehicle> getVehicle()
    {
        return vehicle;
    }

    public void setVehicle(Set<Vehicle> vehicle)
    {
        this.vehicle = vehicle;
    }

    public static class ClaimBuilder
    {
        protected String claimNumber;
        protected String firstName;
        protected String lastName;
        protected String status;
        protected Date lossDate;
        protected Integer assignedAdjusterID;
        protected Integer causeOfLossCode;
        protected String lossDescription;
        protected Date reportedDate;

        protected Set<Vehicle> vehicle = new HashSet<Vehicle>();

        public ClaimBuilder ClaimNumber(String claimNumber)
        {
            this.claimNumber = claimNumber;
            return this;
        }

        public ClaimBuilder AssignedAdjusterID(Integer assignedAdjusterID)
        {
            this.assignedAdjusterID = assignedAdjusterID;
            return this;
        }

        public ClaimBuilder FirstName(String firstName)
        {
            this.firstName = firstName;
            return this;
        }

        public ClaimBuilder LastName(String lastName)
        {
            this.lastName = lastName;
            return this;
        }

        public ClaimBuilder Status(String status)
        {
            this.status = status;
            return this;
        }

        public ClaimBuilder LossDate(Date lossDate)
        {
            this.lossDate = lossDate;
            return this;
        }

        public ClaimBuilder CauseOfLossCode(Integer causeOfLossCode)
        {
            this.causeOfLossCode = causeOfLossCode;
            return this;
        }

        public ClaimBuilder LossDescription(String lossDescription)
        {
            this.lossDescription = lossDescription;
            return this;
        }

        public ClaimBuilder ReportedDate(Date reportedDate)
        {
            this.reportedDate = reportedDate;
            return this;
        }

        public ClaimBuilder Vehicle(Set<Vehicle> vehicle)
        {
            this.vehicle = vehicle;
            return this;
        }

        public Claim createClaim()
        {
            LossInformation info = new LossInformation(claimNumber, causeOfLossCode, lossDescription, reportedDate);

            Claim mitchellClaim = new Claim(claimNumber, firstName, lastName, status, lossDate, info,
                    assignedAdjusterID, vehicle);
            return mitchellClaim;

        }
    }

}
