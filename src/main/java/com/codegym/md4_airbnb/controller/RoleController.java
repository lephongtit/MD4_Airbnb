package com.codegym.md4_airbnb.controller;

import com.codegym.md4_airbnb.model.Role;
import com.codegym.md4_airbnb.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")

@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<Iterable<Role>>listRole(){
        Iterable<Role> roles = roleService.findAll();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Role>createRole(@RequestBody Role role){
        roleService.save(role);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
