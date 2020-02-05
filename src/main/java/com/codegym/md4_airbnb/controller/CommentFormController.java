package com.codegym.md4_airbnb.controller;

import com.codegym.md4_airbnb.model.CommentForm;
import com.codegym.md4_airbnb.model.Room;
import com.codegym.md4_airbnb.service.CommentFormService;
import com.codegym.md4_airbnb.service.RoomService;
import com.codegym.md4_airbnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class CommentFormController {

    @Autowired
    private UserService userService;
    @Autowired
    private CommentFormService commentFormService;
    @Autowired
    private RoomService roomService;

    @PostMapping("room/{id}/comments")
    public ResponseEntity<Optional<Room>> Comments(@PathVariable("id") Long id, @RequestBody CommentForm commentForm) {
        commentForm.setUser(userService.getCurrentUser());
        commentFormService.save(commentForm);
        Optional<Room> room = roomService.findById(id);
        if (room.isPresent()){
            room.get().getListComment().add(commentForm);
            roomService.save(room.get());
            return new ResponseEntity<>(room, HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    }
