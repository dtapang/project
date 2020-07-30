package com.korea.project.repository;

import com.korea.project.entity.Project;
import com.korea.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    List<Project> findAllByOwner(String owner);
    List<Project> findAllByNameContaining(String search);
    List<Project> findAllByCodeContaining(String search);
    List<Project> findAllByName(String name);
}


