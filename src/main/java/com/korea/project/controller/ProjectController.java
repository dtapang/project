package com.korea.project.controller;

import com.korea.project.entity.Project;
import org.springframework.http.ResponseEntity;
import com.korea.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService service;

    @PostMapping("/project/create")
    public ResponseEntity<?>  create(@RequestBody Project project) {

        service.create(project);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/project/list")
    public List<Project> list() {
        return service.get();
    }

    @GetMapping("/project/find/{id}")
    public Project findById(@PathVariable("id") Integer id) {
        return service.get(id);
    }

    @PutMapping("/project/update/name/{id}/{name}")
    public ResponseEntity<?> updateName(@PathVariable("id") Integer id, @PathVariable String name) {
        service.updateName(id,name);
        return ResponseEntity.ok("Success");
    }

    @PutMapping("/project/update/code/{id}/{code}")
    public ResponseEntity<?> updateCode(@PathVariable("id") Integer id, @PathVariable String code) {
        service.updateCode(id,code);
        return ResponseEntity.ok("Success");
    }

    @DeleteMapping(value = "/project/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") Integer id) {
        boolean isRemoved = service.delete(id);
        if (!isRemoved)
            return ResponseEntity.ok("Failed");
        return ResponseEntity.ok("Success");
    }



}




