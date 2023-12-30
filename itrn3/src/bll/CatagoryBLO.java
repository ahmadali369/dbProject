package bll;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import bll.Interfaces.ICatagoryBLO;
import dal.Interfaces.IDalFacade;
import transerferObjects.CatagoryTO;
//import transerferObjects.ProductTO;

public class CatagoryBLO implements ICatagoryBLO{

	
	IDalFacade dalFacade; 
	
	public CatagoryBLO(IDalFacade dalFacade) {
		this.dalFacade = dalFacade; 
		
	}
	


	@Override
	public List<Map<String, Object>> getAllCatagoriesList() {
		// TODO Auto-generated method stub
		try {
			return dalFacade.getAllCatagoriesList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null; 
		
	}

	@Override
	public void addCatagory(CatagoryTO catagoryTO) {
		// TODO Auto-generated method stub
		try {
			dalFacade.addCatagory(catagoryTO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
