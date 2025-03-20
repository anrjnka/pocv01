package com.pocv01.model;

public class LookupResponse {
    private Long value;
    private String label;

    public LookupResponse(Long value, String label){
        this.value = value;
        this.label = label;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
   
}
