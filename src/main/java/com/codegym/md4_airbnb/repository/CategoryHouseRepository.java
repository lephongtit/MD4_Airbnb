package com.codegym.md4_airbnb.repository;

import com.codegym.md4_airbnb.model.CategoryHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryHouseRepository extends JpaRepository<CategoryHouse,Long> {
   CategoryHouse findByName( String name);
}
