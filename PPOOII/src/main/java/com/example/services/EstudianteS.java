package com.example.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.EstudianteM;
import com.example.repositories.EstudianteR;

@Service
public class EstudianteS {

	@Autowired
	private EstudianteR	estRepositorio;
	
	public EstudianteM save(EstudianteM estModel) {
		return estRepositorio.save(estModel);
		
	}
	
	public ArrayList<EstudianteM> getAll(){
		return (ArrayList<EstudianteM>) estRepositorio.findAll();
	}
	
	public EstudianteM update(EstudianteM temp) {
		return exists(temp.getId()) ?  estRepositorio.save(temp)
				:null;
	}
	
	public boolean delete(int id) {
		if(exists(id)) {
			estRepositorio.deleteById(id);
			if(exists(id)) {
				return false;
			} 
			return true;
		}
		return false;
	}
	
	private boolean exists(int id) {
		return estRepositorio.existsById(id);
	}
	
}
