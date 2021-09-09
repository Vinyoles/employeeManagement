package com.repository;

import java.util.ArrayList;
import java.util.Iterator;

import com.domain.Employee;
import com.domain.Position;

public class DataBase {
	
	ArrayList<Employee> employees = new ArrayList<Employee>();
	
	public DataBase() {
		employees.add(new Employee("Andreu", "Vinyoles", Position.Mid));
		employees.add(new Employee("Eduard", "Lara", Position.Boss));
		employees.add(new Employee("Bernat", "", Position.Mid)); //TODO
		employees.add(new Employee("Mustafà", "", Position.Junior)); //TODO
		employees.add(new Employee("Lara", "", Position.TeamManager)); //TODO
		employees.add(new Employee("Jordi", "Albiol", Position.Senior));
		employees.add(new Employee("Roger", "Torrent", Position.Senior));
		employees.add(new Employee("Iván", "", Position.Junior)); //TODO
		employees.add(new Employee("Gabriel", "", Position.Junior)); //TODO
	}
	
	
	public void insertNewEmployee(Employee employee) {
		employees.add(employee);
	}
	
	public Employee getEmployee(int id) {
		Employee employee = null;
		Iterator<Employee> iterator = employees.iterator();
		while (iterator.hasNext()) {
			employee = iterator.next();
			if (employee.getId() == id) {
				break;
			}
		}		
		return employee;
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
	
	public void modifyEmployee(Employee employeeForm) {
		Iterator<Employee> iterator = employees.iterator();
		while (iterator.hasNext()) {
			Employee employeeSearch = iterator.next();
			if (employeeSearch.getId() == employeeForm.getId()) {
				employeeSearch.setName(employeeForm.getName());
				employeeSearch.setSurname(employeeForm.getSurname());
				employeeSearch.setPosition(employeeForm.getPosition());
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
