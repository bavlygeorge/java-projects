package educationalSystem;

public class EducationalInstitute {
	private String name;
	private Person[] students;
	private Person[] instructors;
	private Person[] admins;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Person[] getStudents() {
		return students;
	}

	public Person[] getInstructors() {
		return instructors;
	}

	public Person[] getAdmins() {
		return admins;
	}
	
}
