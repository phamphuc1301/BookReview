package com.fsoft.services;

import com.fsoft.entities.Trainer;

public interface TrainerService {
	public Iterable<Trainer> findAll();

	public Trainer save(Trainer trainer);
	
	int saveTrainer(String trainerName, String trainerAccount,String trainerEmail,
			String mobilePhone);
	
	public Trainer findById(Integer trainerId);
}
