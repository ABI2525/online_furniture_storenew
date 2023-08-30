package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Orders;

public interface OrdersRepo extends JpaRepository<Orders,Integer>{

}
