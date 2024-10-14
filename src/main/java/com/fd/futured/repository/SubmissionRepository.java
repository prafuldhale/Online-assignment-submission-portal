package com.fd.futured.repository;

import com.fd.futured.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Praful
 */
@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}
