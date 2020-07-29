package com.korea.project.service;

import com.korea.project.entity.ProjectResourceDetail;
import com.korea.project.entity.Resource;
import java.util.List;

public interface ProjectResourceDetailService {

        boolean create(ProjectResourceDetail projectResourceDetail);
        List<Resource> getAllResources(Integer projectId);
        List<ProjectResourceDetail> getAllResourcesByProjectId(Integer projectId);
        ProjectResourceDetail getResourceDetailById(Integer id);
        ProjectResourceDetail update(Integer id, ProjectResourceDetail projectResourceDetail);
        boolean delete(Integer id);

}
