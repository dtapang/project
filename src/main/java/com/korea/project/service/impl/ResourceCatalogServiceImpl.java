package com.korea.project.service.impl;

import com.korea.project.entity.ResourceCatalog;
import com.korea.project.models.ResourceCatalogCreateRequest;
import com.korea.project.models.ResourceCatalogResponse;
import com.korea.project.repository.ResourceCatalogRepository;
import com.korea.project.service.ResourceCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResourceCatalogServiceImpl implements ResourceCatalogService {

    @Autowired
    ResourceCatalogRepository resourceCatalogRepository;

    @Override
    public boolean create(ResourceCatalogCreateRequest rc) {
        ResourceCatalog resourceCatalogDbo = new ResourceCatalog();
        resourceCatalogDbo.setCategory(rc.getCategory());
        resourceCatalogDbo.setCode(rc.getCode());
        return resourceCatalogRepository.save(resourceCatalogDbo)!=null?true:false;
    }

    @Override
    @Transactional
    public boolean delete(String code) {
        if(resourceCatalogRepository.existsByCode(code)) {
            resourceCatalogRepository.deleteByCode(code);
            return true;
        }
        return false;
    }

    @Override
    public List<ResourceCatalogResponse> getAll() {
        List<ResourceCatalog> catalogs = resourceCatalogRepository.findAll();
        List<ResourceCatalogResponse> res = catalogs.stream()
                .map(c -> new ResourceCatalogResponse(c.getCode(), c.getCategory()))
                .collect(Collectors.toList());
        return res;
    }

    @Override
    public ResourceCatalogResponse get(String code) {
        ResourceCatalog catalog = resourceCatalogRepository.findByCode(code).orElse(null);
        if(catalog!=null) {
            ResourceCatalogResponse res = new ResourceCatalogResponse(catalog.getCode(), catalog.getCategory());
            return res;
        }
        return null;
    }

    @Override
    @Transactional
    public boolean update(String code, String newCode, String newCategory) {
        if(resourceCatalogRepository.existsByCode(code)) {
            ResourceCatalog rc = resourceCatalogRepository.findByCode(code).orElse(null);
            if(rc!=null) {
                rc.setCode(newCode);
                rc.setCategory(newCategory);
                resourceCatalogRepository.save(rc);
                return true;
            }
            return false;
        }
        return false;
    }
}
