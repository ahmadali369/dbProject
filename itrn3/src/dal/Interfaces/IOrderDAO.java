package dal.Interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import transerferObjects.OrderTO;

public interface IOrderDAO {

	
	void placeOrder(OrderTO orderTO)throws SQLException;
	
	void changeOrderStatus(int orderId, String status)throws SQLException;
	List<Map<String, Object>> getOrdersBySatus(String status)throws SQLException;
	List<Map<String, Object>> getOrdersByStatusAndCustormerId(String status, int custId)throws SQLException;
}
