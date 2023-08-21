package com.test.app.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.app.domain.dto.UserDto;
import com.test.app.domain.mapper.UserMapper;

@Service
public class PrincipalDetailsService implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;
	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
//	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto dto = userMapper.selectAt(username);
		if(dto==null)
			return null;
		return new PrincipalDetails(dto);
		
	}

}
