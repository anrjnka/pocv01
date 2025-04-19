package com.pocv01.Entity;


import java.util.Date;

@jakarta.persistence.Entity
public class TblVendor {

    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long pk_vendor_id;

    @jakarta.validation.constraints.NotBlank(message = "Nama Vendor cannot be empty")
    private String namavendor;
    private String codevendor;
    private String noidentitasvendor;
    private String alamatvendor;
    private String namasales;
    private String notelepon;
    private Boolean isactive;

    private String createdby;
    private Date createddate;

    private String lastupdatedby;
    private Date lastupdateddate;

    // Getters and Setters
    
    public String getNamavendor() {
        return namavendor;
    }

    public Long getPk_vendor_id() {
		return pk_vendor_id;
	}

	public void setPk_vendor_id(Long pk_vendor_id) {
		this.pk_vendor_id = pk_vendor_id;
	}

	public void setNamavendor(String namavendor) {
        this.namavendor = namavendor;
    }

    public String getNoidentitasvendor() {
        return noidentitasvendor;
    }

    public void setNoidentitasvendor(String noidentitasvendor) {
        this.noidentitasvendor = noidentitasvendor;
    }

    public String getAlamatvendor() {
        return alamatvendor;
    }

    public void setAlamatvendor(String alamatvendor) {
        this.alamatvendor = alamatvendor;
    }

    public String getNamasales() {
        return namasales;
    }

    public void setNamasales(String namasales) {
        this.namasales = namasales;
    }

    public String getNotelepon() {
        return notelepon;
    }

    public void setNotelepon(String notelepon) {
        this.notelepon = notelepon;
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

    public String getCodevendor() {
        return codevendor;
    }

    public void setCodevendor(String codevendor) {
        this.codevendor = codevendor;
    }
}
