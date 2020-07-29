package com.korea.project.service.impl;

import com.korea.project.repository.ResourceRepository;
import com.korea.project.service.ResourceService;
import com.korea.project.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;


@Service
public class ResourceServiceImpl implements ResourceService {


    @Autowired
    private ResourceRepository repository;

    @Override
    public boolean create(Resource resource) {
        System.out.println("Saved---->"+repository.getClass().getName());
        return repository.save(resource)!=null?true:false;
    }

    @Override
    public List<Resource> readAll() {
        return repository.findAll();
    }

    @Override
    public List<Resource> readByName(String name) {
        return null;
    }

    @Override
    public Resource get(Integer id) {
        Optional<Resource>  target = repository.findById(id);
        if(target.isPresent()) {
            return target.get();
        } else{
            return null;
        }



    }

    @Override
    public Resource update(String name, String code) {
        Optional<Resource> optional;
        optional = repository.findByCode(code);
        if (optional.isPresent()) {
            Resource resource1 = optional.get();
            resource1.setName(name);
            resource1.setName(code);
            return repository.save(resource1);
        }

        return null;
    }

    @Override
    @Transactional
    public boolean delete(Resource resource) {
        if (resource == null) {
            System.out.println("delete null resource");
        }
        System.out.println("give a deleting resource" + resource.getId());

        try {
            repository.delete(resource);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;

        }

        return true;
    }

    @Override
    public Resource readOneByCode(String code) {
        return repository.findByCode(code).orElse(null);
    }
}





