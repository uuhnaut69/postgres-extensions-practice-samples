package com.uuhnaut69.api.service;

import java.util.List;

import com.uuhnaut69.api.model.Account;

public interface AccountService {

	void bulkInsert();

	List<Account> fullTextSearch(String text);

}
