package bll;

import java.util.List;
import java.util.Map;

import transerferObjects.CatagoryTO;
//import transerferObjects.ProductTO;

public interface ICatagoryBLO {

	public void addCatagory(CatagoryTO catagoryTO);

	public List<Map<String, Object>> getAllCatagoriesList();
}
