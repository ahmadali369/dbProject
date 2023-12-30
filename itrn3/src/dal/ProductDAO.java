package dal;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;

import dal.Interfaces.IProductDAO;
//import dal.classes.DBconfig;
import transerferObjects.ProductTO;

public class ProductDAO implements IProductDAO {

	DBconfig dbconnection = DBconfig.getInstance();

//    String insertProductSQL = "INSERT INTO Product (Name, Description, Price, Quantity, CategoryID, Cost, ImagePath) VALUES (?, ?, ?, ?, ?, ?, ?)";

	@Override
	public void addProdcut(ProductTO productTO) throws SQLException {
		// TODO Auto-generated method stub

		int imgid = storeImage(productTO.getImgPathString());

		Connection connection = null;
		try {
			connection = dbconnection.getConnection();
			connection.setAutoCommit(false);

			String insertProductSQL = "INSERT INTO Product (Name, Description, Price, Quantity, CategoryID, Cost, ImageID) VALUES (?, ?, ?, ?, ?, ?, ?)";

			try (PreparedStatement preparedStatement = connection.prepareStatement(insertProductSQL,
					Statement.RETURN_GENERATED_KEYS)) {
				preparedStatement.setString(1, productTO.getName());
				preparedStatement.setString(2, productTO.getDiscription());
				preparedStatement.setDouble(3, productTO.getPriceDouble());
				preparedStatement.setInt(4, productTO.getQuantity());
				preparedStatement.setString(5, productTO.getCatagory());
				preparedStatement.setDouble(6, productTO.getCost());
				preparedStatement.setInt(7, imgid);

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

	private int storeImage(String path) {

		Connection connection = null;
		try {

			connection = dbconnection.getConnection();
			connection.setAutoCommit(false);
			// Read the image file into a byte array
			File imageFile = new File(path);
			FileInputStream fis = new FileInputStream(imageFile);
			byte[] imageData = new byte[(int) imageFile.length()];
			fis.read(imageData);
			fis.close();

			// Insert the image data into the database
			String query = "INSERT INTO images (image_data) VALUES (?)";
			PreparedStatement preparedStatement2 = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStatement2.setBytes(1, imageData);
			int affectedRows = preparedStatement2.executeUpdate();

			connection.commit();

			if (affectedRows > 0) {
				// Retrieve the generated keys
				ResultSet generatedKeys = preparedStatement2.getGeneratedKeys();

				if (generatedKeys.next()) {
					// Retrieve the generated key (assuming it's an auto-incremented primary key)
					Long generatedKey = generatedKeys.getLong(1);
					return Integer.parseInt(generatedKey.toString());

//			        System.out.println("Generated Key: " + generatedKey);
				} else {
					System.out.println("No generated keys were found.");
				}
			} else {
				System.out.println("Insertion failed, no rows affected.");
			}

			// Close the resources
			preparedStatement2.close();

			connection.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return -1;
	}

	@Override
	public List<Map<String, Object>> getAllProduct() throws SQLException {
		List<Map<String, Object>> products = new ArrayList<>();

		try (Connection connection = dbconnection.getConnection()) {
			String selectAllProductsSQL = "SELECT * FROM Product";

			try (PreparedStatement preparedStatement = connection.prepareStatement(selectAllProductsSQL)) {
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					while (resultSet.next()) {
						Map<String, Object> product = new HashMap<>();

						int productId = resultSet.getInt("ProductID");
						product.put("productId", productId);
						product.put("name", resultSet.getString("Name"));
						product.put("description", resultSet.getString("Description"));
						product.put("price", resultSet.getBigDecimal("Price"));
						product.put("quantity", resultSet.getInt("Quantity"));
						product.put("categoryId", resultSet.getInt("CategoryID"));
						product.put("imageId", resultSet.getInt("ImageID"));
						product.put("cost", resultSet.getBigDecimal("Cost"));

						product.put("imagePath", resultSet.getString("ImagePath"));
						
						
						
						product.put("imgBytes", getImgBytes(productId));
						
						

						products.add(product);
					}
				}
			}
		}

		return products;
	}

	private byte[] getImgBytes(int id) {
		try (Connection connection = dbconnection.getConnection()) {

			String query = "SELECT image_data FROM images WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
//                byte[] imageData = resultSet.getBytes("image_data");
				return resultSet.getBytes("image_data");

			}

			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

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
