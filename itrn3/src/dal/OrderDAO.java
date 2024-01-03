package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import dal.Interfaces.IOrderDAO;
import transerferObjects.OrderTO;

public class OrderDAO implements IOrderDAO{

	
	DBconfig dbconnection = DBconfig.getInstance();
//	@Override
//	public void placeOrder(OrderTO orderTO) throws SQLException {
//		// TODO Auto-generated method stub
//		try (Connection connection = dbconnection.getConnection()) {
//		String insertOrderSQL = "INSERT INTO `Order` (UserID, Status, shipAddress) VALUES (?, ?, ?)";
//		
//	     try (PreparedStatement preparedStatement = connection.prepareStatement(insertOrderSQL)) {
//	            preparedStatement.setInt(1, orderTO.getCustomerID());
//	            preparedStatement.setString(2, orderTO.getStatus());
//	            preparedStatement.setString(3, orderTO.getShippingAddress());
//
//	            int rowsAffected = preparedStatement.executeUpdate();
//
//	            if (rowsAffected > 0) {
//	                System.out.println("Order data inserted successfully.");
//	            } else {
//	                System.out.println("Failed to insert order data.");
//	            }
//	        }
//		}
//		
//	}
	
	@Override
	public void placeOrder(OrderTO orderTO) throws SQLException {
	    try (Connection connection = dbconnection.getConnection()) {
	        String insertOrderSQL = "INSERT INTO `Order` (UserID, Status, shipAddress) VALUES (?, ?, ?)";

	        try (PreparedStatement preparedStatement = connection.prepareStatement(insertOrderSQL, Statement.RETURN_GENERATED_KEYS)) {
	            preparedStatement.setInt(1, orderTO.getCustomerID());
	            preparedStatement.setString(2, orderTO.getStatus());
	            preparedStatement.setString(3, orderTO.getShippingAddress());

	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                // Retrieve the generated key(s)
	                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
	                    if (generatedKeys.next()) {
	                        long orderId = generatedKeys.getLong(1);
	                        System.out.println("Order data inserted successfully. Generated key: " + orderId);
	                        // You can store or use the generated key as needed
	                    } else {
	                        System.out.println("Failed to retrieve generated key for the order.");
	                    }
	                }
	            } else {
	                System.out.println("Failed to insert order data.");
	            }
	        }
	    }
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
