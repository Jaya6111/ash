package com.as.driver.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.as.driver.service.CabLocationService;

@RestController
public class CabLocationController {

    @Autowired
    private CabLocationService cabLocationService;


    @PutMapping
    public ResponseEntity<?> updateLocation() throws InterruptedException {

		/*
		 * int range = 100; while (range > 0) {
		 * cabLocationService.updateLocation(Math.random() + " , " + Math.random());
		 * Thread.sleep(1000); range--;
		 * 
		 * }
		 */
    	cabLocationService.updateLocation("return");
        Map<String, String> map = new HashMap<String, String>();

        return new ResponseEntity<>(map.put("message", "Location Update")
                , HttpStatus.OK);
    }
}
