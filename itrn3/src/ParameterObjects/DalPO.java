package ParameterObjects;

import dal.IProductDAO;
import dal.ProductDAO;

public class DalPO {

	IProductDAO productDAO;

	public DalPO() {
		super();
		this.productDAO = new ProductDAO();

	}

	public IProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(IProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	
	
	

}
