package model;

import java.time.LocalDate;

public class Grade {
	private Student student;	//student who have passed the exam
	private Course course;		
	private int value;			//numerical value of the grade
	private LocalDate examDate;
}
