package com.korea.project.service;

import com.korea.project.entity.Project;

import java.util.List;

public interface ProjectService {

    boolean create(Project project);
    List<Project> get();
    List<Project> get(String name);
    Project get(int id);
    Project updateName(int id, String name);
    boolean delete(int id);

    void updateCode(Integer id, String code);
}
