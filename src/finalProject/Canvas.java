package finalProject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Canvas {
	int maxId;
	int maxName;
	Student student;
	BST<Student> bstStudent;
	HashTable2<String, Student> hashStudent;

	public Canvas(int maxId, int maxName) {
		this.maxId = maxId;
		this.maxName = maxName;
		bstStudent = new BST<Student>();
		hashStudent = new HashTable2<String, Student>(maxId);
	}

	public void enrollStudent(String id, String name, String grade, String country, int age) {
		Student newStudent = new Student(id, name, grade, country, age);
		bstStudent.insert(newStudent);
		hashStudent.add(id,newStudent);
	}

	public int size() {
		return hashStudent.getSize();
	}
	
	public void displayAllStudentsUnsorted() {
//		hashStudent.;
	}
//	public void dropStudent() {
//		Scanner scanner;
//		scanner = new Scanner(System.in);
//		 System.out.println("Type a student id to drop: ");
//	        try {
//	        	bstStudent.remove(scanner);
//	        	(me,hashName.get(new User(scanner.nextLine())));
//	        }catch(Exception ex) {
//	        	System.out.println("Invalid Friend!");
//	        }
//	        
//	    
//	}
}