package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer>{

}
