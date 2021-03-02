package kr.or.ddit.lprod.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.buyer.dao.BuyerDaoImpl;
import kr.or.ddit.buyer.dao.IBuyerDao;
import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.buyer.service.IBuyerService;
import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.vo.LprodVO;

public class LprodServiceImpl implements ILprodService{
	
	private ILprodDao dao;
	private static ILprodService service;
	private LprodServiceImpl() {
		dao = LprodDaoImpl.getInstance();
	}
	 
	public static ILprodService getInstance() {
		if(service == null) {
			service = new LprodServiceImpl();
		}
		return service;
	}
	
	
	@Override
	public List<LprodVO> getAllLprod() {
		List<LprodVO> list = null;

		try {
			list = dao.getAllLprod();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
