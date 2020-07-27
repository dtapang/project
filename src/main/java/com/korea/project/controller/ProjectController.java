package com.korea.project.controller;

import com.korea.project.repository.ProjectDao;
import com.korea.project.entity.Project;
import com.korea.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService service;

    @Autowired
    private ProjectDao dao;


    @PostMapping("/project/create")
    public void create(@RequestParam("name") String name,
                       @RequestParam("userid") int userid,
                       @RequestParam("code") String code) {
        Project project = new Project();
        project.setName(name);
        project.setId(userid);
        project.setCode(code);
        service.create(project);
    }

    @GetMapping("/project/list")
    public List<Project> list() {
        return service.readAll();
    }

    /**
     * find a project by its id
     */
    @GetMapping("/project/find/{id}")
    public Project findById(@PathVariable("id") Integer id) {
        return service.readOneById(id);
    }

    /**
     * updated a project information
     */
    @PutMapping("/project/update/{id}")
    public Project update(@PathVariable("id") Integer id,
                          @RequestParam("name") String name,
                          @RequestParam("code") String code,
                          @RequestParam("userid") int userid) {
         return service.update(id,name,code);
    }


    @DeleteMapping(value = "/project/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable ("id") Integer id) {

        boolean isRemoved = service.delete(id);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);

    }



}




