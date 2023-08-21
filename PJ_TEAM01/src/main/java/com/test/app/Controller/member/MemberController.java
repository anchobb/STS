package com.test.app.Controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.app.Domain.Dto.MemberDto;
import com.test.app.Domain.Service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/member")
public class MemberController{

	@Autowired
	MemberService memberService;
	
	@GetMapping("/add")
	public void f1(MemberDto dto) {
		log.info("GET /member/add");
		memberService.addMember(dto);
	}

	@GetMapping("/selectall")
	public void f2(MemberDto dto) {
		log.info("GET /member/selectall");
	}

	@GetMapping("/update")
	public void f3(MemberDto dto) {
		log.info("GET /member/update");
		memberService.modifyMember(dto);
	}
	
	@GetMapping("/remove/{id}")
	public void f4(@PathVariable String id) {
		log.info("GET /member/delete");
		memberService.removeMember(id);
	}
	
	
}