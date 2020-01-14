package com.uuhnaut69.api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.javafaker.Faker;
import com.uuhnaut69.api.model.Account;
import com.uuhnaut69.api.repository.AccountRepository;
import com.uuhnaut69.api.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	private final AccountRepository accountRepository;

	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public void bulkInsert() {
		Faker faker = new Faker();
		List<Account> accounts = new ArrayList<>();
		IntStream.range(0, 30).forEach(t -> accounts.add(new Account(faker.name().fullName(),
				faker.address().fullAddress(), faker.educator().university(), faker.job().title())));
		if (!accounts.isEmpty()) {
			accountRepository.saveAll(accounts);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Account> fullTextSearch(String text) {
		return accountRepository.fullTextSearch(text);
	}

}
