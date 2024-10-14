package com.fd.futured.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "assignments")
@Getter
@Setter
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignmentID;  // AssignmentID (Primary Key)

    private String title;  // Title

    private String description;  // Description

    @Column(nullable = false)
    private LocalDate deadline;  // Deadline

    @ManyToOne
    @JoinColumn(name = "course_id")  // Foreign Key to Course
    private Course course;
    @ManyToOne  // Many assignments can belong to one teacher
    @JoinColumn(name = "teacher_id", nullable = false)  // Foreign key column in the assignments table
    private Teacher teacher;  // Relationship with Teacher

    private String attachments;  // Attachments

    // Getters and Setters
    // ...
}
