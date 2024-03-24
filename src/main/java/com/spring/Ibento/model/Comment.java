package com.spring.Ibento.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "comments")
@Data
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "thread_id", nullable = false)
    private Thread thread;

    @Column(nullable = false)
    @JsonProperty("comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Comment parent;

    @JsonProperty("upvotes")
    private int upvotes;

    @JsonProperty("downvotes")
    private int downvotes;

    @Column(name = "is_active", nullable = false)
    @JsonProperty("isActive")
    private boolean active;

    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @JsonProperty("createdAt")
    private Timestamp createdAt;

    // Constructors, Getters, Setters, and toString() method
    // ...
}
