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

    @Column(name = "isactive")
    private Boolean isactive;

    @Column(name = "createdby")
    private String createdby;

    @Column(name = "createddate")
    private Date createddate;

    @Column(name = "lastupdatedby")
    private String lastupdatedby;

    @Column(name = "lastupdateddate")
    private Date lastupdateddate;

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

	public Boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getLastupdatedby() {
		return lastupdatedby;
	}

	public void setLastupdatedby(String lastupdatedby) {
		this.lastupdatedby = lastupdatedby;
	}

	public Date getLastupdateddate() {
		return lastupdateddate;
	}

	public void setLastupdateddate(Date lastupdateddate) {
		this.lastupdateddate = lastupdateddate;
	}
    
    
}