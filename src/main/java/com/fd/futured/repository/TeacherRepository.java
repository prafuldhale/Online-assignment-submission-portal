package com.fd.futured.repository;

import com.fd.futured.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Praful
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
