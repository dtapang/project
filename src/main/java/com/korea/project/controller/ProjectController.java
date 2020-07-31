package com.korea.project.controller;

import com.korea.project.entity.Project;
import com.korea.project.entity.User;
import com.korea.project.service.impl.DAOUserDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.korea.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private DAOUserDetailsService userService;

    @PostMapping("/create")
    public ResponseEntity<?>  create(@RequestBody Project project) {
        if(projectService.create(project))
            return ResponseEntity.ok("New Project Created Successfully");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("New project could not be created");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllProjects(Principal principal){
        User user = getCurrentUser(principal);
        if(user==null)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("user does not exist!");
        Set<Project> projects = projectService.getUserProjects(user);
        if(projects==null)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("user has no projects!");
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    private User getCurrentUser(Principal principal){
        return userService.getCurrentUser(principal);
    }

    @GetMapping("/find")
    public ResponseEntity<?> findByProjectId(Principal principal, @RequestParam( name="projectId") Integer projectId){
        User user = userService.getCurrentUser(principal);
        Optional<Project> project = projectService.getByProjectId(projectId);
        if(user==null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if(!project.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if(!user.getUsername().equals(project.get().getOwner().getUsername()))
            return new ResponseEntity<>("Project does not belong to the user", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(project,HttpStatus.OK);
    }


    @GetMapping("/search")
    public  ResponseEntity<?> search(@RequestParam(name="query") String query){
        return new ResponseEntity<>(projectService.searchByNameOrCode(query),HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestParam(name="project") Project project ) {
        boolean updateSucceded = projectService.update(project.getId(),project.getName(),project.getCode());
        if(updateSucceded)
            return ResponseEntity.ok("Project updated successfully");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Project update failed!");
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> delete(@RequestBody Project project) {
        boolean isRemoved = projectService.delete(project);
        if (!isRemoved)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("New project could not be created");
        return ResponseEntity.ok("Project Deleted Successfully");
    }
}




