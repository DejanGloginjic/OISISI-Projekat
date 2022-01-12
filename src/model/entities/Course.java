package model.entities;

import java.util.ArrayList;

import enumerations.Semester;

public class Course{
	private String code;
	private String name;
	private Semester semester;
	private int yearOfTheCourse;
	private Professor subjectProfessor;
	private int numberOfESPB;
	private ArrayList<Student> studentsWhoHavePassedTheExam;
	private ArrayList<Student> studentsWhoHaveNotPassedTheExam;
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String code, String name, Semester semester, int yearOfTheCourse, Professor subjectProfessor,
			int numberOfESPB, ArrayList<Student> studentsWhoHavePassedTheExam,
			ArrayList<Student> studentsWhoHaveNotPassedTheExam) {
		super();
		this.code = code;
		this.name = name;
		this.semester = semester;
		this.yearOfTheCourse = yearOfTheCourse;
		this.subjectProfessor = subjectProfessor;
		this.numberOfESPB = numberOfESPB;
		this.studentsWhoHavePassedTheExam = studentsWhoHavePassedTheExam;
		this.studentsWhoHaveNotPassedTheExam = studentsWhoHaveNotPassedTheExam;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public int getYearOfTheCourse() {
		return yearOfTheCourse;
	}

	public void setYearOfTheCourse(int yearOfTheCourse) {
		this.yearOfTheCourse = yearOfTheCourse;
	}

	public Professor getSubjectProfessor() {
		return subjectProfessor;
	}

	public void setSubjectProfessor(Professor subjectProfessor) {
		this.subjectProfessor = subjectProfessor;
	}

	public int getNumberOfESPB() {
		return numberOfESPB;
	}

	public void setNumberOfESPB(int numberOfESPB) {
		this.numberOfESPB = numberOfESPB;
	}

	public ArrayList<Student> getStudentsWhoHavePassedTheExam() {
		return studentsWhoHavePassedTheExam;
	}

	public void setStudentsWhoHavePassedTheExam(ArrayList<Student> studentsWhoHavePassedTheExam) {
		this.studentsWhoHavePassedTheExam = studentsWhoHavePassedTheExam;
	}

	public ArrayList<Student> getStudentsWhoHaveNotPassedTheExam() {
		return studentsWhoHaveNotPassedTheExam;
	}

	public void setStudentsWhoHaveNotPassedTheExam(ArrayList<Student> studentsWhoHaveNotPassedTheExam) {
		this.studentsWhoHaveNotPassedTheExam = studentsWhoHaveNotPassedTheExam;
	}
	
	
}
