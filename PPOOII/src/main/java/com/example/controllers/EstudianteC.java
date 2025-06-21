package com.example.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.services.EstudianteS;
import com.example.models.*;

@RestController
@RequestMapping("/estudiante")
public class EstudianteC {

	@Autowired
	private EstudianteS estService;
	
	@PostMapping
	public ResponseEntity<EstudianteM> save(@RequestBody EstudianteM estModel){
		return ResponseEntity.ok(estService.save(estModel));
	}
	
	@GetMapping
	public ResponseEntity<ArrayList<EstudianteM>> getAll(){
		return ResponseEntity.ok(estService.getAll());
	}
	
	@PutMapping
	public ResponseEntity<EstudianteM> update(@RequestBody EstudianteM estModel){
		return ResponseEntity.ok(estService.update(estModel));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id){
		estService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
