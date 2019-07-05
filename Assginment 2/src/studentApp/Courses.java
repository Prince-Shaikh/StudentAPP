package studentApp;

import java.util.ArrayList;
import java.util.HashMap;

public class Courses {

	private String code;
	private String title;
	private String teacher;
	private int creditHours;
	private HashMap<Student,int[]> studentsEnrolled = new HashMap<>();
	
	public Courses(String code, String title, String teacher, int credit){
		this.code = code;
		this.title = title;
		this.teacher = teacher;
		this.creditHours = credit;
	}
	
	public void enrollStudent(Student student, int[] marks) {
		studentsEnrolled.put(student, marks);
	}
	
	public void unEnrollStudent(Student student) {
		studentsEnrolled.remove(student);
	}
	public Student[] getEnrolledStudents() {
		
		Student[] arr = new Student[studentsEnrolled.size()];
		
		int i = 0;
		for(Student student : studentsEnrolled.keySet()) {
			arr[i] = student;
			i++;
		}
		return arr;
	}
	public HashMap<Student,int[]> getEnrolledStudentsAsMap(){
		return studentsEnrolled;
	}
	public int[] getStudentMarks(Student student) {
		return studentsEnrolled.get(student);
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getTeacher() {
		return teacher;
	}
	
	public void setCreditHours(int num) {
		this.creditHours = num;
	}
	public int getCreditHours() {
		return creditHours;
	}
}
