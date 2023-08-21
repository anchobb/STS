package com.test.app.Domain.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.app.Domain.Dto.MemberDto;
import com.test.app.Domain.Mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberService{
	
	@Autowired
	MemberMapper memberMapper;
	
	public List<MemberDto> getAllMember(){
		
		return memberMapper.membersearchAll();
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void addMember(MemberDto dto) {
		String id = dto.getId();
		memberMapper.insert(dto);
		dto.setId(id);
		memberMapper.insert(dto);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void modifyMember(MemberDto dto) {
		memberMapper.update(dto);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void removeMember(String id) {
		memberMapper.delete(id);
	}
	
}