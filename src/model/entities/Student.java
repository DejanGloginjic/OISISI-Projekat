package model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import enumerations.Status;


public class Student implements Serializable{
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
	private List<Grade> passedExams;
	private List<String> remainingExams;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String surname, String name, LocalDate dateOfBirth, Adress residentialAddress, int telephoneNumber,
			String eMail, String indexNumber, int yearOfEnrollment, int currentYearOfStudy, Status status,List<Grade> passedExams,
				List<String> remainingExams) {
		super();
		this.surname = surname;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.residentialAddress = residentialAddress;
		this.telephoneNumber = telephoneNumber;
		this.eMail = eMail;
		this.indexNumber = indexNumber;
		this.yearOfEnrollment = yearOfEnrollment;
		this.currentYearOfStudy = currentYearOfStudy;
		this.status = status;
		this.passedExams = passedExams;
		this.remainingExams = remainingExams;
		
		int total = 0;
		int i = 0;
		for(Grade g : passedExams) {
			i++;
			total += g.getValue();
		}
		
		if(i != 0) {
			double avg = total / i;
			this.averageGrade = avg;
		}
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Adress getResidentialAddress() {
		return residentialAddress;
	}

	public void setResidentialAddress(Adress residentialAddress) {
		this.residentialAddress = residentialAddress;
	}

	public int getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(int telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getIndexNumber() {
		return indexNumber;
	}

	public void setIndexNumber(String indexNumber) {
		this.indexNumber = indexNumber;
	}

	public int getYearOfEnrollment() {
		return yearOfEnrollment;
	}

	public void setYearOfEnrollment(int yearOfEnrollment) {
		this.yearOfEnrollment = yearOfEnrollment;
	}

	public int getCurrentYearOfStudy() {
		return currentYearOfStudy;
	}

	public void setCurrentYearOfStudy(int currentYearOfStudy) {
		this.currentYearOfStudy = currentYearOfStudy;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}

	public List<Grade> getPassedExams() {
		return passedExams;
	}

	public void setPassedExams(ArrayList<Grade> passedExams) {
		this.passedExams = passedExams;
	}

	public List<String> getRemainingExams() {
		return remainingExams;
	}

	public void setRemainingExams(ArrayList<String> remainingExams) {
		this.remainingExams = remainingExams;
	}
	
	public static Status budget() {
		return Status.B;
	}
	
	public static Status selffinancing() {
		return Status.S;
	}

	@Override
	public String toString() {
		return "Student [surname=" + surname + ", name=" + name + ", dateOfBirth=" + dateOfBirth
				+ ", residentialAddress=" + residentialAddress + ", telephoneNumber=" + telephoneNumber + ", eMail="
				+ eMail + ", indexNumber=" + indexNumber + ", yearOfEnrollment=" + yearOfEnrollment
				+ ", currentYearOfStudy=" + currentYearOfStudy + ", status=" + status + ", averageGrade=" + averageGrade
				+ ", passedExams=" + passedExams + ", remainingExams=" + remainingExams + "]";
	}
	
}
