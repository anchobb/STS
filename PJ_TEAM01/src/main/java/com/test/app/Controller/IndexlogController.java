package com.test.app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class IndexlogController {

	@PostMapping("/indexlog")
	public void f1() {
		log.info("GET /main/indexlog");
	}
}	
