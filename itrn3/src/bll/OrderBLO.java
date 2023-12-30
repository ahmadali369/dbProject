package bll;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import bll.Interfaces.IOrderBLO;
import dal.Interfaces.IDalFacade;
import transerferObjects.OrderTO;

public class OrderBLO implements IOrderBLO{

	
	
	IDalFacade dalFacade; 
	
	public OrderBLO(IDalFacade dalFacade) {
		this.dalFacade = dalFacade; 
		
	}
	
	@Override
	public void placeOrder(OrderTO orderTO) {
		// TODO Auto-generated method stub
		try {
			dalFacade.placeOrder(orderTO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void changeOrderStatus(int orderId, String status) {
		// TODO Auto-generated method stub
		
		try {
			dalFacade.changeOrderStatus(orderId, status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Map<String, Object>> getOrdersBySatus(String status) {
		// TODO Auto-generated method stub
		try {
			return dalFacade.getOrdersBySatus(status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}

	@Override
	public List<Map<String, Object>> getOrdersByStatusAndCustormerId(String status, int custId) {
		// TODO Auto-generated method stub
		try {
			return dalFacade.getOrdersByStatusAndCustormerId(status, custId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}

}
