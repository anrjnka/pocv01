package com.pocv01.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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

    @ManyToOne
    @JoinColumn(name="fk_vendor_id", referencedColumnName="pk_vendor_id", insertable=false, updatable=false)
    private TblVendor vendor;

    @Column(name = "fk_status_id")
    private Long fkStatusId;

    @ManyToOne
    @JoinColumn(name="fk_status_id", referencedColumnName="pk_status_id", insertable=false, updatable=false)
    private TblStatus status;

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

    public Long getFkStatusId() {
        return fkStatusId;
    }

    public void setFkStatusId(Long fkStatusId) {
        this.fkStatusId = fkStatusId;
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

    public TblVendor getVendor() {
        return vendor;
    }

    public void setVendor(TblVendor vendor) {
        this.vendor = vendor;
    }

    public TblStatus getStatus() {
        return status;
    }

    public void setStatus(TblStatus status) {
        this.status = status;
    }

   
} 
