package com.javatpoint.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.javatpoint.dto.PostDto;
import com.javatpoint.dto.UserRequestDto;
import com.javatpoint.model.UserRecord;
import com.javatpoint.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<UserRecord> getAllUsers() {
		List<UserRecord> userRecords = new ArrayList<>();
		userRepository.findAll().forEach(userRecords::add);
		return userRecords;
	}

	public void addUser(UserRequestDto userRequestDto) {
		UserRecord user = new UserRecord();
		//user.setId(userRequestDto.getId());
		user.setEmail(userRequestDto.getEmail());
		user.setName(userRequestDto.getName());
		userRepository.save(user);
	}

	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

	public List<UserRecord> findByName(String name) {
		return userRepository.findByName(name);
	}

	public void updateUser(int id, UserRecord userRecordDetail) {
		UserRecord user = userRepository.findById(id);
		user.setName(userRecordDetail.getName());
		user.setEmail(userRecordDetail.getEmail());
		userRepository.save(user);
	}

	public List<UserRecord> pageUser(int pageNum, int pageSize) {
		Page<UserRecord> page = userRepository.findAll(PageRequest.of(pageNum, pageSize));
		return page.toList();
	}

}