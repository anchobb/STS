package com.test.app.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.domain.dto.MemoDto;
import com.test.app.domain.mapper.MemoMapper;

import lombok.extern.slf4j.Slf4j;

//Service등록 2개. Bean으로 등록되어있는지 확인(root-context에서)
@Service
@Slf4j
public class MemoService {
	
	@Autowired //Service와 mapper연결을 위한 의존주입
	private MemoMapper mapper;

	//전체메모가져오기
	public List<MemoDto> getAllMemo(){
		log.info("MemoService's getAllMemo Call!");
		return mapper.selectAll();
	}
	
	//메모작성
	public int addMemo(MemoDto dto) {
		log.info("MemoService's addMemo Call!");
		return mapper.insert(dto);
	}
	
	//메모수정
	
	
	//메모삭제
	
	
}
