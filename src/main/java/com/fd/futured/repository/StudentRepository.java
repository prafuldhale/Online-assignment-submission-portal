package com.fd.futured.repository;

import com.fd.futured.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Praful
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
