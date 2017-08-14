package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.common.BeanMapper;
import com.example.demo.persistence.UserDAO;
import com.example.demo.persistence.UserEntity;
import com.example.demo.service.UserService;
import com.example.demo.webapp.dto.UserDTO;
import com.example.demo.webapp.dto.UserInDTO;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private BeanMapper beanMapper;

	@Override
	public UserDTO save(UserInDTO userInDTO) {
		UserEntity user = beanMapper.map(userInDTO, UserEntity.class);
		user = userDAO.save(user);
		return beanMapper.map(user, UserDTO.class);
	}

	@Override
	public List<UserDTO> findAll() {
		List<UserEntity> users = userDAO.findAll();
		return beanMapper.map(users, UserDTO.class);
	}

	@Override
	public UserDTO findById(Integer userId) {
		UserEntity user = userDAO.findById(userId);
		return beanMapper.map(user, UserDTO.class);
	}
}
