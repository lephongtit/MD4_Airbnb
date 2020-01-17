package com.codegym.md4_airbnb.service.impl;

import com.codegym.md4_airbnb.model.CategoryHouse;
import com.codegym.md4_airbnb.repository.CategoryHouseRepository;
import com.codegym.md4_airbnb.service.CategoryHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryHouseServiceImpl implements CategoryHouseService {
    @Autowired
        private CategoryHouseRepository categoryHouseRepository ;

    @Override
    public Iterable<CategoryHouse> findAll() {
        return categoryHouseRepository.findAll() ;
    }

    @Override
    public Optional<CategoryHouse> findById(Long id) {
        return categoryHouseRepository.findById(id) ;
    }

    @Override
    public void save(CategoryHouse categoryHome) {
        categoryHouseRepository.save(categoryHome);

    }

    @Override
    public CategoryHouse findByName(String name) {
        return categoryHouseRepository.findByName(name);
    }
}
