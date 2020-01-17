package com.codegym.md4_airbnb.model;

import javax.persistence.*;

@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameHouse;
    private String hostName;

    @ManyToOne
    @JoinColumn(name = "category_house")
    private category_house category_house;
    private String address;
    private String description;
    private String imageUrls;

    public House() {
    }


    public House(String nameHouse, com.codegym.md4_airbnb.model.category_house category_house, String address, String description, String imageUrls) {
        this.nameHouse = nameHouse;
        this.category_house = category_house;
        this.address = address;
        this.description = description;
        this.imageUrls = imageUrls;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameHouse() {
        return nameHouse;
    }

    public void setNameHouse(String nameHouse) {
        this.nameHouse = nameHouse;
    }

    public com.codegym.md4_airbnb.model.category_house getCategory_house() {
        return category_house;
    }

    public void setCategory_house(com.codegym.md4_airbnb.model.category_house category_house) {
        this.category_house = category_house;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String imageUrls) {
        this.imageUrls = imageUrls;
    }
}
