package com.pocv01.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

import java.sql.Date;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.ManyToOne;

    @Entity
    @Table(name = "tbl_catalogvendor")
    public class TblCatalogVendor {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "pk_catalogvendor_id")
        private Long id;

        @Column(name = "fk_vendor_id")
        private Long vendorId;
        
        @ManyToOne
        @JoinColumn(name="fk_vendor_id", referencedColumnName="pk_vendor_id", insertable=false, updatable=false)
        private TblVendor vendor;

        @Column(name = "namavendor")
        private String namaVendor;

        @Column(name = "fk_bahan_id")
        private Long bahanId;

        @ManyToOne
        @JoinColumn(name="fk_bahan_id", referencedColumnName="pk_bahan_id", insertable=false, updatable=false)
        private TblBahan bahan;

        @Column(name = "namabahan")
        private String namaBahan;

        @Column(name = "fk_satuanbahan_id")
        private Long satuanBahanId;

        @ManyToOne
        @JoinColumn(name="fk_satuanbahan_id", referencedColumnName="pk_satuanbahan_id", insertable=false, updatable=false)
        private TblSatuanBahan satuan;

        @Column(name = "pricing")
        private String pricing;

        @Column(name = "fk_active_id")
        private Long isActive;

        @ManyToOne
        @JoinColumn(name="fk_active_id", referencedColumnName="pk_active_id", insertable=false, updatable=false)
        private TblActive active;

        @Column(name = "createdby")
        private String createdBy;

        public String getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}

		public java.util.Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(java.util.Date createdDate) {
			this.createdDate = createdDate;
		}

		public String getLastUpdatedBy() {
			return lastUpdatedBy;
		}

		public void setLastUpdatedBy(String lastUpdatedBy) {
			this.lastUpdatedBy = lastUpdatedBy;
		}

		public java.util.Date getLastUpdatedDate() {
			return lastUpdatedDate;
		}

		public void setLastUpdatedDate(java.util.Date lastUpdatedDate) {
			this.lastUpdatedDate = lastUpdatedDate;
		}

		public void setIsActive(Long isActive) {
			this.isActive = isActive;
		}

		@Column(name = "createddate")
        private java.util.Date createdDate; // Changed to java.sql.Date

        @Column(name = "lastupdatedby")
        private String lastUpdatedBy;

        @Column(name = "lastupdateddate")
        private java.util.Date lastUpdatedDate; // Changed to java.sql.Date

        // Getters and setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getVendorId() {
            return vendorId;
        }

        public void setVendorId(Long vendorId) {
            this.vendorId = vendorId;
        }

        public String getNamaVendor() {
            return namaVendor;
        }

        public void setNamaVendor(String namaVendor) {
            this.namaVendor = namaVendor;
        }

        public Long getBahanId() {
            return bahanId;
        }

        public void setBahanId(Long bahanId) {
            this.bahanId = bahanId;
        }
    
        public String getNamaBahan() {
            return namaBahan;
        }

        public void setNamaBahan(String namaBahan) {
            this.namaBahan = namaBahan;
        }

        public Long getSatuanBahanId() {
            return satuanBahanId;
        }
    
        public void setSatuanBahanId(Long satuanBahanId) {
            this.satuanBahanId = satuanBahanId;
        }

        public String getPricing() {
            return pricing;
        }

        public void setPricing(String pricing) {
            this.pricing = pricing;
        }

        public Long getIsActive() {
            return isActive;
        }

    public TblBahan getBahan() {
        return bahan;
    }

    public void setBahan(TblBahan bahan) {
        this.bahan = bahan;
    }

    public TblVendor getVendor() {
        return vendor;
    }

    public void setVendor(TblVendor vendor) {
        this.vendor = vendor;
    }

    public TblSatuanBahan getSatuan() {
        return satuan;
    }

    public void setSatuan(TblSatuanBahan satuan) {
        this.satuan = satuan;
    }

    public TblActive getActive() {
        return active;
    }

    public void setActive(TblActive active) {
        this.active = active;
    }

    }
