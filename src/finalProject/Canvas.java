package finalProject;

import java.util.ArrayList;
import java.util.Hashtable;

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
		Student s = hashStudent.remove(id);
		System.out.println("Total tree students: " + bstStudent.getSize());
		bstStudent.remove(s);
		System.out.println("Total tree students: " + bstStudent.getSize());
		return s;
	}

	public int size() {
		return hashStudent.size();
	}
	
	public Student searchById(String id) {
		return hashStudent.get(id);
	}
	
	public ArrayList<Student> searchByName(String name) {
		ArrayList<Student> found= new ArrayList<Student>();
		for (String id : hashStudent.keySet()) {
			Student s = hashStudent.get(id);
			if (s.getName().toLowerCase().indexOf(name.toLowerCase()) != -1) found.add(s);
		}
		return found;
	}
	
	public void displayAllStudentsUnsorted() {
		for (String id : hashStudent.keySet()) {
			System.out.println(hashStudent.get(id).toString());
		}
	}
}