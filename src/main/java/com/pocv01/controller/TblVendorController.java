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

import com.pocv01.Entity.TblVendor;
import com.pocv01.model.Response;
import com.pocv01.repository.tblVendorRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/vendor")
public class TblVendorController {

    @Autowired
    private tblVendorRepository vendorRepository;

    // Create new Vendor
    @PostMapping("/createVendor")
    public ResponseEntity<Response> createVendor(@jakarta.validation.Valid @RequestBody TblVendor vendor) {
    	Response result = new Response();
    	try {
    	vendor.setCreatedDate(new java.util.Date()); // Set created date to now
        vendor.setCreatedBy("system"); // Set createdby as "system" or current user
        
        
        if (ResponseEntity.ok(vendorRepository.save(vendor))!=null) {
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

    // Update existing Vendor
    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateVendor(@PathVariable Long id, @jakarta.validation.Valid @RequestBody TblVendor vendor) {
        Optional<TblVendor> existingVendor = vendorRepository.findById(id);
        Response result = new Response();
        if (!existingVendor.isPresent()) {
        	return ResponseEntity.notFound().build();
        }

        try {
        	TblVendor vendorToUpdate = existingVendor.get();
            vendorToUpdate.setNamaVendor(vendor.getNamaVendor());
            vendorToUpdate.setCodeVendor(vendor.getCodeVendor());
            vendorToUpdate.setNoidentitasvendor(vendor.getNoidentitasvendor());
            vendorToUpdate.setAlamatVendor(vendor.getAlamatVendor());
            vendorToUpdate.setNamaSales(vendor.getNamaSales());
            vendorToUpdate.setNoTelepon(vendor.getNoTelepon());
            vendorToUpdate.setIsActive(vendor.getIsActive());
            vendorToUpdate.setLastUpdatedDate(new java.util.Date()); // Set last updated date
            vendorToUpdate.setLastUpdatedBy("system"); // Set the last updated by (can be current user)

            // Save the updated Vendor and check if the save was successful
            TblVendor savedVendor = vendorRepository.save(vendorToUpdate);

            // If save was successful, return created response
            if (savedVendor != null) {
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

    // Delete Vendor by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVendor(@PathVariable Long id) {
        Optional<TblVendor> existingVendor = vendorRepository.findById(id);

        if (!existingVendor.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        vendorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // POST method to get all Vendor
    @GetMapping("/getAllVendor")
    public ResponseEntity<List<TblVendor>> getAllVendor() {
        // This is a workaround to use POST for fetching data
        // The request body can be used to add any filters or additional parameters if necessary
        List<TblVendor> vendorList = vendorRepository.findAll();
        return ResponseEntity.ok(vendorList);
    }

    // Get Vendor by ID (GET remains for ID lookup)
    @GetMapping("/getVendor/{id}")
    public ResponseEntity<TblVendor> getVendorById(@PathVariable Long id) {
        Optional<TblVendor> vendor = vendorRepository.findById(id);

        if (vendor.isPresent()) {
            return ResponseEntity.ok(vendor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

