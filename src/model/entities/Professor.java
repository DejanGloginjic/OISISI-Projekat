package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;

public class Professor {
 private String surname;
 private String name;
 private LocalDate dateOfBirth;
 private Adress residentialAddress;
 private int telephoneNumber;
 private String eMail;
 private Adress officeAddress;
 private String IdNumber;
 private String title;
 private int yearOfTrail;
 private ArrayList<Course> listOfSubjects;
 
public Professor() {
	super();
	// TODO Auto-generated constructor stub
}

public Professor(String surname, String name, LocalDate dateOfBirth, Adress residentialAddress, int telephoneNumber,
		String eMail, Adress officeAddress, String idNumber, String title, int yearOfTrail,
		ArrayList<Course> listOfSubjects) {
	super();
	this.surname = surname;
	this.name = name;
	this.dateOfBirth = dateOfBirth;
	this.residentialAddress = residentialAddress;
	this.telephoneNumber = telephoneNumber;
	this.eMail = eMail;
	this.officeAddress = officeAddress;
	IdNumber = idNumber;
	this.title = title;
	this.yearOfTrail = yearOfTrail;
	this.listOfSubjects = listOfSubjects;
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

public Adress getOfficeAddress() {
	return officeAddress;
}

public void setOfficeAddress(Adress officeAddress) {
	this.officeAddress = officeAddress;
}

public String getIdNumber() {
	return IdNumber;
}

public void setIdNumber(String idNumber) {
	IdNumber = idNumber;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public int getYearOfTrail() {
	return yearOfTrail;
}

public void setYearOfTrail(int yearOfTrail) {
	this.yearOfTrail = yearOfTrail;
}

public ArrayList<Course> getListOfSubjects() {
	return listOfSubjects;
}

public void setListOfSubjects(ArrayList<Course> listOfSubjects) {
	this.listOfSubjects = listOfSubjects;
}

 
}
