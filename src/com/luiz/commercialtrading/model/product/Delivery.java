package com.luiz.commercialtrading.model.product;

import java.util.concurrent.ThreadLocalRandom;

public class Delivery extends Goods {
	
	private Product product;
	private double price;

	public Delivery(Product product) {
		super(product);
		this.product = product;
		price = ThreadLocalRandom.current().nextInt(1, 11);
	}
	
	@Override
	public double getPrice() {
		return product.getPrice() + price;
	}

	@Override
	public String toString() {
		return "[price=" + price + "]";
	}

}
