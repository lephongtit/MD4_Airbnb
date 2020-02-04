package com.codegym.md4_airbnb.service.impl;

import com.codegym.md4_airbnb.model.Room;
import com.codegym.md4_airbnb.repository.RoomRepository;
import com.codegym.md4_airbnb.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Override
    public Iterable<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Optional<Room> findById(Long id) {
        return roomRepository.findById(id);
    }

    @Override
    public void save(Room room) {
        roomRepository.save(room);

    }

    @Override
    public void delete(Long id) {
        Optional<Room> room= roomRepository.findById(id);
        if (room.isPresent()){
            roomRepository.delete(room.get());
        }

    }
}
