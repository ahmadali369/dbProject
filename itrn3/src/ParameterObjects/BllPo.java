package ParameterObjects;

import bll.IProductBLO;
import bll.ProductBLO;
import dal.DalFacade;
import dal.IDalFacade;

public class BllPo {

//	IDalFacade dalFacade; 
	
	
	IProductBLO productBLO; 
	
	
	public BllPo(IDalFacade dalFacade) {
		
		productBLO = new ProductBLO(dalFacade);
		
	}

	public IProductBLO getProductBLO() {
		return productBLO;
	}

	public void setProductBLO(IProductBLO productBLO) {
		this.productBLO = productBLO;
	}
	
	
}
