package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import dal.Interfaces.IOrderDAO;
import transerferObjects.OrderTO;
import transerferObjects.ProductTO;

public class OrderDAO implements IOrderDAO{

	
	DBconfig dbconnection = DBconfig.getInstance();

	
	@Override
	public void placeOrder(OrderTO orderTO) throws SQLException {
		long orderId = -1; 
	    try (Connection connection = dbconnection.getConnection()) {
	        String insertOrderSQL = "INSERT INTO `Order` (UserID, Status, shipAddress) VALUES (?, ?, ?)";

	        try (PreparedStatement preparedStatement = connection.prepareStatement(insertOrderSQL, Statement.RETURN_GENERATED_KEYS)) {
	            preparedStatement.setInt(1, orderTO.getCustomerID());
	            preparedStatement.setString(2, orderTO.getStatus());
	            preparedStatement.setString(3, orderTO.getShippingAddress());

	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	            
	                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
	                    if (generatedKeys.next()) {
	                        orderId = generatedKeys.getLong(1);
//	                        System.out.println("Order data inserted successfully. Generated key: " + orderId);
	                        
	                    } else {
//	                        System.out.println("Failed to retrieve generated key for the order.");
	                    }
	                }
	            } else {
//	                System.out.println("Failed to insert order data.");
	            }
	        }
	        
	        try {
	        	addProductDetails(orderTO, orderId); 
			} catch (Exception e) {
				// TODO: handle exception
			}
	               
	        
	        
	    }
	}

	private void addProductDetails(OrderTO orderTO, long id) {
		
		
		try (Connection connection = dbconnection.getConnection()) {
			
			for(ProductTO productTO : orderTO.getProductList()) {
				System.out.println("product id---" + productTO.getProductid());
				
				
		        String insertOrderDetailSQL = "INSERT INTO OrderDetail (OrderID, ProductID, Quantity) VALUES (?, ?, ?)";


		        try (PreparedStatement preparedStatement = connection.prepareStatement(insertOrderDetailSQL)) {
		            preparedStatement.setInt(1, (int)id);
		            preparedStatement.setInt(2, productTO.getProductid());
		            preparedStatement.setInt(3, 1);

		            int rowsAffected = preparedStatement.executeUpdate();

//		            if (rowsAffected > 0) {
//		                System.out.println("OrderDetail data inserted successfully.");
//		            } else {
//		                System.out.println("Failed to insert order detail data.");
//		            }
		        }
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
