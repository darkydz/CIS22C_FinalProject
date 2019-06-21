package finalProject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class CIS22C {
	public static void main(String[] args) {
		System.out.println("Welcome to the Canvas!\n");
		Scanner input = new Scanner(System.in);
		File file = new File("Student.txt");
		String id, name, grade, country, ageString;
		try {
			Scanner sc = new Scanner(file);
			Canvas c = new Canvas(25, 25);
			while (sc.hasNextLine()) {
				id = sc.nextLine();
				name = sc.nextLine();
				grade = sc.nextLine();
				country = sc.nextLine();
				ageString = sc.nextLine();
				c.enrollStudent(id, name, grade, country, Integer.parseInt(ageString));
			}
			System.out.println("Total students: " + c.size());
			Boolean mainMenuOn = true;
			while (mainMenuOn) {
				displayMainMenu();
				switch (input.nextLine()) {
				case "1":
					System.out.println("Please enter new student ID");
					id = input.nextLine();
					System.out.println("Please enter new student Full Name");
					name = input.nextLine();
					System.out.println("Please enter new student Grade");
					grade = input.nextLine();
					System.out.println("Please enter new student Country");
					country = input.nextLine();
					System.out.println("Please enter new student Age");
					ageString = input.nextLine();
					c.enrollStudent(id, name, grade, country, Integer.parseInt(ageString));
					System.out.println("You have successfully enrolled " + name);
					break;
				case "2":
					System.out.println("Total students: " + c.size());
					System.out.println("Please enter student ID to drop:");
					id = input.nextLine();
					try {
						Student drop = c.dropStudent(id);
						System.out.println("You have successfully drop " + drop.getName());
						System.out.println("Total students: " + c.size());
					}
					catch (Exception e) {
						System.out.println("Student ID " + id + " does not exist!");
					}
					break;
				case "3":
					break;
				case "4":
					Boolean listMenuOn = true;
					while (listMenuOn) {
						displayListMenu();
						switch (input.nextLine()) {
						case "1":
							c.displayAllStudentsUnsorted();
							break;
						case "2":
							break;
						case "3":
							break;
						case "0":
							listMenuOn = false;
							break;
						default:
							break;
						}
					}
					break;
				case "5":
//						exportFile();
					System.out.println("Your student list has been succesfully exported");
					break;
				case "0":
					mainMenuOn = false;
//						exportFile();
					System.out.println("Bye! Your student list has been automatically saved");
					break;
				default:
					break;
				}
			}
			sc.close();
		} catch (IOException e) {
			System.out.println("No file found!");
		}

	}

	private static void displayMainMenu() {
		System.out.println("\n====Main Menu======\n");
		System.out.println("Select an option from menu below: ");
		System.out.println("1. Enroll New Student ");
		System.out.println("2. Drop Existing Student ");
		System.out.println("3. Student Look-up ");
		System.out.println("4. Student List");
		System.out.println("5. Export Student List");
		System.out.println("0. Exit");
	}
	
	private static void displayListMenu() {
		System.out.println("\n====4. Student List Menu======\n");
		System.out.println("Select an option from menu below: ");
		System.out.println("1. List all students");
		System.out.println("2. List all students by ID");
		System.out.println("3. List all students by Name");
		System.out.println("0. Back to previous menu");
	}

}
