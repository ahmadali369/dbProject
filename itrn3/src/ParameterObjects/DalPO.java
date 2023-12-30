package ParameterObjects;

import dal.CatagoryDAO;
import dal.ProductDAO;
import dal.Interfaces.ICatagoryDAO;
import dal.Interfaces.IProductDAO;

public class DalPO {

	IProductDAO productDAO;
	ICatagoryDAO catagoryDAO; 

	public DalPO() {
		super();
		this.productDAO = new ProductDAO();
		this.catagoryDAO = new CatagoryDAO(); 

	}

	
	
	public ICatagoryDAO getCatagoryDAO() {
		return catagoryDAO;
	}



	public void setCatagoryDAO(ICatagoryDAO catagoryDAO) {
		this.catagoryDAO = catagoryDAO;
	}



	public IProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(IProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	
	
	

}
