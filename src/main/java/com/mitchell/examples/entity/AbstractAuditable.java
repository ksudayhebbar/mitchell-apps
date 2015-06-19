package com.mitchell.examples.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractAuditable implements Serializable
{

    private static final long serialVersionUID = -3723385327354502794L;

    @Basic
    @Column(name = "CREATED_BY", updatable = false)
    private String createdBy;

    @Basic
    @Column(name = "CREATED_ON", updatable = false)
    private Date createdDate;

    @Basic
    @Column(name = "UPDATED_BY")
    private String lastModifiedBy;

    @Basic
    @Column(name = "UPDATED_ON")
    private Date lastModifiedDate;

    public AbstractAuditable()
    {
        super();
    }

    public String getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate()
    {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate)
    {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy()
    {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy)
    {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate()
    {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate)
    {
        this.lastModifiedDate = lastModifiedDate;
    }

}
