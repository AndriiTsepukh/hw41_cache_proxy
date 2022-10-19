package com.example.hw41.controllers;

import com.example.hw41.client.NasaFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.IMAGE_PNG;

@RestController
public class NasaPictureController {
    @Autowired
    NasaFeignClient nasaFeignClient;

    @GetMapping("/mars/pictures/largest")
    public ResponseEntity<byte[]> getLargestPicture(@RequestParam(name="sol") int sol, @RequestParam(name = "camera", required = false) String camera) {
        var body = nasaFeignClient.getBiggestPicture(sol, camera);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(IMAGE_PNG);
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(body, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }
}
