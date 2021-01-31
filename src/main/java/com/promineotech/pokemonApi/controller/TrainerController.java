package com.promineotech.pokemonApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.pokemonApi.entity.Trainer;
import com.promineotech.pokemonApi.service.TrainerService;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

	@Autowired
	private TrainerService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> getTrainer(@PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.getTrainerById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getTrainers() {
		return new ResponseEntity<Object>(service.getTrainers(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createTrainer(@RequestBody Trainer trainer) {
		System.out.println(trainer);
		return new ResponseEntity<Object>(service.createTrainer(trainer), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateTrainer(@RequestBody Trainer trainer, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.updateTrainer(trainer, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteTrainer(@PathVariable Long id) {
		try {
			service.deleteTrainer(id);
			return new ResponseEntity<Object>("Successfully deleted trainer with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
