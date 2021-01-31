package com.promineotech.pokemonApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.pokemonApi.entity.Trainer;

public interface TrainerRepository extends CrudRepository<Trainer, Long> {
}
