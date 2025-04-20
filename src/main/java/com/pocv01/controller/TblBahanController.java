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

import com.pocv01.Entity.TblBahan;
import com.pocv01.model.Response;
import com.pocv01.repository.tblBahanRepository;

@RestController
@CrossOrigin
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
        bahanToUpdate.setCodebahan(bahan.getCodebahan());
        bahanToUpdate.setNamabahan(bahan.getNamabahan());
        bahanToUpdate.setFk_satuanbesar_id(bahan.getFk_satuanbesar_id());
        bahanToUpdate.setFk_satuan_id(bahan.getFk_satuan_id());
        bahanToUpdate.setFk_satuandetail_id(bahan.getFk_satuandetail_id());
        bahanToUpdate.setJumlah(bahan.getJumlah());
        bahanToUpdate.setDeskripsi(bahan.getDeskripsi());
        bahanToUpdate.setFk_active_id(bahan.getFk_active_id());
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
    @GetMapping("/getAllBahan")
    public ResponseEntity<List<TblBahan>> getAllBahan() {
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

