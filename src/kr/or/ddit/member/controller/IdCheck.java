package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

@WebServlet("/IdCheck")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public IdCheck() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0. 클라이언트 전송시 데이터 받기 - 입력한 id
		String inputId = request.getParameter("id");
		//1. service객체 얻기
		IMemberService service = MemberServiceImpl.getInstance();
		//2. service메서드 호출 - 결과값얻기
		String resId = service.selectById(inputId);
		//3. 결과값 request에 저장
		request.setAttribute("resId", resId);
		//4. jsp로 forward
		request.getRequestDispatcher("1130/idCheck.jsp").forward(request, response);
	}

}
