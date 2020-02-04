package com.codegym.md4_airbnb.service;

import com.codegym.md4_airbnb.model.Room;

import java.util.Optional;

public interface RoomService {
    Iterable<Room> findAll();
    Optional<Room>  findById(Long id);
    void save(Room room);
    void delete(Long id);
}
