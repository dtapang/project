package com.korea.project.controller;

import com.korea.project.entity.Project;
import com.korea.project.entity.User;
import com.korea.project.repository.UserRepository;
import com.korea.project.service.impl.DAOUserDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.korea.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService service;

    @Autowired
    private DAOUserDetailsService userService;

    @PostMapping("/project/create")
    public ResponseEntity<?>  create(@RequestBody Project project) {
        service.create(project);
        return ResponseEntity.ok("Success");
    }


    @GetMapping("/project/getAllProjects")
    public ResponseEntity<?> getAllProjects(Principal principal){
        User user = getCurrentUser(principal);
        List<Project> projectList = service.getUserProjects(user);
        return new ResponseEntity<>(projectList, HttpStatus.OK);
    }


    private User getCurrentUser(Principal principal){
        return userService.getCurrentUser(principal);
    }


    @GetMapping("/project/list")
    public ResponseEntity<?> findByProjectId(Principal principal, @RequestParam( name="projectId") Integer projectId){
        User user = userService.getCurrentUser(principal);
        Project project = service.get(projectId);
        if(user==null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if(project==null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if(!user.getUsername().equals(project.getOwner().getUsername()))
            return new ResponseEntity<>("Project does not belong to the user", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(project,HttpStatus.OK);
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




