package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Professor {
 private String surname;
 private String name;
 private LocalDate dateOfBirth;
 private Adress residentialAddress;
 private String telephoneNumber;
 private String eMail;
 private Adress officeAddress;
 private String IdNumber;
 private String title;
 private int yearOfTrail;
 private List<Course> listOfSubjects;
 
public Professor() {
	super();
	// TODO Auto-generated constructor stub
}



public Professor(String surname, String name, LocalDate dateOfBirth, Adress residentialAddress, String telephoneNumber,
		String eMail, Adress officeAddress, String idNumber, String title, int yearOfTrail) {
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
}



public Professor(String surname, String name, LocalDate dateOfBirth, Adress residentialAddress, String telephoneNumber,
		String eMail, Adress officeAddress, String idNumber, String title, int yearOfTrail,
		List<Course> listOfSubjects) {
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

public String getTelephoneNumber() {
	return telephoneNumber;
}

public void setTelephoneNumber(String telephoneNumber) {
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

public List<Course> getListOfSubjects() {
	return listOfSubjects;
}

public void setListOfSubjects(List<Course> courseList) {
	this.listOfSubjects = courseList;
}

@Override
public String toString() {
	return IdNumber + " " + name + " " + surname;
}
//Obradovic,Branimir,1979-01-07,Safarikova#2#Novi Sad#Srbija,021/922-333,branimir.obradovic@mailinator.com,Nikole Pasica#6a#Novi Sad#Srbija,600600644,DOCENT,17
public String toStringForDataBaseWriter() {
	return surname + ", " + name + ", " + dateOfBirth + ", " + residentialAddress + ", " + telephoneNumber + ", " + eMail + ", " + officeAddress + ", " + IdNumber + ", " + title + ", " + yearOfTrail;
}

}
