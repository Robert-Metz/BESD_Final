package com.promineotech.pokemonApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.pokemonApi.entity.Pokemon;
import com.promineotech.pokemonApi.service.PokemonService;


@RestController
@RequestMapping("/pokemon")
public class PokemonController {
	
	@Autowired
	private PokemonService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getPokemon() {
		return new ResponseEntity<Object>(service.getPokemon(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createPokemon(@RequestBody Pokemon pokemon) {
		return new ResponseEntity<Object>(service.createPokemon(pokemon), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updatePokemon(@RequestBody Pokemon pokemon, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.updatePokemon(pokemon, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to update pokemon.", HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deletePokemon(@PathVariable Long id) {
		try {
			service.releasePokemon(id);
			return new ResponseEntity<Object>("Successfully released pokemon with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to release pokemon! You must have a bond (or an error)", HttpStatus.BAD_REQUEST);
		}
	}

}
