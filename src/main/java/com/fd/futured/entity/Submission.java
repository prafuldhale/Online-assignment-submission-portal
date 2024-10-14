package com.fd.futured.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


/**
 * @author Praful
 */

@Entity
@Table(name = "submissions")
@Getter
@Setter
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long submissionID;  // SubmissionID (Primary Key)

    @ManyToOne
    @JoinColumn(name = "student_id")  // Foreign Key to Student
    private Student student;

    @ManyToOne
    @JoinColumn(name = "assignment_id")  // Foreign Key to Assignment
    private Assignment assignment;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;  // Relationship with Teacher

    private LocalDateTime submissionTime;  // Submission Time

    private String status;  // Status

    private String filesSubmitted;  // Files Submitted

    // Getters and Setters
    // ...
}
