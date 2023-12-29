package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

//import dal.classes.DBconfig;
import transerferObjects.ProductTO;

public class ProductDAO implements IProductDAO{

	
	DBconfig dbconnection = DBconfig.getInstance();
	
//    String insertProductSQL = "INSERT INTO Product (Name, Description, Price, Quantity, CategoryID, Cost, ImagePath) VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	@Override
	public void addProdcut(ProductTO productTO) throws SQLException {
		// TODO Auto-generated method stub
		
		
		Connection connection = null;
		try {
			connection = dbconnection.getConnection();
			connection.setAutoCommit(false);

		    String insertProductSQL = "INSERT INTO Product (Name, Description, Price, Quantity, CategoryID, Cost, ImagePath) VALUES (?, ?, ?, ?, ?, ?, ?)";
			
		    
		    try (PreparedStatement preparedStatement = connection.prepareStatement(insertProductSQL,
					Statement.RETURN_GENERATED_KEYS)) {
				preparedStatement.setString(1, productTO.getName());
				preparedStatement.setString(2, productTO.getDiscription());
				preparedStatement.setDouble(3, productTO.getPriceDouble());
				preparedStatement.setInt(4, productTO.getQuantity());
				preparedStatement.setString(5, productTO.getCatagory());
				preparedStatement.setDouble(6, productTO.getCost());
				preparedStatement.setString(7, productTO.getImgString());
				preparedStatement.executeUpdate();

				connection.commit();
			}
		} catch (SQLException e) {

			e.printStackTrace();
			
//			logger.debug("InsetBook Func thrown an Exception");

			if (connection != null) {
				connection.rollback();
			}

			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
		
		
	}

	@Override
	public List<Map<String, Object>> getAllProduct() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProduct(ProductTO productTO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(ProductTO productTO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Map<String, Object>> getAllProdcutsByCatagory() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}





}
