package model.entities;

import java.io.Serializable;
import java.time.LocalDate;

public class Grade implements Serializable{
	private Student student;	//student who have passed the exam
	private Course course;		
	private int value;			//numerical value of the grade
	private LocalDate examDate;
	
	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Grade(Student student, Course course, int value, LocalDate examDate) {
		super();
		this.student = student;
		this.course = course;
		this.value = value;
		this.examDate = examDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public LocalDate getExamDate() {
		return examDate;
	}

	public void setExamDate(LocalDate examDate) {
		this.examDate = examDate;
	}

	@Override
	public String toString() {
		return  student.getIndexNumber() + ", "  + course.getCode() + ", " + value + ", " + examDate ;
	}
	
	
}
