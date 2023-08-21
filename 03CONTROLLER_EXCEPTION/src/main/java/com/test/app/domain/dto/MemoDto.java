package com.test.app.domain.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Builder
public class MemoDto {
	
	@Min(value=10, message="최소 숫자는 10이상 이어야합니다.") //변수값의 최소값 정하기. message도 가능!
	@Max(value=1000, message="최대 숫자는 1000이하 이어야합니다.")
	private int id;
	@NotBlank(message="text를 입력하세요.")
	private String text;
	@NotBlank(message="작성자를 입력하세요.")
	@Email(message="유효한 이메일 주소를 입력하세요.")
	private String writer;
	@Future(message="현재 날짜 이후 날짜로 작성하셔야 합니다.")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //바인딩처리!
	private LocalDateTime regdate; //yyyy-MM-dd HH:mm:ss
}
