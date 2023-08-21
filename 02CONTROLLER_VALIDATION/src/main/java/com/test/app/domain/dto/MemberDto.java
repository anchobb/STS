package com.test.app.domain.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberDto {
	private String userid;
	private String password;
	private String name;
	private String phone;
	private String address;
	
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate  birthday;
	private String [] hobbys; //체크박스는 배열 스트링으로 봄
	private String [] hobbys2; //쉼표를 기준으로 배열
}
