package com.pocv01.controller;

import java.util.List;
import java.util.Optional;
import com.pocv01.service.authenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pocv01.repository.tblCabangRepository;
import com.pocv01.App;
import com.pocv01.Entity.TblCabang;
import com.pocv01.Entity.TblCatalogVendor;
import com.pocv01.model.Response;




@RestController
@CrossOrigin
@RequestMapping("/api/cabang")
public class TblCabangController {

    @Autowired
    private tblCabangRepository cabangRepository;

    @PostMapping("/createCabang")
    public ResponseEntity<Response> createCabang(@jakarta.validation.Valid @RequestBody TblCabang tblCab) {
        //TODO: process POST request
        Response result = new Response();
            try {
                tblCab.setCreatedBy("system");
                tblCab.setCreatedDate(new java.util.Date());
                
                if(ResponseEntity.ok(cabangRepository.save(tblCab))!=null){
                    result.setStatus("success");
                    return new ResponseEntity<>(result, HttpStatus.CREATED);
                }else{
                    result.setStatus("Failed");
                    return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
                }
            } catch (Exception e) {
                result = null;
                return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
            }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateCabang(@PathVariable Long id, @jakarta.validation.Valid @RequestBody TblCabang tblCab) {
        //TODO: process PUT request
        Optional<TblCabang> existingCab = cabangRepository.findById(id);
        Response result = new Response();

        if(!existingCab.isPresent()){
            return ResponseEntity.notFound().build();
        }

        try {
            TblCabang cabToUpdate = existingCab.get();
            cabToUpdate.setNamaCabang(tblCab.getNamaCabang());
            cabToUpdate.setIsActive(tblCab.getIsActive());
            cabToUpdate.setLastUpdatedBy("system");
            cabToUpdate.setLastUpdatedDate(new java.util.Date());

            TblCabang saveCab = cabangRepository.save(cabToUpdate);

            if (saveCab !=null) {
                result.setStatus("success");
                return new ResponseEntity<>(result, HttpStatus.CREATED);
                
            } else {
                result.setStatus("Failed");
                return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
            }
            
        } catch (Exception e) {
            result = null;
            return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
        }        
    }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<Void> deleteCabang(@PathVariable Long id){
    Optional<TblCabang> existingCabang = cabangRepository.findById(id);

    if (!existingCabang.isPresent()) {
        return ResponseEntity.notFound().build();    
    } 

    cabangRepository.deleteById(id);
    return ResponseEntity.noContent().build();
   }

   @GetMapping("/getAllCabang")
   public ResponseEntity<List<TblCabang>> getAllCabang() {
       // This is a workaround to use POST for fetching data
        // The request body can be used to add any filters or additional parameters if necessary
        List<TblCabang> cabangList = cabangRepository.findAll();
        return ResponseEntity.ok(cabangList);
   }
   
    @GetMapping("/getCatalogVendor/{id}")
    public ResponseEntity<TblCabang> getCabangById(@PathVariable Long id) {
        Optional<TblCabang> cabang= cabangRepository.findById(id);

        if (cabang.isPresent()) {
            return ResponseEntity.ok(cabang.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
   

    
}
