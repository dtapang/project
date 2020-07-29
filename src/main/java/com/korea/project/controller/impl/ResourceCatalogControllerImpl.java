package com.korea.project.controller.impl;

import com.korea.project.models.ResourceCatalogCreateRequest;
import com.korea.project.models.ResourceCatalogResponse;
import com.korea.project.models.ResourceCatalogUpdateRequest;
import com.korea.project.service.ResourceCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resource/catalog")
public class ResourceCatalogControllerImpl {

    @Autowired
    ResourceCatalogService resourceCatalogService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ResourceCatalogCreateRequest request) {
        if(resourceCatalogService.create(request)) {
            return ResponseEntity.ok("New Resource Catalog Successfully Created");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("New Resource Catalog could not be created");
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<?> delete(@PathVariable String code) {
        if(resourceCatalogService.delete(code)) {
            return ResponseEntity.ok("Resource Catalog Successfully Deleted");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Resource Catalog could not be deleted");
    }

    @GetMapping("/all")
    public List<ResourceCatalogResponse> getAll() {
        return resourceCatalogService.getAll();
    }

    @GetMapping("/find/{code}")
    public ResourceCatalogResponse get(@PathVariable String code) {
        return resourceCatalogService.get(code);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ResourceCatalogUpdateRequest rc) {
        if(resourceCatalogService.update(rc.getCode(), rc.getNewCode(), rc.getNewCategory())) {
            return ResponseEntity.ok("Resource Catalog Successfully Updated");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Resource Catalog could not be Updated");
    }
}
