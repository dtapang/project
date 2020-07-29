package com.korea.project.service;

import com.korea.project.entity.Resource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import java.util.List;

public interface ResourceService {

    boolean create(Resource resource);

    boolean delete(Resource resource);

    public Resource get(Integer id);

    List<Resource> readAll();
    List<Resource> readByName(String name);

    Resource update(String name, String code);



    Resource readOneByCode(String code);


}
