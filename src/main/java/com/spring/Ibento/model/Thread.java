package com.spring.Ibento.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "threads")
public class Thread {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(name = "created_by", nullable = false)
    private int createdBy;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;

    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
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
