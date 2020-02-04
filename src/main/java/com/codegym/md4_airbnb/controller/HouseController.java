package com.codegym.md4_airbnb.controller;

import com.codegym.md4_airbnb.model.CategoryHouse;
import com.codegym.md4_airbnb.model.House;
import com.codegym.md4_airbnb.service.CategoryHouseService;
import com.codegym.md4_airbnb.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")

public class HouseController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private CategoryHouseService categoryHouseService;

    @GetMapping("/house")
    public ResponseEntity<Iterable<House>> listHouse(){
        Iterable<House> houses= houseService.findAll();
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }
    @PostMapping("/house")
    public  ResponseEntity<House> createHouse(@RequestBody House house){
        if (house.getCategory_house() !=null){
            String nameHouse = house.getCategory_house().getName();
            CategoryHouse categoryHouse = categoryHouseService.findByName(nameHouse);
            house.setCategory_house(categoryHouse);

        }
        houseService.save(house);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/house/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        Optional<House> house=houseService.findById(id);
        if (house == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        houseService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/house/{id}")
    public  ResponseEntity<Void> edit(@PathVariable("id") Long id, @RequestBody House house){
        Optional<House> house1=houseService.findById(id);
        if (house1.isPresent()){
            //xử lí lỗi rông back end
//            house1.get().setNameHouse(house.getNameHouse());
//            house1.get().setCategory_house(house.getCategory_house());
//            house1.get().setAddress(house.getAddress());
            if (!house.getNameHouse().equals("")){
                house1.get().setNameHouse(house.getNameHouse());
            }
            if (house.getCategory_house().getId()!=null){
                String nameHouse= house.getCategory_house().getName();
                CategoryHouse categoryHouse=categoryHouseService.findByName(nameHouse);
                house1.get().setCategory_house(categoryHouse);
            }
            if (!house.getAddress().equals("")){
                house1.get().setAddress(house.getAddress());
            }
            if (!house.getDescription().equals("")){
                house1.get().setDescription(house.getDescription());
            }
            if (!house.getImageUrls().equals("")){
                house1.get().setImageUrls(house.getImageUrls());
            }
            houseService.save(house1.get());
            return  new ResponseEntity(house1,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
// chi tiet 1 nha
   @GetMapping("house/{id}")
   public  ResponseEntity<House> findById(@PathVariable Long id){
        Optional<House> house=houseService.findById(id);
        if (house == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(house,HttpStatus.OK);
   }


}
