package dal;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import ParameterObjects.DalPO;
import dal.Interfaces.IDalFacade;
import transerferObjects.CatagoryTO;
import transerferObjects.OrderTO;
import transerferObjects.ProductTO;

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

}
