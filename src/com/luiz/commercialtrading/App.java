package com.luiz.commercialtrading;

import java.util.List;

import com.luiz.commercialtrading.model.company.AbstractCompanyFactory;
import com.luiz.commercialtrading.model.company.Company;
import com.luiz.commercialtrading.model.company.CompanyFactory;
import com.luiz.commercialtrading.model.depot.DepotFactory;

public class App {
	
	public App() {
		
		String[] names = {"Big-A", "Big-B", "Big-C"};
		AbstractCompanyFactory factory = new CompanyFactory(new DepotFactory());
		List<Company> companies = factory.createCompany(names);
		
		
	}
	
	public static void main(String[] args) {
		new App();
	}

}
