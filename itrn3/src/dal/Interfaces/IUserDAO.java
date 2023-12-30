package dal.Interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import transerferObjects.ActivityTO;
import transerferObjects.UserTO;

public interface IUserDAO {


	
	boolean addNewUser(UserTO userNewTO)throws SQLException;
	boolean loginUser(UserTO userOldTO)throws SQLException; 
	void storeUserActivity(ActivityTO activityTO)throws SQLException; 
	List<Map<String, Object>> getAllUsers()throws SQLException; 
	void deleteUser(int id)throws SQLException; 
	
}
