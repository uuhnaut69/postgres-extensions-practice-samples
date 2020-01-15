package com.uuhnaut69.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uuhnaut69.api.model.KeySkill;

@Repository
public interface KeySkillRepository extends JpaRepository<KeySkill, UUID> {

}
