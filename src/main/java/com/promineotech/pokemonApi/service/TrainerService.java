package com.promineotech.pokemonApi.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.pokemonApi.entity.Trainer;
import com.promineotech.pokemonApi.repository.TrainerRepository;

@Service
public class TrainerService {

	private static final Logger logger = LogManager.getLogger(TrainerService.class);
	
	@Autowired
	private TrainerRepository repo;
	
	public Trainer getTrainerById(Long id) throws Exception {
		try {
			return repo.findOne(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to retrieve trainer: " + id, e);
			throw e;
		}
	}
	
	public Iterable<Trainer> getTrainers() {
		return repo.findAll();
	}
	
	public Trainer createTrainer(Trainer trainer) {
		return repo.save(trainer);
	}
	
	public Trainer updateTrainer(Trainer trainer, Long id) throws Exception {
		try {
			Trainer oldTrainer = repo.findOne(id);
			oldTrainer.setId(trainer.getId());
			oldTrainer.setName(trainer.getName());
			oldTrainer.setIsMaster(trainer.getIsMaster());
			return repo.save(oldTrainer);
		} catch (Exception e) {
			logger.error("Exception occurred while trying ot update trainer: " + id, e);
			throw new Exception("Unable to update trainer.");
		}
	}
	
	public void deleteTrainer(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to delete trainer: " + id, e);
			throw new Exception("Unable to delete trainer.");
		}
	}
}
