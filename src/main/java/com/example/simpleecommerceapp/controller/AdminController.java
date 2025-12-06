package com.example.simpleecommerceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.simpleecommerceapp.entity.Admin;

import com.example.simpleecommerceapp.service.AdminService;
import com.example.simpleecommerceapp.service.OrderService;
import com.example.simpleecommerceapp.service.ProductService;
import com.example.simpleecommerceapp.service.UserService;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @GetMapping("/verify/credentials")
    public String verifyCredentials(@ModelAttribute("admin")  Admin admin, Model model) {
       if(adminService.verifyCredentials(admin.getEmail(), admin.getPassword())) {
           return "/admin/home";
       } else {
           model.addAttribute("error", "Invalid email or password");
           return "Login";
       }
    }

    @GetMapping("/admin/home")
    public String adminHomePage(Model model) {

        model.addAttribute("adminList",  adminService.getAllAdmin());
        model.addAttribute("userList",   userService.getAllUser());
        model.addAttribute("orderList",  orderService.getAllOrder());
        model.addAttribute("productList",productService.getAllpProducts());

        return "AdminHomePage";
    }

    @GetMapping("/add/admin")
    public String createAdmin(){
            return "AddAdmin";

    }
    @PostMapping("/add/admin")
    public String createAdmin(Admin admin){

            adminService.createUser(admin);
            return "/admin/home";            
    }

    @GetMapping("/update/admin/{id}")
    public String updateAdmin(@PathVariable Long id, Model model) {
        model.addAttribute("admin" , adminService.getAdminById(id));

        return "UpdateAdmin"
    }

    public String updateAdmin(Admin admin) {
        
    }

}