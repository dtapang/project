package com.korea.project.service;

import com.korea.project.entity.Project;
import com.korea.project.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProjectService {

    boolean create(Project project);
    Optional<Project> getByProjectId(Integer id);
    Set<Project> searchByNameOrCode(String query);
    Set<Project> getUserProjects(User user);
    boolean update(Integer id, String name, String code);
    boolean delete(Project project);
}
