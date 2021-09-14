package com.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.domain.Employee;

public class DataBase2 {
	
	private Connection connection;
	
	public DataBase2() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String conex = "jdbc:mysql://54.38.34.13:3306/admin_employees_online";
			this.connection = DriverManager.getConnection(conex, "admin_employees", "lNbOUopApA");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insert(Employee employee) {
		String query = "INSERT INTO employees (id_employee, name, surname, position, salary"
				+ "VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement preparedStmt;
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, employee.getId()); //TODO id should be set by autoincrement
			preparedStmt.setString(2, employee.getName());
			preparedStmt.setString(3, employee.getSurname());
			preparedStmt.setString(4, employee.getPosition().toString()); //TODO how to set enum?
			preparedStmt.setDouble(5, employee.getSalary()); //TODO salary from position
			preparedStmt.executeUpdate();
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void delete(int id) {
		String query = "DELETE FROM employees WHERE id_employee=" + id;
		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.executeUpdate();
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void modify (Employee employee) {
		String query = "UPDATE FROM employee SET name=?, surname=?, position=?, salary=? WHERE id_employee=?";
		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, employee.getName());
			preparedStmt.setString(2, employee.getSurname());
			preparedStmt.setString(3, employee.getPosition().toString()); //TODO set enum
			preparedStmt.setDouble(4, employee.getSalary());
			preparedStmt.setDouble(5, employee.getId());
			System.out.println(preparedStmt.toString()); //TODO cal?
			preparedStmt.executeUpdate();
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public Employee getEmployee(int id) {
		Employee employee = null;
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM employees WHERE id_employee=" + id;
			statement.execute(query);
			ResultSet rs = statement.getResultSet();
			rs.next();
			employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return employee;
	}
	
	public ArrayList<Employee> getEmployees(){
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM employees";
			statement.execute(query);
			ResultSet rs = statement.getResultSet();
			while (rs.next()) {
				Employee employee = new Employee (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
				employeeList.add(employee);
			}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return employeeList;
	}
	
	public boolean verifyUser(String user, String password) {
		boolean check = false;
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT COUNT(*) FROM users WHERE user_name='" + user + "' AND password='" + password + "'";
			statement.execute(query);
			ResultSet rs = statement.getResultSet();
			rs.next();
			if (rs.getInt(1)>0) check = true;
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return check;
	}

}







