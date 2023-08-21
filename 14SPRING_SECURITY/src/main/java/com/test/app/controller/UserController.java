package com.test.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.app.domain.dto.UserDto;
import com.test.app.domain.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("/join")
	public void join_get() {
		log.info("GET /join..");
	}
	
	@PostMapping("/join")
	public String join_post(UserDto dto) {
		log.info("POST /join" + dto);
		//01
		
		//02
		
		//03
		dto.setRole("ROLE_USER");
		dto.setPassword(passwordEncoder.encode(dto.getPassword())); //dto에 저장된 패스워드를 암호화한 후 다시 패스워드에 저장
		userMapper.insert(dto);
	
		//04	
		return "redirect:login?msg=Join_Success!"; 
	}
}
