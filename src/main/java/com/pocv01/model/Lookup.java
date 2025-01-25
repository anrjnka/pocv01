package com.pocv01.model;

import java.util.List;

public class Lookup {

    private List<Item> jenisgudang;
    private List<Item> cabang;
    private List<Item> satuanbahan;
    private List<Item> nomorbahan;
    private List<Item> statuspo;

    // Getter and Setter for jenisgudang
    public List<Item> getJenisgudang() {
        return jenisgudang;
    }

    public void setJenisgudang(List<Item> jenisgudang) {
        this.jenisgudang = jenisgudang;
    }

    // Getter and Setter for cabang
    public List<Item> getCabang() {
        return cabang;
    }

    public void setCabang(List<Item> cabang) {
        this.cabang = cabang;
    }

    // Getter and Setter for satuanbahan
    public List<Item> getSatuanbahan() {
        return satuanbahan;
    }

    public void setSatuanbahan(List<Item> satuanbahan) {
        this.satuanbahan = satuanbahan;
    }

    // Getter and Setter for nomorbahan
    public List<Item> getNomorbahan() {
        return nomorbahan;
    }

    public void setNomorbahan(List<Item> nomorbahan) {
        this.nomorbahan = nomorbahan;
    }

    // Getter and Setter for statuspo
    public List<Item> getStatuspo() {
        return statuspo;
    }

    public void setStatuspo(List<Item> statuspo) {
        this.statuspo = statuspo;
    }

    
}
