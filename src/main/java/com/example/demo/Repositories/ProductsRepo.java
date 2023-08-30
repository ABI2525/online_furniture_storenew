package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Products;

public interface ProductsRepo extends JpaRepository<Products,Integer>{

}
