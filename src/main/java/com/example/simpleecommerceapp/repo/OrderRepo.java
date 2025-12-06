package com.example.simpleecommerceapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.simpleecommerceapp.entity.Order;


@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
     

    public Order findByName(String name);
}
