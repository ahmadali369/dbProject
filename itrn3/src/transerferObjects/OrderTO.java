package transerferObjects;

import java.util.List;

public class OrderTO {

	int id; 
	int customerID; 
	List<ProductTO> productList;
	String shippingAddress;
	String status; 
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<ProductTO> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductTO> productList) {
		this.productList = productList;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
