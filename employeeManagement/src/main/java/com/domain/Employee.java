package com.domain;

public class Employee {
	public Employee(String name, String surname, String position) {
		id = previousID++;
		this.name = name;
		this.surname = surname;
		this.position = position;
		
		//TODO canviar a switch?
		if (position.equals("Junior")) salary = 1500;
		else if (position.equals("Mid")) salary = 1900;
		else if (position.equals("Senior")) salary = 2400;
		else if (position.equals("TeamManager")) salary = 2900;
		else if (position.equals("Boss")) salary = 5400;
		//TODO else throws exception
	}
	
	
	private int id;
	private int previousID = 0;
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
