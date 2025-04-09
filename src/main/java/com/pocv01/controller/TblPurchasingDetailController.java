package com.pocv01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pocv01.Entity.TblPurchasingDetail;
import com.pocv01.model.Response;
import com.pocv01.repository.tblPurchasingDetailRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/purchasingDetail")
public class TblPurchasingDetailController {

    @Autowired
    private tblPurchasingDetailRepository tblRepository;

    // Create new jenis gudang
    @PostMapping("/createPurchasingDetail")
    public ResponseEntity<Response> createJenisGudang(@jakarta.validation.Valid @RequestBody TblPurchasingDetail tbl) {
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

    // Update existing po detail
    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateJenisGudang(@PathVariable Long id, @jakarta.validation.Valid @RequestBody TblPurchasingDetail tbl) {
        Optional<TblPurchasingDetail> existingTbl = tblRepository.findById(id);
        Response result = new Response();
        if (!existingTbl.isPresent()) {
        	return ResponseEntity.notFound().build();
        }

        try {
        	TblPurchasingDetail tblToUpdate = existingTbl.get();
        	tblToUpdate.setFkCatalogVendorId(tbl.getFkCatalogVendorId());
        	tblToUpdate.setFkPurchasingId(tbl.getFkPurchasingId());
        	tblToUpdate.setIsactive(tbl.getIsactive());
        	tblToUpdate.setJumlah(tbl.getJumlah());
        	tblToUpdate.setPkPurchasingDetailId(tbl.getPkPurchasingDetailId());
        	tblToUpdate.setLastupdateddate(new java.util.Date()); // Set last updated date
        	tblToUpdate.setLastupdatedby("system"); // Set the last updated by (can be current user)

            // Save the updated catalogVendor and check if the save was successful
        	TblPurchasingDetail savedTbl = tblRepository.save(tblToUpdate);

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

    // Delete po detail by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteJenisGudang(@PathVariable Long id) {
        Optional<TblPurchasingDetail> existingTbl = tblRepository.findById(id);

        if (!existingTbl.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        tblRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // POST method to get all po detail
    @GetMapping("/getAllPurchasingDetail")
    public ResponseEntity<List<TblPurchasingDetail>> getAllPO() {
        // This is a workaround to use POST for fetching data
        // The request body can be used to add any filters or additional parameters if necessary
        List<TblPurchasingDetail> tblList = tblRepository.findAll();
        return ResponseEntity.ok(tblList);
    }

    // Get po detail by ID (GET remains for ID lookup)
    @GetMapping("/getPurchasingDetail/{id}")
    public ResponseEntity<TblPurchasingDetail> getPOById(@PathVariable Long id) {
        Optional<TblPurchasingDetail> tbl = tblRepository.findById(id);

        if (tbl.isPresent()) {
            return ResponseEntity.ok(tbl.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
