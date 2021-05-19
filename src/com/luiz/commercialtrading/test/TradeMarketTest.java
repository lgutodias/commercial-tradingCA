package com.luiz.commercialtrading.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.luiz.commercialtrading.model.company.AbstractCompanyFactory;
import com.luiz.commercialtrading.model.company.Company;
import com.luiz.commercialtrading.model.company.CompanyFactory;
import com.luiz.commercialtrading.model.depot.DepotFactory;
import com.luiz.commercialtrading.model.trade.TradeMarketFacade;
import com.luiz.commercialtrading.model.trade.Transaction;

class TradeMarketTest {

	
	@Test
	void testNumberOfTransactions() {
		int[] average = new int[3];
		
		for (int i = 0; i < average.length; i++) {
			average[i] = trade();
		}
		System.out.print("average: ");
		System.out.println(Arrays.toString(average));
	}
	
	public int trade() {
		String[] names = {"Big-A", "Big-B", "Big-C"};
		AbstractCompanyFactory factory = new CompanyFactory(new DepotFactory());
		List<Company> companies = factory.createCompany(names);
		
		TradeMarketFacade facade = new TradeMarketFacade(companies);
		facade.startTrading();
		List<Transaction> transactions = facade.getTransactions();
		return transactions.size();
	}

}
