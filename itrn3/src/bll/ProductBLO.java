package bll;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import bll.Interfaces.IProductBLO;
import dal.Interfaces.IDalFacade;
import transerferObjects.ProductTO;

public class ProductBLO implements IProductBLO{

	IDalFacade dalFacade; 
	
	public ProductBLO(IDalFacade dalFacade) {
		this.dalFacade = dalFacade; 
		
	}
	
	
	@Override
	public void addProduct(ProductTO productTO) {
		// TODO Auto-generated method stub
		try {
			dalFacade.addProdcut(productTO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Map<String, Object>> getAllProdcuts() {
		// TODO Auto-generated method stub
		try {
			return dalFacade.getAllProduct();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}

	@Override
	public void updateProdcut(ProductTO productTO) {
		// TODO Auto-generated method stub
		try {
			dalFacade.updateProduct(productTO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteProduct(ProductTO productTO) {
		// TODO Auto-generated method stub
		try {
			dalFacade.deleteProduct(productTO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Map<String, Object>> getAllProdcutsByCatagory() {
		// TODO Auto-generated method stub
		try {
			return dalFacade.getAllProdcutsByCatagory();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}


}
