package com.pocv01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pocv01.Entity.TblCatalogVendor;
import com.pocv01.App;
import com.pocv01.Entity.TblBahan;
import com.pocv01.model.Response;
import com.pocv01.repository.tblCatalogVendorRepository;
import com.pocv01.repository.tblBahanRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.stream.Collectors;

import com.pocv01.Entity.TblActive;
import com.pocv01.Entity.TblSatuanBahan;
import com.pocv01.Entity.TblVendor;
import com.pocv01.model.LookupResponse;
import com.pocv01.repository.tblActiveRepository;
import com.pocv01.repository.tblSatuanBahanRepository;
import com.pocv01.repository.tblVendorRepository;


@RestController
@CrossOrigin
@RequestMapping("/api/catalogVendor")
public class TblCatalogVendorController {

    @Autowired
    private tblCatalogVendorRepository catVenRepository;
    
    @Autowired
    private tblBahanRepository bahanRepository;

    @Autowired
    private tblSatuanBahanRepository satuanRepository;

    @Autowired
    private tblVendorRepository vendorRepository;

    @Autowired
    private tblActiveRepository activeRepository;

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
        	catVenToUpdate.setBahanId(catVen.getBahanId());
        	catVenToUpdate.setVendorId(catVen.getVendorId());
        	catVenToUpdate.setPricing(catVen.getPricing());
        	catVenToUpdate.setSatuanBahanId(catVen.getSatuanBahanId());
        	catVenToUpdate.setIsActive(catVen.getIsActive());
        	catVenToUpdate.setLastUpdatedDate(new java.util.Date()); // Set last updated date
        	catVenToUpdate.setLastUpdatedBy("system"); // Set the last updated by (can be current user)

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
    @GetMapping("/getAllCatalogVendor")
    public ResponseEntity<Map<String,Object>> getAllCatalogVendor() {
        // This is a workaround to use POST for fetching data
        // The request body can be used to add any filters or additional parameters if necessary
        
        List<TblCatalogVendor> catalogVendorList = catVenRepository.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("data", catalogVendorList);

        /*List<TblBahan> bahanList = bahanRepository.findAll();
        List<LookupResponse> bahanResponse = bahanList.stream().
        map(bahan -> new LookupResponse(bahan.getPk_bahan_id(), bahan.getNamabahan())).
        collect(Collectors.toList());

        List<TblSatuanBahan> satuanBahanList = satuanRepository.findAll();
        List<LookupResponse> satuanResponse = satuanBahanList.stream().
        map(satuan -> new LookupResponse(satuan.getId(), satuan.getNamaSatuan())).
        collect(Collectors.toList());

        List<TblVendor> vendorList = vendorRepository.findAll();
        List<LookupResponse> vendorResponse = vendorList.stream().
        map(vendor -> new LookupResponse(vendor.getPk_vendor_id(), vendor.getNamavendor())).
        collect(Collectors.toList());

        List<TblActive> activeList = activeRepository.findAll();
        List<LookupResponse> activeResponse = activeList.stream().
        map(active -> new LookupResponse(active.getId(), active.getIsActiveDesc())).
        collect(Collectors.toList());

        response.put("lookup", new HashMap<String,Object>(){{
            put("nomorbahan", bahanResponse);
            put("satuanbahan", satuanResponse);
            put("vendor", vendorResponse);
            put("active", activeResponse);

        }});
        */
        return ResponseEntity.ok(response);
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
