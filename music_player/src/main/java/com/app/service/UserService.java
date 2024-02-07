package com.app.service;

import com.app.dto.SignInReqDTO;
import com.app.dto.SignUpDTO;

public interface UserService {
	//sign up
		SignUpDTO userRegistration(SignUpDTO signupReqDTO);
		
		SignInReqDTO userSignin(SignInReqDTO signinReqDTO, String email);
}
