package com.test.app.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.app.domain.dto.MemoDto;

import lombok.extern.slf4j.Slf4j;

//파라미터 받기~

@Controller
@Slf4j
@RequestMapping("/memo") //http://localhost:8080/app/memo/
public class MemoController {
	
	@GetMapping("/form")
	public void get() {
		log.info("GET /memo/form..");
	}
	@PostMapping("/post")
	public String post(@Valid MemoDto dto,BindingResult bindingResult,Model model) { //유효성체크를 위해서 @Valid 애노테이션 변수에 추가, BindingResult에서 유효성체크에 문제 생길 시 확인
		log.info("POST /memo/post.." + dto);
		log.info("POST /memo/post..isError " +bindingResult.getFieldError("id"));
		if(bindingResult.hasFieldErrors()) {
//			log.info("POST /memo/post..isError " +bindingResult.getFieldError("id").getDefaultMessage()); //MemoDto에서 지정했던 메시지도 확인 가능
			for(FieldError error : bindingResult.getFieldErrors()) {
				log.info(error.getField()+" : "+error.getDefaultMessage());
				model.addAttribute(error.getField(), error.getDefaultMessage());
			}
			return "memo/form"; //메서드의 형식을 void가 아니라 다른 것으로 바꾸면 view를 보낼 return값을 입력해야함!
		}
		return ""; //post라는 위치가 없기 때문에 return "";로 작성해둠
	}
	
}
