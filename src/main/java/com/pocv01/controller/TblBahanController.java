package com.pocv01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pocv01.Entity.TblBahan;
import com.pocv01.model.Response;
import com.pocv01.repository.tblBahanRepository;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bahan")
public class TblBahanController {

    @Autowired
    private tblBahanRepository bahanRepository;

    // Create new Bahan
    @PostMapping("/createBahan")
    public ResponseEntity<Response> createBahan(@jakarta.validation.Valid @RequestBody TblBahan bahan) {
        bahan.setCreateddate(new java.util.Date()); // Set created date to now
        Response result = new Response();
        
        // Assuming you're passing createdby as part of the request
        // If not, you can set it manually or use authentication to set the current user
        try {
        bahan.setCreatedby("system"); // Set createdby as "system" or current user
        
        if (ResponseEntity.ok(bahanRepository.save(bahan))!=null) {
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

    // Update existing Bahan
    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateBahan(@PathVariable Long id, @jakarta.validation.Valid @RequestBody TblBahan bahan) {
        Optional<TblBahan> existingBahan = bahanRepository.findById(id);
        Response result = new Response();
        if (!existingBahan.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        try {
        TblBahan bahanToUpdate = existingBahan.get();
        bahanToUpdate.setNamabahan(bahan.getNamabahan());
        bahanToUpdate.setPackingbesar(bahan.getPackingbesar());
        bahanToUpdate.setPackingsatuan(bahan.getPackingsatuan());
        bahanToUpdate.setPackingdetail(bahan.getPackingdetail());
        bahanToUpdate.setJumlah(bahan.getJumlah());
        bahanToUpdate.setDeskripsi(bahan.getDeskripsi());
        bahanToUpdate.setIsactive(bahan.getIsactive());
        bahanToUpdate.setLastupdateddate(new java.util.Date()); // Update last updated date
        bahanToUpdate.setLastupdatedby(bahan.getLastupdatedby()); // Set the last updated by (can be the current user)
        
        
        if (ResponseEntity.ok(bahanRepository.save(bahanToUpdate))!=null) {
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

    // Delete Bahan by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBahan(@PathVariable Long id) {
        Optional<TblBahan> existingBahan = bahanRepository.findById(id);
        
        if (!existingBahan.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        bahanRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // POST method to get all Bahan
    @PostMapping("/getAllBahan")
    public ResponseEntity<List<TblBahan>> getAllBahan(@RequestBody Object requestBody) {
        // This is a workaround to use POST for fetching data
        // The request body can be used to add any filters or additional parameters if necessary
        List<TblBahan> bahanList = bahanRepository.findAll();
        return ResponseEntity.ok(bahanList);
    }

    // Get Bahan by ID (GET remains for ID lookup)
    @GetMapping("/getBahan/{id}")
    public ResponseEntity<TblBahan> getBahanById(@PathVariable Long id) {
        Optional<TblBahan> bahan = bahanRepository.findById(id);

        if (bahan.isPresent()) {
            return ResponseEntity.ok(bahan.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

