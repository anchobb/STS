package com.test.app.Controller.music;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.test.app.Controller.member.MemberAllSearchController;
import com.test.app.Domain.Dto.MemberDto;
import com.test.app.Domain.Dto.MusicDto;
import com.test.app.Domain.Service.MusicService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MusicSearchController {

	private MusicService service = MusicService.getInstance();
	private MemberDto memDto = new MemberDto();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MusicSearchController execute!");
		
		try {
			
			if(req.getMethod().equals("GET")) {
			req.getRequestDispatcher("/WEB-INF/view/musicsearchpage.jsp").forward(req, resp);
			
			}
		
			resp.setContentType("application/json;charset=UTF-8");
		
		// �Ķ���� ����
		String searchText = req.getParameter("searchText");
		String memberId =(String) req.getSession().getAttribute("ID");
		System.out.println("searchText : " + searchText);
		System.out.println("MusicSearchController MEMBER ID : " + memberId);
		
		// �Է°� ����

		// ���� ����

		List<MusicDto> list = service.searchTracks(searchText, memberId);
		
		
		PrintWriter out = resp.getWriter();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonConverted = objectMapper.writeValueAsString(list);
		
		// ��� ����
//		resp.setContentType("application/json");
		out.print(jsonConverted);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		
	}
}