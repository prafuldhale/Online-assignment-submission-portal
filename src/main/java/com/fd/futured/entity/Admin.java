package com.fd.futured.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "admins")
@Getter
@Setter
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminID;  // AdminID (Primary Key)

    private String name;  // Name

    @Column(nullable = false, unique = true)
    private String email;  // Email

    @OneToMany
    private List<Student> studentList;  // Relationship with Student

    @OneToMany
    private List<Teacher> teacherList;  // Relationship with Teacher

    // Getters and Setters
    // ...
}
