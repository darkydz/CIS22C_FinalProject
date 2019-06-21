package finalProject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Canvas {
	int maxId;
	int maxName;
	Student student;
	BST<Student> bstStudent;
	Hashtable<String, Student> hashStudent;

	public Canvas(int maxId, int maxName) {
		this.maxId = maxId;
		this.maxName = maxName;
		bstStudent = new BST<Student>();
		hashStudent = new Hashtable<String, Student>();
	}

	public void enrollStudent(String id, String name, String grade, String country, int age) {
		Student newStudent = new Student(id, name, grade, country, age);
		bstStudent.insert(newStudent);
		hashStudent.put(id, newStudent);
	}
	
	public Student dropStudent(String id) {
		return hashStudent.remove(id);
	}

	public int size() {
		return hashStudent.size();
	}
	
	public void displayAllStudentsUnsorted() {
//		hashStudent.;
	}
}