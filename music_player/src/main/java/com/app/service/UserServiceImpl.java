package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserEntityDao;
import com.app.dto.SigninReqDTO;
import com.app.dto.SignupDTO;
import com.app.entities.UserEntity;
import com.app.exception.ResourceNotFoundException;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	//dep : dao layer i/f
	@Autowired
	private UserEntityDao userDao;
	//dep
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public SignupDTO userRegistration(SignupDTO reqDTO) {
		return mapper.map(userDao.save(mapper.map(reqDTO, UserEntity.class)),SignupDTO.class);
	}

	@Override
	public SigninReqDTO userSignin(SigninReqDTO signinReqDTO, String email) {
		
		UserEntity user = userDao.findByEmail(email).orElseThrow(()-> new ResourceNotFoundException("Invalid email!!!"));
		System.out.println(user.toString());
		return mapper.map(user, SigninReqDTO.class);		
		
	}

}