package com.korea.project.service;

import com.korea.project.entity.Project;
import com.korea.project.entity.ProjectResourceDetail;
import com.korea.project.entity.Resource;
import java.util.List;

public interface ProjectResourceDetailService {

        boolean create(ProjectResourceDetail projectResourceDetail);
        List<Resource> getAllResources(Project project);
        List<ProjectResourceDetail> getAllResourcesByProject(Project project);
        ProjectResourceDetail getResourceDetailByProject(Project project);
        ProjectResourceDetail update(Integer id, ProjectResourceDetail projectResourceDetail);
        boolean delete(Integer id);

}
