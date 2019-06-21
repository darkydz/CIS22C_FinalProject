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
		File file = new File("Students.txt");
		String id, name, grade, country, age;
		Student student;
		try {
			Scanner sc = new Scanner(file);
			Canvas c = new Canvas(25, 25);
			while (sc.hasNextLine()) {
				id = sc.nextLine().replaceFirst("Student ID: ", "");
				name = sc.nextLine().replaceFirst("Name: ", "");;
				age = sc.nextLine().replaceFirst("Age: ", "");;
				country = sc.nextLine().replaceFirst("Country: ", "");;
				grade = sc.nextLine().replaceFirst("Grade: ", "");;
				if (sc.hasNextLine()) sc.nextLine();
				c.enrollStudent(id, name, grade, country, age);
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
					age = input.nextLine();
					c.enrollStudent(id, name, grade, country, age);
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
					} catch (Exception e) {
						System.out.println("Student ID " + id + " does not exist!");
					}
					break;
				case "3":
					Boolean searchMenuOn = true;
					while (searchMenuOn) {
						displaySearchMenu();
						switch (input.nextLine()) {
						case "1":
							System.out.println("Please enter a student ID:");
							id = input.nextLine();
							student = c.searchById(id);
							if (student != null)
								System.out.println(student.toString());
							else
								System.out.println("Student ID " + id + " does not exist!");
							break;
						case "2":
							System.out.println("Please enter a name or part of the name:");
							name = input.nextLine();
							ArrayList<Student> students = c.searchByName(name);
							if (students.size() > 0) 
							{
								System.out.println("(" + students.size() + ") students found:");
								for (Student s : students) {
									System.out.println(s.toString());
								}
							}
							else
								System.out.println("No student found!");
							break;
						case "0":
							searchMenuOn = false;
							break;
						default:
							break;
						}
					}
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
							c.displayAllStudentsById();
							break;
						case "3":
							c.displayAllStudentsByName();
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
					c.exportStudentList();
					break;
				case "0":
					mainMenuOn = false;
					c.exportStudentList();
					System.out.println("Bye!");
					break;
				default:
					break;
				}
			}
			sc.close();
			input.close();
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

	private static void displaySearchMenu() {
		System.out.println("\n====3. Student Look-up Menu======\n");
		System.out.println("Select an option from menu below: ");
		System.out.println("1. Look up by Student ID");
		System.out.println("2. Look up by Student Name");
		System.out.println("0. Back to previous menu");

	}

}
