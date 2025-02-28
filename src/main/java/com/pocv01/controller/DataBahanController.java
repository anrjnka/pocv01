package com.pocv01.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pocv01.model.CatalogVendor;
import com.pocv01.model.DataBahan;
import com.pocv01.model.User;
import com.pocv01.service.catalogVendorService;
import com.pocv01.service.dataBahanService;
import com.pocv01.service.menuService;
import com.pocv01.service.userService;

@RestController
@RequestMapping("/api")
public class DataBahanController {
	@PostMapping("/DataBahan")
    public ResponseEntity<List<DataBahan>> dataBahan(@Validated @RequestBody User user) {
        List<DataBahan> result = dataBahanService.dataBahan(user);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
        /*if (result.getStatus().equals("success")) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }*/
    }
}
