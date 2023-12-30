package dal.Interfaces;

import java.util.List;
import java.util.Map;

import transerferObjects.CatagoryTO;

public interface ICatagoryDAO {

	public void addCatagory(CatagoryTO catagoryTO);

	public List<Map<String, Object>> getAllCatagoriesList();
}
