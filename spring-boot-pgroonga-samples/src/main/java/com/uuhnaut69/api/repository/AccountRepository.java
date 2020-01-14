package com.uuhnaut69.api.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uuhnaut69.api.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {

	@Query(value = "select * from account where full_name &@~ ?1", nativeQuery = true)
	List<Account> fullTextSearch(String text);
}
