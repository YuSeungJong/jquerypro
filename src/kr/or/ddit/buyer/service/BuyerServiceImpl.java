package kr.or.ddit.buyer.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.buyer.dao.BuyerDaoImpl;
import kr.or.ddit.buyer.dao.IBuyerDao;
import kr.or.ddit.buyer.vo.BuyerVO;
/*
	dao객체 얻어오기
	자신의 객체를 생성하고 리턴하기 - controller에서 사용하기 위함
 */
public class BuyerServiceImpl implements IBuyerService{
	private IBuyerDao dao;
	private static IBuyerService service;
	private BuyerServiceImpl() {
		dao = BuyerDaoImpl.getInstance();
	}
	 
	public static IBuyerService getInstance() {
		if(service == null) {
			service = new BuyerServiceImpl();
		}
		return service;
	}
	
	@Override
	public List<BuyerVO> getBuyerNames() {
		
		List<BuyerVO> list = null;
		
		try {
			list = dao.getBuyerNames();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public BuyerVO getDetail(String buyId) {
		BuyerVO buyVo = null;
		
		try {
			buyVo = dao.getDetail(buyId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return buyVo;
	}

}
