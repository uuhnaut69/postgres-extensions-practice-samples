package com.uuhnaut69.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uuhnaut69.api.model.Job;
import com.uuhnaut69.api.service.JobService;

@RestController
@RequestMapping("/jobs")
public class JobController {

	private final JobService jobService;

	public JobController(JobService jobService) {
		this.jobService = jobService;
	}

	@PostMapping
	public List<Job> dummyData() {
		return jobService.dummyJobData();
	}

	@GetMapping
	public List<Job> fullTextSearch(@RequestParam(value = "text", defaultValue = "") String text) {
		return jobService.fullTextSearch(text);
	}
}
