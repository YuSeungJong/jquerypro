package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/List.do")	// ajax에서 "/List.do"의 이름을 가지고 호출
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberList() {
        super();
        // TODO Auto-generated constructor stub
    }
    // request : 요청, response : 응답
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공식처럼 사용하기
		//0. 클라이언트 요청(전송)시 전송되는 데이터를 받는다.
		
		//1. service 객체 얻어오기
			IMemberService service = MemberServiceImpl.getInstance();
		//2. service메서드 호출 - 결과를 받는다.
			List<MemberVO> list = service.getAllMember();
		// forward : 컨트롤러와 뷰사이가 공유가됨, redirect: 공유안됨
		//3. request객체에 결과를 저장한다.
			request.setAttribute("listvalue", list); // "listvalue" : jsp에서 값을 받아올 이름
		//4. 결과로 출력하거나 json데이터 생성 - jsp 응답페이지
		// jsp페이지로 forward
		request.getRequestDispatcher("1127/memberList.jsp").forward(request, response); // "" 안에는 jsp이름
		
		
		
	}

}
