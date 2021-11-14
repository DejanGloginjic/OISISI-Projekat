package entity;

import java.time.LocalDate;
import java.util.ArrayList;

enum Status{B, S};

public class Student {
	private String surname;
	private String name;
	private LocalDate dateOfBirth;
	private Adress residentialAddress;
	private int telephoneNumber;
	private String eMail;
	private String indexNumber;
	private int yearOfEnrollment;
	private int currentYearOfStudy;
	private Status status;
	private double averageGrade;
	private ArrayList<Grade> passedExams;
	private ArrayList<String> remainingExams;
}
