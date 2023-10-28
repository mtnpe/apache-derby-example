package com.javatpoint.repository;
import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.javatpoint.model.UserRecord;

public interface UserRepository extends JpaRepository<UserRecord, Integer> {

	UserRecord findById(int id);
	List<UserRecord> findByName(String name);
	List<UserRecord> findByNameContaining(String name);
	List<UserRecord> findByEmail(String email);
	List<UserRecord> findAllByEmailOrName(String email, String name);
	
	
}

