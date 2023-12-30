package ParameterObjects;

import dal.ProductDAO;
import dal.Interfaces.IProductDAO;

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
