package com.uuhnaut69.api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.javafaker.Faker;
import com.uuhnaut69.api.model.KeySkill;
import com.uuhnaut69.api.repository.KeySkillRepository;
import com.uuhnaut69.api.service.KeySkillService;

@Service
@Transactional
public class KeySkillServiceImpl implements KeySkillService {

	private final KeySkillRepository keySkillRepository;

	public KeySkillServiceImpl(KeySkillRepository keySkillRepository) {
		this.keySkillRepository = keySkillRepository;
	}

	@Override
	public List<KeySkill> dummyKeySkillData() {
		Faker faker = new Faker();
		List<KeySkill> keySkills = new ArrayList<>();
		IntStream.range(0, 5).forEach(e -> keySkills.add(new KeySkill(faker.job().keySkills())));
		if (!keySkills.isEmpty()) {
			keySkillRepository.saveAll(keySkills);
		}
		return keySkills;
	}

	@Override
	@Transactional(readOnly = true)
	public List<KeySkill> getKeySkills() {
		return keySkillRepository.findAll();
	}

}
