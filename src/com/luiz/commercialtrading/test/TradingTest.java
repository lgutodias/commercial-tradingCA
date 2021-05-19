package com.luiz.commercialtrading.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.luiz.commercialtrading.model.company.AbstractCompanyFactory;
import com.luiz.commercialtrading.model.company.Company;
import com.luiz.commercialtrading.model.company.CompanyFactory;
import com.luiz.commercialtrading.model.depot.Depot;
import com.luiz.commercialtrading.model.depot.DepotCheckerFacade;
import com.luiz.commercialtrading.model.depot.DepotFactory;
import com.luiz.commercialtrading.model.depot.DepotTradeFacade;
import com.luiz.commercialtrading.model.trade.Transaction;

class TradingTest {

	@Test
	void testSingleTrade() {
		String[] names = {"Big-A", "Big-B", "Big-C"};
		AbstractCompanyFactory factory = new CompanyFactory(new DepotFactory());
		List<Company> companies = factory.createCompany(names);
		DepotCheckerFacade checker = new DepotCheckerFacade();
		
		Depot buyer = companies.get(0).getDepot(0);
		Depot seller = companies.get(1).getDepot(0);
		
		DepotTradeFacade facade = new DepotTradeFacade();
		facade.trade(buyer, seller);
		
		List<Transaction> transactions = facade.getTransactions();
		
		for (Transaction transaction : transactions) {
			System.out.println(transaction);
		}
		assertTrue(checker.isExternalAvailable(buyer));
		assertTrue(buyer.getBalance() > 20);
		assertTrue(checker.isNativeAvailable(seller));
		assertTrue(transactions.size() > 0);
	}

}
