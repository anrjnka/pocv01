package com.pocv01.DTO;

import java.util.Date;

public class TblApprovalDTO {

    private Long id;
    private String moduleName; // module name from TblApproval
    private Long fkModuleId;
    private Long fkModulerowid;
    private String reviewNotes;
    private String reviewBy;
    private Long fkStatusId;
    private Long isActive; // Note: You should probably use Boolean if `isActive` is truly a flag
    private String createdBy;
    private Date createdDate;
    private String lastUpdatedBy;
    private Date lastUpdatedDate;

    // TblModule details
    private String moduleModuleName;
    private String moduleDesc;
    private String tblName;
    
    //Tbl_status
    private String namaStatus;

  
	// Constructor matching the query result (order must be the same)
    public TblApprovalDTO(
        Long id, String moduleName, Long fkModuleId, Long fkModulerowid, 
        String reviewNotes, String reviewBy, Long fkStatusId, 
        Long isActive, String createdBy, Date createdDate, 
        String lastUpdatedBy, Date lastUpdatedDate, 
        String moduleModuleName, String moduleDesc, String tableName, String namaStatus
    ) {
        this.id = id;
        this.moduleName = moduleName;
        this.fkModuleId = fkModuleId;
        this.fkModulerowid = fkModulerowid;
        this.reviewNotes = reviewNotes;
        this.reviewBy = reviewBy;
        this.fkStatusId = fkStatusId;
        this.isActive = isActive;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdatedDate = lastUpdatedDate;
        this.moduleModuleName = moduleModuleName;
        this.moduleDesc = moduleDesc;
        this.tblName = tableName;
        this.namaStatus = namaStatus;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModuleName() { return moduleName; }
    public void setModuleName(String moduleName) { this.moduleName = moduleName; }

    public Long getFkModuleId() { return fkModuleId; }
    public void setFkModuleId(Long fkModuleId) { this.fkModuleId = fkModuleId; }

    public Long getFkModulerowid() { return fkModulerowid; }
    public void setFkModulerowid(Long fkModulerowid) { this.fkModulerowid = fkModulerowid; }

    public String getReviewNotes() { return reviewNotes; }
    public void setReviewNotes(String reviewNotes) { this.reviewNotes = reviewNotes; }

    public String getReviewBy() { return reviewBy; }
    public void setReviewBy(String reviewBy) { this.reviewBy = reviewBy; }

    public Long getFkStatusId() { return fkStatusId; }
    public void setFkStatusId(Long fkStatusId) { this.fkStatusId = fkStatusId; }

    public Long getIsActive() { return isActive; }
    public void setIsActive(Long isActive) { this.isActive = isActive; }

    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public Date getCreatedDate() { return createdDate; }
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

    public String getLastUpdatedBy() { return lastUpdatedBy; }
    public void setLastUpdatedBy(String lastUpdatedBy) { this.lastUpdatedBy = lastUpdatedBy; }

    public Date getLastUpdatedDate() { return lastUpdatedDate; }
    public void setLastUpdatedDate(Date lastUpdatedDate) { this.lastUpdatedDate = lastUpdatedDate; }

    public String getModuleModuleName() { return moduleModuleName; }
    public void setModuleModuleName(String moduleModuleName) { this.moduleModuleName = moduleModuleName; }

    public String getModuleDesc() { return moduleDesc; }
    public void setModuleDesc(String moduleDesc) { this.moduleDesc = moduleDesc; }

    public String getTblName() { return tblName; }
    public void setTblName(String tblName) { this.tblName = tblName; }

	public String getNamaStatus() {
		return namaStatus;
	}

	public void setNamaStatus(String namaStatus) {
		this.namaStatus = namaStatus;
	}
    
    
}
