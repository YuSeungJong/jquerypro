package kr.or.ddit.lprod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.lprod.vo.LprodVO;

@WebServlet("/lprodController.do")
public class LprodController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0. 클라이언트 요청(전송)시 전송되는 데이터를 받는다.
		
				//1. service 객체 얻어오기
				ILprodService service = LprodServiceImpl.getInstance();
				//2. service메서드 호출 - 결과를 받는다.
				List<LprodVO> list = service.getAllLprod();
				// forward : 컨트롤러와 뷰사이가 공유가됨, redirect: 공유안됨
				//3. request객체에 결과를 저장한다.
				request.setAttribute("listvalue", list);
				//4. 결과로 출력하거나 json데이터 생성 - jsp 응답페이지
				// jsp페이지로 forward
				RequestDispatcher disp = request.getRequestDispatcher("1127/lprod.jsp");
				disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
