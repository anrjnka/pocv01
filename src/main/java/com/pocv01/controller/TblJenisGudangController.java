package com.pocv01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pocv01.Entity.TblCatalogVendor;
import com.pocv01.Entity.TblGudang;
import com.pocv01.Entity.TblJenisGudang;
import com.pocv01.model.Response;

import com.pocv01.repository.tblJenisGudangRepository;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jenisGudang")
public class TblJenisGudangController {

    @Autowired
    private tblJenisGudangRepository jenGudRepository;

    // Create new jenis gudang
    @PostMapping("/createJenisGudang")
    public ResponseEntity<Response> createJenisGudang(@jakarta.validation.Valid @RequestBody TblJenisGudang tbl) {
    	Response result = new Response();
    	 try {
    		 tbl.setCreatedDate(new java.util.Date()); // Set created date to now
    		 tbl.setCreatedBy("system"); // Set createdby as "system" or current user
       
        
        if (ResponseEntity.ok(jenGudRepository.save(tbl))!=null) {
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

    // Update existing jenis gudang
    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateJenisGudang(@PathVariable Long id, @jakarta.validation.Valid @RequestBody TblJenisGudang tbl) {
        Optional<TblJenisGudang> existingTbl = jenGudRepository.findById(id);
        Response result = new Response();
        if (!existingTbl.isPresent()) {
        	return ResponseEntity.notFound().build();
        }

        try {
        	TblJenisGudang tblToUpdate = existingTbl.get();
        	tblToUpdate.setJenisGudang(tbl.getJenisGudang());
        	tblToUpdate.setIsActive(tbl.getIsActive());
        	tblToUpdate.setLastUpdatedDate(new java.util.Date()); // Set last updated date
        	tblToUpdate.setLastUpdatedBy("system"); // Set the last updated by (can be current user)
        	tblToUpdate.setCreatedBy(tbl.getCreatedBy());
        	tblToUpdate.setCreatedDate(tbl.getCreatedDate());

            // Save the updated catalogVendor and check if the save was successful
        	TblJenisGudang savedTbl = jenGudRepository.save(tblToUpdate);

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

    // Delete jenis gudang by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteJenisGudang(@PathVariable Long id) {
        Optional<TblJenisGudang> existingTbl = jenGudRepository.findById(id);

        if (!existingTbl.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        jenGudRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // POST method to get all jenis gudang
    @PostMapping("/getAllJenisGudang")
    public ResponseEntity<List<TblJenisGudang>> getAllSatuanBahan(@RequestBody Object requestBody) {
        // This is a workaround to use POST for fetching data
        // The request body can be used to add any filters or additional parameters if necessary
        List<TblJenisGudang> tblList = jenGudRepository.findAll();
        return ResponseEntity.ok(tblList);
    }

    // Get jenis gudang by ID (GET remains for ID lookup)
    @GetMapping("/getSatuanBahan/{id}")
    public ResponseEntity<TblJenisGudang> getJenGudById(@PathVariable Long id) {
        Optional<TblJenisGudang> tbl = jenGudRepository.findById(id);

        if (tbl.isPresent()) {
            return ResponseEntity.ok(tbl.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
