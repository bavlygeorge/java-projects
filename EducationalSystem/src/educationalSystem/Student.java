package educationalSystem;

public class Student extends Person{
	private int ID;
	private Subject[] courses;
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}

	public Subject[] getCourses() {
		return courses;
	}
	
	public int totalGrades() {
		int total = 0;
		// loop over courses and add their grades
		for(int i=0; i<courses.length; i++) {
			total += courses[i].getGrade();
		}
		return total;
	}
}
