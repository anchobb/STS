package com.test.app.Controller.music;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.test.app.Controller.member.MemberAllSearchController;
import com.test.app.Domain.Dto.MusicDto;
import com.test.app.Domain.Service.MusicService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MusicOpenurlController {

	private MusicService service = MusicService.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MusicOpenurlController execute!");
		
		String url = req.getParameter("url");

		// 입력값 검증

		// 서비스 실행
		List<MusicDto> list = null;
		list = service.openWebpage(url);
	    Map<String, Object> result = new HashMap<>();
	    result.put("result", list);
		
		// 뷰로 전달
	    resp.setContentType("text/html;charset=UTF-8");

        try {
            PrintWriter out = resp.getWriter();

            // 클라이언트로 새 창을 열기 위한 스크립트 전송
            out.println("<script>");
            out.println("window.open('" + url + "', '_blank');");
            out.println("</script>");
            
            // 리다이렉트 방식으로 새 창을 열기 위한 스크립트 전송 (혹은 이 방식으로도 가능)
            // out.println("<script>");
            // out.println("window.location.href = '" + url + "';");
            // out.println("</script>");

            out.flush();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
