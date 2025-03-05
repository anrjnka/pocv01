package com.pocv01.Entity;


import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class TblGudang {

    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long pk_gudang_id;

    @jakarta.validation.constraints.NotBlank(message = "Nama Gudang cannot be empty")
    private String namagudang;

    private String jenisgudang;
    private String cabanggudang;
    private Boolean isactive;

    private String createdby;
    private Date createddate;

    private String lastupdatedby;
    private Date lastupdateddate;

    // Getters and Setters
    

    public String getNamagudang() {
        return namagudang;
    }

    public Long getPk_gudang_id() {
		return pk_gudang_id;
	}

	public void setPk_gudang_id(Long pk_gudang_id) {
		this.pk_gudang_id = pk_gudang_id;
	}


	    public void setNamagudang(String namagudang) {
	        this.namagudang = namagudang;
	    }

	    public String getJenisgudang() {
	        return jenisgudang;
	    }

	    public void setJenisgudang(String jenisgudang) {
	        this.jenisgudang = jenisgudang;
	    }

	    public String getCabanggudang() {
	        return cabanggudang;
	    }

	    public void setCabanggudang(String cabanggudang) {
	        this.cabanggudang = cabanggudang;
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