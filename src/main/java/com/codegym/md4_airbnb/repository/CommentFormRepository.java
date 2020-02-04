package com.codegym.md4_airbnb.repository;

import com.codegym.md4_airbnb.model.CommentForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentFormRepository extends JpaRepository<CommentForm,Long> {
}
