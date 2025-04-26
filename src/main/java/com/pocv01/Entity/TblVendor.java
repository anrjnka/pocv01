package com.pocv01.Entity;


import java.util.Date;

import jakarta.persistence.Column;

@jakarta.persistence.Entity
public class TblVendor {

    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long pk_vendor_id;

    @Column(name = "namavendor")
    @jakarta.validation.constraints.NotBlank(message = "Nama Vendor cannot be empty")
    private String namaVendor;
    
    @Column(name = "codevendor")
    private String codeVendor;
    
    @Column(name = "noidentitasvendor")
    private String noidentitasvendor;
    
    @Column(name = "alamatvendor")
    private String alamatVendor;
    
    @Column(name = "namasales")
    private String namaSales;
    
    @Column(name = "notelepon")
    private String noTelepon;
    
    @Column(name = "fk_active_id")
    private Boolean isActive;

    @Column(name = "createdby")
    private String createdBy;
    
    @Column(name = "createddate")
    private Date createdDate;

    @Column(name = "lastupdatedby")
    private String lastUpdatedBy;
    
    @Column(name = "lastupdateddate")
    private Date lastUpdatedDate;

	public Long getPk_vendor_id() {
		return pk_vendor_id;
	}

	public void setPk_vendor_id(Long pk_vendor_id) {
		this.pk_vendor_id = pk_vendor_id;
	}

	public String getNamaVendor() {
		return namaVendor;
	}

	public void setNamaVendor(String namaVendor) {
		this.namaVendor = namaVendor;
	}

	public String getCodeVendor() {
		return codeVendor;
	}

	public void setCodeVendor(String codeVendor) {
		this.codeVendor = codeVendor;
	}

	public String getNoidentitasvendor() {
		return noidentitasvendor;
	}

	public void setNoidentitasvendor(String noidentitasvendor) {
		this.noidentitasvendor = noidentitasvendor;
	}

	public String getAlamatVendor() {
		return alamatVendor;
	}

	public void setAlamatVendor(String alamatVendor) {
		this.alamatVendor = alamatVendor;
	}

	public String getNamaSales() {
		return namaSales;
	}

	public void setNamaSales(String namaSales) {
		this.namaSales = namaSales;
	}

	public String getNoTelepon() {
		return noTelepon;
	}

	public void setNoTelepon(String noTelepon) {
		this.noTelepon = noTelepon;
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

    // Getters and Setters
    
}
