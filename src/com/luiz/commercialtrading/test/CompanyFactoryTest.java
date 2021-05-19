package com.luiz.commercialtrading.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.luiz.commercialtrading.model.company.AbstractCompanyFactory;
import com.luiz.commercialtrading.model.company.Company;
import com.luiz.commercialtrading.model.company.CompanyFactory;
import com.luiz.commercialtrading.model.depot.DepotFactory;

class CompanyFactoryTest {

	@Test
	void test() {
		
		String[] names = {"Big-A", "Big-B", "Big-C"};
		AbstractCompanyFactory factory = new CompanyFactory(new DepotFactory());
		List<Company> companies = factory.createCompany(names);
		
		for (Company company : companies) {
			System.out.println(company.getName());
		}
		assertEquals(companies.get(0).getName(), names[0]);
	}

}
