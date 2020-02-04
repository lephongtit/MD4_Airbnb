package com.codegym.md4_airbnb.service.impl;

import com.codegym.md4_airbnb.model.CommentForm;
import com.codegym.md4_airbnb.repository.CommentFormRepository;
import com.codegym.md4_airbnb.service.CommentFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentFormServiceImpl implements CommentFormService {
    @Autowired
     private  CommentFormRepository commentFormRepository;
    @Override
    public Iterable<CommentForm> findAll() {
        return commentFormRepository.findAll();
    }

    @Override
    public Optional<CommentForm> findById(Long id) {
        return commentFormRepository.findById(id);
    }

    @Override
    public void save(CommentForm commentForm) {
        commentFormRepository.save(commentForm);

    }

    @Override
    public void delete(Long id) {
        Optional<CommentForm> commentForm= commentFormRepository.findById(id);
        if (commentForm.isPresent()){
            commentFormRepository.delete(commentForm.get());
        }
    }
}
