package finalProject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;

public class Canvas {
	int maxId;
	int maxName;
	Student student;
	BST<Student> bstStudent;
	BST<Student2> bstStudent2;
	Hashtable<String, Student> hashStudent;

	public Canvas(int maxId, int maxName) {
		this.maxId = maxId;
		this.maxName = maxName;
		bstStudent = new BST<Student>();
		bstStudent2 = new BST<Student2>();
		hashStudent = new Hashtable<String, Student>();
	}

	public void enrollStudent(String id, String name, String grade, String country, String age) {
		Student newStudent = new Student(id, name, grade, country, age);
		bstStudent.insert(newStudent);
		hashStudent.put(id, newStudent);

		Student2 newStudent2 = new Student2(id, name, grade, country, age);
		bstStudent2.insert(newStudent2);
	}

	public Student dropStudent(String id) {
		Student student = hashStudent.remove(id);
		System.out.println("Total tree students: " + bstStudent.getSize());
		bstStudent.remove(student);
		System.out.println("Total tree students: " + bstStudent.getSize());

		Student2 student2 = new Student2(student.getId(), student.getName(), student.getGrade(), student.getCountry(),
				student.getAge());
		bstStudent2.remove(student2);

		return student;
	}

	public int size() {
		return hashStudent.size();
	}

	public Student searchById(String id) {
		return hashStudent.get(id);
	}

	public ArrayList<Student> searchByName(String name) {
		ArrayList<Student> found = new ArrayList<Student>();
		for (String id : hashStudent.keySet()) {
			Student s = hashStudent.get(id);
			if (s.getName().toLowerCase().indexOf(name.toLowerCase()) != -1)
				found.add(s);
		}
		return found;
	}

	public void displayAllStudentsUnsorted() {
		for (String id : hashStudent.keySet()) {
			System.out.println(hashStudent.get(id).toString());
		}
	}

	public void displayAllStudentsById() {
		bstStudent.inOrderPrint();
	}

	public void displayAllStudentsByName() {
		bstStudent2.inOrderPrint();
	}

	public void exportStudentList() {
		String fileName = "StudentList_" + System.currentTimeMillis() + ".txt";
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
			for (String id : hashStudent.keySet()) {
				writer.append(hashStudent.get(id).toString());
				writer.append("\n");
			}
			writer.close();
			System.out.println("Your student list " + fileName + " has been succesfully exported");
		}
		catch (Exception e) {
			System.out.println("File export failed!");
		}
	}
}