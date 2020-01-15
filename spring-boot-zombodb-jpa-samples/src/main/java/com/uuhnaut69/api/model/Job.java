package com.uuhnaut69.api.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Job implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(columnDefinition = "zdb.fulltext")
	private String title;

	private String position;

	private String seniority;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "job_field", joinColumns = @JoinColumn(name = "job_id"), inverseJoinColumns = @JoinColumn(name = "field_id"))
	private Set<Field> fields = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "job_key_skill", joinColumns = @JoinColumn(name = "job_id"), inverseJoinColumns = @JoinColumn(name = "key_skill_id"))
	private Set<KeySkill> keySkills = new HashSet<>();

}
