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

@org.springframework.stereotype.Controller //TODO comparar amb la Lara, en principi el org era un import i el controller anava sol
@RequestMapping("")
public class Controller {
	
	DataBase db = new DataBase();
	User user;
	
	@GetMapping("/")
	public String start(Model model) {
		model.addAttribute("title", "employeeManagement - Employees login"); //sets the title of the website
		return "login"; //returns the login.html in src/main/resources/templates
	}
	
	//returns the mapping result, changing to consulting.html if the credentials are correct or staying on login.html if not
	@PostMapping("/")
	public String login(User user, Model model) {
		if (user.getName().equals("andreu") && user.getPassword().equals("pass")) { //TODO check this data with a list
			
			this.user=user;
			
			ArrayList<Employee> employees = db.getEmployees();
			
			//makes available for the html consulting template the following variables
			model.addAttribute("title", "employeeManagement - Employees login");
			model.addAttribute("user", user);
			model.addAttribute("employees", employees);
			
			return "consulting";
			
		} else {
			return "login";
		}
	}
	
	@PostMapping("/insert")
	public String insert(Model model, Employee employee) {
		db.insertNewEmployee(employee);
		ArrayList<Employee> employees = db.getEmployees();
		model.addAttribute("user", this.user);
		model.addAttribute("employees", employees);
		return "consulting";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, Model model) {
		db.deleteEmployee(id);
		ArrayList<Employee> employees = db.getEmployees();
		model.addAttribute("employees", employees);
		model.addAttribute("user", this.user);
		model.addAttribute("boton", "insert user");
		model.addAttribute("action", "/insert");
		return "consulting";
	}
}
