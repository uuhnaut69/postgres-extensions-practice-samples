package com.uuhnaut69.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uuhnaut69.api.model.KeySkill;
import com.uuhnaut69.api.service.KeySkillService;

@RestController
@RequestMapping("/keyskills")
public class KeySkillController {

	private final KeySkillService keySkillService;

	public KeySkillController(KeySkillService keySkillService) {
		this.keySkillService = keySkillService;
	}

	@PostMapping
	public List<KeySkill> dummyKeySkillData() {
		return keySkillService.dummyKeySkillData();
	}
}
