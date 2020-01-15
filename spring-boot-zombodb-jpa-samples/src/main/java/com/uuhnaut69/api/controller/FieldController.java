package com.uuhnaut69.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uuhnaut69.api.model.Field;
import com.uuhnaut69.api.service.FieldService;

@RestController
@RequestMapping("/fields")
public class FieldController {

	private final FieldService fieldService;

	public FieldController(FieldService fieldService) {
		this.fieldService = fieldService;
	}

	@PostMapping
	public List<Field> dummyFieldData() {
		return fieldService.dummyFieldData();
	}

}
