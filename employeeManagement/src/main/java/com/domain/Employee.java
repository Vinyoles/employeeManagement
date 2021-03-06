package com.domain;

public class Employee {
	
	public Employee(String name, String surname, Position position) {
		id = counter++;
		this.name = name;
		this.surname = surname;
		this.position = position;
		
		switch (position) {
		case Junior:
			salary = 1500;
			break;
		case Mid:
			salary = 1900;
			break;
		case Senior:
			salary = 2400;
			break;
		case TeamManager:
			salary = 2900;
			break;
		case Boss:
			salary = 5400;
			break;
		}
	}
	public Employee(){}
	public Employee(int id, String name, String surname, Position position, double salary){
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.position = position;
		this.salary = salary;
	}
	
	
	
	
	private int id;
	private static int counter = 1;
	private String name;
	private String surname;
	private double salary;
	private Position position;
	
	
	
	
	public static double setSalaryFromPosition(Position position) {
		double salaryFromPosition = 0;
		switch (position) {
		case Junior:
			salaryFromPosition = 1500;
			break;
		case Mid:
			salaryFromPosition = 1900;
			break;
		case Senior:
			salaryFromPosition = 2400;
			break;
		case TeamManager:
			salaryFromPosition = 2900;
			break;
		case Boss:
			salaryFromPosition = 5400;
			break;
		}	
		return salaryFromPosition;
	}
	
	
	
	
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
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		Employee.counter = counter;
	}
}
