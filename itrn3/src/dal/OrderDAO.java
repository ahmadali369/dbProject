package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dal.Interfaces.IOrderDAO;
import transerferObjects.OrderTO;
import transerferObjects.ProductTO;

public class OrderDAO implements IOrderDAO {

	DBconfig dbconnection = DBconfig.getInstance();

	@Override
	public void placeOrder(OrderTO orderTO) throws SQLException {
		long orderId = -1;
		try (Connection connection = dbconnection.getConnection()) {
			String insertOrderSQL = "INSERT INTO Orderr (UserID, Status, shipAddress) VALUES (?, ?, ?)";

			try (PreparedStatement preparedStatement = connection.prepareStatement(insertOrderSQL,
					Statement.RETURN_GENERATED_KEYS)) {
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

			for (ProductTO productTO : orderTO.getProductList()) {
				System.out.println("product id---" + productTO.getProductid());

				String insertOrderDetailSQL = "INSERT INTO OrderDetail (OrderID, ProductID, Quantity) VALUES (?, ?, ?)";

				try (PreparedStatement preparedStatement = connection.prepareStatement(insertOrderDetailSQL)) {
					preparedStatement.setInt(1, (int) id);
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

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

//	@Override
//	public void changeOrderStatus(int orderId, String status) throws SQLException {
//		// TODO Auto-generated method stub
//
//		
//		
//		
//	}

	@Override
	public void changeOrderStatus(int orderId, String status) throws SQLException {

		String updateOrderStatusSQL = "UPDATE Orderr SET Status = ? WHERE OrderID = ?";

		try (Connection connection = dbconnection.getConnection()) {
			try (PreparedStatement preparedStatement = connection.prepareStatement(updateOrderStatusSQL)) {

				preparedStatement.setString(1, status);
				preparedStatement.setInt(2, orderId);

				preparedStatement.executeUpdate();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public List<Map<String, Object>> getOrdersBySatus(String status) throws SQLException {
		List<Map<String, Object>> orders = new ArrayList<>();

		try (Connection connection = dbconnection.getConnection()) {

			String selectOrdersSQL = "SELECT * FROM Orderr WHERE Status = ?";

			try (PreparedStatement preparedStatement = connection.prepareStatement(selectOrdersSQL)) {

				preparedStatement.setString(1, status);

				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					while (resultSet.next()) {
						Map<String, Object> order = new HashMap<>();
						order.put("orderId", resultSet.getInt("OrderID"));
						order.put("userid", resultSet.getInt("UserID"));
						order.put("date", resultSet.getString("OrderDate"));
						order.put("status", resultSet.getString("Status"));
						order.put("address", resultSet.getString("shipAddress"));

						orders.add(order);
					}
				}
			}
		}

		return orders;
	}

//	@Override
//	public List<Map<String, Object>> getOrdersBySatus(String status) throws SQLException {
//		
//		List<Map<String, Object>> orders = new ArrayList<>();
//
//		try (Connection connection = dbconnection.getConnection()) {
//			String selectAllProductsSQL = "SELECT * FROM Orderr";  
//
//			try (PreparedStatement preparedStatement = connection.prepareStatement(selectAllProductsSQL)) {
//				try (ResultSet resultSet = preparedStatement.executeQuery()) {
//					while (resultSet.next()) {
//						Map<String, Object> order = new HashMap<>();
//
////						int productId = resultSet.getInt("ProductID");
//						order.put("orderId", resultSet.getInt("OrderID"));
//						order.put("userid", resultSet.getInt("UserID"));
//						order.put("date", resultSet.getString("OrderDate"));
//						order.put("status", resultSet.getString("Status"));
//						order.put("address", resultSet.getString("shipAddress"));
//
//
//						orders.add(order);
//					}
//				}
//			}
//		}
//
//		return orders;
//	
//	}

	@Override
	public List<Map<String, Object>> getOrdersByStatusAndCustormerId(String status, int userId) throws SQLException {
		List<Map<String, Object>> orders = new ArrayList<>();

		try (Connection connection = dbconnection.getConnection()) {

			String selectOrdersSQL = "SELECT * FROM Orderr WHERE Status = ? AND UserID = ?";

			try (PreparedStatement preparedStatement = connection.prepareStatement(selectOrdersSQL)) {

				preparedStatement.setString(1, status);
				preparedStatement.setInt(2, userId);

				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					while (resultSet.next()) {
						Map<String, Object> order = new HashMap<>();
						order.put("orderId", resultSet.getInt("OrderID"));
						order.put("userid", resultSet.getInt("UserID"));
						order.put("date", resultSet.getString("OrderDate"));
						order.put("status", resultSet.getString("Status"));
						order.put("address", resultSet.getString("shipAddress"));

						orders.add(order);
					}
				}
			}
		}

		return orders;
	}

//	@Override
//	public List<Map<String, Object>> getOrdersByStatusAndCustormerId(String status, int custId) throws SQLException {
//		// TODO Auto-generated method stub
//		
//		
//		List<Map<String, Object>> orders = new ArrayList<>();
//
//		try (Connection connection = dbconnection.getConnection()) {
//			String selectAllProductsSQL = "SELECT * FROM Orderr";  
//
//			try (PreparedStatement preparedStatement = connection.prepareStatement(selectAllProductsSQL)) {
//				try (ResultSet resultSet = preparedStatement.executeQuery()) {
//					while (resultSet.next()) {
//						Map<String, Object> order = new HashMap<>();
//
////						int productId = resultSet.getInt("ProductID");
//						order.put("orderId", resultSet.getInt("OrderID"));
//						order.put("userid", resultSet.getInt("UserID"));
//						order.put("date", resultSet.getString("OrderDate"));
//						order.put("status", resultSet.getString("Status"));
//						order.put("address", resultSet.getString("shipAddress"));
//
//
//						orders.add(order);
//					}
//				}
//			}
//		}
//
//		return orders;
//		
//		
//	}

}
