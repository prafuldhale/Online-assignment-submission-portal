package com.fd.futured.service;

import com.fd.futured.dto.CourseDTO;
import com.fd.futured.entity.Course;
import com.fd.futured.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // 1. Get all courses
    public List<CourseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();

        // Convert Course entities to CourseDTO objects
        return courses.stream()
                .map(course -> new CourseDTO(
                        course.getCourseID(),
                        course.getCourseName(),
                        course.getTeacher() != null ? course.getTeacher().getName() : null))
                .collect(Collectors.toList());
    }

    // 2. Get course by ID
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    // 3. Create new course
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    // 4. Update course
    public Course updateCourse(Long id, Course courseDetails) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            course.setCourseName(courseDetails.getCourseName());
            course.setTeacher(courseDetails.getTeacher());
            return courseRepository.save(course);
        }
        return null;
    }

    // 5. Delete course
    public boolean deleteCourse(Long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
