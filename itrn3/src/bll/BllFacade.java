package bll;

import java.util.List;
import java.util.Map;

import ParameterObjects.BllPo;
import bll.Interfaces.IBLLFacade;
import dal.Interfaces.IDalFacade;
import transerferObjects.ActivityTO;
import transerferObjects.CatagoryTO;
import transerferObjects.OrderTO;
import transerferObjects.ProductTO;
import transerferObjects.UserTO;

public class BllFacade implements IBLLFacade {

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

	@Override
	public void placeOrder(OrderTO orderTO) {
		// TODO Auto-generated method stub
		bllPo.getOrder().placeOrder(orderTO);
		
	}

	@Override
	public void changeOrderStatus(int orderId, String status) {
		// TODO Auto-generated method stub
		bllPo.getOrder().changeOrderStatus(orderId, status);
	}

	@Override
	public List<Map<String, Object>> getOrdersBySatus(String status) {
		// TODO Auto-generated method stub
		return bllPo.getOrder().getOrdersBySatus(status);
	}

	@Override
	public List<Map<String, Object>> getOrdersByStatusAndCustormerId(String status, int custId) {
		// TODO Auto-generated method stub
		return bllPo.getOrder().getOrdersByStatusAndCustormerId(status, custId);
	}

	@Override
	public boolean addNewUser(UserTO userNewTO) {
		// TODO Auto-generated method stub
		return bllPo.getUserBLO().addNewUser(userNewTO);
	}

	@Override
	public boolean loginUser(UserTO userOldTO) {
		// TODO Auto-generated method stub
		return bllPo.getUserBLO().loginUser(userOldTO);
	}

	@Override
	public void storeUserActivity(ActivityTO activityTO) {
		// TODO Auto-generated method stub
		bllPo.getUserBLO().storeUserActivity(activityTO);
		
	}

	@Override
	public List<Map<String, Object>> getAllUsers() {
		// TODO Auto-generated method stub
		return bllPo.getUserBLO().getAllUsers();
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		bllPo.getUserBLO().deleteUser(id);
	}

	@Override
	public int getUserid() {
		// TODO Auto-generated method stub
		return bllPo.getUserBLO().getUserid();
	}

	@Override
	public List<Map<String, Object>> getProductsForOrderDetail(int orderDetailID) {
		// TODO Auto-generated method stub
		return bllPo.getProductBLO().getAllProdcutsByCatagory();
	}

}
