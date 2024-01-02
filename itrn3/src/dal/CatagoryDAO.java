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

import dal.Interfaces.ICatagoryDAO;
import transerferObjects.CatagoryTO;

public class CatagoryDAO implements ICatagoryDAO{
	DBconfig dbconnection = DBconfig.getInstance();

	@Override
	public void addCatagory(CatagoryTO catagoryTO) throws SQLException  {
		// TODO Auto-generated method stub

		Connection connection = null;
		try {
			connection = dbconnection.getConnection();
			connection.setAutoCommit(false);

			String insertProductSQL = "INSERT INTO Category (CategoryName) VALUES (?)";

			try (PreparedStatement preparedStatement = connection.prepareStatement(insertProductSQL,
					Statement.RETURN_GENERATED_KEYS)) {
				preparedStatement.setString(1, catagoryTO.getCatagory());

				preparedStatement.executeUpdate();
				connection.commit();

//				preparedStatement.setString(7, productTO.getImgString());

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
	public List<Map<String, Object>> getAllCatagoriesList()  throws SQLException {
		List<Map<String, Object>> catagories = new ArrayList<>();

		try (Connection connection = dbconnection.getConnection()) {
			
			
			String selectAllProductsSQL = "SELECT * FROM Category";

			try (PreparedStatement preparedStatement = connection.prepareStatement(selectAllProductsSQL)) {
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					
					while (resultSet.next()) {
						Map<String, Object> catagory = new HashMap<>();

						int productId = resultSet.getInt("CategoryID");
						catagory.put("catId", productId);
						catagory.put("name", resultSet.getString("CategoryName"));


						catagories.add(catagory);
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return catagories;
	}

}
