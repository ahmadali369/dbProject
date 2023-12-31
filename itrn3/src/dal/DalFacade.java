package dal;

import java.awt.AlphaComposite;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import ParameterObjects.DalPO;
import dal.Interfaces.IDalFacade;
import transerferObjects.ActivityTO;
import transerferObjects.CatagoryTO;
import transerferObjects.OrderTO;
import transerferObjects.ProductTO;
import transerferObjects.UserTO;

public class DalFacade implements IDalFacade {

	DalPO dalPO;

	public DalFacade(DalPO dalPO) {
		this.dalPO = dalPO;

	}

	@Override
	public void addProdcut(ProductTO productTO) throws SQLException {
		// TODO Auto-generated method stub
		dalPO.getProductDAO().addProdcut(productTO);

	}

	@Override
	public List<Map<String, Object>> getAllProduct() throws SQLException {
		// TODO Auto-generated method stub
		return dalPO.getProductDAO().getAllProduct();
	}

	@Override
	public List<Map<String, Object>> getAllProdcutsByCatagory() throws SQLException {
		// TODO Auto-generated method stub
		return dalPO.getProductDAO().getAllProdcutsByCatagory();
	}

	@Override
	public void updateProduct(ProductTO productTO) throws SQLException {
		// TODO Auto-generated method stub
		dalPO.getProductDAO().updateProduct(productTO);

	}

	@Override
	public void deleteProduct(ProductTO productTO) throws SQLException {
		// TODO Auto-generated method stub
		dalPO.getProductDAO().deleteProduct(productTO);
	}

	@Override
	public void addCatagory(CatagoryTO catagoryTO) throws SQLException  {
		// TODO Auto-generated method stub
		dalPO.getCatagoryDAO().addCatagory(catagoryTO);

	}

	@Override
	public List<Map<String, Object>> getAllCatagoriesList()  throws SQLException {
		// TODO Auto-generated method stub
		return dalPO.getCatagoryDAO().getAllCatagoriesList();
	}

	@Override
	public void placeOrder(OrderTO orderTO) throws SQLException {
		// TODO Auto-generated method stub
		dalPO.getOrder().placeOrder(orderTO);
		
	}

	@Override
	public void changeOrderStatus(int orderId, String status) throws SQLException {
		// TODO Auto-generated method stub
		dalPO.getOrder().changeOrderStatus(orderId, status);
		
	}

	@Override
	public List<Map<String, Object>> getOrdersBySatus(String status) throws SQLException {
		// TODO Auto-generated method stub
		return dalPO.getOrder().getOrdersBySatus(status);
	}

	@Override
	public List<Map<String, Object>> getOrdersByStatusAndCustormerId(String status, int custId) throws SQLException {
		// TODO Auto-generated method stub
		return dalPO.getOrder().getOrdersByStatusAndCustormerId(status, custId);
	}

	@Override
	public boolean addNewUser(UserTO userNewTO) throws SQLException {
		// TODO Auto-generated method stub
		return dalPO.getUserDAO().addNewUser(userNewTO);
	}

	@Override
	public boolean loginUser(UserTO userOldTO) throws SQLException {
		// TODO Auto-generated method stub
		return dalPO.getUserDAO().loginUser(userOldTO);
	}

	@Override
	public void storeUserActivity(ActivityTO activityTO) throws SQLException {
		// TODO Auto-generated method stub
		dalPO.getUserDAO().storeUserActivity(activityTO);
		
	}

	@Override
	public List<Map<String, Object>> getAllUsers() throws SQLException {
		// TODO Auto-generated method stub
		return dalPO.getUserDAO().getAllUsers();
	}

	@Override
	public void deleteUser(int id) throws SQLException {
		// TODO Auto-generated method stub
		dalPO.getUserDAO().deleteUser(id);
		
	}

	@Override
	public int getUserid() {
		// TODO Auto-generated method stub
		return dalPO.getUserDAO().getUserid();
	}

	@Override
	public List<Map<String, Object>> getProductsForOrderDetail(int orderDetailID) throws SQLException {
		// TODO Auto-generated method stub
		return dalPO.getProductDAO().getProductsForOrderDetail(orderDetailID);
	}

}
