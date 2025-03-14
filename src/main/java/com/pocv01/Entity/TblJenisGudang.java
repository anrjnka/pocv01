package com.pocv01.Entity;


	import java.util.Date;  // Import java.util.Date

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	@Entity
	@Table(name = "tbl_jenisgudang")
	public class TblJenisGudang {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "pk_jenisgudang_id")
	    private Long id;

	    @Column(name = "jenisgudang")
	    private String jenisGudang;

	    @Column(name = "isactive")
	    private Boolean isActive;

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

	    public String getJenisGudang() {
	        return jenisGudang;
	    }

	    public void setJenisGudang(String jenisGudang) {
	        this.jenisGudang = jenisGudang;
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
