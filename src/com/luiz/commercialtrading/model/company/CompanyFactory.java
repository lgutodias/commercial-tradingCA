package com.luiz.commercialtrading.model.company;


import java.util.List;

import com.luiz.commercialtrading.model.depot.AbstractDepotFactory;
import com.luiz.commercialtrading.model.depot.Depot;

public class CompanyFactory extends AbstractCompanyFactory {
	
	private AbstractDepotFactory factory;

	public CompanyFactory(AbstractDepotFactory factory) {
		this.factory = factory;
	}

	@Override
	protected Company create(String name) {
		List<Depot> depots = factory.createDepot(50);
		Company company = new Company(name);
		company.setDepots(depots);
		return company;
	}
	
	

}
