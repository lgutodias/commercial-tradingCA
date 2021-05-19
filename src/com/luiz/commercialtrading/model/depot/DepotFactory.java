package com.luiz.commercialtrading.model.depot;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.luiz.commercialtrading.model.product.Product;
import com.luiz.commercialtrading.model.product.ProductFactory;

public class DepotFactory extends AbstractDepotFactory {

	@Override
	protected Depot create() {
		int qty = ThreadLocalRandom.current().nextInt(15, 51);
		double cashBalance = ThreadLocalRandom.current().nextDouble(50, 101);
		List<Product> products = ProductFactory.createProduct(qty);
		return new Depot.Builder().cash(cashBalance).nativeStock(products).build();
	}

}
