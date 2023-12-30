package bll;

import java.util.List;
import java.util.Map;

import ParameterObjects.BllPo;
import bll.Interfaces.IBLLFacade;
import dal.Interfaces.IDalFacade;
import transerferObjects.ProductTO;

public class BllFacade implements IBLLFacade{

	BllPo bllPo; 
	

	
	public BllFacade(BllPo bllPo) {
		
		this.bllPo = bllPo; 
	}
	
	
	
	
	@Override
	public void addProduct(ProductTO productTO) {
		// TODO Auto-generated method stub
		
		bllPo.getProductBLO().addProduct(productTO);
		
	}

	@Override
	public List<Map<String, Object>> getAllProdcuts() {
		// TODO Auto-generated method stub
		return bllPo.getProductBLO().getAllProdcuts();
	}

	@Override
	public List<Map<String, Object>> getAllProdcutsByCatagory() {
		// TODO Auto-generated method stub
		return bllPo.getProductBLO().getAllProdcutsByCatagory();
	}

	@Override
	public void updateProdcut(ProductTO productTO) {
		// TODO Auto-generated method stub
		
		bllPo.getProductBLO().updateProdcut(productTO);
		
	}

	@Override
	public void deleteProduct(ProductTO productTO) {
		// TODO Auto-generated method stub
		bllPo.getProductBLO().deleteProduct(productTO);
		
	}

}
