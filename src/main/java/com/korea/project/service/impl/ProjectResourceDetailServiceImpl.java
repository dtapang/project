package com.korea.project.service.impl;

import com.korea.project.entity.ProjectResourceDetail;
import com.korea.project.repository.ProjectResourceDetailRepository;
import com.korea.project.service.ProjectResourceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectResourceDetailServiceImpl implements ProjectResourceDetailService {

    @Autowired
    ProjectResourceDetailRepository projectResourceDetailRepository;

    @Override
    public boolean create(ProjectResourceDetail projectResourceDetail) {
        return (projectResourceDetailRepository.save(projectResourceDetail)!=null)?true:false;
    }

    @Override
    public List<ProjectResourceDetail> readAll() {
        return projectResourceDetailRepository.findAll();
    }

    @Override
    public ProjectResourceDetail readOneById(int id) {
        return projectResourceDetailRepository.getOne(id);
    }

    @Override
    public ProjectResourceDetail update(int id, ProjectResourceDetail projectResourceDetail) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        projectResourceDetailRepository.deleteById(id);
        if(!projectResourceDetailRepository.existsById(id)) return true;
        return false;
    }
}
