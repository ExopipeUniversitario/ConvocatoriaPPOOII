package com.example.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.DocenteM;
import com.example.repositories.DocenteR;

@Service
public class DocenteS {

	@Autowired
	private DocenteR docRepositorio;
	
	public DocenteM save(DocenteM docModel) {
		if(validateDocument(docModel)) {
			return docRepositorio.save(docModel);
		}
		return null;	
	}
	
	public ArrayList<DocenteM> getAll(){
		return (ArrayList<DocenteM>) docRepositorio.findAll();
	}
	
	public DocenteM update(DocenteM temp) {
		return exists(temp.getId()) ?  docRepositorio.save(temp)
				:null;
	}
	
	public boolean delete(int id) {
		if(exists(id)) {
			docRepositorio.deleteById(id);
			if(exists(id)) {
				return false;
			} 
			return true;
		}
		return false;
	}
	
	private boolean exists(int id) {
		return docRepositorio.existsById(id);
	}
	
	private boolean validateDocument(DocenteM doc) {
	    if(exists(doc.getId())){
	        Optional<DocenteM> optionalTemp = docRepositorio.findById(doc.getId());
	        if(optionalTemp.isPresent()) {
	            DocenteM temp = optionalTemp.get();
	            if(doc.getTipoDocumento().equals(temp.getTipoDocumento()) && doc.getNumeroDocumento().equals(temp.getNumeroDocumento())) {
	            	return false;
	            } 
	        }
	        return false;
	    }
	    return true;
	}

	
}
