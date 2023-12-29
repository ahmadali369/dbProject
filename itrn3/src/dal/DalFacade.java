package dal;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import ParameterObjects.DalPO;
import transerferObjects.ProductTO;

public class DalFacade implements IDalFacade{

	
	DalPO dalPO; 
	
	public DalFacade(DalPO dalPO) {
		this.dalPO = dalPO; 
		
		
	}
	
	
	@Override
	public void addProdcut(ProductTO productTO) throws SQLException {
		// TODO Auto-generated method stub
		dalPO.getProductDAO().addProdcut(productTO);
		
	}

	@Override
	public List<Map<String, Object>> getAllProduct() throws SQLException {
		// TODO Auto-generated method stub
		return dalPO.getProductDAO().getAllProduct();
	}

	@Override
	public List<Map<String, Object>> getAllProdcutsByCatagory() throws SQLException {
		// TODO Auto-generated method stub
		return dalPO.getProductDAO().getAllProdcutsByCatagory();
	}

	@Override
	public void updateProduct(ProductTO productTO) throws SQLException {
		// TODO Auto-generated method stub
		dalPO.getProductDAO().updateProduct(productTO);
		
	}

	@Override
	public void deleteProduct(ProductTO productTO) throws SQLException {
		// TODO Auto-generated method stub
		dalPO.getProductDAO().deleteProduct(productTO);
	}

}
