package com.luiz.commercialtrading.model.product;

import java.util.concurrent.ThreadLocalRandom;

public class Item implements Product {
	
	private double price;
	
	public Item() {
		super();
		price = ThreadLocalRandom.current().nextInt(1, 11);
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Item [price=" + price + "]";
	}

}
