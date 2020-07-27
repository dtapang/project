package com.korea.project.service;

import com.korea.project.entity.Project;

import java.util.List;

public interface ProjectService {

    boolean create(Project project);
    List<Project> readAll();
    List<Project> readByName(String name);
    Project readOneById(int id);
    Project update(int id, String name, String code);
    boolean delete(int id);
    boolean addExtraColumn(int id, String colName, String colType);

}
