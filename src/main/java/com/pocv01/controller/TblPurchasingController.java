package com.pocv01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pocv01.Entity.TblPurchasing;
import com.pocv01.model.Response;

import com.pocv01.repository.tblJenisGudangRepository;
import com.pocv01.repository.tblPurchasingRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/purchasing")
public class TblPurchasingController {

    @Autowired
    private tblPurchasingRepository tblRepository;

    // Create new jenis gudang
    @PostMapping("/createPurchasing")
    public ResponseEntity<Response> createJenisGudang(@jakarta.validation.Valid @RequestBody TblPurchasing tbl) {
    	Response result = new Response();
    	 try {
    		 tbl.setCreateddate(new java.util.Date()); // Set created date to now
    		 tbl.setCreatedby("system"); // Set createdby as "system" or current user
       
        
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

    // Update existing po
    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateJenisGudang(@PathVariable Long id, @jakarta.validation.Valid @RequestBody TblPurchasing tbl) {
        Optional<TblPurchasing> existingTbl = tblRepository.findById(id);
        Response result = new Response();
        if (!existingTbl.isPresent()) {
        	return ResponseEntity.notFound().build();
        }

        try {
        	TblPurchasing tblToUpdate = existingTbl.get();
        	tblToUpdate.setFkVendorId(tbl.getFkVendorId());
        	tblToUpdate.setNomorPo(tbl.getNomorPo());
        	tblToUpdate.setIsactive(tbl.getIsactive());
        	tblToUpdate.setPkPurchasingId(tbl.getPkPurchasingId());
        	tblToUpdate.setStatus(tbl.getStatus());
        	tblToUpdate.setLastupdateddate(new java.util.Date()); // Set last updated date
        	tblToUpdate.setLastupdatedby("system"); // Set the last updated by (can be current user)

            // Save the updated catalogVendor and check if the save was successful
        	TblPurchasing savedTbl = tblRepository.save(tblToUpdate);

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

    // Delete po by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteJenisGudang(@PathVariable Long id) {
        Optional<TblPurchasing> existingTbl = tblRepository.findById(id);

        if (!existingTbl.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        tblRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // POST method to get all po
    @GetMapping("/getAllPurchasing")
    public ResponseEntity<List<TblPurchasing>> getAllPO() {
        // This is a workaround to use POST for fetching data
        // The request body can be used to add any filters or additional parameters if necessary
        List<TblPurchasing> tblList = tblRepository.findAll();
        return ResponseEntity.ok(tblList);
    }

    // Get poby ID (GET remains for ID lookup)
    @GetMapping("/getPurchasing/{id}")
    public ResponseEntity<TblPurchasing> getPOById(@PathVariable Long id) {
        Optional<TblPurchasing> tbl = tblRepository.findById(id);

        if (tbl.isPresent()) {
            return ResponseEntity.ok(tbl.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
