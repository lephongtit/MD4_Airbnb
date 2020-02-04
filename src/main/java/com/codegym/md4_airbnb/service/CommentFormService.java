package com.codegym.md4_airbnb.service;

import com.codegym.md4_airbnb.model.CommentForm;

import java.util.Optional;

public interface CommentFormService {
    Iterable<CommentForm> findAll();
    Optional<CommentForm> findById(Long id);
    void save(CommentForm commentForm);
    void delete(Long id);
}
