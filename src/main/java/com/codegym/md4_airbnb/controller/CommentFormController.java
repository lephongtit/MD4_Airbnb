package com.codegym.md4_airbnb.controller;

import com.codegym.md4_airbnb.service.CommentFormService;
import com.codegym.md4_airbnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class CommentFormController {
    @Autowired
    private UserService userService;
    @Autowired
    private CommentFormService commentFormService;

}
