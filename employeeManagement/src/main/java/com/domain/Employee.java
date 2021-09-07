package com.domain;

public class Employee {
	public Employee(String name, String surname, String position) {
		id = counter++;
		this.name = name;
		this.surname = surname;
		this.position = position;
		
		switch (position) {
			case "Junior":
				salary = 1500;
				break;
			case "Mid":
				salary = 1900;
				break;
			case "Senior":
				salary = 2400;
				break;
			case "Team Manager":
				salary = 2900;
				break;
			case "Boss":
				salary = 5400;
				break;
			default:
				//throws Exception(); //TODO
			}
	}
	
	
	private int id;
	private static int counter = 1;
	private String name;
	private String surname;
	private double salary;
//	private enum position {
//		Junior, Mid, Senior, TeamManager, Boss;
//	}
	private String position;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

}
