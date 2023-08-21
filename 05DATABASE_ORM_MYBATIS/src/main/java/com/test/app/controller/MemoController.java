package com.test.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.app.domain.dto.MemoDto;
import com.test.app.domain.service.MemoService;

import lombok.extern.slf4j.Slf4j;

//컨트롤러설정 2개!
@Controller
@Slf4j
@RequestMapping("/memo")
public class MemoController {

	@Autowired //controller와 service연결을 위한 의존주입
	private MemoService service;
	
	@GetMapping("/showMemo")
	public void f1(Model model){	
		log.info("GET /memo/showMemo");
		List<MemoDto> list = service.getAllMemo();
		list.forEach((dto)->{System.out.println(dto);});
		model.addAttribute("list",list);
	};
	
	@PostMapping("/addMemo")
	public void f2(MemoDto dto){	
		log.info("POST /memo/addMemo.." + dto);
		service.addMemo(dto);
		log.info("POST /memo/addMemo..nextid : " + dto.getId());
	};
	
	
}
