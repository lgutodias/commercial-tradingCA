package com.luiz.commercialtrading.model.product;

public class Goods implements Product {
	
	private Product product;
	
	public Goods(Product product) {
		super();
		this.product = product;
	}

	@Override
	public double getPrice() {
		return product.getPrice();
	}

	@Override
	public String toString() {
		return "Goods [product=" + product + "]";
	}

}
