package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Model.Registration;

public interface RegistrationRepo extends JpaRepository<Registration, Integer>{

	@Query(value = "select * from customer_details where name=:sn",nativeQuery = true)
	public List<Registration> getNameReg(@Param("sn") String name);

}
