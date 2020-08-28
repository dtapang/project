package com.korea.project.controller;

import com.korea.project.entity.Project;
import com.korea.project.entity.User;
import com.korea.project.models.ProjectResponse;
import com.korea.project.service.impl.DAOUserDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.korea.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private DAOUserDetailsService userService;

    @PostMapping("/projects")
    public ResponseEntity<?>  create(@RequestBody Project project) {
        if(projectService.create(project))
            return ResponseEntity.ok("New Project Created Successfully");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("New project could not be created");
    }

    @GetMapping("/projects")
    public ResponseEntity<?> getAllProjects(Principal principal){
        try{
            User user = getCurrentUser(principal);
            if(user==null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user does not exist!");
            Set<Project> projects = projectService.getUserProjects(user);

            Set<ProjectResponse> projectResponses = new HashSet<>();

            projects.forEach((project)->projectResponses.add(new ProjectResponse(project.getId(), project.getName(), project.getCode())));

            if(projects==null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user has no projects!");
            return new ResponseEntity<>(projectResponses, HttpStatus.OK);

        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving projects: "+ exception.getMessage());
        }

    }

    private User getCurrentUser(Principal principal){
        return userService.getCurrentUser(principal);
    }

    @GetMapping("/projects/{projectId}")
    public ResponseEntity<?> findByProjectId(Principal principal,  @PathVariable int projectId){
        //@RequestParam(name = "projectId") Integer projectId,
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

    @GetMapping("/projects/search")
    public  ResponseEntity<?> search(@RequestParam(name="query") String query){
        return new ResponseEntity<>(projectService.searchByNameOrCode(query),HttpStatus.OK);
    }

    @PutMapping("/projects")
    public ResponseEntity<?> update(@RequestParam(name="project") Project project ) {
        boolean updateSucceded = projectService.update(project.getId(),project.getName(),project.getCode());
        if(updateSucceded)
            return ResponseEntity.ok("Project updated successfully");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Project update failed!");
    }

    @DeleteMapping("/projects")
    public ResponseEntity<?> delete(@RequestBody Project project) {
        boolean isRemoved = projectService.delete(project);
        if (!isRemoved)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("New project could not be created");
        return ResponseEntity.ok("Project Deleted Successfully");
    }
}




