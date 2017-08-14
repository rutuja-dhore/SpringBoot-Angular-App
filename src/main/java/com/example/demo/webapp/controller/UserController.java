package com.example.demo.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;
import com.example.demo.webapp.dto.UserDTO;
import com.example.demo.webapp.dto.UserInDTO;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<UserDTO> findAll() {
		return userService.findAll();
	}

	@GetMapping(value = "/{userId}")
	public UserDTO findById(@PathVariable Integer userId) {
		return userService.findById(userId);
	}

	@PostMapping
	public UserDTO create(@RequestBody UserInDTO userInDTO) {
		return userService.save(userInDTO);
	}

	@DeleteMapping
	public void delete(Integer userId) {
		userService.delete(userId);
	}
}
