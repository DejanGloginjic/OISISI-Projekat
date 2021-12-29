package model.entities;

import java.io.Serializable;
import java.time.LocalDate;

public class Grade implements Serializable{
	private Student student;	//student who have passed the exam
	private Course course;		
	private int value;			//numerical value of the grade
	private LocalDate examDate;
}
