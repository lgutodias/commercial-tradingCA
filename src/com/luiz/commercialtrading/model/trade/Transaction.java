package com.luiz.commercialtrading.model.trade;

import com.luiz.commercialtrading.model.product.Product;

public class Transaction {
	
	private final int idBuyer;
	private final int idSeller;
	private final Product product;
	
	public Transaction(int idBuyer, int idSeller, Product product) {
		this.idBuyer = idBuyer;
		this.idSeller = idSeller;
		this.product = product;
	}

	public int getIdBuyer() {
		return idBuyer;
	}

	public int getIdSeller() {
		return idSeller;
	}

	public Product getProduct() {
		return product;
	}

	@Override
	public String toString() {
		return "Transaction [idBuyer=" + idBuyer + ", idSeller=" + idSeller + ", product=" + product + "]";
	}
	
}
