package com.spring.Ibento.model;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private int id;

    @Column(nullable = false)
    @JsonProperty("name")
    private String name;

    @Column(nullable = false, unique = true)
    @JsonProperty("email")
    private String email;

    @Column(nullable = false, unique = true)
    @JsonProperty("username")
    private String username;

    @Column(nullable = false)
    @JsonProperty("password")
    private String password;

    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @JsonProperty("createdAt")
    private Timestamp createdAt;

    @Column(name = "is_active", nullable = false)
    @JsonProperty("active")
    private boolean active;

    // Constructors, Getters, Setters, and toString() method
    // ...
}
