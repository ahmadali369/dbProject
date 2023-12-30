package ParameterObjects;

import bll.OrderBLO;
import bll.Interfaces.IOrderBLO;
import dal.CatagoryDAO;
import dal.OrderDAO;
import dal.ProductDAO;
import dal.UserDAO;
import dal.Interfaces.ICatagoryDAO;
import dal.Interfaces.IOrderDAO;
import dal.Interfaces.IProductDAO;
import dal.Interfaces.IUserDAO;

public class DalPO {

	IProductDAO productDAO;
	ICatagoryDAO catagoryDAO; 
	IOrderDAO order; 
	IUserDAO userDAO; 

	public DalPO() {
		super();
		this.productDAO = new ProductDAO();
		this.catagoryDAO = new CatagoryDAO(); 
		this.order = new OrderDAO(); 
		this.userDAO = new UserDAO(); 

	}

	
	
	public IUserDAO getUserDAO() {
		return userDAO;
	}



	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
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
