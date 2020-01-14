package com.uuhnaut69.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uuhnaut69.api.model.Account;
import com.uuhnaut69.api.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	private final AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@PostMapping
	public void generateDummyData() {
		accountService.bulkInsert();
	}

	@GetMapping
	public List<Account> fullTextSearch(@RequestParam(value = "text", defaultValue = "") String text) {
		return accountService.fullTextSearch(text);
	}
}
