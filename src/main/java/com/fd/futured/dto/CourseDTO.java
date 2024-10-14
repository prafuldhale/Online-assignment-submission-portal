package com.fd.futured.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDTO {

    private Long courseID;  // CourseID
    private String courseName;  // Course Name
    private String teacherName;  // Teacher Name

    public CourseDTO(Long courseID, String courseName, String teacherName) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.teacherName = teacherName;
    }
}
