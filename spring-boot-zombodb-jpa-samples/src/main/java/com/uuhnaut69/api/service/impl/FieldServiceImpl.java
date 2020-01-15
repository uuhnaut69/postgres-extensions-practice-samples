package com.uuhnaut69.api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.javafaker.Faker;
import com.uuhnaut69.api.model.Field;
import com.uuhnaut69.api.repository.FieldRepository;
import com.uuhnaut69.api.service.FieldService;

@Service
@Transactional
public class FieldServiceImpl implements FieldService {

	private final FieldRepository fieldRepository;

	public FieldServiceImpl(FieldRepository fieldRepository) {
		this.fieldRepository = fieldRepository;
	}

	@Override
	public List<Field> dummyFieldData() {
		Faker faker = new Faker();
		List<Field> fields = new ArrayList<>();
		IntStream.range(0, 3).forEach(e -> fields.add(new Field(faker.job().field())));
		if (!fields.isEmpty()) {
			fieldRepository.saveAll(fields);
		}
		return fields;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Field> getFields() {
		return fieldRepository.findAll();
	}

}
