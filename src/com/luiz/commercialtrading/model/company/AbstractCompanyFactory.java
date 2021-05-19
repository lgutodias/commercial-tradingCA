package com.luiz.commercialtrading.model.company;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCompanyFactory {
	
	public List<Company> createCompany(String[] names) {
		List<Company> companies = new ArrayList<>();
		
		for (int i = 0; i < names.length; i++) {
			companies.add(create(names[i]));
		}
		return companies;
	}
	
	protected abstract Company create(String name);

}
