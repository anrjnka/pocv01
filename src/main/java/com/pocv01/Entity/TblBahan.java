package com.pocv01.Entity;


import java.util.Date;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;

@jakarta.persistence.Entity
public class TblBahan {

    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk_bahan_id;

    @NotBlank(message = "Nama Bahan cannot be empty")
    private String namabahan;

    private String packingbesar;
    private String packingsatuan;
    private String packingdetail;
    private Integer jumlah;
	private String deskripsi;
    private Boolean isactive;
    private String createdby;
    private Date createddate;
    private String lastupdatedby;
    private Date lastupdateddate;

    // Getters and Setters


    public Long getPk_bahan_id() {
		return pk_bahan_id;
	}

	public void setPk_bahan_id(Long pk_bahan_id) {
		this.pk_bahan_id = pk_bahan_id;
	}
	
    public String getNamabahan() {
        return namabahan;
    }

    public void setNamabahan(String namabahan) {
        this.namabahan = namabahan;
    }

    public String getPackingbesar() {
        return packingbesar;
    }

    public void setPackingbesar(String packingbesar) {
        this.packingbesar = packingbesar;
    }

    public String getPackingsatuan() {
        return packingsatuan;
    }

    public void setPackingsatuan(String packingsatuan) {
        this.packingsatuan = packingsatuan;
    }

    public String getPackingdetail() {
        return packingdetail;
    }

    public void setPackingdetail(String packingdetail) {
        this.packingdetail = packingdetail;
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
