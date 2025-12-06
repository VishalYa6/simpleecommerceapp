package com.example.simpleecommerceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simpleecommerceapp.entity.Order;
import com.example.simpleecommerceapp.repo.OrderRepo;

@Service
public class OrderService {
    
    @Autowired
     private OrderRepo orderRepo;
     public List<Order> getAllOrder() {
        return orderRepo.findAll();
    }
    public Order getOrderById(Long id) {
        return orderRepo.findById(id).orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));
    }

    public void createOrder(Order Order) {
        orderRepo.save(Order);
    }

    public void UpdateOrder(Order Order , Long id) {
        orderRepo.findById(Order.getId()).orElseThrow(() -> new RuntimeException("Admin not found with id: " + Order.getId()));
        orderRepo.save(Order);
    }

    public void deleteOrder( Long id) {
        orderRepo.findById(id).orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));
        orderRepo.deleteById(id);
    }

    

}
