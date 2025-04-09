package com.pocv01.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tbl_purchasing")
public class TblPurchasing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_purchasing_id")
    private Long pkPurchasingId;

    @Column(name = "nomor_po")
    private String nomorPo;

    @Column(name = "fk_vendor_id")
    private Long fkVendorId;

    @Column(name = "status")
    private String status;

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

    public Long getPkPurchasingId() {
        return pkPurchasingId;
    }

    public void setPkPurchasingId(Long pkPurchasingId) {
        this.pkPurchasingId = pkPurchasingId;
    }

    public String getNomorPo() {
        return nomorPo;
    }

    public void setNomorPo(String nomorPo) {
        this.nomorPo = nomorPo;
    }

    public Long getFkVendorId() {
        return fkVendorId;
    }

    public void setFkVendorId(Long fkVendorId) {
        this.fkVendorId = fkVendorId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
