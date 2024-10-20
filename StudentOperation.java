package com.ty;

import java.util.Scanner;

public class StudentOperation {
	
	public static void main(String[] args) {
		StudentInterface sf = new StudentImplementation();
	
		System.out.println("Welcome to Student registration app");
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println(
					"1:addStudent\n2:updateStudent\n3:deleteStudent\n4:GetAllStudent\n5:getStudentById\n6:deleteAllStudent\n7:exit");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				sf.addStudent();
			}
				break;
			case 2: {
				sf.updateStudent();
			}
				break;
			case 3: {
				sf.deleteStudent();
			}
				break;
			case 4: {
				sf.getAllStudent();
			}
				break;
			case 5: {
				sf.getStudentById();
			}
				break;
			case 6: {
				sf.deleteAllStudent();
			}
				break;
			case 7:
				System.out.println("Thank you");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid entry");
			}
		}
	}

}
