package com.example.simpleecommerceapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.simpleecommerceapp.entity.Order;
import com.example.simpleecommerceapp.entity.User;


@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
     

    public Order findByUser(User user);
}
