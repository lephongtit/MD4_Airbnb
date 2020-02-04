package com.codegym.md4_airbnb.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameHouse;
    private String nameHost;
    private String nameRoom;
    private String description;
    private Long priceRoom;

    @Column(columnDefinition = "TEXT")
    private String imgeUrls;

    @OneToMany(targetEntity = CommentForm.class)
    private List<CommentForm> listComment;

    public Room(String nameHouse, String nameHost, String nameRoom, String description, Long priceRoom, String imgeUrls, List<CommentForm> listComment) {
        this.nameHouse = nameHouse;
        this.nameHost = nameHost;
        this.nameRoom = nameRoom;
        this.description = description;
        this.priceRoom = priceRoom;
        this.imgeUrls = imgeUrls;
        this.listComment = listComment;
    }
    public Room(){

    }

    public List<CommentForm> getListComment(){return listComment;}

    public void setListComment(List<CommentForm> listComment){
        this.listComment=listComment;
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

    public String getNameHost() {
        return nameHost;
    }

    public void setNameHost(String nameHost) {
        this.nameHost = nameHost;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPriceRoom() {
        return priceRoom;
    }

    public void setPriceRoom(Long priceRoom) {
        this.priceRoom = priceRoom;
    }

    public String getImgeUrls() {
        return imgeUrls;
    }

    public void setImgeUrls(String imgeUrls) {
        this.imgeUrls = imgeUrls;
    }
}
