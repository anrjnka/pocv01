package com.pocv01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pocv01.Entity.TblModule;
import com.pocv01.model.Response;
import com.pocv01.repository.tblModuleRepository;




@RestController
@CrossOrigin
@RequestMapping("/api/module")
public class TblModuleController {

    @Autowired
    private tblModuleRepository tblRepository;

    // Create new Module
    @PostMapping("/createModule")
    public ResponseEntity<Response> createApproval(@jakarta.validation.Valid @RequestBody TblModule tbl) {
    	Response result = new Response();
    	 try {
    		 tbl.setCreatedDate(new java.util.Date()); // Set created date to now
    		 tbl.setCreatedBy("system"); // Set createdby as "system" or current user
       
        
        if (ResponseEntity.ok(tblRepository.save(tbl))!=null) {
        	result.setStatus("success");
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } else {
        	result.setStatus("Failed");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    	 } catch (Exception e) {
 			// TODO: handle exception
 			result = null;
 			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
 		}
    }

    // Update existing Module
    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateApproval(@PathVariable Long id, @jakarta.validation.Valid @RequestBody TblModule tbl) {
        Optional<TblModule> existingTbl = tblRepository.findById(id);
        Response result = new Response();
        if (!existingTbl.isPresent()) {
        	return ResponseEntity.notFound().build();
        }

        try {
        	TblModule tblToUpdate = existingTbl.get();
        	tblToUpdate.setFk_active_id(tbl.getFk_active_id());
        	tblToUpdate.setFk_status_id(tbl.getFk_status_id());
        	tblToUpdate.setModuleDesc(tbl.getModuleDesc());
        	tblToUpdate.setModuleName(tbl.getModuleName());
        	tblToUpdate.setTableName(tbl.getTableName());
        	tblToUpdate.setModuleName(tbl.getModuleName());
        	tblToUpdate.setLastUpdatedDate(new java.util.Date()); // Set last updated date
        	tblToUpdate.setLastUpdatedBy("system"); // Set the last updated by (can be current user)

            // Save the updated catalogVendor and check if the save was successful
        	TblModule savedTbl = tblRepository.save(tblToUpdate);

            // If save was successful, return created response
            if (savedTbl != null) {
            	result.setStatus("success");
                return new ResponseEntity<>(result, HttpStatus.CREATED);
            } else {
                // In case something went wrong, return bad request
            	result.setStatus("failed");
                return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            // Handle any other exception or error
        	result = null;
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    // Delete Module by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteApproval(@PathVariable Long id) {
        Optional<TblModule> existingTbl = tblRepository.findById(id);

        if (!existingTbl.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        tblRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // POST method to get all Module
    @GetMapping("/getAllModule")
    public ResponseEntity<List<TblModule>> getAllApproval() {
        // This is a workaround to use POST for fetching data
        // The request body can be used to add any filters or additional parameters if necessary
        List<TblModule> tblList = tblRepository.findAll();
        return ResponseEntity.ok(tblList);
    }

    // Get appproval by ID (GET remains for ID lookup)
    @GetMapping("/getModule/{id}")
    public ResponseEntity<TblModule> getApprovalById(@PathVariable Long id) {
        Optional<TblModule> tbl = tblRepository.findById(id);

        if (tbl.isPresent()) {
            return ResponseEntity.ok(tbl.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
