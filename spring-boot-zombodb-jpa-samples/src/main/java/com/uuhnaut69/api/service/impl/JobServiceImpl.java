package com.uuhnaut69.api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.javafaker.Faker;
import com.uuhnaut69.api.model.Field;
import com.uuhnaut69.api.model.Job;
import com.uuhnaut69.api.model.KeySkill;
import com.uuhnaut69.api.repository.JobRepository;
import com.uuhnaut69.api.service.FieldService;
import com.uuhnaut69.api.service.JobService;
import com.uuhnaut69.api.service.KeySkillService;

@Service
@Transactional
public class JobServiceImpl implements JobService {

	private final JobRepository jobRepository;
	private final KeySkillService keySkillService;
	private final FieldService fieldService;

	public JobServiceImpl(JobRepository jobRepository, KeySkillService keySkillService, FieldService fieldService) {
		this.jobRepository = jobRepository;
		this.keySkillService = keySkillService;
		this.fieldService = fieldService;
	}

	@Override
	public List<Job> dummyJobData() {
		Faker faker = new Faker();
		Random random = new Random();
		List<Job> jobs = new ArrayList<>();
		List<KeySkill> keySkills = keySkillService.getKeySkills();
		List<Field> fields = fieldService.getFields();
		IntStream.range(0, 10).forEach(i -> {
			Job job = new Job();
			job.setTitle(faker.job().title());
			job.setPosition(faker.job().position());
			job.setSeniority(faker.job().seniority());
			IntStream.range(0, 3).forEach(e -> job.getFields().add(fields.get(random.nextInt(fields.size()))));
			IntStream.range(0, 3).forEach(e -> job.getKeySkills().add(keySkills.get(random.nextInt(keySkills.size()))));
			jobs.add(job);
		});
		if (!jobs.isEmpty()) {
			jobRepository.saveAll(jobs);
		}
		return jobs;
	}

	@Override
	public List<Job> fullTextSearch(String text) {
		return null;
	}

}
