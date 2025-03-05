package com.pocv01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pocv01.Entity.TblGudang;
import com.pocv01.model.Response;
import com.pocv01.repository.tblGudangRepository;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gudang")
public class TblGudangController {

    @Autowired
    private tblGudangRepository gudangRepository;

    // Create new Gudang
    @PostMapping("/createGudang")
    public ResponseEntity<Response> createGudang(@jakarta.validation.Valid @RequestBody TblGudang gudang) {
    	Response result = new Response();
    	 try {
    	gudang.setCreateddate(new java.util.Date()); // Set created date to now
        gudang.setCreatedby("system"); // Set createdby as "system" or current user
       
        
        if (ResponseEntity.ok(gudangRepository.save(gudang))!=null) {
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

    // Update existing Gudang
    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateGudang(@PathVariable Long id, @jakarta.validation.Valid @RequestBody TblGudang gudang) {
        Optional<TblGudang> existingGudang = gudangRepository.findById(id);
        Response result = new Response();
        if (!existingGudang.isPresent()) {
        	return ResponseEntity.notFound().build();
        }

        try {
        	TblGudang gudangToUpdate = existingGudang.get();
            gudangToUpdate.setNamagudang(gudang.getNamagudang());
            gudangToUpdate.setJenisgudang(gudang.getJenisgudang());
            gudangToUpdate.setCabanggudang(gudang.getCabanggudang());
            gudangToUpdate.setIsactive(gudang.getIsactive());
            gudangToUpdate.setLastupdateddate(new java.util.Date()); // Set last updated date
            gudangToUpdate.setLastupdatedby("system"); // Set the last updated by (can be current user)

            // Save the updated Gudang and check if the save was successful
            TblGudang savedGudang = gudangRepository.save(gudangToUpdate);

            // If save was successful, return created response
            if (savedGudang != null) {
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

    // Delete Gudang by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGudang(@PathVariable Long id) {
        Optional<TblGudang> existingGudang = gudangRepository.findById(id);

        if (!existingGudang.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        gudangRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // POST method to get all Gudang
    @PostMapping("/getAllGudang")
    public ResponseEntity<List<TblGudang>> getAllGudang(@RequestBody Object requestBody) {
        // This is a workaround to use POST for fetching data
        // The request body can be used to add any filters or additional parameters if necessary
        List<TblGudang> gudangList = gudangRepository.findAll();
        return ResponseEntity.ok(gudangList);
    }

    // Get Gudang by ID (GET remains for ID lookup)
    @GetMapping("/getGudang/{id}")
    public ResponseEntity<TblGudang> getGudangById(@PathVariable Long id) {
        Optional<TblGudang> gudang = gudangRepository.findById(id);

        if (gudang.isPresent()) {
            return ResponseEntity.ok(gudang.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
