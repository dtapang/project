package com.korea.project.repository;

import com.korea.project.entity.Project;
import com.korea.project.entity.ProjectResourceDetail;
import com.korea.project.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectResourceDetailRepository extends  JpaRepository<ProjectResourceDetail, Integer>{
    List<ProjectResourceDetail> getProjectResourceDetailsByProjectid(Integer id);
    List<Resource> getResourcesByProjectid(Integer id);
    Project getByProjectid(Integer id);
    ProjectResourceDetailRepository getProjectResourceDetailById(Integer id);
    void deleteProjectResourceDetailById(Integer id);
    void deleteProjectResourceDetailByProjectid(Integer id);
}
