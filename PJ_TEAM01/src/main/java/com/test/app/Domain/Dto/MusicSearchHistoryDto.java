package com.test.app.Domain.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MusicSearchHistoryDto {
	private int historyNo;
	private String ID;
	private String searchHistory;
		
}