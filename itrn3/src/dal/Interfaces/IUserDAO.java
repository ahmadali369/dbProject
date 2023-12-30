package dal.Interfaces;

import java.sql.SQLException;

import transerferObjects.UserNewTO;
import transerferObjects.UserOldTO;

public interface IUserDAO {

	void addNewUser(UserNewTO userNewTO) throws SQLException;

	void loginUser(UserOldTO userOldTO) throws SQLException;
}
