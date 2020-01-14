package com.uuhnaut69.api.service;

import java.util.List;

import com.uuhnaut69.api.model.Job;

public interface JobService {

	List<Job> dummyJobData();

	List<Job> fullTextSearch(String text);
}
