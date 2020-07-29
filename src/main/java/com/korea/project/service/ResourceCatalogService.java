package com.korea.project.service;

import com.korea.project.models.ResourceCatalogCreateRequest;
import com.korea.project.models.ResourceCatalogResponse;

import java.util.List;

public interface ResourceCatalogService {

    boolean create(ResourceCatalogCreateRequest rc);
    boolean delete(String code);
    List<ResourceCatalogResponse> getAll();
    ResourceCatalogResponse get(String code);
    boolean update(String code, String newCode, String newCategory);
}
