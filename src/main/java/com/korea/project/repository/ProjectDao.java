package com.korea.project.repository;

import com.korea.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ProjectDao extends JpaRepository<Project, Integer> {

}


