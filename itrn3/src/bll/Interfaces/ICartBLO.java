package bll.Interfaces;

import java.util.List;

import transerferObjects.ProductTO;

public interface ICartBLO {

	void addToCart(ProductTO productTO);
	List<ProductTO> getCartProducts(); 
	void removeFromCart(ProductTO productTO); 
	
	
}
