package com.fd.futured.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "teachers")
@Getter
@Setter
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherID;  // TeacherID (Primary Key)

    private String name;  // Name

    @Column(nullable = false, unique = true)
    private String email;  // Email

    @OneToMany(mappedBy = "teacher")  // Corrected mapping
    private List<Course> coursesManaged;  // Relationship with Course

    @OneToMany(mappedBy = "teacher")  // Corrected mapping
    private List<Assignment> assignmentList;  // Relationship with Assignment

    @OneToMany(mappedBy = "teacher")  // Assuming there is a teacher field in Submission as well
    private List<Submission> submissionReview;  // Relationship with Submission

    // Getters and Setters
    // ...
}
