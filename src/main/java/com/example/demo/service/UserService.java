package com.example.demo.service;

import java.util.List;

import com.example.demo.webapp.dto.UserDTO;
import com.example.demo.webapp.dto.UserInDTO;

public interface UserService {

	UserDTO save(UserInDTO userInDTO);

	List<UserDTO> findAll();

	UserDTO findById(Integer userId);

	void delete(Integer userId);
}
