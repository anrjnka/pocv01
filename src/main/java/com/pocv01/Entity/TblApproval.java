package com.pocv01.Entity;



import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_approval")
public class TblApproval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_approval_id")
    private Long id;

    @Column(name = "module_name")
    private String moduleName;

    @Column(name = "fk_module_id")
    private Long fkModuleId;
    
    @ManyToOne
    @JoinColumn(name="fk_module_id", referencedColumnName="pk_module_id", insertable=false, updatable=false)
    private TblModule module;

    @Column(name = "fk_modulerow_id")
    private Long fkModulerowid;

    @Column(name = "reviewnotes")
    private String reviewNotes;

    @Column(name = "reviewby")
    private String reviewBy;

    @Column(name = "fk_status_id")
    private Long fkStatusId;
    
    @ManyToOne
    @JoinColumn(name="fk_status_id", referencedColumnName="pk_status_id", insertable=false, updatable=false)
    private TblStatus status;


    @Column(name = "fk_active_id")
    private Long isActive;
    
    @ManyToOne
    @JoinColumn(name="fk_active_id", referencedColumnName="pk_active_id", insertable=false, updatable=false)
    private TblActive active;

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

	public Long getFkModuleId() {
		return fkModuleId;
	}

	public void setFkModuleId(Long fkModuleId) {
		this.fkModuleId = fkModuleId;
	}

	public Long getFkModulerowid() {
		return fkModulerowid;
	}

	public void setFkModulerowid(Long fkModulerowid) {
		this.fkModulerowid = fkModulerowid;
	}

	public String getReviewNotes() {
		return reviewNotes;
	}

	public void setReviewNotes(String reviewNotes) {
		this.reviewNotes = reviewNotes;
	}

	public String getReviewBy() {
		return reviewBy;
	}

	public void setReviewBy(String reviewBy) {
		this.reviewBy = reviewBy;
	}

	public Long getFkStatusId() {
		return fkStatusId;
	}

	public void setFkStatusId(Long fkStatusId) {
		this.fkStatusId = fkStatusId;
	}

	public Long getIsActive() {
		return isActive;
	}

	public void setIsActive(Long isActive) {
		this.isActive = isActive;
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

	

    // --- Getters and Setters ---
    

}
