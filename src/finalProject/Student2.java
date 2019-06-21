package finalProject;

public class Student2 implements Comparable<Student2> {

	private String id;
	private String name;
	private String grade;
	private String country;
	private String age;

	public Student2(String id, String name, String grade, String country, String age) {
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.country = country;
		this.age = age;
	}

	public String getGrade() {
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

	public String getAge() {
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

	public void setAge(String age) {
		this.age = age;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		String result = "Student ID: " + id + "\nName: " + name + "\nAge: " + age + "\nCountry: " + country
				+ "\nGrade: " + grade + "\n";
		return result;
	}

	@Override
	public int compareTo(Student2 otherStudent) {

		if (this.name.compareTo(otherStudent.getName()) != 0) {
			return -1 * this.name.compareTo(otherStudent.getName());
		} else if (this.id.compareTo(otherStudent.getId()) != 0) {
			return this.id.compareTo(otherStudent.getId());
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
