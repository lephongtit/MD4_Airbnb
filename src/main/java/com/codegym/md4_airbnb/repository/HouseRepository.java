package com.codegym.md4_airbnb.repository;

import com.codegym.md4_airbnb.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House,Long> {
}
