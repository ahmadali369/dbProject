package ParameterObjects;

import bll.ProductBLO;
import bll.Interfaces.IProductBLO;
import dal.DalFacade;
import dal.Interfaces.IDalFacade;

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
