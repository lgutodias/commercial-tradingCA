package com.luiz.commercialtrading.model.trade;

import java.util.List;

import com.luiz.commercialtrading.model.company.Company;

public class TradeMarketFacade {
	
	private List<Company> companies;
	private TradeMarket market = new TradeMarket();
	
	public TradeMarketFacade(List<Company> companies) {
		this.companies = companies;
	}

	public void startTrading() {
		prepareTraders();
		market.startTrading();
	}
	
	private void prepareTraders() {
		for (Company company : companies) {
			if(company.depotsSize() > 0) {
				market.addAll(company.getDepots());
			}
		}
	}
	
	public List<Transaction> getTransactions() {
		return market.getTransactions();
	}

}
