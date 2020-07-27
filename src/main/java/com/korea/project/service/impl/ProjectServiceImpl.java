package com.korea.project.service.impl;

import com.korea.project.repository.ProjectRepository;
import com.korea.project.entity.Project;
import com.korea.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
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
    public List<Project> readAll() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> readByName(String name) {
        throw new NotImplementedException();
    }

    @Override
    public Project readOneById(int id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public Project update(int id, String name, String code) {
        Optional<Project> optional = projectRepository.findById(id);
        if (optional.isPresent()) {
            Project project1 = optional.get();
            project1.setName(name);
            project1.setCode(code);
            return projectRepository.save(project1);
        }

        return null;
    }

    @Override
    public boolean delete(int id) {
        if(projectRepository.existsById(id)){
            projectRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    @Transactional
    @Override
    public boolean addExtraColumn(int id, String colName, String colType) {

        Optional<Project> optional = projectRepository.findById(id);
        if (!optional.isPresent()) return false;
        Project project = optional.get();

        boolean extraColExists = (project.getExtracolsname() != null);
        if (extraColExists){
            project.setExtracolsname(project.getExtracolsname() + "," + colName);
            project.setExtracolstype(project.getExtracolstype() + "," + colType);
        }else{
            project.setExtracolsname(colName);
            project.setExtracolstype(colType);
        }
        return (projectRepository.save(project)==null)?false:true;

    }
}




