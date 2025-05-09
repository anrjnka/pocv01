package com.pocv01.repository;

import com.pocv01.DTO.TblApprovalDTO;
import com.pocv01.Entity.TblApproval;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TblApprovalRepositoryDTO extends JpaRepository<TblApproval, Long> {

	@Query("SELECT new com.pocv01.DTO.TblApprovalDTO(" +
		       "a.id, a.moduleName, a.fkModuleId, a.fkModulerowid, a.reviewNotes, a.reviewBy, " +
		       "a.fkStatusId, a.isActive, a.createdBy, a.createdDate, a.lastUpdatedBy, a.lastUpdatedDate, " +
		       "m.moduleName, m.moduleDesc, m.tableName) " +  // <- changed from m.tblName to m.tableName
		       "FROM TblApproval a " +
		       "JOIN TblModule m ON a.fkModuleId = m.id " +
		       "WHERE m.moduleName = :moduleName")
		List<TblApprovalDTO> findAllJoinedByModuleName(@Param("moduleName") String moduleName);


}
