package com.uuhnaut69.api.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.javafaker.Faker;
import com.uuhnaut69.api.model.Field;
import com.uuhnaut69.api.model.Job;
import com.uuhnaut69.api.repository.JobRepository;
import com.uuhnaut69.api.service.JobService;

@Service
@Transactional
public class JobServiceImpl implements JobService {

	private final JobRepository jobRepository;

	public JobServiceImpl(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	@Override
	public List<Job> dummyJobData() {
		Faker faker = new Faker();
		List<Job> jobs = new ArrayList<>();
		IntStream.range(0, 15).forEach(i -> {
			Job job = new Job();
			job.setTitle(faker.job().title());
			job.setPosition(faker.job().position());
			job.setKeySkills(faker.job().keySkills());
			job.setSeniority(faker.job().seniority());
			Set<Field> fields = new HashSet<>();
			IntStream.range(0, 3).forEach(e -> fields.add(new Field(faker.job().field())));
			job.setFields(fields);
			jobs.add(job);
		});
		if (!jobs.isEmpty()) {
			jobRepository.saveAll(jobs);
		}
		return jobs;
	}

	@Override
	public List<Job> fullTextSearch(String text) {
		// TODO Auto-generated method stub
		return null;
	}

}
