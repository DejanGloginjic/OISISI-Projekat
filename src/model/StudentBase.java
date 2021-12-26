package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import enumerations.Status;
import model.Student;

public class StudentBase {
	
	private static StudentBase instance = null;

	public static StudentBase getInstance() {
		if (instance == null) {
			instance = new StudentBase();
		}
		return instance;
	}
	
	private List<Student> studentList;
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
		this.studentList = new ArrayList<>();
		
		Adress adresa1 = new Adress("Sportska ulica", 12, "Novi Sad", "Srbija");
		studentList.add(new Student("Nikoliæ", "Nikola", LocalDate.of(1997, 1, 1), adresa1, 111, "nikola@hotmail.com", "ra-178-2016", 2016, 1, Status.B, 9.15, null, null));
		Adress adresa2 = new Adress("Strazilovska", 2, "Novi Sad", "Srbija");
		studentList.add(new Student("Lukiæ", "Luka", LocalDate.of(1997, 2, 2), adresa2, 222, "luka@hotmail.com", "ra-102-2016", 2016, 4, Status.B, 8.25, null, null));
		Adress adresa3 = new Adress("Ulica kralja Petra", 16, "Novi Sad", "Srbija");
		studentList.add(new Student("Miniæ", "Mina", LocalDate.of(1995, 8, 12), adresa3, 333, "mina@hotmail.com", "sw-25-2014", 2014, 1, Status.S, 7.80, null, null));
		Adress adresa4 = new Adress("Bulevar oslobodjenja", 6, "Novi Sad", "Srbija");
		studentList.add(new Student("Markoviæ", "Marko", LocalDate.of(1999, 4, 9), adresa4, 444, "marko@hotmail.com", "sw-10-2018", 2018, 2, Status.B, 9.25, null, null));
		
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
	
}
