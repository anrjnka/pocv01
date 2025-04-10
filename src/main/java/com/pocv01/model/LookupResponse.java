package com.pocv01.model;

import java.util.List;

public class LookupResponse {
    private Long value;
    private String label;
    private Object data; 

    public LookupResponse(Long value, String label, Object data){
        this.value = value;
        this.label = label;
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
   
}
