package com.korea.project.service;

import com.korea.project.entity.Project;
import com.korea.project.entity.User;

import java.util.List;

public interface ProjectService {

    boolean create(Project project);
    List<Project> get();
    List<Project> get(String name);
    Project get(int id);
    List<Project> getUserProjects(User user);
    List<Project> searchByName(String name);
    List<Project> searchByCode(String code);

    Project updateName(int id, String name);
    boolean delete(int id);

    void updateCode(Integer id, String code);
}
