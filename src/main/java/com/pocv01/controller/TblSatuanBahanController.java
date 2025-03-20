package com.pocv01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pocv01.Entity.TblCatalogVendor;
import com.pocv01.Entity.TblGudang;
import com.pocv01.Entity.TblSatuanBahan;
import com.pocv01.model.Response;
import com.pocv01.repository.tblCatalogVendorRepository;
import com.pocv01.repository.tblGudangRepository;
import com.pocv01.repository.tblSatuanBahanRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/satuanBahan")
public class TblSatuanBahanController {

    @Autowired
    private tblSatuanBahanRepository satBahRepository;

    // Create new catalogSatbah
    @PostMapping("/createSatuanBahan")
    public ResponseEntity<Response> createSatuanBahan(@jakarta.validation.Valid @RequestBody TblSatuanBahan tbl) {
    	Response result = new Response();
    	 try {
    		 tbl.setCreatedDate(new java.util.Date()); // Set created date to now
    		 tbl.setCreatedBy("system"); // Set createdby as "system" or current user
       
        
        if (ResponseEntity.ok(satBahRepository.save(tbl))!=null) {
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

    // Update existing catalogSatbah
    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateSatuanBahan(@PathVariable Long id, @jakarta.validation.Valid @RequestBody TblSatuanBahan tbl) {
        Optional<TblSatuanBahan> existingTbl = satBahRepository.findById(id);
        Response result = new Response();
        if (!existingTbl.isPresent()) {
        	return ResponseEntity.notFound().build();
        }

        try {
        	TblSatuanBahan tblToUpdate = existingTbl.get();
        	tblToUpdate.setNamaSatuan(tbl.getNamaSatuan());
        	tblToUpdate.setIsActive(tbl.getIsActive());
        	tblToUpdate.setLastUpdatedDate(new java.util.Date()); // Set last updated date
        	tblToUpdate.setLastUpdatedBy("system"); // Set the last updated by (can be current user)

            // Save the updated catalogVendor and check if the save was successful
        	TblSatuanBahan savedTbl = satBahRepository.save(tblToUpdate);

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

    // Delete catalogSatbah by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSatuanBahan(@PathVariable Long id) {
        Optional<TblSatuanBahan> existingTbl = satBahRepository.findById(id);

        if (!existingTbl.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        satBahRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // POST method to get all catalogSatbah
    @GetMapping("/getAllSatuanBahan")
    public ResponseEntity<List<TblSatuanBahan>> getAllSatuanBahan() {
        // This is a workaround to use POST for fetching data
        // The request body can be used to add any filters or additional parameters if necessary
        List<TblSatuanBahan> tblList = satBahRepository.findAll();
        return ResponseEntity.ok(tblList);
    }

    // Get catalogSatbah by ID (GET remains for ID lookup)
    @GetMapping("/getSatuanBahan/{id}")
    public ResponseEntity<TblSatuanBahan> getSatBahById(@PathVariable Long id) {
        Optional<TblSatuanBahan> tbl = satBahRepository.findById(id);

        if (tbl.isPresent()) {
            return ResponseEntity.ok(tbl.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
