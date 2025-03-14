package com.pocv01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pocv01.Entity.TblCatalogVendor;
import com.pocv01.Entity.TblGudang;
import com.pocv01.model.Response;
import com.pocv01.repository.tblCatalogVendorRepository;
import com.pocv01.repository.tblGudangRepository;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/catalogVendor")
public class TblCatalogVendorController {

    @Autowired
    private tblCatalogVendorRepository catVenRepository;

    // Create new catalogVendor
    @PostMapping("/createCatalogVendor")
    public ResponseEntity<Response> createCatalogVendor(@jakarta.validation.Valid @RequestBody TblCatalogVendor catVen) {
    	Response result = new Response();
    	 try {
    		 catVen.setCreatedDate(new java.util.Date()); // Set created date to now
    		 catVen.setCreatedBy("system"); // Set createdby as "system" or current user
       
        
        if (ResponseEntity.ok(catVenRepository.save(catVen))!=null) {
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

    // Update existing catalogVendor
    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateCatalogVendor(@PathVariable Long id, @jakarta.validation.Valid @RequestBody TblCatalogVendor catVen) {
        Optional<TblCatalogVendor> existingCatVen = catVenRepository.findById(id);
        Response result = new Response();
        if (!existingCatVen.isPresent()) {
        	return ResponseEntity.notFound().build();
        }

        try {
        	TblCatalogVendor catVenToUpdate = existingCatVen.get();
        	catVenToUpdate.setNamaBahan(catVen.getNamaBahan());
        	catVenToUpdate.setNamaVendor(catVen.getNamaVendor());
        	catVenToUpdate.setNomorBahan(catVen.getNomorBahan());
        	catVenToUpdate.setNomorVendor(catVen.getNomorVendor());
        	catVenToUpdate.setPricing(catVen.getPricing());
        	catVenToUpdate.setSatuanStockBahan(catVen.getSatuanStockBahan());
        	catVenToUpdate.setIsActive(catVen.getIsActive());
        	catVenToUpdate.setLastUpdatedDate(new java.util.Date()); // Set last updated date
        	catVenToUpdate.setLastUpdatedBy("system"); // Set the last updated by (can be current user)
        	catVenToUpdate.setCreatedBy(catVen.getCreatedBy());
        	catVenToUpdate.setCreatedDate(catVen.getCreatedDate());

            // Save the updated catalogVendor and check if the save was successful
        	TblCatalogVendor savedCatVen = catVenRepository.save(catVenToUpdate);

            // If save was successful, return created response
            if (savedCatVen != null) {
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

    // Delete catalogVendor by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCatVen(@PathVariable Long id) {
        Optional<TblCatalogVendor> existingCatVen = catVenRepository.findById(id);

        if (!existingCatVen.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        catVenRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // POST method to get all catalogVendor
    @PostMapping("/getAllCatalogVendor")
    public ResponseEntity<List<TblCatalogVendor>> getAllCatalogVendor(@RequestBody Object requestBody) {
        // This is a workaround to use POST for fetching data
        // The request body can be used to add any filters or additional parameters if necessary
        List<TblCatalogVendor> catalogVendorList = catVenRepository.findAll();
        return ResponseEntity.ok(catalogVendorList);
    }

    // Get catalogVendor by ID (GET remains for ID lookup)
    @GetMapping("/getCatalogVendor/{id}")
    public ResponseEntity<TblCatalogVendor> getCatVenById(@PathVariable Long id) {
        Optional<TblCatalogVendor> catalogVendor = catVenRepository.findById(id);

        if (catalogVendor.isPresent()) {
            return ResponseEntity.ok(catalogVendor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
