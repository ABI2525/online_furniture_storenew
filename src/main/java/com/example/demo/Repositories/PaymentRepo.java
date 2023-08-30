package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Payment;

public interface PaymentRepo extends JpaRepository<Payment,Integer>{

}
