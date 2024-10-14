package com.fd.futured.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Praful
 */


@Entity
@Table(name = "courses")
@Setter
@Getter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseID;  // CourseID (Primary Key)

    private String courseName;  // Course Name

    @ManyToOne
    @JoinColumn(name = "teacher_id")  // Foreign Key to Teacher
    private Teacher teacher;

    @OneToMany(mappedBy = "courseEnrolled")
    private List<Student> studentList;  // Relationship with Student

    // Getters and Setters
    // ...
}
