package com.codegym.md4_airbnb.controller;

import com.codegym.md4_airbnb.model.CategoryHouse;
import com.codegym.md4_airbnb.service.CategoryHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @PostMapping
    public  ResponseEntity<CategoryHouse> create(@RequestBody CategoryHouse categoryHouse){
        categoryHouseService.save(categoryHouse);
        return new ResponseEntity(categoryHouse,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoryHouse> editCategory(@PathVariable("id") Long id, @RequestBody CategoryHouse categoryHouse){
        Optional<CategoryHouse> categoryHouse1=categoryHouseService.findById(id);
        if (categoryHouse1.isPresent()){
            categoryHouse1.get().setName(categoryHouse.getName());
            categoryHouseService.save(categoryHouse1.get());
            return new ResponseEntity("thanh cong",HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryHouse> delete(@PathVariable("id") Long id){
        Optional<CategoryHouse> categoryHouse= categoryHouseService.findById(id);
        if (categoryHouse== null){
            return new ResponseEntity(categoryHouse,HttpStatus.NOT_FOUND);
        }
        categoryHouseService.delete(id);
        return new ResponseEntity( "thành công",HttpStatus.OK);
    }

}
