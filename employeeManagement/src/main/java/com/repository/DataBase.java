package com.repository;

import java.util.ArrayList;

import com.domain.Employee;

public class DataBase {
	
	ArrayList<Employee> employees = new ArrayList<Employee>();
	public DataBase() {
		employees.add(new Employee("Andreu", "Vinyoles", "Mid")); //TODO
		employees.add(new Employee("Eduard", "Lara", "Boss")); //TODO
		employees.add(new Employee("Bernat", "", "Mid")); //TODO
		employees.add(new Employee("Mustafá", "", "Junior")); //TODO
		employees.add(new Employee("Lara", "", "Team Manager")); //TODO
		employees.add(new Employee("Jordi", "Albiol", "Senior")); //TODO
	}
	
	
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
}
