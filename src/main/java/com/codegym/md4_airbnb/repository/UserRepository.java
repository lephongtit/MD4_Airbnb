package com.codegym.md4_airbnb.repository;

import com.codegym.md4_airbnb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String userName);
    User findByEmail(String email);

}
