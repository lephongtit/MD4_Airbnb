package com.codegym.md4_airbnb.service;

import com.codegym.md4_airbnb.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface HouseService {
    Iterable<House> findAll();
    Optional<House> findById(Long id);
    void save(House house);
    void delete(Long id);
}
