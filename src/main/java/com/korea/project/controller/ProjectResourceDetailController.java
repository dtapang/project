package com.korea.project.controller;


import com.korea.project.entity.Project;
import com.korea.project.entity.ProjectResourceDetail;
import com.korea.project.service.ProjectResourceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProjectResourceDetailController {

    @Autowired
    private ProjectResourceDetailService projectResourceDetailService;

    @PostMapping("/prd")
    public ResponseEntity<?> create(@RequestBody ProjectResourceDetail projectResourceDetail) {
        projectResourceDetailService.create(projectResourceDetail);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/prd/listByProject/{id}")
    public List<ProjectResourceDetail> list(@PathVariable("id") Integer id) {
        return projectResourceDetailService.getAllResourcesByProject(id);
    }

    @GetMapping("/prd/find/{id}")
    public ProjectResourceDetail findById(@PathVariable("id") Integer id) {
        return projectResourceDetailService.getResourceDetailByProject(id);
    }

    @PutMapping("/prd/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody ProjectResourceDetail prd) {
        projectResourceDetailService.update(id,prd);
        return ResponseEntity.ok("Success");
    }

    @DeleteMapping(value = "/prd/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") Integer id) {
        boolean isRemoved = projectResourceDetailService.delete(id);
        if (!isRemoved)
            return ResponseEntity.ok("Failed");
        return ResponseEntity.ok("Success");
    }



}
