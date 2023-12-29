package ParameterObjects;

import bll.IProductBLO;
import bll.ProductBLO;

public class BllPo {

	
	IProductBLO productBLO; 
	
	public BllPo() {
		
		productBLO = new ProductBLO();
		
	}

	public IProductBLO getProductBLO() {
		return productBLO;
	}

	public void setProductBLO(IProductBLO productBLO) {
		this.productBLO = productBLO;
	}
	
	
}
