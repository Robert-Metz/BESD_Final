package com.promineotech.pokemonApi.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.pokemonApi.entity.Pokemon;
import com.promineotech.pokemonApi.repository.PokemonRepository;

@Service
public class PokemonService {

	private static final Logger logger = LogManager.getLogger(PokemonService.class);
	
	@Autowired
	private PokemonRepository repo;
	
	public Iterable<Pokemon> getPokemonByTrainerId(Long trainerId) {
		return repo.findAllByTrainerId(trainerId);
	}
	
	public Iterable<Pokemon> getPokemon() {
		return repo.findAll();
	}
	
	public Pokemon createPokemon(Pokemon pokemon) { 
		return repo.save(pokemon);
	}
	
	public Pokemon updatePokemon(Pokemon pokemon, Long id) throws Exception {
		try {
			Pokemon oldPokemon = repo.findOne(id);
			oldPokemon.setName(pokemon.getName());
			oldPokemon.setType(pokemon.getType());
			oldPokemon.setDescription(pokemon.getDescription());
			oldPokemon.setTrainerId(pokemon.getTrainerId());
			return repo.save(oldPokemon);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to update pokemon: " + id, e);
			throw new Exception("Unable to update pokemon!");
		}
	}
	
	public void releasePokemon(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			logger.error("A fuss occurred trying to release Pokemon: " + id, e);
			throw new Exception("Unable to release Pokemon! You must have a bond!");
		}
	}
	
}
