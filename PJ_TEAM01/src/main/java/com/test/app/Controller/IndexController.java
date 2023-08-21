package com.test.app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/main")
public class IndexController{
	
	
	@GetMapping("/index")
	public void f1() {
		log.info("GET /main/index");
	}

}