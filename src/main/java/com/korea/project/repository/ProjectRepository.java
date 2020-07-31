package com.korea.project.repository;

import com.korea.project.entity.Project;
import com.korea.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    Set<Project> findAllByOwner(User owner);
    Set<Project> findAllByNameContaining(String query);
    Set<Project> findAllByCodeContaining(String query);
}


