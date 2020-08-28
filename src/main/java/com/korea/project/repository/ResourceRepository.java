package com.korea.project.repository;

import com.korea.project.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {
    Optional<Resource> findByCode(String code);

    void deleteById(Integer id);
}
