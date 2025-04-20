package com.pocv01.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_status")
public class TblStatus {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="pk_status_id")
    private Long id;

    @Column(name="nama_status")
    private String namaStatus;

    @Column(name="isactive")
    private Boolean isActive;

    @Column(name = "createdby")
    private String createdBy;

    @Column(name = "createddate")
    private java.util.Date createdDate; // Changed to java.sql.Date

    @Column(name = "lastupdatedby")
    private String lastUpdatedBy;

    @Column(name = "lastupdateddate")
    private java.util.Date lastUpdatedDate; // Changed to java.sql.Date

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaStatus() {
        return namaStatus;
    }

    public void setNamaStatus(String namaStatus) {
        this.namaStatus = namaStatus;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }
}
