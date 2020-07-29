package com.korea.project.repository;

import com.korea.project.entity.ResourceCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResourceCatalogRepository extends JpaRepository<ResourceCatalog, Integer> {
    Optional<ResourceCatalog> findByCode(String code);
    Boolean existsByCode(String code);
    void deleteByCode(String code);
}
