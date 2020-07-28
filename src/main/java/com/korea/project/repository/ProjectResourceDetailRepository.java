package com.korea.project.repository;

import com.korea.project.entity.ProjectResourceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectResourceDetailRepository extends  JpaRepository<ProjectResourceDetail, Integer>{
}
