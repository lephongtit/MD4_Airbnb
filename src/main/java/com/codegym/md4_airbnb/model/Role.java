package com.codegym.md4_airbnb.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
@Data
public class Role implements Serializable {
    private static  final long serializable =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public static final long getSerializable(){
        return serializable;
    }

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }
}
