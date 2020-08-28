package com.korea.project.service.impl;

import com.korea.project.entity.Project;
import com.korea.project.entity.User;
import com.korea.project.repository.ProjectRepository;
import com.korea.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public boolean create(Project project) {
        return projectRepository.save(project)!=null?true:false;
    }

    @Override
    public Optional<Project> getByProjectId(Integer id) {
        return projectRepository.findById(id);
    }

    @Override
    @Transactional
    public Set<Project> searchByNameOrCode(String query) {
        Set<Project> codeSet = projectRepository.findAllByCodeContaining(query);
        Set<Project> nameSet = projectRepository.findAllByNameContaining(query);
        Set<Project> searchResultSet = new HashSet<>();

        searchResultSet.addAll(codeSet);
        searchResultSet.addAll(nameSet);
        return searchResultSet;
    }

    @Override
    public Set<Project> getUserProjects(User user) {
        return projectRepository.findAllByOwner(user);
    }

    @Override
    @Transactional
    public boolean update(Integer id, String name, String code) {
        try{
            Optional<Project> optional = projectRepository.findById(id);
            if (optional.isPresent()) {
                Project project1 = optional.get();
                project1.setName(name);
                project1.setCode(code);
                projectRepository.save(project1);
                return true;
            }
            return false;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Project project) {
        if (project == null) {
            System.out.println("delete null project");
            return false;
        }
        System.out.println("give a deleting project" + project.getId());
        try {
            projectRepository.delete(project);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        return true;
    }
}




