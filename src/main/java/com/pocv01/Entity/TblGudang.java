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
@Table(name = "tbl_gudang")
public class TblGudang {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_gudang_id")
    private Long id;

	@Column(name = "namagudang")
    private String namaGudang;
	
	@Column(name = "codegudang")
	private String codeGudang;
	
	@Column(name = "fk_jenisgudang_id")
    private Long jenisGudangId;
	
	@ManyToOne
    @JoinColumn(name="fk_jenisgudang_id", referencedColumnName="pk_jenisgudang_id", insertable=false, updatable=false)
    private TblJenisGudang jenisGudang;

	@Column(name = "fk_cabang_id")
    private Long cabangId;

	@ManyToOne
    @JoinColumn(name="fk_cabang_id", referencedColumnName="pk_cabang_id", insertable=false, updatable=false)
    private TblCabang cabangGudang;
	
	@Column(name = "fk_active_id")
    private Long activeId;

	@ManyToOne
	@JoinColumn(name="fk_active_id", referencedColumnName="pk_active_id", insertable=false, updatable=false)
	private TblActive active;

	@Column(name = "createdby")
    private String createdBy;

	@Column(name = "createddate")
    private Date createdDate;

	@Column(name = "lastupdatedby")
    private String lastupdatedBy;
	
	@Column(name = "lastupdateddate")
    private Date lastupdatedDate;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaGudang() {
        return namaGudang;
    }

    public void setNamaGudang(String namaGudang) {
        this.namaGudang = namaGudang;
    }

    public String getCodeGudang() {
        return codeGudang;
    }

    public void setCodeGudang(String codeGudang) {
        this.codeGudang = codeGudang;
    }

    public TblActive getActive() {
        return active;
    }

    public void setActive(TblActive active) {
        this.active = active;
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

    public String getLastupdatedBy() {
        return lastupdatedBy;
    }

    public void setLastupdatedBy(String lastupdatedBy) {
        this.lastupdatedBy = lastupdatedBy;
    }

    public Date getLastupdatedDate() {
        return lastupdatedDate;
    }

    public void setLastupdatedDate(Date lastupdatedDate) {
        this.lastupdatedDate = lastupdatedDate;
    }

    public Long getActiveId() {
        return activeId;
    }

    public void setActiveId(Long activeId) {
        this.activeId = activeId;
    }

    public Long getJenisGudangId() {
        return jenisGudangId;
    }

    public void setJenisGudangId(Long jenisGudangId) {
        this.jenisGudangId = jenisGudangId;
    }

    public Long getCabangId() {
        return cabangId;
    }

    public void setCabangId(Long cabangId) {
        this.cabangId = cabangId;
    }

    public TblJenisGudang getJenisGudang() {
        return jenisGudang;
    }

    public void setJenisGudang(TblJenisGudang jenisGudang) {
        this.jenisGudang = jenisGudang;
    }

    public TblCabang getCabangGudang() {
        return cabangGudang;
    }

    public void setCabangGudang(TblCabang cabangGudang) {
        this.cabangGudang = cabangGudang;
    }
    
    
	}