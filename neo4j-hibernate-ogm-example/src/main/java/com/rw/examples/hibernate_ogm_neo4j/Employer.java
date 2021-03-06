package com.rw.examples.hibernate_ogm_neo4j;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="Employer")
public class Employer extends AbstractEntity{
	
	private String name;
	
	@OneToMany(mappedBy = "employer")
    private Set<Employee> employees = new HashSet<Employee>();
	
	private Employer() {}
	
	public Employer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addEmployee(Employee e) {
		employees.add(e);
		e.worksFor(this);
	}
	

	@Override
	public String toString() {
		return "Company [id=" + getId() + ", name=" + name + "]" + " employees: " + employees.stream().map(e->e.getName()).collect(Collectors.joining(","));
	}
	
	
	
	
}
