package com.example.repositories;

import com.example.models.DocenteM;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteR extends CrudRepository<DocenteM,Integer> {

	
}
