package com.korea.project.controller;

import com.korea.project.models.ResourceRequest;
import com.korea.project.repository.ResourceRepository;
import com.korea.project.service.ResourceService;
import com.korea.project.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ResourceController {


    @Autowired
    private ResourceService service;

    @Autowired
    private ResourceRepository repository;

    /**
     * create new resources
     * @return
     */
    @PostMapping("/resource/create")
    public ResponseEntity<?> create(@RequestBody ResourceRequest resourceRequest) {
        Resource resource = new Resource();
        resource.setName(resourceRequest.getName());
        resource.setCode(resourceRequest.getCode());

        if(service.create(resource))
            return ResponseEntity.ok("New Resource Created Successfully");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("New resource could not be created");
    }


    /**
     * get all resources
     * @return
     */
    @GetMapping("/resource/list")
    public List<Resource> list() {
        return service.readAll();
    }

    /**
     * find a resource by its code
     * @return
     */
    @GetMapping("/resource/find/{code}")
    public Resource findById(@PathVariable("code") String code) {
        return service.readOneByCode(code);
    }

    /**
     * updated a resource information
     * @return
     */
    @PutMapping("/resource/update/{id}")
    public Resource update(@RequestParam("name") String name,
                           @RequestParam("code") String code)
    {
        return service.update(name,code);
    }

    /**
     * delete a resource information
     * @return
     */
    @DeleteMapping(value = "/resource/delete")
    public ResponseEntity<Object> delete(@RequestParam (name = "resourceId") Integer resourceId) {

        Resource resourceToDelete = service.get(resourceId);

        if (resourceToDelete == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.delete(resourceToDelete);
        return new ResponseEntity<>(resourceToDelete, HttpStatus.OK);


    }

}
