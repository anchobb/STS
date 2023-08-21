package com.test.app.Config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test.app.Domain.Dto.MemberDto;
import com.test.app.Domain.Mapper.MemberMapper;

@Service
public class PrincipalDetailsService implements UserDetailsService{

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MemberDto dto = memberMapper.selectAt(username);
		if(dto==null)
			return null;
		
		return new PrincipalDetails(dto);
	}

}
