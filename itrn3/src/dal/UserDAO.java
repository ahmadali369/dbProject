package dal;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dal.Interfaces.IUserDAO;
import transerferObjects.ActivityTO;
import transerferObjects.UserTO;

public class UserDAO implements IUserDAO{

	DBconfig dbconnection = DBconfig.getInstance();
	
	@Override
	public boolean addNewUser(UserTO userNewTO) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean loginUser(UserTO userOldTO) throws SQLException {
		// TODO Auto-generated method stub
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
