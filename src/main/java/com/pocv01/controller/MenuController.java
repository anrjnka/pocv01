package com.pocv01.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pocv01.model.Menu;
import com.pocv01.model.Response;
import com.pocv01.model.User;
import com.pocv01.service.menuService;
import com.pocv01.service.userService;

@RestController
@RequestMapping("/api")
public class MenuController {
	@PostMapping("/menu")
    public ResponseEntity<List<Menu>> menu(@Validated @RequestBody User user) {
        List<Menu> result = menuService.menu(user);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
        /*if (result.getStatus().equals("success")) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }*/
    }
}
