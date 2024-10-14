package com.fd.futured.service;

import com.fd.futured.entity.Admin;
import com.fd.futured.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // 1. Get all admins
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    // 2. Get admin by ID
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    // 3. Create new admin
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    // 4. Update admin
    public Admin updateAdmin(Long id, Admin adminDetails) {
        Admin admin = adminRepository.findById(id).orElse(null);
        if (admin != null) {
            admin.setName(adminDetails.getName());
            admin.setEmail(adminDetails.getEmail());
            return adminRepository.save(admin);
        }
        return null;
    }

    // 5. Delete admin
    public boolean deleteAdmin(Long id) {
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
