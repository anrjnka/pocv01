package com.pocv01.Entity;


	import java.util.Date;  // Import java.util.Date

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	@Entity
	@Table(name = "tbl_satuanbahan")
	public class TblSatuanBahan {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "pk_satuanbahan_id")
	    private Long id;

	    @Column(name = "namasatuan")
	    private String namaSatuan;

	    @Column(name = "isactive")
	    private String isActive;

	    @Column(name = "createdby")
	    private String createdBy;

	    @Column(name = "createddate")
	    private Date createdDate;  // Changed to java.util.Date

	    @Column(name = "lastupdatedby")
	    private String lastUpdatedBy;

	    @Column(name = "lastupdateddate")
	    private Date lastUpdatedDate;  // Changed to java.util.Date

	    // Getters and Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getNamaSatuan() {
	        return namaSatuan;
	    }

	    public void setNamaSatuan(String namaSatuan) {
	        this.namaSatuan = namaSatuan;
	    }

	    public String getIsActive() {
	        return isActive;
	    }

	    public void setIsActive(String isActive) {
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
