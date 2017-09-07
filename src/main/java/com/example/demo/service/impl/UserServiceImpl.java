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

	@Override
	public void delete(Integer userId) {
		UserEntity user = userDAO.findById(userId);
		if (null != user) {
			userDAO.delete(userId);
		}
	}

	@Override
	public UserDTO update(Integer userId, UserInDTO userInDTO) {
		UserEntity user = userDAO.findById(userId);
		if (null != user) {
			user.setFirstName(userInDTO.getFirstName());
			user.setLastName(userInDTO.getLastName());
			user.setAge(userInDTO.getAge());
			user = userDAO.save(user);
			return beanMapper.map(user, UserDTO.class);
		}
		return null;
	}

}
