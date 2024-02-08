package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.SignInReqDTO;
import com.app.dto.SignInRespDTO;
import com.app.dto.SignUpDTO;
//import com.app.entities.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/users")
//@CrossOrigin(origins="http://localhost:3000")
public class UserController {

	@Autowired(required = true)
	private UserService userService;

//signup

	@PostMapping("/signup")
	public ResponseEntity<?> userSignup(@RequestBody @Valid SignUpDTO dto) {
		System.out.println("in sign up " + dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.userRegistration(dto));
	}

<<<<<<< HEAD
@PostMapping("/signin")
public ResponseEntity<?> signinUser(@RequestBody @Valid SignInReqDTO reqDTO) {
	System.out.println("in signin " + reqDTO);
	
	SignInRespDTO signinRespDTO = userService.userSignin(reqDTO);
	System.out.println(signinRespDTO.toString());
	
	return ResponseEntity.ok("User signin successfully");
}
=======
	@PostMapping("/signin")
	public ResponseEntity<?> signinUser(@RequestBody @Valid SignInReqDTO reqDTO) {
		System.out.println("in signin " + reqDTO);

//	if(reqDTO.getEmail().equals())

		return ResponseEntity.ok("User signin successfully");
	}
>>>>>>> d00bc9633c89465b501f47b28677c5428cec0a88
}
