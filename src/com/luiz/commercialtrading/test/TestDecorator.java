package com.luiz.commercialtrading.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.luiz.commercialtrading.model.product.Delivery;
import com.luiz.commercialtrading.model.product.Item;
import com.luiz.commercialtrading.model.product.Product;
import com.luiz.commercialtrading.model.product.ProductFactory;

class TestDecorator {

	@Test
	void test() {
		Product p1 = new Delivery(new Item());
		System.out.println(p1.getPrice());
	}
	
	@Test
	void testProductFactory() {
		int qty = 20;
		List<Product> products = ProductFactory.createProduct(qty);
		for (Product product : products) {
			System.out.println(product.getPrice());
		}
		assertTrue(products.size() == qty);
	}

}
