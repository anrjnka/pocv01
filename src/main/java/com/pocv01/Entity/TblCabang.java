package com.pocv01.Entity;

import java.util.Date;

import io.micrometer.observation.transport.Propagator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tbl_cabang")
public class TblCabang {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "pk_cabang_id")
    private Long id;

    @Column(name = "namacabang")
    private String namaCabang;

    @Column(name = "isactive")
    private String isActive;

    @Column(name = "createdby")
    private String createdBy;

	@Column(name = "createddate")
    private java.util.Date createdDate;

    @Column(name = "lastupdatedby")
    private String lastUpdatedBy;

    @Column(name = "lastupdateddate")
    private java.util.Date lastUpdatedDate; 

    public Long getId() {
        return id;
    }

    public String getNamaCabang() {
        return namaCabang;
    }

    public String getIsActive() {
        return isActive;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNamaCabang(String namaCabang) {
        this.namaCabang = namaCabang;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }
    
    
}
