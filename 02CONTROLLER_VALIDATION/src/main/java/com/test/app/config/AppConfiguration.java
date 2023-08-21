package com.test.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.test.app.domain.dto.Person;

//Bean 애노케이션으로 Bean주입

@Configuration
public class AppConfiguration {
	@Bean("myPerson")
	public Person PersonBean() {
		return new Person().builder()
				.name("정우균")
				.age(11)
				.addr("대구")
				.build();
	}
}
