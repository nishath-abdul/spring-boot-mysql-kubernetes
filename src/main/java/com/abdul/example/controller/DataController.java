package com.abdul.example.controller;

import com.abdul.example.entity.User;
import com.abdul.example.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class DataController {

	@Autowired
	private DataRepository dataRepository;

	@GetMapping("/test")
	public String testEndpoint() {
		return "Hello TEST working";
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return dataRepository.findAll();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable int id){
		Optional<User> userDetail = dataRepository.findById(id);
		if (userDetail.isPresent()) {
			return userDetail.get();
		} else {
			throw new DataAccessResourceFailureException("The User Id is not found");
		}
	}

	@PostMapping("/user")
	public void addUser(@RequestBody User user) {
		dataRepository.save(user);
	}

	@PutMapping("user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") int userId, @RequestBody User user) {
		Optional<User> userDetail = dataRepository.findById(userId);
		if (userDetail.isPresent()) {
			User retrievedUser = userDetail.get();
			retrievedUser.setUserName(user.getUserName());
			User updatedUserDetails = dataRepository.save(retrievedUser);
			return ResponseEntity.ok(updatedUserDetails);
		} else {
			return ResponseEntity.ok(dataRepository.save(user));
		}
	}

	@DeleteMapping("user/{id}")
	public void deleteUser(@PathVariable(value = "id") int userId) throws DataAccessResourceFailureException {
		Optional<User> userDetail = dataRepository.findById(userId);
		if (userDetail.isPresent()) {
			dataRepository.deleteById(userId);
		} else {
			throw new DataAccessResourceFailureException("The User Id is not found");
		}
	}

}
