package com.uuhnaut69.api.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Account implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	private String fullName;

	private String address;

	private String educator;

	private String job;

	public Account(String fullName, String address, String educator, String job) {
		this.fullName = fullName;
		this.address = address;
		this.educator = educator;
		this.job = job;
	}

}
