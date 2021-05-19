package com.luiz.commercialtrading.model.depot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.luiz.commercialtrading.model.product.Product;

public class Depot {
	
	private static int ID = 1;
	
	private final int id;
	private double cash;
	private boolean trading;
	private List<Product> nativeStock;
	private List<Product> externalStock;
	
	public static class Builder {
		
		private int id;
		private double cash;
		private boolean trading;
		private List<Product> nativeStock;
		private List<Product> externalStock;
		
		public Builder() {
			id = ID++;
			cash = 0;
			trading = true;
			nativeStock = new ArrayList<>();
			externalStock = new ArrayList<>();
		}
		
		public Builder cash(double cash) {
			this.cash = cash;
			return this;
		}
		
		public Builder nativeStock(List<Product> products) {
			nativeStock = products;
			return this;
		}
		
		public Depot build() {
			return new Depot(this);
		}	
	}
	
	public Depot(Builder builder) {
		id = builder.id;
		cash = builder.cash;
		trading = builder.trading;
		nativeStock = builder.nativeStock;
		externalStock = builder.externalStock;
	}

	public List<Product> getExternalStock() {
		return externalStock;
	}

	public void setExternalStock(List<Product> externalStock) {
		this.externalStock = externalStock;
	}

	public int getId() {
		return id;
	}

	public double getBalance() {
		return cash;
	}
	
	public void lodge(double cash) {
		this.cash += cash;
	}
	
	public boolean withdrawn(double cash) {
		if(cash <= this.cash) {
			this.cash -= cash;
			return true;
		}
		return false;
	}

	public boolean isTrading() {
		return trading;
	}

	public void setTrading(boolean trading) {
		this.trading = trading;
	}

	public List<Product> getNativeStock() {
		return nativeStock;
	}
	
	public Product peek(int index) {
		return nativeStock.get(index);
	}
	
	public Product sell(int index) {
		return nativeStock.remove(index);
	}
	
	public void buy(Product product) {
		externalStock.add(product);
	}
	
	public int natStockSize() {
		return nativeStock.size();
	}
	
	public int extStockSize() {
		return externalStock.size();
	}

	@Override
	public String toString() {
		return "Depot [id=" + id + ", nativeStock=" + nativeStock + ", externalStock=" + externalStock + "]";
	}
	
}
