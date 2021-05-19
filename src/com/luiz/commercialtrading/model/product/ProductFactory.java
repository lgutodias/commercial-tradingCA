package com.luiz.commercialtrading.model.product;

import java.util.ArrayList;
import java.util.List;

public class ProductFactory {
	
	public static List<Product> createProduct(int qty) {
		List<Product> products = new ArrayList<>();
		for (int i = 0; i < qty; i++) {
			products.add(new Delivery(new Item()));
		}	
		return products;
	}

}
