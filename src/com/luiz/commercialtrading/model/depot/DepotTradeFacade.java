package com.luiz.commercialtrading.model.depot;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.luiz.commercialtrading.model.product.Product;
import com.luiz.commercialtrading.model.trade.Transaction;

public class DepotTradeFacade {
	
	private List<Transaction> transactions = new ArrayList<Transaction>();
	private DepotCheckerFacade checker = new DepotCheckerFacade();
	
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public boolean trade(Depot buyer, Depot seller) {
		if(!checker.hasSource(buyer) || !checker.hasSource(seller)) {
			return false;
		}
		
		int stockSize = seller.natStockSize();
		int index = ThreadLocalRandom.current().nextInt(0, stockSize);
		Product product = seller.peek(index);
		double money = product.getPrice();
		
		if(!buyer.withdrawn(money)) {
			return false;
		}
		
		seller.lodge(money);
		buyer.buy(seller.sell(index));
		
		int idBuyer = buyer.getId();
		int idSeller = seller.getId();
		transactions.add(new Transaction(idBuyer, idSeller, product));
		return true;
	}
}
