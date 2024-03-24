package com.spring.Ibento.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "threads")
public class Thread implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private int id;

    @Column(nullable = false, length = 255)
    @JsonProperty("title")
    private String title;

    @Column(name = "created_by", nullable = false)
    @JsonProperty("createdBy")
    private int createdBy;

    @Column(columnDefinition = "TEXT")
    @JsonProperty("description")
    private String description;

    @Column(name = "is_active", nullable = false)
    @JsonProperty("isActive")
    private boolean isActive = true;

    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @JsonProperty("createdAt")
    private Timestamp createdAt;

    // Constructors, Getters, Setters, and toString() method
    // ...

    public Thread() {
    }

    public Thread(String title, int createdBy, String description) {
        this.title = title;
        this.createdBy = createdBy;
        this.description = description;
    }

    // Getters and Setters
    // ...
}
