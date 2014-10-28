package com.zhaos.visitor1;

import java.util.ArrayList;
import java.util.List;

public class BuyBasket {

	private List<Product> productList = new ArrayList<Product>();
	
	public void addProduct(Product product){
		productList.add(product);
	}
	
	public List<Product> getProductList(){
		return productList;
	}
	
	public void notify(Visitor visitor){
		for (Product product : productList) {
			visitor.visit(product);
		}
	}
}
