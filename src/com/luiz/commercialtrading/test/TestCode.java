package com.luiz.commercialtrading.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.luiz.commercialtrading.model.depot.AbstractDepotFactory;
import com.luiz.commercialtrading.model.depot.Depot;
import com.luiz.commercialtrading.model.depot.DepotFactory;

class TestCode {

	@Test
	void testIfDepotsAreEqual() {
		AbstractDepotFactory factory = new DepotFactory();
		List<Depot> depots = factory.createDepot(3);
		Depot buyer = depots.get(0);
		Depot seller = depots.get(0);
		System.out.println(buyer.hashCode());
		System.out.println(seller.hashCode());
		assertFalse(!buyer.equals(seller));
	}

}
