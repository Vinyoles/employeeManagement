package com.controllers;

import java.util.ArrayList;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.User;
import com.repository.DataBase;
import com.domain.Employee;

@org.springframework.stereotype.Controller //TODO works but strange
@RequestMapping("") //localhost:8080
public class Controller {
	
	DataBase db = new DataBase();
	User user;
	
	@GetMapping("/")
	public String start(Model model) {
		model.addAttribute("title", "employeeManagement - Employees login"); //sets the title of the website
		return "login";
	}
	
	@PostMapping("/")
	public String login(User user, Model model) {
		if (db.verifyUser(user.getName(), user.getPassword())) { //verifies the user data on the db
			this.user=user;
			ArrayList<Employee> employees = db.getEmployees();
			model.addAttribute("title", "employeeManagement - Employees login");
			model.addAttribute("user", user);
			model.addAttribute("employees", employees);
			model.addAttribute("action", "/insert");
			model.addAttribute("boton", "Insert Employee");
			model.addAttribute("employee", new Employee());
			return "consulting";
			
		} else {
			model.addAttribute("failed", true);
			return "login";  
		}
	}
	
	@PostMapping("/insert")
	public String insert(Model model, Employee employee) {
		db.insert(employee);
		ArrayList<Employee> employees = db.getEmployees();
		model.addAttribute("user", this.user);
		model.addAttribute("employees", employees);
		model.addAttribute("action", "/insert");
		model.addAttribute("boton", "Insert Employee");
		model.addAttribute("employee", new Employee());
		return "consulting";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, Model model) {
		db.delete(id);
		ArrayList<Employee> employees = db.getEmployees();
		model.addAttribute("employees", employees);
		model.addAttribute("user", this.user);
		model.addAttribute("boton", "Insert Employee");
		model.addAttribute("action", "/insert");
		model.addAttribute("employee", new Employee());
		return "consulting";
	}
	
	@GetMapping("/modify/{id}")
	public String modify(@PathVariable int id, Model model) {
		Employee employee = db.getEmployee(id);
		ArrayList<Employee> employees = db.getEmployees();
		model.addAttribute("employees", employees);
		model.addAttribute("employee", employee);
		model.addAttribute("user", this.user);
		model.addAttribute("boton", "Modify Employee");
		model.addAttribute("action", "/modify/value/" + id);
		return "consulting";
	}
	
	@PostMapping("/modify/value/{id}")
	public String sendModification(@PathVariable int id, Employee employee, Model model) {
		employee.setId(id);
		Employee.setCounter(Employee.getCounter()-1);
		db.modify(employee);
		ArrayList<Employee> employees = db.getEmployees();
		model.addAttribute("user", this.user);
		model.addAttribute("employees", employees);
		model.addAttribute("employee", null);
		model.addAttribute("boton", "Insert Employee");
		model.addAttribute("action", "/insert");
		model.addAttribute("employee", new Employee());
		return "consulting";
	}
}
