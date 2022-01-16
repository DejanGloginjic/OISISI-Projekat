package model.dataBase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import enumerations.Semester;
import model.entities.Adress;
import model.entities.Course;
import model.entities.Grade;
import model.entities.Professor;
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
		List<Grade> g3 = new ArrayList<>();
		List<Course> remainingExames = new ArrayList<>();
		
		Student s = new Student();
		
		Professor p1 = new Professor();
		Professor p2 = new Professor();
		
		Course c = new Course("1","Baze podataka",Semester.WINTER,3,p1,10,null,null);
		Course c1 = new Course("2","OISISI",Semester.WINTER,3,p2,8,null,null);
		Course cn1 = new Course("3","Operativni sistemi",Semester.SUMMER,4,p1,10,null,null);
		Course cn2 = new Course("4","Matematicka Analiza 2",Semester.WINTER,3,p1,10,null,null);
		
		Grade g2 = new Grade(s, c, 10, date);
		Grade g4 = new Grade(s, c1, 12, date);
		Grade gn1 = new Grade(s, cn1, 9, date);
		Grade gn2 = new Grade(s, cn2, 7, date);
		g1.add(g2);
		
		
		g3.add(g4);
		g1.add(g4);
		
		Course remc = new Course("7","Baze podataka 6",Semester.WINTER,3,p1,10,null,null);
		
		remainingExames.add(remc);
		
		Student s1 = new Student("Gloginjic", "Dejan", date, a1, 2, "deki555@hotmail.com", "ra-241-2020", 2019, 2, enumerations.Status.B, g1, remainingExames);
		
		Adress a2 = new Adress("Sportska", 2, "Mkronjic Grad", "BiH");
		LocalDate date1 = LocalDate.of(2020, 1, 8);
		Student s2 = new Student("Antic", "Tamara", date1, a1, 2, "tamara555@hotmail.com", "sw-1-2019", 2019, 2, enumerations.Status.B, g1, remainingExames);
		
		Adress a3 = new Adress("Sportska", 2, "Mkronjic Grad", "BiH");
		Student s3 = new Student("Tesanovic", "Ivana", date1, a1, 2, "ivana555@hotmail.com", "ra-24-2020", 2019, 2, enumerations.Status.B, g3, remainingExames);
		
		Adress a4 = new Adress("Sportska", 2, "Mkronjic Grad", "BiH");
		Student s4 = new Student("Boskic", "Slavko", date1, a1, 2, "ivana555@hotmail.com", "ra-2-2020", 2019, 2, enumerations.Status.B, g3, remainingExames);
		
		this.studentList.add(s1);
		this.studentList.add(s2);
		this.studentList.add(s3);
		this.studentList.add(s4);

		this.studentListForSearch.add(s1);
		this.studentListForSearch.add(s2);
		this.studentListForSearch.add(s3);
		this.studentListForSearch.add(s4);
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
		for(Student s : this.studentList) {
			if(s.getIndexNumber().equals(s.getIndexNumber()))
				this.studentList.remove(s);
				break;
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
			break;
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
	
}
