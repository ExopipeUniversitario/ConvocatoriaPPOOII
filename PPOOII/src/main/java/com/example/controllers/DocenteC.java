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

import com.example.models.DocenteM;
import com.example.services.DocenteS;

@RestController
@RequestMapping("/docente")
public class DocenteC {

	@Autowired
	private DocenteS docService;
	
	@PostMapping
	public ResponseEntity<DocenteM> save(@RequestBody DocenteM docModel){
		return ResponseEntity.ok(docService.save(docModel));
	}
	
	@GetMapping
	public ResponseEntity<ArrayList<DocenteM>> getAll(){
		return ResponseEntity.ok(docService.getAll());
	}
	
	@PutMapping
	public ResponseEntity<DocenteM> update(@RequestBody DocenteM docModel){
		return ResponseEntity.ok(docService.update(docModel));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id){
		docService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
