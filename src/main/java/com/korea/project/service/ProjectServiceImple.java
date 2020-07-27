package com.korea.project.service;

import com.korea.project.repository.ProjectDao;
import com.korea.project.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImple implements ProjectService{
    @Autowired
    private ProjectDao dao;

    @Override
    public boolean create(Project project) {
        System.out.println("Saved---->"+dao.getClass().getName());
        return dao.save(project)!=null?true:false;
    }

    @Override
    public List<Project> readAll() {
        return dao.findAll();
    }

    @Override
    public List<Project> readByName(String name) {
        throw new NotImplementedException();
    }

    @Override
    public Project readOneById(int id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public Project update(int id, String name, String code) {
        Optional<Project> optional = dao.findById(id);
        if (optional.isPresent()) {
            Project project1 = optional.get();
            project1.setName(name);
            project1.setName(code);
            return dao.save(project1);
        }

        return null;
    }

    @Override
    public boolean delete(int id) {
        if(dao.existsById(id)){
            dao.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}




