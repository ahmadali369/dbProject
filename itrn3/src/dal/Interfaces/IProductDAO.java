package dal.Interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import transerferObjects.ProductTO;

//import transferObjects.BookTO;

public interface IProductDAO {

	
	public void addProdcut(ProductTO productTO) throws SQLException;

	public List<Map<String, Object>> getAllProduct() throws SQLException;
	
	public List<Map<String, Object>> getAllProdcutsByCatagory() throws SQLException;

	public void updateProduct(ProductTO productTO) throws SQLException;

	public void deleteProduct(ProductTO productTO) throws SQLException;
	
	
}
