package com.codegym.md4_airbnb.service;

import com.codegym.md4_airbnb.model.Role;

public interface RoleService {
    Iterable<Role> findAll();
    void save(Role role);
    Role findByName(String name);
}
