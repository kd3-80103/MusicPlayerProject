package com.app.service;

import com.app.dto.SignInReqDTO;
import com.app.dto.SignInRespDTO;
import com.app.dto.SignUpDTO;

public interface UserService {
	//sign up
		SignUpDTO userRegistration(SignUpDTO signupReqDTO);
		
		SignInRespDTO userSignin(SignInReqDTO signinReqDTO);
}
