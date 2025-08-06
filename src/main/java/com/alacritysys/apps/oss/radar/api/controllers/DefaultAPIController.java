package com.alacritysys.apps.oss.radar.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DefaultAPIController {

    @GetMapping("/api")
    public ResponseEntity<String> apiHome(){
        return ResponseEntity.ok("welcome");
    }
}
