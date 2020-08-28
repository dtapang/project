package com.korea.project.repository;

import com.korea.project.entity.Project;
import com.korea.project.entity.ProjectResourceDetail;
import com.korea.project.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectResourceDetailRepository extends  JpaRepository<ProjectResourceDetail, Integer>{
    List<ProjectResourceDetail> getProjectResourceDetailsByProjectByProjectid(int projectId);
    List<Resource> getResourcesByProjectByProjectid(int projectId);

}
