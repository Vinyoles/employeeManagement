package com.repository;

import java.util.ArrayList;
import java.util.Iterator;

import com.domain.Employee;

public class DataBase {
	
	ArrayList<Employee> employees = new ArrayList<Employee>();
	public DataBase() {
		employees.add(new Employee("Andreu", "Vinyoles", "Mid"));
		employees.add(new Employee("Eduard", "Lara", "Boss"));
		employees.add(new Employee("Bernat", "", "Mid")); //TODO
		employees.add(new Employee("Mustafà", "", "Junior")); //TODO
		employees.add(new Employee("Lara", "", "Team Manager")); //TODO
		employees.add(new Employee("Jordi", "Albiol", "Senior"));
		employees.add(new Employee("Roger", "", "Senior")); //TODO
	}
	
	public void insertNewEmployee(Employee employee) {
		employees.add(employee);
	}
	
	public void deleteEmployee(int id) {
		Iterator<Employee> iterator = employees.iterator();
		while (iterator.hasNext()) {
			Employee employee = iterator.next();
			if (employee.getId() == id) {
				iterator.remove();
				break;
			}
		}
	}
	
	
	
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}


}
