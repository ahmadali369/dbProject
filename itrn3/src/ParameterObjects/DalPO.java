package ParameterObjects;

import bll.OrderBLO;
import bll.Interfaces.IOrderBLO;
import dal.CatagoryDAO;
import dal.OrderDAO;
import dal.ProductDAO;
import dal.Interfaces.ICatagoryDAO;
import dal.Interfaces.IOrderDAO;
import dal.Interfaces.IProductDAO;

public class DalPO {

	IProductDAO productDAO;
	ICatagoryDAO catagoryDAO; 
	IOrderDAO order; 

	public DalPO() {
		super();
		this.productDAO = new ProductDAO();
		this.catagoryDAO = new CatagoryDAO(); 
		this.order = new OrderDAO(); 

	}

	
	
	public IOrderDAO getOrder() {
		return order;
	}



	public void setOrder(IOrderDAO order) {
		this.order = order;
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
