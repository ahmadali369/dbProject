package bll.Interfaces;

import java.util.List;
import java.util.Map;

import transerferObjects.OrderTO;

public interface IOrderBLO {

	void placeOrder(OrderTO orderTO);
	
	void changeOrderStatus(int orderId, String status); 
	List<Map<String, Object>> getOrdersBySatus(String status);
	List<Map<String, Object>> getOrdersByStatusAndCustormerId(String status, int custId);

	
	
	
	
}
