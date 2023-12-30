package transerferObjects;

import java.util.List;

public class OrderTO {

	int id; 
	List<ProductTO> productList;
	String shippingAddress;
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
	
	
	
}
