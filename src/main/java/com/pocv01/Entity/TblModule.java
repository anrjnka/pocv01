package com.pocv01.Entity;



import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_module")
public class TblModule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_module_id")
    private Long id;

    @Column(name = "module_name")
    private String moduleName;

    @Column(name = "module_desc")
    private String moduleDesc;

    @Column(name = "tbl_name")
    private String tableName;


    @Column(name = "fk_status_id")
    private Long fk_status_id;

    @Column(name = "fk_active_id")
    private Long fk_active_id;

    @Column(name = "createdby")
    private String createdBy;

    @Column(name = "createddate")
    private Date createdDate;

    @Column(name = "lastupdatedby")
    private String lastUpdatedBy;

    @Column(name = "lastupdateddate")
    private Date lastUpdatedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleDesc() {
		return moduleDesc;
	}

	public void setModuleDesc(String moduleDesc) {
		this.moduleDesc = moduleDesc;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Long getFk_status_id() {
		return fk_status_id;
	}

	public void setFk_status_id(Long fk_status_id) {
		this.fk_status_id = fk_status_id;
	}

	public Long getFk_active_id() {
		return fk_active_id;
	}

	public void setFk_active_id(Long fk_active_id) {
		this.fk_active_id = fk_active_id;
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

	

    
    

}
