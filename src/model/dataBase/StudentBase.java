package model.dataBase;

import java.util.ArrayList;
import java.util.List;


import localization.Language;
import model.entities.Course;
import model.entities.Grade;
import model.entities.Student;
import view.window.MyTabbedPane;

public class StudentBase {
	
	private static StudentBase instance = null;

	public static StudentBase getInstance(){
		if (instance == null) {
			instance = new StudentBase();
		}
		return instance;
	}
	
	private List<Student> studentList = new ArrayList<>();
	private List<Student> studentListForSearch = new ArrayList<>();
	private List<String> columnList;
	
	private Student selectedStudent = new Student();

	private StudentBase(){
		
		columnList = new ArrayList<>();
		this.getColumnList().add(Language.getInstance().getResourceBundle().getString("index"));
		this.getColumnList().add(Language.getInstance().getResourceBundle().getString("nameT"));
		this.getColumnList().add(Language.getInstance().getResourceBundle().getString("surnameT"));
		this.getColumnList().add(Language.getInstance().getResourceBundle().getString("currentYearT"));
		this.getColumnList().add("Status");
		this.getColumnList().add(Language.getInstance().getResourceBundle().getString("averageGrade"));
	}
	
	

	public List<Student> getStudentList() {
		return studentList;
	}
	
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
		MyTabbedPane.getInstance().updateViewStudent();
	}
	
	public void setStudentListForSearch(List<Student> studentList) {
		this.studentListForSearch = studentList;
	}
	
	public List<Student> getStudentListForSearch() {
		return this.studentListForSearch;
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
		studentListForSearch = studentList;
	}
	
	public void deleteStudent(Student student) {
		for(Student m : this.studentList) {
			if(m.getIndexNumber().equals(student.getIndexNumber())) {
				this.studentList.remove(m);
				break;
			}
		}
		studentListForSearch = studentList;
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
		studentListForSearch = studentList;
	}
	
	public Student getSelectedStudent() {
		int rowSelected1 = MyTabbedPane.getInstance().getSt().getSelectedRow();
		Student s = StudentBase.getInstance().getRow(rowSelected1);
		return s;
	}
	
	public void addCourseToSelectedStudent(Course c) {
		Student s = selectedStudent;
		for(Student st : this.studentList) {
			if(st.getIndexNumber().equals(s.getIndexNumber())) {
				st.getRemainingExams().add(c);
				break;
			}
		}
	}

	public Student findSelectedStudent() {
		return selectedStudent;
	}

	public void setSelectedStudent(Student s) {
		this.selectedStudent = s;
	}
	
	public void deleteCourseToSelectedStudent(Course c) {
		Student s = getSelectedStudent();
		for(Student st : this.studentList) {
			if(st.getIndexNumber().equals(s.getIndexNumber())) {
				st.getRemainingExams().remove(c);
				break;
			}
		}
	}
	
	public Student findStudent(String index) {
		Student s = new Student();
		for(int i = 0; i < this.studentList.size(); i++) {
			if(this.studentList.get(i).getIndexNumber().equals(index)) {
				s = this.studentList.get(i);
			}
		}
		return s;
	}
	
	public void addGradesToStudents(List<Grade> grades){
		for(Student student : this.studentList){
			for(int i = 0; i < grades.size(); i++){
				if(student.getIndexNumber().equals(grades.get(i).getStudent().getIndexNumber())) {
					student.getPassedExams().add(grades.get(i));
				}
			}
		}
	}
	
	public void addCourseToStudent(Student student, Course course) {
		for(Student s : this.studentList) {
			if(s.getIndexNumber().equals(student.getIndexNumber())) {
				s.getRemainingExams().add(course);
				break;
			}
		}
	}
	
	public void addPassedExamsToStudent(Student student, Grade grade) {
		for(Student s : this.studentList) {
			if(s.getIndexNumber().equals(student.getIndexNumber())) {
				s.getPassedExams().add(grade);
				break;
			}
		}
	}
	
	public void updateComponent() {
		this.columnList.clear();
		this.getColumnList().add(Language.getInstance().getResourceBundle().getString("index"));
		this.getColumnList().add(Language.getInstance().getResourceBundle().getString("nameT"));
		this.getColumnList().add(Language.getInstance().getResourceBundle().getString("surnameT"));
		this.getColumnList().add(Language.getInstance().getResourceBundle().getString("currentYearT"));
		this.getColumnList().add("Status");
		this.getColumnList().add(Language.getInstance().getResourceBundle().getString("averageGrade"));
		MyTabbedPane.getInstance().updateViewStudent();
	}
}
