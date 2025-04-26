package com.pocv01.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pocv01.Entity.TblActive;
import com.pocv01.Entity.TblBahan;
import com.pocv01.Entity.TblCabang;
import com.pocv01.Entity.TblJenisGudang;
import com.pocv01.Entity.TblSatuanBahan;
import com.pocv01.Entity.TblVendor;
import com.pocv01.model.LookupKey;
import com.pocv01.model.LookupResponse;
import com.pocv01.repository.tblActiveRepository;
import com.pocv01.repository.tblBahanRepository;
import com.pocv01.repository.tblCabangRepository;
import com.pocv01.repository.tblJenisGudangRepository;
import com.pocv01.repository.tblSatuanBahanRepository;
import com.pocv01.repository.tblVendorRepository;




@RestController
@CrossOrigin
@RequestMapping("/api/lookup")
public class LookupController {
	
	@Autowired
	private tblBahanRepository bahanRepository;

	@Autowired
	private tblSatuanBahanRepository satuanRepository;

	@Autowired
	private tblVendorRepository vendorRepository;

	@Autowired
	private tblActiveRepository activeRepository;
	
	@Autowired
	private tblJenisGudangRepository jenisGudangRepository;

	@Autowired
	private tblCabangRepository cabangRepository;
	
	
	@PostMapping("/getLookupByKey")
    public ResponseEntity<Map<String, Object>>  getLookupByKey(@Validated @RequestBody LookupKey keys) {
		
		String[] arrayKeys = keys.getKeys().split("\\|");
		System.out.println("keys :"+keys.getKeys());
		
		//dedup array 
		Set<String> set = new HashSet(Arrays.asList(arrayKeys));
		String[] arrayKey = set.toArray(new String[0]);
		
		
		//Map<String, Map<String,Object>> response = new HashMap<>();
		Map<String, Object> response = new HashMap<>();
		Map<String, Object> responseMap = new HashMap<>();
		
		for(String key : arrayKey) {
			System.out.println("map :"+key);
			if(key=="nomorbahan"||key.equals("nomorbahan")) {
				List<TblBahan> bahanList = bahanRepository.findAll();
		        List<LookupResponse> bahanResponse = bahanList.stream().
		        map(bahan -> new LookupResponse(bahan.getPk_bahan_id(), bahan.getNamaBahan())).
		        collect(Collectors.toList());
		        responseMap.put("nomorbahan", bahanResponse);		        
			}else if(key=="satuanbahan"||key.equals("satuanbahan")) {			
				List<TblSatuanBahan> satuanBahanList = satuanRepository.findAll();
		        List<LookupResponse> satuanResponse = satuanBahanList.stream().
		        map(satuan -> new LookupResponse(satuan.getId(), satuan.getNamaSatuan())).
		        collect(Collectors.toList());
		        responseMap.put("satuanbahan", satuanResponse);			
			}else if(key=="vendor"||key.equals("vendor")){				 
				 List<TblVendor> vendorList = vendorRepository.findAll();
			     List<LookupResponse> vendorResponse = vendorList.stream().
			     map(vendor -> new LookupResponse(vendor.getPk_vendor_id(), vendor.getNamaVendor())).
			     collect(Collectors.toList());
			     responseMap.put("vendor", vendorResponse);		     
			}else if(key=="active"||key.equals("active")) {
				List<TblActive> activeList = activeRepository.findAll();
				List<LookupResponse> activeResponse = activeList.stream().
				map(active -> new LookupResponse(active.getId(), active.getIsActiveDesc())).
				collect(Collectors.toList());
				responseMap.put("active", activeResponse);
			}else if(key=="jenisgudang"||key.equals("jenisgudang")) {
				List<TblJenisGudang> jenisGudangList = jenisGudangRepository.findAll();
				List<LookupResponse> jenisGudangResponse = jenisGudangList.stream().
				map(jenisGudang -> new LookupResponse(jenisGudang.getId(), jenisGudang.getJenisGudang())).
				collect(Collectors.toList());
				responseMap.put("jenisgudang", jenisGudangResponse);
			}else if(key=="cabang"||key.equals("cabang")) {
				List<TblCabang> cabangList = cabangRepository.findAll();
				List<LookupResponse> cabangResponse = cabangList.stream().
				map(cabang -> new LookupResponse(cabang.getId(), cabang.getNamaCabang())).
				collect(Collectors.toList());
				responseMap.put("cabang", cabangResponse);
			}else {
				return getAllLookup();
			}
			
			response.put("lookup",responseMap);
		}	
        return ResponseEntity.ok(response);
    }
	
	@GetMapping("/getAllLookUp")
    public ResponseEntity<Map<String,Object>>  getAllLookup() {
		
		Map<String, Object> response = new HashMap<>();
		
		List<TblBahan> bahanList = bahanRepository.findAll();
        List<LookupResponse> bahanResponse = bahanList.stream().
        map(bahan -> new LookupResponse(bahan.getPk_bahan_id(), bahan.getNamaBahan())).
        collect(Collectors.toList());

        List<TblSatuanBahan> satuanBahanList = satuanRepository.findAll();
        List<LookupResponse> satuanResponse = satuanBahanList.stream().
        map(satuan -> new LookupResponse(satuan.getId(), satuan.getNamaSatuan())).
        collect(Collectors.toList());

        List<TblVendor> vendorList = vendorRepository.findAll();
        List<LookupResponse> vendorResponse = vendorList.stream().
        map(vendor -> new LookupResponse(vendor.getPk_vendor_id(), vendor.getNamaVendor())).
        collect(Collectors.toList());

        List<TblActive> activeList = activeRepository.findAll();
        List<LookupResponse> activeResponse = activeList.stream().
        map(active -> new LookupResponse(active.getId(), active.getIsActiveDesc())).
        collect(Collectors.toList());

		List<TblJenisGudang> jenisGudangList = jenisGudangRepository.findAll();
		List<LookupResponse> jenisGudangResponse = jenisGudangList.stream().
		map(jenisGudang -> new LookupResponse(jenisGudang.getId(), jenisGudang.getJenisGudang())).
		collect(Collectors.toList());

		List<TblCabang> cabangList = cabangRepository.findAll();
		List<LookupResponse> cabangResponse = cabangList.stream().
		map(cabang -> new LookupResponse(cabang.getId(), cabang.getNamaCabang())).
		collect(Collectors.toList());

        response.put("lookup", new HashMap<String,Object>(){{
            put("nomorbahan", bahanResponse);
            put("satuanbahan", satuanResponse);
            put("vendor", vendorResponse);
            put("active", activeResponse);
            put("jenisgudang", jenisGudangResponse);
            put("cabang", cabangResponse);

        }});
        return ResponseEntity.ok(response);
    }
	
	
	
	
}
