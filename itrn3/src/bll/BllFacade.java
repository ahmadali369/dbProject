package bll;

import java.util.List;
import java.util.Map;

import ParameterObjects.BllPo;
import bll.Interfaces.IBLLFacade;
import dal.Interfaces.IDalFacade;
import transerferObjects.CatagoryTO;
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




	@Override
	public void addCatagory(CatagoryTO catagoryTO) {
		// TODO Auto-generated method stub
		bllPo.getCatagoryBLO().addCatagory(catagoryTO);
		
	}




	@Override
	public List<Map<String, Object>> getAllCatagoriesList() {
		// TODO Auto-generated method stub
		return bllPo.getCatagoryBLO().getAllCatagoriesList();
	}




	@Override
	public void addToCart(ProductTO productTO) {
		// TODO Auto-generated method stub
		bllPo.getCart().addToCart(productTO);
		
	}




	@Override
	public List<ProductTO> getCartProducts() {
		// TODO Auto-generated method stub
		return bllPo.getCart().getCartProducts();
	}




	@Override
	public void removeFromCart(ProductTO productTO) {
		// TODO Auto-generated method stub
		bllPo.getCart().removeFromCart(productTO);
		
	}

}
