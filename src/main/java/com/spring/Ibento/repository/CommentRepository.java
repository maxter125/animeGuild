package com.spring.Ibento.repository;

import com.spring.Ibento.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    // You can add custom query methods here if needed
}
