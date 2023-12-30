package dal.Interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import transerferObjects.CatagoryTO;

public interface ICatagoryDAO {

	public void addCatagory(CatagoryTO catagoryTO) throws SQLException ;

	public List<Map<String, Object>> getAllCatagoriesList() throws SQLException ;
}
