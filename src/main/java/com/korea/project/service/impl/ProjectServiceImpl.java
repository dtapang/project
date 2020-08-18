package com.korea.project.service.impl;

import com.korea.project.entity.Project;
import com.korea.project.entity.User;
import com.korea.project.repository.ProjectRepository;
import com.korea.project.repository.UserRepository;
import com.korea.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public boolean create(Project project) {
        return projectRepository.save(project)!=null?true:false;
    }

    @Override
    public List<Project> get() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> get(String name) {
        return projectRepository.findAllByName(name);
    }

    @Override
    public Project get(int id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public List<Project> getUserProjects(User user) {
        return projectRepository.findAllByOwner(user);
    }

    @Override
    public List<Project> searchByName(String name) {
        return projectRepository.findAllByNameContaining(name);
    }

    @Override
    public List<Project> searchByCode(String code) {
        return projectRepository.findAllByCodeContaining(code);
    }

    @Override
    @Transactional
    public Project updateName(int id, String name) {
        Optional<Project> optional = projectRepository.findById(id);
        if (optional.isPresent()) {
            Project project1 = optional.get();
            project1.setName(name);
            return projectRepository.save(project1);
        }
        return null;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        if(projectRepository.existsById(id)){
            projectRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    @Transactional
    public void updateCode(Integer id, String code) {
        Optional<Project> optional = projectRepository.findById(id);
        if (optional.isPresent()) {
            Project project1 = optional.get();
            project1.setCode(code);
            projectRepository.save(project1);
        }
    }


}




