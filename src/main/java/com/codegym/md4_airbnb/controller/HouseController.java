package com.codegym.md4_airbnb.controller;

import com.codegym.md4_airbnb.model.CategoryHouse;
import com.codegym.md4_airbnb.model.House;
import com.codegym.md4_airbnb.service.CategoryHouseService;
import com.codegym.md4_airbnb.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/house")
public class HouseController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private CategoryHouseService categoryHouseService;

    @GetMapping
    public ResponseEntity<Iterable<House>> listHouse(){
        Iterable<House> houses= houseService.findAll();
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }
    @PostMapping
    public  ResponseEntity<House> createHouse(@RequestBody House house){
        if (house.getCategory_house() !=null){
            String nameHouse = house.getCategory_house().getName();
            CategoryHouse categoryHouse = categoryHouseService.findByName(nameHouse);
            house.setCategory_house(categoryHouse);
        }
        houseService.save(house);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
