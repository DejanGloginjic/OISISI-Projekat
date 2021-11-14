package entity;

import java.util.ArrayList;

enum Semester {SUMMER, WINTER};

public class Course {
	private int code;
	private String name;
	private Semester semester;
	private int yearOfTheCourse;
	private Professor subjectProfessor;
	private int numberOfESPB;
	private ArrayList<Student> studentsWhoHavePassedTheExam;
	private ArrayList<Student> studentsWhoHaveNotPassedTheExam;
}
