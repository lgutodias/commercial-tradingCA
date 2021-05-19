package com.luiz.commercialtrading.model.company;

import java.util.List;

import com.luiz.commercialtrading.model.depot.Depot;

public class Company {
	
	private String name;
	private List<Depot> depots;
	
	public Company(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public Depot getDepot(int index) {
		return depots.get(index);
	}

	public List<Depot> getDepots() {
		return depots;
	}

	public void setDepots(List<Depot> depots) {
		this.depots = depots;
	}
	
	public int depotsSize() {
		return depots.size();
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", depots=" + depots + "]";
	}
	
}
