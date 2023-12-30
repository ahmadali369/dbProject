package dal;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dal.Interfaces.IOrderDAO;
import transerferObjects.OrderTO;

public class OrderDAO implements IOrderDAO{

	
	DBconfig dbconnection = DBconfig.getInstance();
	@Override
	public void placeOrder(OrderTO orderTO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeOrderStatus(int orderId, String status) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Map<String, Object>> getOrdersBySatus(String status) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> getOrdersByStatusAndCustormerId(String status, int custId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
