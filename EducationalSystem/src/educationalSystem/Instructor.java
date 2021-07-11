package educationalSystem;

import java.util.Date;

public class Instructor extends Person{
	private Date officeHours;
	private Subject[] courses;
	
	public Date getOfficeHours() {
		return officeHours;
	}
	
	public void setOfficeHours(Date officeHours) {
		this.officeHours = officeHours;
	}
	
	public Subject[] getCourses() {
		return courses;
	}
	
	public void displayInfo() {
		System.out.println("Name: "+super.name);
		System.out.println("Office Hours: "+this.getOfficeHours());
	}
	
}
