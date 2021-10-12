package com.mx.bky.dao;


import com.mx.bky.domain.Peticion;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PeticionDAO extends JpaRepository<Peticion, Long>{
    
}

