package com.luiz.commercialtrading.model.depot;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDepotFactory {
	
	public List<Depot> createDepot(int qty) {
		List<Depot> depots = new ArrayList<>();
		
		for (int i = 0; i < qty; i++) {
			depots.add(create());	
		}
		return depots;
	}
	
	protected abstract Depot create();

}
