package com.codegym.md4_airbnb.service;

import com.codegym.md4_airbnb.model.CategoryHouse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CategoryHouseService {
    Iterable<CategoryHouse> findAll();

    Optional<CategoryHouse> findById(Long id);

    void save(CategoryHouse categoryHome);

    CategoryHouse findByName(String name);
}
