package com.test.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.app.domain.dto.MemoDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DiTest {
	@Autowired
	MemoDto memoDto;
	@Autowired
	MemoDto memoDto2;
	@Autowired
	ApplicationContext applicationContext;
	
	@Test
	public void test() {
		System.out.println("MemoDto : " + memoDto);
		System.out.println("MemoDto2 : " + memoDto2);
		System.out.println("applicationContext : "+applicationContext);
		System.out.println("applicationContext.getBean() : "+applicationContext.getBean("memoDto",MemoDto.class));
		
	}

}
