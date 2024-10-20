package com.ty;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentImplementation implements StudentInterface{
	Scanner sc=new Scanner(System.in);

	public void addStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
			PreparedStatement preparedStatement=connection.prepareStatement("insert into student values(?,?,?,?,?)");
			System.out.println("Enter the id of Student");
			int id=sc.nextInt();
			preparedStatement.setInt(1, id);
			System.out.println("Enter the name of Student");
			String name=sc.next();
			preparedStatement.setString(2, name);
			System.out.println("Enter the age of Student");
			int age=sc.nextInt();
			preparedStatement.setInt(3, age);
			System.out.println("Enter the gender of Student");
			String gender=sc.next();
			preparedStatement.setString(4, gender);
			System.out.println("Enter the marks of Student");
			int marks=sc.nextInt();
			preparedStatement.setInt(5, marks);
			preparedStatement.execute();
			preparedStatement.close();
			System.out.println("Student data Saved");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void updateStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
			PreparedStatement preparedStatement=connection.prepareStatement("update student set marks=? where id=?");
			System.out.println("Enter marks you want to update");
			int marks=sc.nextInt();
			preparedStatement.setInt(1, marks);
			System.out.println("Enter id of the Student to be updated");
			int id=sc.nextInt();
			preparedStatement.setInt(2, id);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
			
//			String query="delete from students where id=?";
//			PreparedStatement preparedStatement=connection.prepareStatement(query);
//			preparedStatement.setInt(101,101);
//			int rowsAffected=preparedStatement.executeUpdate();
//			
		System.out.println("Delete Student by ID");
		System.out.println("________________");
		PreparedStatement preparedStatement=connection.prepareStatement("delete from student where id=?");
		System.out.println("Enter the Student ID to be deleted");
		int id=sc.nextInt();
		preparedStatement.setInt(1, id);
		preparedStatement.execute();
		preparedStatement.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	public void getAllStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
			PreparedStatement preparedStatement=connection.prepareStatement("select * from student");
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("id is "+resultSet.getInt(1));
				System.out.println("Name is "+resultSet.getString(2));
				System.out.println("Age is "+resultSet.getInt(3));
				System.out.println("Gender is "+resultSet.getString(4));
				System.out.println("mark is "+resultSet.getInt(5));
				System.out.println("____________________________");
			}
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getStudentById() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
			PreparedStatement preparedStatement=connection.prepareStatement("select * from student where id=?");
			System.out.println("Enter the id of Student");
			int id=sc.nextInt();
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("id is "+resultSet.getInt(1));
				System.out.println("Name is "+resultSet.getString(2));
				System.out.println("Age is "+resultSet.getInt(3));
				System.out.println("Gender is "+resultSet.getString(4));
				System.out.println("mark is "+resultSet.getInt(5));
				System.out.println("____________________________");
			}
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteAllStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		System.out.println("Delete All Student");
		System.out.println("________________");
		PreparedStatement preparedStatement=connection.prepareStatement("truncate table student");
		preparedStatement.execute();
		preparedStatement.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	      e.printStackTrace();
		}
	
	}

}


