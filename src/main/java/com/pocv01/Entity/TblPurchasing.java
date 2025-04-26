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

    @Column(name = "lastupdateddate")
    private Date lastUpdatedDate;

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
