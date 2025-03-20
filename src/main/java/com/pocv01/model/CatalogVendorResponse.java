package com.pocv01.model;

import java.util.List;

import com.pocv01.Entity.TblBahan;
import com.pocv01.Entity.TblCatalogVendor;

public class CatalogVendorResponse {
    private List<TblCatalogVendor> data;
    private List<TblBahan> lookup;

    public CatalogVendorResponse(List<TblCatalogVendor> data, List<TblBahan> lookup){
        this.data = data;
        this.lookup = lookup;
    }

    public List<TblCatalogVendor> getData() {
        return data;
    }

    public List<TblBahan> getLookup() {
        return lookup;
    }

    public void setData(List<TblCatalogVendor> data) {
        this.data = data;
    }

    public void setLookup(List<TblBahan> lookup) {
        this.lookup = lookup;
    }
}
