package dal;

import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

public class DBconfig {
	Properties properties;
	String DB_URL;
	String DB_USER;
	String DB_NAME;
	String DB_PASSWORD = "";
//    String DB_PASSWORD = properties.getProperty("db.password");
	
//	private static final Logger logger = LogManager.getLogger(DBconfig.class);

	private DBconfig() {
		
		properties = new Properties();
		try (FileInputStream input = new FileInputStream("config.properties")) {
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}

		DB_URL = properties.getProperty("db.server.address");
		DB_USER = properties.getProperty("db.username");
		DB_NAME = properties.getProperty("db.dbname");

		createDatabaseAndTableIfNotExists();
	}

	private static DBconfig obj;

	public static DBconfig getInstance() {
		if (obj == null)
			obj = new DBconfig();
		return obj;
	}

	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		return connection;
	}

	public boolean doesDatabaseExist() {
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {

			ResultSet resultSet = statement.executeQuery("SHOW DATABASES LIKE '" + DB_NAME + "'");
			return resultSet.next();
		} catch (SQLException e) {
//			e.printStackTrace();
//			logger.debug("DB Auto Created.");
			System.out.println("DB Auto Created.");
			return false;
		}
	}

	public void createDatabaseAndTableIfNotExists() {
		if (!doesDatabaseExist()) {

			try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", DB_USER,
					DB_PASSWORD); Statement statement = connection.createStatement()) {

				String createDatabaseSQL = "CREATE DATABASE " + DB_NAME;
				statement.executeUpdate(createDatabaseSQL);
			} catch (SQLException e) {
//				logger.debug("createDatabaseAndTableIfNotExists func triggerd an exception");
				e.printStackTrace();
			}
		}

		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {

			String useDatabaseSQL = "USE " + DB_NAME;
			statement.executeUpdate(useDatabaseSQL);

            String createImagesTableSQL = "CREATE TABLE IF NOT EXISTS images (" +
            	    "id INT AUTO_INCREMENT PRIMARY KEY," +
            	    "image_data LONGBLOB" +

            	    ")";

            	statement.executeUpdate(createImagesTableSQL);

/////==== cat
                String createCategoryTableSQL = "CREATE TABLE IF NOT EXISTS Category (" +
                        "CategoryID INT AUTO_INCREMENT PRIMARY KEY," +
                        "CategoryName VARCHAR(255) NOT NULL UNIQUE" +
                        ")";

                statement.executeUpdate(createCategoryTableSQL);
                
                String[] dummyCategories = {"Electronics", "Clothing", "Books", "Home and Garden"};
                String insertCategorySQL = "INSERT INTO Category (CategoryName) VALUES (?)";
//                String insertCategorySQL = "INSERT INTO Category (CategoryName) SELECT ? FROM dual WHERE NOT EXISTS (SELECT * FROM Category WHERE CategoryName = ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertCategorySQL)) {
                    for (String categoryName : dummyCategories) {
                        preparedStatement.setString(1, categoryName);

                        int rowsAffected = preparedStatement.executeUpdate();

                    }
                }catch (Exception e) {
					// TODO: handle exception
				}
   /// cat ====             
                
            	
            	
            String createProductTableSQL = "CREATE TABLE IF NOT EXISTS Product (" +
                    "ProductID INT AUTO_INCREMENT PRIMARY KEY," +
                    "Name VARCHAR(255)," +
                    "Description VARCHAR(255)," +
                    "Price DECIMAL(10, 2)," +
                    "Quantity INT NOT NULL," +
                    "CategoryID INT," +
                    "ImageID INT," +
                    "Cost DECIMAL(10, 2) NOT NULL," +
                    "ImagePath VARCHAR(255)," +
                    "FOREIGN KEY (ImageID) REFERENCES images(id)" +
                    ")";

            statement.executeUpdate(createProductTableSQL);
            
            String createUserTableSQL = "CREATE TABLE IF NOT EXISTS User (" +
                    "UserID INT AUTO_INCREMENT PRIMARY KEY," +
                    "FirstName VARCHAR(255) NOT NULL," +
                    "LastName VARCHAR(255) NOT NULL," +
                    "EmailAddress VARCHAR(255) NOT NULL UNIQUE," +
                    "Password VARCHAR(255) NOT NULL," +
                    "HomeAddress VARCHAR(255)" +
                    ")";
            
            statement.executeUpdate(createUserTableSQL);
            
            
            String createOrderTableSQL = "CREATE TABLE IF NOT EXISTS `Order` (" +
                    "OrderID INT AUTO_INCREMENT PRIMARY KEY," +
                    "UserID INT," +
                    "OrderDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                    "Status VARCHAR(50) NOT NULL," +
                    "shipAddress varchar(255)," +
                    "FOREIGN KEY (UserID) REFERENCES User(UserID)" +
                    ")";
            statement.executeUpdate(createOrderTableSQL);



            String createOrderDetailTableSQL = "CREATE TABLE IF NOT EXISTS OrderDetail (" +
                    "OrderDetailID INT AUTO_INCREMENT PRIMARY KEY," +
                    "OrderID INT," +
                    "ProductID INT," +
                    "Quantity INT NOT NULL," +
                    "FOREIGN KEY (OrderID) REFERENCES `Order`(OrderID)," +
                    "FOREIGN KEY (ProductID) REFERENCES Product(ProductID)" +
                    ")";
            statement.executeUpdate(createOrderDetailTableSQL);
            
            String createUserActivityLogTableSQL = "CREATE TABLE IF NOT EXISTS UserActivityLog (" +
                    "LogID INT AUTO_INCREMENT PRIMARY KEY," +
                    "UserID INT," +
                    "ActivityType VARCHAR(50) NOT NULL," +
                    "Timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                    "FOREIGN KEY (UserID) REFERENCES User(UserID)" +
                    ")";
            statement.executeUpdate(createUserActivityLogTableSQL);
            
		

		} catch (SQLException e) {
//			logger.debug("createDatabaseAndTableIfNotExists func triggerd an exception");
			e.printStackTrace();
		}

	}

	public static void close(Connection connection, PreparedStatement preparedStatement) {
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
//			 logger.debug("close func triggerd an exception");

			e.printStackTrace();
		}
	}

}






