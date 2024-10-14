package com.fd.futured.repository;

import com.fd.futured.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Praful
 */
@Repository
public interface AssignmentRepository extends JpaRepository<Assignment,Long> {
}
