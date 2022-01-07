package model.dataBase;

import java.util.ArrayList;
import java.util.List;

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
		
		
		columnList = new ArrayList<>();
		this.getColumnList().add("Indeks");
		this.getColumnList().add("Ime");
		this.getColumnList().add("Prezime");
		this.getColumnList().add("Godina studija");
		this.getColumnList().add("Status");
		this.getColumnList().add("Prosjek");
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
		/*try {	
			DatabaseWriterAndReader.getInstance().writeStudentToFile(this.studentList);
		}catch(Exception e) {
			e.printStackTrace();
		}*/
	}
	
	public void deleteStudent(String index) {
		for(Student s : studentList) {
			if(s.getIndexNumber().equals(index))
				studentList.remove(s);
				break;
		}
	}
	
	public void editStudent(Student s) {
		for(Student student : studentList) {
			if(student.getIndexNumber().equals(s.getIndexNumber())) {
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
			}
		}
	}
}
