package com.codegym.md4_airbnb.model;

import javax.persistence.*;

@Entity
public class CommentForm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  String comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public CommentForm(String comment, User user) {
        this.comment = comment;
        this.user = user;
    }

    public CommentForm(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
