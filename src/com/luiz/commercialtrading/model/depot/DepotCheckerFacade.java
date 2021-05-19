package com.luiz.commercialtrading.model.depot;

public class DepotCheckerFacade {
	
	public boolean hasSource(Depot depot) {
		if(!hasCash(depot) || !isNativeAvailable(depot) || !isExternalAvailable(depot)) {
			depot.setTrading(false);
			return false;
		}
		return true;
	}
	
	public boolean hasCash(Depot depot) {
		return depot.getBalance() > 0; 
	}
	
	public boolean isNativeAvailable(Depot depot) {
		return depot.natStockSize() > 14 && depot.natStockSize() < 51;
	}
	
	public boolean isExternalAvailable(Depot depot) {
		return depot.extStockSize() < 41;
	}

}
