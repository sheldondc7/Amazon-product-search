package com.sellics.s3.controller;

import com.sellics.s3.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/file")
public class StorageController {

  @Autowired private StorageService service;

  @GetMapping("/download/{fileName}")
  public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable final String fileName) {
    var data = service.downloadFile(fileName);
    var resource = new ByteArrayResource(data);
    return ResponseEntity.ok()
        .contentLength(data.length)
        .header("Content-type", "application/octet-stream")
        .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
        .body(resource);
  }
}
