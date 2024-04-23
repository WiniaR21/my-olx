package com.myolx.cars.controller;

import com.myolx.cars.service.ImagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(path = "/image")
@RequiredArgsConstructor
public class TestController {
    private final ImagesService imagesService;

    @PostMapping(path = "/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
        imagesService.uploadImage(file);
        return ResponseEntity.ok().body(null);
    }

    @GetMapping(path = "/download")
    public ResponseEntity<byte[]> download(@RequestParam String imageName){
        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf("image/png"))
                .body(imagesService.downloadImage(imageName));
    }
}
