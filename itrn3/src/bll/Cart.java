package bll;

import java.util.ArrayList;
import java.util.List;

import bll.Interfaces.ICart;
import transerferObjects.ProductTO;

public class Cart implements ICart{

	List<ProductTO> cart;
	
	
	
	public Cart() {
	
		cart = new ArrayList<ProductTO>(); 
		
	}
	
	@Override
	public void addToCart(ProductTO productTO) {
		// TODO Auto-generated method stub
		
		cart.add(productTO); 
		
	}

	@Override
	public List<ProductTO> getCartProducts() {
		// TODO Auto-generated method stub
		return cart;
	}

	@Override
	public void removeFromCart(ProductTO productTO) {
		// TODO Auto-generated method stub
		cart.remove(productTO); 
		
	}

}
