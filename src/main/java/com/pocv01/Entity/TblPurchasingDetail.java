package com.pocv01.Entity;

import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tbl_purchasing_detail")

public class TblPurchasingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_purchasingdetail_id")
    private Long pkPurchasingDetailId;

    @Column(name = "fk_purchasing_id")
    private Long fkPurchasingId;

    @Column(name = "fk_catalogvendor_id")
    private Long fkCatalogVendorId;

    @Column(name = "jumlah")
    private Long jumlah;

    @Column(name = "fk_active_id")
    private Long isActive;

    @ManyToOne
    @JoinColumn(name="fk_active_id", referencedColumnName="pk_active_id", insertable=false, updatable=false)
    private TblActive active;

    @Column(name = "createdby")
    private String createdBy;

    @Column(name = "createddate")
    private Date createdDate;

    @Column(name = "lastupdatedby")
    private String lastUpdatedBy;

    @Column(name = "lastUpdatedDate")
    private Date lastUpdatedDate;

	public Long getPkPurchasingDetailId() {
		return pkPurchasingDetailId;
	}

	public void setPkPurchasingDetailId(Long pkPurchasingDetailId) {
		this.pkPurchasingDetailId = pkPurchasingDetailId;
	}

	public Long getFkPurchasingId() {
		return fkPurchasingId;
	}

	public void setFkPurchasingId(Long fkPurchasingId) {
		this.fkPurchasingId = fkPurchasingId;
	}

	public Long getFkCatalogVendorId() {
		return fkCatalogVendorId;
	}

	public void setFkCatalogVendorId(Long fkCatalogVendorId) {
		this.fkCatalogVendorId = fkCatalogVendorId;
	}

	public Long getJumlah() {
		return jumlah;
	}

	public void setJumlah(Long jumlah) {
		this.jumlah = jumlah;
	}

	public Long getIsActive() {
		return isActive;
	}

	public void setIsActive(Long isActive) {
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