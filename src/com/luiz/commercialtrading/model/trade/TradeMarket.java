package com.luiz.commercialtrading.model.trade;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

import com.luiz.commercialtrading.model.depot.Depot;
import com.luiz.commercialtrading.model.depot.DepotTradeFacade;

public class TradeMarket {
	
	private List<Depot> traders = new CopyOnWriteArrayList<>();
	private DepotTradeFacade facade = new DepotTradeFacade();

	public List<Depot> getTraders() {
		return traders;
	}

	public void setTraders(List<Depot> traders) {
		this.traders = traders;
	}
	
	public void addAll(List<Depot> traders) {
		this.traders.addAll(traders);
	}
	
	public void remove(Depot trader) {
		traders.remove(trader);
	}
	
	public void startTrading() {
		
		while(traders.size() > 1) {
			
			int size = traders.size();
			Depot buyer = pickTrader(size);
			Depot seller = pickTrader(size);
			
			if(!buyer.equals(seller)) {
				if(!facade.trade(buyer, seller)) {
					removeIfNotResource(buyer);
					removeIfNotResource(seller);
					continue;
				}
//				System.out.println("Trade Ok");
			}
			
		}
	}
	
	public Depot pickTrader(int stopAt) {
		int index = ThreadLocalRandom.current().nextInt(0, stopAt);
		return traders.get(index);
	}
	
	public void removeIfNotResource(Depot trader) {
		if(!trader.isTrading()) {
//			System.out.println(trader);
			remove(trader);
		}
	}
	
	public List<Transaction> getTransactions() {
		return facade.getTransactions();
	}

}
