package com.fd.futured.repository;

import com.fd.futured.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Praful
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
