package com.fd.futured.repository;

import com.fd.futured.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Praful
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
