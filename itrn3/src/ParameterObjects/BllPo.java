package ParameterObjects;

import bll.CartBLO;
import bll.CatagoryBLO;
import bll.OrderBLO;
import bll.ProductBLO;
import bll.Interfaces.ICartBLO;
import bll.Interfaces.ICatagoryBLO;
import bll.Interfaces.IOrderBLO;
import bll.Interfaces.IProductBLO;
import dal.DalFacade;
import dal.Interfaces.IDalFacade;

public class BllPo {

//	IDalFacade dalFacade; 
	
	
	IProductBLO productBLO; 
	ICatagoryBLO catagoryBLO; 
	ICartBLO cart; 
	IOrderBLO order; 
	
	
	public BllPo(IDalFacade dalFacade) {
		
		productBLO = new ProductBLO(dalFacade);
		catagoryBLO = new CatagoryBLO(dalFacade); 
		cart = new CartBLO(); 
		order = new OrderBLO(dalFacade); 
		
	}

	public ICatagoryBLO getCatagoryBLO() {
		return catagoryBLO;
	}

	public void setCatagoryBLO(ICatagoryBLO catagoryBLO) {
		this.catagoryBLO = catagoryBLO;
	}

	public IProductBLO getProductBLO() {
		return productBLO;
	}

	public void setProductBLO(IProductBLO productBLO) {
		this.productBLO = productBLO;
	}

	public ICartBLO getCart() {
		return cart;
	}

	public void setCart(ICartBLO cart) {
		this.cart = cart;
	}

	public IOrderBLO getOrder() {
		return order;
	}

	public void setOrder(IOrderBLO order) {
		this.order = order;
	}
	
	
}
