package com.codegym.md4_airbnb.controller;

import com.codegym.md4_airbnb.model.CategoryHouse;
import com.codegym.md4_airbnb.service.CategoryHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/category/house")
public class CategoryHouseController {
    @Autowired
    private CategoryHouseService categoryHouseService;

    @GetMapping
    public ResponseEntity<Iterable<CategoryHouse>> listCategory(){
        Iterable<CategoryHouse> categoryHouses= categoryHouseService.findAll();
        return new ResponseEntity<>(categoryHouses, HttpStatus.OK);
    }

}
