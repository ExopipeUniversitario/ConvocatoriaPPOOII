package com.example.repositories;

import com.example.models.EstudianteM;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteR extends CrudRepository<EstudianteM,Integer>{
	

	

}
