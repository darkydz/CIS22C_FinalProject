package finalProject;

public class Student implements Comparable<Student> {

	private String id;
	private String name;
	private String grade;
	private String country;
	private int age;

	public Student(String id, String name, String grade, String country, int age) {
		this.id=id;
		this.name = name;
		this.grade = grade;
		this.country = country;
		this.age = age;
	}
	
	public String getgrade() {
		return grade;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public String getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		String result = "Student ID: " + id + "\nName: " + name;
		return result;
	}

	@Override
	public int compareTo(Student otherStudent) {

		if (this.id.compareTo(otherStudent.getId()) !=0 ) {
			return this.id.compareTo(otherStudent.getId());
		} else if (this.name.compareTo(otherStudent.getName()) != 0) {
			return this.name.compareTo(otherStudent.getName());
		} else {
			return 0;
		}
	}

	@Override
	public int hashCode() {
		String key = id + name; // define key for this class
		int sum = 0;
		for (int i = 0; i < key.length(); i++) {
			sum += (int) key.charAt(i);
		}
		return sum;
	}

}
