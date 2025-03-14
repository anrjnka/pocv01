package com.pocv01.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;

    @Entity
    @Table(name = "tbl_catalogvendor")
    public class TblCatalogVendor {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "pk_catalogvendor_id")
        private Long id;

        @Column(name = "fk_nomorvendor")
        private String nomorVendor;

        @Column(name = "namavendor")
        private String namaVendor;

        @Column(name = "fk_nomorbahan")
        private String nomorBahan;

        @Column(name = "namabahan")
        private String namaBahan;

        @Column(name = "fk_satuanstockbahan")
        private String satuanStockBahan;

        @Column(name = "pricing")
        private String pricing;

        @Column(name = "isactive")
        private Boolean isActive;

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

		public void setIsActive(Boolean isActive) {
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

        public String getNomorVendor() {
            return nomorVendor;
        }

        public void setNomorVendor(String nomorVendor) {
            this.nomorVendor = nomorVendor;
        }

        public String getNamaVendor() {
            return namaVendor;
        }

        public void setNamaVendor(String namaVendor) {
            this.namaVendor = namaVendor;
        }

        public String getNomorBahan() {
            return nomorBahan;
        }

        public void setNomorBahan(String nomorBahan) {
            this.nomorBahan = nomorBahan;
        }

        public String getNamaBahan() {
            return namaBahan;
        }

        public void setNamaBahan(String namaBahan) {
            this.namaBahan = namaBahan;
        }

        public String getSatuanStockBahan() {
            return satuanStockBahan;
        }

        public void setSatuanStockBahan(String satuanStockBahan) {
            this.satuanStockBahan = satuanStockBahan;
        }

        public String getPricing() {
            return pricing;
        }

        public void setPricing(String pricing) {
            this.pricing = pricing;
        }

        public Boolean getIsActive() {
            return isActive;
        }

    }
