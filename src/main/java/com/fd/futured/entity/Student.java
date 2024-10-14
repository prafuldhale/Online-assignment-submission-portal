package com.fd.futured.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "students")
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentID; // StudentID (Primary Key)

    private String name;  // Name

    @Column(nullable = false, unique = true)
    private String email;  // Email

    @ManyToOne
    @JoinColumn(name = "course_id")  // Foreign Key to Course
    private Course courseEnrolled;

    @OneToMany(mappedBy = "student")
    private List<Submission> submissionHistory;  // Relationship with Submission

    // Getters and Setters
    // ...
}
