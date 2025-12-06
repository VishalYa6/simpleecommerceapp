package com.example.simpleecommerceapp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simpleecommerceapp.entity.Admin;
import com.example.simpleecommerceapp.repo.AdminRepo;

@Service    
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;

    public List<Admin> getAllAdmin() {
        return adminRepo.findAll();
    }

    public Admin getAdminById(Long id) {
        return adminRepo.findById(id).orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));
    }

    public void UpdateAdmin(Admin admin , Long id) {
        adminRepo.findById(admin.getId()).orElseThrow(() -> new RuntimeException("Admin not found with id: " + admin.getId()));
        adminRepo.save(admin);
    }

    public void deleteAdmin( Long id) {
        adminRepo.findById(id).orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));
        adminRepo.deleteById(id);
    }

    private boolean verifyCredentials(String email, String password) {
        Admin admin = adminRepo.findByEmail(email);
        if (admin.getPassword() == password) {
            return true ;
        } else {
            return false ;
        }
    }

}
