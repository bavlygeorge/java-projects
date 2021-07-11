package test;

import java.sql.Date;

import educationalSystem.Instructor;
import educationalSystem.Student;

public class Test {
	
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setName("Karim");
		s1.setID(14);
		
		Student s2 = new Student();
		s2.setName("Emad");
		s2.setID(15);
		
		Instructor i1 = new Instructor();
		i1.setName("Albert");
		i1.setOfficeHours(new Date(System.currentTimeMillis()));
		i1.displayInfo();
		
	}
}
