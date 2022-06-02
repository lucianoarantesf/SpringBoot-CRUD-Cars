package com.luciano.carros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luciano.carros.domain.carros;

@Repository
public interface ICarros extends JpaRepository<carros, Integer> {

}
