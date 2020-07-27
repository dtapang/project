package com.korea.project.service;

import com.korea.project.entity.ProjectResourceDetail;

import java.util.List;

public interface ProjectResourceDetailService {

        boolean create(ProjectResourceDetail projectResourceDetail);
        List<ProjectResourceDetail> readAll();
        ProjectResourceDetail readOneById(int id);
        ProjectResourceDetail update(int id, ProjectResourceDetail projectResourceDetail);
        boolean delete(int id);
}
