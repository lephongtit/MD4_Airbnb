package com.codegym.md4_airbnb.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameHouse;
    private String hostName;

    @ManyToOne
    @JoinColumn(name = "CategoryHouse")
    private CategoryHouse category_house;
    private String address;
    private String description;

    @Column(columnDefinition = "TEXT")
    private String imageUrls;

    @OneToMany(targetEntity = Room.class)
    private List<Room> rooms;

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public House() {
    }


    public House(String nameHouse,String hostName, CategoryHouse category_house, String address, String description, String imageUrls) {
        this.nameHouse = nameHouse;
        this.hostName = hostName;
        this.category_house = category_house;
        this.address = address;
        this.description = description;
        this.imageUrls = imageUrls;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
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

    public CategoryHouse getCategory_house() {
        return category_house;
    }

    public void setCategory_house(CategoryHouse category_house) {
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
