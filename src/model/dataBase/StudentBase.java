package model.dataBase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.entities.Adress;
import model.entities.Grade;
import model.entities.Student;

public class StudentBase {
	
	private static StudentBase instance = null;

	public static StudentBase getInstance(){
		if (instance == null) {
			instance = new StudentBase();
		}
		return instance;
	}
	
	private List<Student> studentList = new ArrayList<>();
	private List<String> columnList;

	private StudentBase(){
		initStudents();
		
		columnList = new ArrayList<>();
		this.getColumnList().add("Indeks");
		this.getColumnList().add("Ime");
		this.getColumnList().add("Prezime");
		this.getColumnList().add("Godina studija");
		this.getColumnList().add("Status");
		this.getColumnList().add("Prosjek");
	}
	
	private void initStudents() {
		Adress a1 = new Adress("Sportska", 2, "Mkronjic Grad", "BiH");
		LocalDate date = LocalDate.of(2020, 1, 8);
		List<Grade> g1 = new ArrayList<>();
		Student s1 = new Student("Gloginjic", "Dejan", date, a1, 2, "deki555@hotmail.com", "ra-241-2020", 2019, 2, enumerations.Status.B, 7, g1, null);
		
		Adress a2 = new Adress("Sportska", 2, "Mkronjic Grad", "BiH");
		LocalDate date1 = LocalDate.of(2020, 1, 8);
		Student s2 = new Student("Antic", "Tamara", date1, a1, 2, "tamara555@hotmail.com", "sw-1-2019", 2019, 2, enumerations.Status.B, 8, g1, null);
		
		Adress a3 = new Adress("Sportska", 2, "Mkronjic Grad", "BiH");
		Student s3 = new Student("Tesanovic", "Ivana", date1, a1, 2, "ivana555@hotmail.com", "ra-24-2020", 2019, 2, enumerations.Status.B, 9, g1, null);
		
		Adress a4 = new Adress("Sportska", 2, "Mkronjic Grad", "BiH");
		Student s4 = new Student("Boskic", "Slavko", date1, a1, 2, "ivana555@hotmail.com", "ra-2-2020", 2019, 2, enumerations.Status.B, 10, g1, null);
		
		this.studentList.add(s1);
		this.studentList.add(s2);
		this.studentList.add(s3);
		this.studentList.add(s4);
	}
	
	public List<Student> getStudentList() {
		return studentList;
	}
	
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	public List<String> getColumnList() {
		return columnList;
	}
	
	public void setColumnList(List<String> columnList) {
		this.columnList = columnList;
	}
	
	public int getColumnCount() {
		return 6;
	}

	public String getColumnName(int index) {
		return this.columnList.get(index);
	}
	
	public Student getRow(int rowIndex) {
		return this.studentList.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
			
		Student student = this.studentList.get(row);
			
		switch (column) {
		case 0:
			return student.getIndexNumber();
		case 1:
			return student.getName();
		case 2:
			return student.getSurname();
		case 3:
			return Integer.toString(student.getCurrentYearOfStudy());
		case 4:
			switch(student.getStatus()) {
			case B:
				return "B";
			case S:
				return "S";
			}
		case 5:
			return Double.toString(student.getAverageGrade());
		default:
			return null;
		}
		
	}
	
	public void addStudent(Student student) {
		this.studentList.add(student);
	}
	
	public void deleteStudent(Student s) {
		for(Student student : studentList) {
			if(s.getIndexNumber().equals(student.getIndexNumber()))
				studentList.remove(s);
				break;
		}
	}
	

	
	public void editStudent(Student s) {
		for(Student student : this.studentList) {
			if(s.getIndexNumber().equals(student.getIndexNumber())) {
				student.setName(s.getName());
				student.setSurname(s.getSurname());
				student.setDateOfBirth(s.getDateOfBirth());
				student.getResidentialAddress().setCity(s.getResidentialAddress().getCity());
				student.getResidentialAddress().setCountry(s.getResidentialAddress().getCountry());
				student.getResidentialAddress().setNumber(s.getResidentialAddress().getNumber());
				student.getResidentialAddress().setStreet(s.getResidentialAddress().getStreet());
				student.setTelephoneNumber(s.getTelephoneNumber());
				student.seteMail(s.geteMail());
				student.setIndexNumber(s.getIndexNumber());
				student.setYearOfEnrollment(s.getYearOfEnrollment());
				student.setAverageGrade(s.getAverageGrade());
				student.setCurrentYearOfStudy(s.getCurrentYearOfStudy());
				student.setStatus(s.getStatus());
				break;
			}
		}
	}
}
