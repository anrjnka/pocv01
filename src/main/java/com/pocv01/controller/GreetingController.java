/**
 * 
 */
/**
 * @author owner
 *
 */
package com.pocv01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pocv01.model.Greeting;

@RestController
@RequestMapping("/api")
public class GreetingController {

    @GetMapping("/greeting/{id}")
    public Greeting greeting(@PathVariable long id) {
        return new Greeting(id, "hayoooo!");
    }
}