package com.greenfoxacademy.yondusarrow.Controller;

import com.greenfoxacademy.yondusarrow.Model.Error;
import com.greenfoxacademy.yondusarrow.Model.RestResponse;
import com.greenfoxacademy.yondusarrow.Model.YondusArrow;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/yondu")
    public ResponseEntity<RestResponse> getYondu(@RequestParam(value = "distance", required = false) Double distance,
                                                 @RequestParam(value = "time", required = false) Double time) {
        if(distance == null || time == null) {
            return new ResponseEntity<>(new Error("Please provide parameter"), HttpStatus.BAD_REQUEST);
        } else if(time == 0) {
            return new ResponseEntity<>(new Error("Time cannot be 0"), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(new YondusArrow(distance,time), HttpStatus.OK);
        }
    }
}
