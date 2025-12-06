package com.example.simpleecommerceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simpleecommerceapp.entity.User;
import com.example.simpleecommerceapp.repo.UserRepo;

@Service
public class UserService {
    
    @Autowired
     private UserRepo userRepo;
     public List<User> getAllUser() {
        return userRepo.findAll();
    }

    public User getUserById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));
    }

    public void createUser(User user) {
        userRepo.save(user);
    }

    public void UpdateUser(User user , Long id) {
        userRepo.findById(user.getId()).orElseThrow(() -> new RuntimeException("Admin not found with id: " + user.getId()));
        userRepo.save(user);
    }

    public void deleteUser( Long id) {
        userRepo.findById(id).orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));
        userRepo.deleteById(id);
    }

    public boolean verifyCredentials(String email, String password) {
        User user= userRepo.findByEmail(email);
        if (user.getPassword() == password) {
            return true ;
        } else {
            return false ;
        }
    }

}
