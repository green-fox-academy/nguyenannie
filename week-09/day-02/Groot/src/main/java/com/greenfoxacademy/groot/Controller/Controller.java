package com.greenfoxacademy.groot.Controller;

import com.greenfoxacademy.groot.Model.Error;
import com.greenfoxacademy.groot.Model.Groot;
import com.greenfoxacademy.groot.Model.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/groot")
    public ResponseEntity<RestResponse> getGroot(@RequestParam(value = "received", required = false) String received) {
        if(received != null) {
            return new ResponseEntity<>(new Groot(received, "I am Groot!"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Error("I am Groot!"), HttpStatus.BAD_REQUEST);
        }
    }
}