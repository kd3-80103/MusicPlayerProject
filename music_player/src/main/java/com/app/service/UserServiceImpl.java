package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserDao;
import com.app.dto.SignUpDTO;
import com.app.dto.SignInReqDTO;

import com.app.entities.User;
import com.app.exception.ResourceNotFoundException;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	//dep : dao layer i/f
	@Autowired
	private UserDao userDao;
	//dep
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public SignUpDTO userRegistration(SignUpDTO reqDTO) {
		User user1=mapper.map(reqDTO, User.class);
		User user2=userDao.save(user1);
		SignUpDTO dto=mapper.map(user2, SignUpDTO.class);
		return dto;
		
		//return mapper.map(userDao.save(mapper.map(reqDTO, User.class)),SignUpDTO.class);
	}

	@Override
	public SignInReqDTO userSignin(SignInReqDTO signinReqDTO, String email) {
		
		User user = userDao.findByEmail(email).orElseThrow(()-> new ResourceNotFoundException("Invalid email!!!"));
		System.out.println(user.toString());
		return mapper.map(user, SignInReqDTO.class);		
		
	}

}