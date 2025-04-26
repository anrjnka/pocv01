package com.pocv01.Entity;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@jakarta.persistence.Entity
public class TblBahan {

    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk_bahan_id;
    
    @Column(name = "namabahan")
    @NotBlank(message = "Nama Bahan cannot be empty")
    private String namaBahan;

    private Long fk_satuanbesar_id;
	@ManyToOne
	@JoinColumn(name="fk_satuanbesar_id", referencedColumnName="pk_satuanbahan_id", insertable=false, updatable=false)
    private TblSatuanBahan packingbesar;
    
    private Long fk_satuan_id;
	@ManyToOne
	@JoinColumn(name="fk_satuan_id", referencedColumnName="pk_satuanbahan_id", insertable=false, updatable=false)
    private TblSatuanBahan packingsatuan;
    
    private Long fk_satuandetail_id;
	@ManyToOne
	@JoinColumn(name="fk_satuandetail_id", referencedColumnName="pk_satuanbahan_id", insertable=false, updatable=false)
    private TblSatuanBahan packingdetail;
    
	@Column(name = "codebahan")
	private String codeBahan;
    
	@Column(name = "jumlah")
	private Integer jumlah;
	
	@Column(name = "deskripsi")
	private String deskripsi;
    
	private Long fk_active_id;
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

    // Getters and Setters


    public Long getPk_bahan_id() {
		return pk_bahan_id;
	}

	public void setPk_bahan_id(Long pk_bahan_id) {
		this.pk_bahan_id = pk_bahan_id;
	}
	
    public String getNamaBahan() {
        return namaBahan;
    }

    public void setNamaBahan(String namaBahan) {
        this.namaBahan = namaBahan;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
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

    public String getCodeBahan() {
        return codeBahan;
    }

    public void setCodeBahan(String codeBahan) {
        this.codeBahan = codeBahan;
    }

    public TblActive getActive() {
        return active;
    }

    public void setActive(TblActive active) {
        this.active = active;
    }

    public Long getFk_active_id() {
        return fk_active_id;
    }

    public void setFk_active_id(Long fk_active_id) {
        this.fk_active_id = fk_active_id;
    }

    public Long getFk_satuanbesar_id() {
        return fk_satuanbesar_id;
    }

    public void setFk_satuanbesar_id(Long fk_satuanbesar_id) {
        this.fk_satuanbesar_id = fk_satuanbesar_id;
    }

    public Long getFk_satuan_id() {
        return fk_satuan_id;
    }

    public void setFk_satuan_id(Long fk_satuan_id) {
        this.fk_satuan_id = fk_satuan_id;
    }

    public Long getFk_satuandetail_id() {
        return fk_satuandetail_id;
    }

    public void setFk_satuandetail_id(Long fk_satuandetail_id) {
        this.fk_satuandetail_id = fk_satuandetail_id;
    }

    public TblSatuanBahan getPackingbesar() {
        return packingbesar;
    }

    public void setPackingbesar(TblSatuanBahan packingbesar) {
        this.packingbesar = packingbesar;
    }

    public TblSatuanBahan getPackingsatuan() {
        return packingsatuan;
    }

    public void setPackingsatuan(TblSatuanBahan packingsatuan) {
        this.packingsatuan = packingsatuan;
    }

    public TblSatuanBahan getPackingdetail() {
        return packingdetail;
    }

    public void setPackingdetail(TblSatuanBahan packingdetail) {
        this.packingdetail = packingdetail;
    }

}
