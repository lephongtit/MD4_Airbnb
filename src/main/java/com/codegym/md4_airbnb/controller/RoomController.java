package com.codegym.md4_airbnb.controller;

import com.codegym.md4_airbnb.model.House;
import com.codegym.md4_airbnb.model.Room;
import com.codegym.md4_airbnb.service.HouseService;
import com.codegym.md4_airbnb.service.RoomService;
import com.codegym.md4_airbnb.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private UserService userService;
    @Autowired
    private HouseService houseService;


    //them phong trong 1 nha
    @PostMapping("/house/{id}/room")
    public ResponseEntity<Iterable<House>> createRoomInHouse(@PathVariable("id")Long id, @RequestBody Room room){
        Optional<House> house= houseService.findById(id);
        if (house.isPresent()){
            room.setNameHouse(house.get().getNameHouse());
            room.setNameHost(house.get().getHostName());
            roomService.save(room);
            house.get().getRooms().add(room);
            houseService.save(house.get());
            return  new ResponseEntity(house,HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    //xoa 1 phong trong nha
    @DeleteMapping("/house/{id}/room/{id}")
    public  ResponseEntity<Iterable<House>> deleteRoomInHouse(@PathVariable("id")Long id,@RequestBody Room room){
        Optional<House> house = houseService.findById(id);
        if (house == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            Optional<Room> room1= roomService.findById(id);
            if (room1== null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            roomService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }





    //danh sach tat ca cac phong
    @GetMapping("/room")
    public ResponseEntity<Iterable<Room>> listRoom(){
        Iterable<Room> rooms= roomService.findAll();
        return new ResponseEntity(rooms, HttpStatus.OK);
    }


    //chi tiet 1 phong
    @GetMapping("/room/{id}")
    public ResponseEntity<String> findById(@PathVariable Long id){
        Optional<Room>room= roomService.findById(id);
        if (room== null){
            return new ResponseEntity(room,HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity(room, HttpStatus.OK);
    }

    //sua thong tin 1 phong
    @PutMapping("/room/{id}")
    public ResponseEntity<Iterable<Room>> edit(@PathVariable("id") Long id, @RequestBody Room room) {
        Optional<Room> room1 =roomService.findById(id);
        if (room1.isPresent()){
            room1.get().setNameRoom(room.getNameRoom());
            room1.get().setDescription(room.getDescription());
            room1.get().setImgeUrls(room.getImgeUrls());
            room1.get().setPriceRoom(room.getPriceRoom());
            roomService.save(room1.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
