package com.korea.project.repository;

import com.korea.project.entity.Project;
import com.korea.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    User findByOwner(Integer ownerId);
    Project findByName(String name);
    List<Project> findAllByNameContaining(String search);
    List<Project> findAllByName(String name);
}


