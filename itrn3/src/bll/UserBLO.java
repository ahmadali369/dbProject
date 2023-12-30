package bll;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import bll.Interfaces.IUserBLO;
import dal.Interfaces.IDalFacade;
import transerferObjects.ActivityTO;
//import transerferObjects.UserNewTO;
import transerferObjects.UserTO;

public class UserBLO implements IUserBLO {

	IDalFacade dalFacade;

	public UserBLO(IDalFacade dalFacade) {
		this.dalFacade = dalFacade;

	}

	@Override
	public boolean addNewUser(UserTO userNewTO) {
		// TODO Auto-generated method stub
		try {
			return dalFacade.addNewUser(userNewTO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean loginUser(UserTO userOldTO) {
		// TODO Auto-generated method stub
		try {
			return dalFacade.loginUser(userOldTO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void storeUserActivity(ActivityTO activityTO) {
		// TODO Auto-generated method stub
		try {
			dalFacade.storeUserActivity(activityTO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Map<String, Object>> getAllUsers() {
		// TODO Auto-generated method stub
		try {
			dalFacade.getAllUsers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		try {
			dalFacade.deleteUser(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
