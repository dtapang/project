package com.korea.project.service.impl;

import com.korea.project.entity.Project;
import com.korea.project.entity.ProjectResourceDetail;
import com.korea.project.entity.Resource;
import com.korea.project.repository.ProjectResourceDetailRepository;
import com.korea.project.service.ProjectResourceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectResourceDetailServiceImpl implements ProjectResourceDetailService {

    @Autowired
    ProjectResourceDetailRepository projectResourceDetailRepository;

    @Override
    public boolean create(ProjectResourceDetail projectResourceDetail) {
        return (projectResourceDetailRepository.save(projectResourceDetail)!=null)?true:false;
    }

    @Override
    public List<Resource> getAllResources(Project project) {

        return projectResourceDetailRepository.getResourcesByProject(project);
    }

    @Override
    public List<ProjectResourceDetail> getAllResourcesByProject(Project project) {
        return projectResourceDetailRepository.getProjectResourceDetailsByProject(project);
    }

    @Override
    public ProjectResourceDetail getResourceDetailByProject(Project project) {
        return projectResourceDetailRepository.getOne(project.getId());
    }

    @Override
    @Transactional
    public ProjectResourceDetail update(Integer id, ProjectResourceDetail projectResourceDetail) {
        Optional<ProjectResourceDetail> optional = projectResourceDetailRepository.findById(id);
        if (optional.isPresent()) {
            ProjectResourceDetail prd = optional.get();
            prd.setEditable(projectResourceDetail.getEditable());
            prd.setExtracolsvalue(projectResourceDetail.getExtracolsvalue());
            prd.setItemid(projectResourceDetail.getItemid());
            prd.setPrice(projectResourceDetail.getPrice());
            prd.setQuantity(projectResourceDetail.getQuantity());
            prd.setResource(projectResourceDetail.getResource());
            prd.setProject(projectResourceDetail.getProject());
            return projectResourceDetailRepository.save(prd);
        }
        return null;
    }

    @Override
    @Transactional
    public boolean delete(Integer id) {
        projectResourceDetailRepository.deleteById(id);
        if(!projectResourceDetailRepository.existsById(id)) return true;
        return false;
    }
}
