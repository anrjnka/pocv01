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
import com.pocv01.model.HeaderBahan;
import com.pocv01.model.User;
import com.pocv01.service.catalogVendorService;
import com.pocv01.service.headerBahanService;
import com.pocv01.service.menuService;
import com.pocv01.service.userService;

@RestController
@RequestMapping("/api")
public class HeaderBahanController {
	@PostMapping("/HeaderBahan")
    public ResponseEntity<List<HeaderBahan>> headerBahan(@Validated @RequestBody User user) {
        List<HeaderBahan> result = headerBahanService.headerBahan(user);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
        /*if (result.getStatus().equals("success")) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }*/
    }
}
