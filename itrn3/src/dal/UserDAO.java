package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import dal.Interfaces.IUserDAO;
import transerferObjects.ActivityTO;
import transerferObjects.UserTO;

public class UserDAO implements IUserDAO{

	DBconfig dbconnection = DBconfig.getInstance();
	
	int userid = -1; 
	
	public int getUserid() {
		return userid;
	}

	
	@Override
	public boolean loginUser(UserTO userOldTO) throws SQLException {
		// TODO Auto-generated method stub
		DBconfig dbconnection = DBconfig.getInstance();
        try (Connection connection = dbconnection.getConnection()) {
            String loginQuery = "SELECT UserID FROM User WHERE EmailAddress = ? AND Password = ?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(loginQuery)) {
                preparedStatement.setString(1, userOldTO.getEmail());
                preparedStatement.setString(2, userOldTO.getPassword());

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int userID = resultSet.getInt("UserID");
                        userid = userID; 
//                        System.out.println("Login successful. UserID: " + userID);
                    } else {
//                        System.out.println("Invalid email address or password.");
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		
		return false;
	}
	
	
	@Override
	public boolean addNewUser(UserTO userNewTO) throws SQLException {
	    Connection connection = null;
	    try {
	        connection = dbconnection.getConnection();
	        connection.setAutoCommit(false);

	        String insertUserSQL = "INSERT INTO User (FirstName, LastName, EmailAddress, Password, HomeAddress) VALUES (?, ?, ?, ?, ?)";

	        try (PreparedStatement preparedStatement = connection.prepareStatement(insertUserSQL, Statement.RETURN_GENERATED_KEYS)) {
	            preparedStatement.setString(1, userNewTO.getFname());
	            preparedStatement.setString(2, userNewTO.getLname());
	            preparedStatement.setString(3, userNewTO.getEmail());
	            preparedStatement.setString(4, userNewTO.getPassword());
	            preparedStatement.setString(5, userNewTO.getAddress());

	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
	                    if (generatedKeys.next()) {
	                        int userID = generatedKeys.getInt(1);
	                        userid = userID;
	                    }
	                }
	                connection.commit();
	                return true;
	            } else {
	                // Handle the case where no rows were affected (insertion failed)
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();

	        if (connection != null) {
	            connection.rollback();
	        }
	    } finally {
	        if (connection != null) {
	            connection.close();
	        }
	    }
	    return false;
	}



	@Override
	public void storeUserActivity(ActivityTO activityTO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Map<String, Object>> getAllUsers() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}



}
