package com.pocv01.DTO;

public class TblBahanDTO {
	 private Long id;
	    private String namaBahan;
	    private String codeBahan;
	    private Integer jumlah;
	    private String deskripsi;
	    private String satuanBesar;
	    private String satuanSatuan;
	    private String satuanDetail;
	    private String statusActiveDesc;

	    public TblBahanDTO(Long id, String namaBahan, String codeBahan, Integer jumlah, String deskripsi,
	                       String satuanBesar, String satuanSatuan, String satuanDetail, String statusActiveDesc) {
	        this.id = id;
	        this.namaBahan = namaBahan;
	        this.codeBahan = codeBahan;
	        this.jumlah = jumlah;
	        this.deskripsi = deskripsi;
	        this.satuanBesar = satuanBesar;
	        this.satuanSatuan = satuanSatuan;
	        this.satuanDetail = satuanDetail;
	        this.statusActiveDesc = statusActiveDesc;
	    }
    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaBahan() {
        return namaBahan;
    }

    public void setNamaBahan(String namaBahan) {
        this.namaBahan = namaBahan;
    }

    public String getCodeBahan() {
        return codeBahan;
    }

    public void setCodeBahan(String codeBahan) {
        this.codeBahan = codeBahan;
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

    public String getSatuanBesar() {
        return satuanBesar;
    }

    public void setSatuanBesar(String satuanBesar) {
        this.satuanBesar = satuanBesar;
    }

    public String getSatuanSatuan() {
        return satuanSatuan;
    }

    public void setSatuanSatuan(String satuanSatuan) {
        this.satuanSatuan = satuanSatuan;
    }

    public String getSatuanDetail() {
        return satuanDetail;
    }

    public void setSatuanDetail(String satuanDetail) {
        this.satuanDetail = satuanDetail;
    }

    public String getStatusActive() {
        return statusActiveDesc;
    }

    public void setStatusActive(String statusActiveDesc) {
        this.statusActiveDesc = statusActiveDesc;
    }
}
