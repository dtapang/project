package com.korea.project.repository;

import com.korea.project.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResourceRepository extends JpaRepository<Resource, Integer> {
    Optional<Resource> findByCode(String code);

    boolean existsByCode(String code);

    //void deleteByCode(String code);

    void deleteById(Integer id);


}
