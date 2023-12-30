package ParameterObjects;

import bll.Cart;
import bll.CatagoryBLO;
import bll.ProductBLO;
import bll.Interfaces.ICart;
import bll.Interfaces.ICatagoryBLO;
import bll.Interfaces.IProductBLO;
import dal.DalFacade;
import dal.Interfaces.IDalFacade;

public class BllPo {

//	IDalFacade dalFacade; 
	
	
	IProductBLO productBLO; 
	ICatagoryBLO catagoryBLO; 
	ICart cart; 
	
	
	public BllPo(IDalFacade dalFacade) {
		
		productBLO = new ProductBLO(dalFacade);
		catagoryBLO = new CatagoryBLO(dalFacade); 
		cart = new Cart(); 
		
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

	public ICart getCart() {
		return cart;
	}

	public void setCart(ICart cart) {
		this.cart = cart;
	}
	
	
}
