package kr.or.ddit.buyer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.buyer.service.IBuyerService;
import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;


@WebServlet("/Buyer.do")
public class BuyerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BuyerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전체 이름 가져오기
		// 공식처럼 사용하기
		//0. 클라이언트 요청(전송)시 전송되는 데이터를 받는다.
				
		//1. service 객체 얻어오기
		IBuyerService service = BuyerServiceImpl.getInstance();
		//2. service메서드 호출 - 결과를 받는다.
		List<BuyerVO> list = service.getBuyerNames();
		// forward : 컨트롤러와 뷰사이가 공유가됨, redirect: 공유안됨
		//3. request객체에 결과를 저장한다.
		request.setAttribute("listvalue", list);
		//4. 결과로 출력하거나 json데이터 생성 - jsp 응답페이지
		// jsp페이지로 forward
		RequestDispatcher disp = request.getRequestDispatcher("1127/buyerNames.jsp");
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// id를 조건으로 해서 조회하기
		
		//0. 클라이언트 요청(전송)시 전송되는 데이터를 받는다. - id
		String buyerId = request.getParameter("id");
		//1. service 객체 얻어오기
		IBuyerService service = BuyerServiceImpl.getInstance();
		//2. service메서드 호출 - 결과를 받는다.
		BuyerVO vo = service.getDetail(buyerId);
		// forward : 컨트롤러와 뷰사이가 공유가됨, redirect: 공유안됨
		//3. request객체에 결과를 저장한다.
		request.setAttribute("vo", vo);
		//4. 결과로 출력하거나 json데이터 생성 - jsp 응답페이지
		// jsp페이지로 forward
		request.getRequestDispatcher("1127/buyerDetail.jsp").forward(request, response);
	}

}
