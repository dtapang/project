package com.korea.project.controller.impl;

import com.korea.project.models.ResourceCatalogCreateRequest;
import com.korea.project.models.ResourceCatalogResponse;
import com.korea.project.models.ResourceCatalogUpdateRequest;
import com.korea.project.service.ResourceCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


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

    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    @DeleteMapping("/delete/{code}")
    public ResponseEntity<?> delete(@PathVariable String code) {
        if(resourceCatalogService.delete(code)) {
            return ResponseEntity.ok("Resource Catalog Successfully Deleted");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Resource Catalog could not be deleted");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(resourceCatalogService.getAll());
    }

    @GetMapping("/find/{code}")
    public ResponseEntity<?> get(@PathVariable String code) {
        ResourceCatalogResponse res = resourceCatalogService.get(code);
        if(res==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource Catalog not found");
        }
        return ResponseEntity.ok(res);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ResourceCatalogUpdateRequest rc) {
        if(resourceCatalogService.update(rc.getCode(), rc.getNewCode(), rc.getNewCategory())) {
            return ResponseEntity.ok("Resource Catalog Successfully Updated");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Resource Catalog could not be Updated");
    }
}
