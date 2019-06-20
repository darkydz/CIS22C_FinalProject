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
		try {
			Scanner sc = new Scanner(file);
			Canvas c = new Canvas(25, 25);
			while (sc.hasNextLine()) {
				String id = sc.nextLine();
				String name = sc.nextLine();
				String grade = sc.nextLine();
				String country = sc.nextLine();
				String ageString = sc.nextLine();
				c.enrollStudent(id, name, grade, country, Integer.parseInt(ageString));
			}
			System.out.println("Total students: " + c.size());
			displayMainMenu();
			Boolean stillOn = true;
			while (stillOn) {
				switch (input.nextLine()) {
					case "1":
						System.out.println("Please enter new student ID");
						String id = input.nextLine();
						System.out.println("Please enter new student Full Name");
						String name = input.nextLine();
						System.out.println("Please enter new student Grade");
						String grade = input.nextLine();
						System.out.println("Please enter new student Country");
						String country = input.nextLine();
						System.out.println("Please enter new student Age");
						String ageString = input.nextLine();
						c.enrollStudent(id, name, grade, country, Integer.parseInt(ageString));
						System.out.println("You have successfully enrolled " + name);
						break;
					case "2":
//						delete by ID
						break;
					case "3":
						break;
					case "4":
						break;
					case "5":
//						exportFile();
						System.out.println("Your student list has been succesfully exported");
						break;
					case "0":
						stillOn = false;
//						exportFile();
						System.out.println("Bye! Your student list has been automatically saved");
						break;
					default:
						break;
				}
				displayMainMenu();
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

}
