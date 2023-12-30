package bll.Interfaces;

import transerferObjects.UserNewTO;
import transerferObjects.UserOldTO;

public interface IUserBLO {

	void addNewUser(UserNewTO userNewTO);
	void loginUser(UserOldTO userOldTO); 
	
}
