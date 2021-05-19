package com.luiz.commercialtrading.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.luiz.commercialtrading.model.depot.AbstractDepotFactory;
import com.luiz.commercialtrading.model.depot.Depot;
import com.luiz.commercialtrading.model.depot.DepotFactory;
import com.luiz.commercialtrading.model.product.Product;

class DepotFactoryTest {

	@Test
	void test() {
		int qty = 50;
		AbstractDepotFactory factory = new DepotFactory();
		List<Depot> depots = factory.createDepot(qty);
		assertTrue(depots.size() == qty);
		Depot depot = depots.get(0);
		int nativeStockSize = depot.getNativeStock().size();
		assertTrue(nativeStockSize > 14 && nativeStockSize < 51);
		Product product = depot.getNativeStock().get(0);
		assertTrue(product.getPrice() > 0 && product.getPrice() < 21);
		
	}

}
