package com.javatpoint.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.javatpoint.dto.PostDto;
import com.javatpoint.dto.UserRequestDto;
import com.javatpoint.model.Facts;
import com.javatpoint.model.UserRecord;
import com.javatpoint.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
    @ResponseStatus(code = HttpStatus.OK)
	public List<UserRecord> getAllUser() {
		return userService.getAllUsers();
	}

	@PostMapping("/add-user")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addUser(@RequestBody UserRequestDto userRequestDto) {
		userService.addUser(userRequestDto);
	}

	@DeleteMapping("/delete-user/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}

	@GetMapping("/find-by-name")
	public List<UserRecord> findByName(@RequestParam(name = "name") String name) {
		return userService.findByName(name);
	}

	@PutMapping("/update-user/{id}")
	public void updateUser(@PathVariable int id, @RequestBody UserRecord userRecordDetail) {
		userService.updateUser(id, userRecordDetail);
	}

	@GetMapping("/users")
	public List<UserRecord> pageUser(@RequestParam(name = "pageNum") int pageNum,
			@RequestParam(name = "pageSize") int pageSize) {
		return userService.pageUser(pageNum, pageSize);
	}
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/randomTextFacts")
	public String getFactsList() {
		//RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);		
		ResponseEntity<Facts> facts = restTemplate.exchange("https://cat-fact.herokuapp.com/facts/random", HttpMethod.GET, entity, Facts.class );
		
		if (facts.getStatusCode().is2xxSuccessful()) {
			return facts.getBody().get_id();
		} else if (facts.getStatusCode().is4xxClientError()){
			return "Yêu cầu không thể thuc hien";
		} else if (facts.getStatusCode().is5xxServerError()) {
			return "loi he thong";
		}
		return "";
	}
	
	@GetMapping("/find-facts-by-id/{id}")
	public String getFactsById(@PathVariable String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);	
		ResponseEntity<Facts> facts = restTemplate.exchange("https://cat-fact.herokuapp.com/facts/"+id, HttpMethod.GET, entity, Facts.class);
		
		//Facts f = facts.getBody();
		return facts.getBody().toString();
	}
	
	@GetMapping("/find-facts-by-type-and-amount")
	public List<Facts> getFactsByTypeAndAmount(@RequestParam(name = "animal_type") String type, @RequestParam(name = "amount") int amount) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);	
		ResponseEntity<Facts[]> facts = restTemplate.exchange("https://cat-fact.herokuapp.com/facts/random?animal_type="+type+
				"&amount="+amount, HttpMethod.GET, entity, Facts[].class);
		return  Arrays.asList(facts.getBody());
	}
	
	@GetMapping("/get-users")
	public void getUser(){
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);	
		ResponseEntity<UserRequestDto[]> users = restTemplate.exchange("https://jsonplaceholder.typicode.com/users", HttpMethod.GET, entity, UserRequestDto[].class);
		List<UserRequestDto> listUsers = Arrays.asList(users.getBody());	
		for (UserRequestDto user: listUsers) {
			userService.addUser(user);
		}		
	}
	
	@PostMapping("/add-post")
	public void addPost(@RequestBody PostDto postDto) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<PostDto> entity = new HttpEntity<PostDto>(postDto, headers);	
		PostDto post= restTemplate.postForObject("https://jsonplaceholder.typicode.com/posts", entity, PostDto.class);

		System.out.println(postDto.toString());
		System.out.println(post.toString());
	}

}