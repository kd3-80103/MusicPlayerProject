package com.app.service;

import com.app.dto.SigninReqDTO;
import com.app.dto.SignupDTO;

public interface UserService {
	//sign up
		SignupDTO userRegistration(SignupDTO signupReqDTO);
		
		SigninReqDTO userSignin(SigninReqDTO signinReqDTO, String email);
}
