package bll.Interfaces;

import java.util.List;
import java.util.Map;

import transerferObjects.ActivityTO;
//import transerferObjects.UserNewTO;
import transerferObjects.UserTO;

public interface IUserBLO {

	public int getUserid(); 
	boolean addNewUser(UserTO userNewTO);
	boolean loginUser(UserTO userOldTO); 
	void storeUserActivity(ActivityTO activityTO); 
	List<Map<String, Object>> getAllUsers(); 
	void deleteUser(int id); 
	
	
	
}
