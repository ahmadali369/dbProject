package bll.Interfaces;

import java.util.List;
import java.util.Map;

import transerferObjects.ProductTO;

public interface IProductBLO {

	public void addProduct(ProductTO productTO);

	public List<Map<String, Object>> getAllProdcuts();

	public List<Map<String, Object>> getAllProdcutsByCatagory();

	public void updateProdcut(ProductTO productTO);

	public void deleteProduct(ProductTO productTO);
}
