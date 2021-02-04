package com.promineotech.pokemonApi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.pokemonApi.entity.Pokemon;

public interface PokemonRepository extends CrudRepository<Pokemon, Long> {
	
	List <Pokemon> findAllByTrainerId (Long trainerId);
}
