package controller;

import java.util.List;

import model.dataBase.StudentBase;
import model.entities.Course;
import model.entities.Grade;
import model.entities.Student;
import view.panels.MyPanelRemainingExams;
import view.window.MyTabbedPane;

public class StudentController {
	
	private static StudentController instance = null;
	
	public static StudentController getInstance() {
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}
	
	private StudentController() {}
	
	
	public void addStudent(Student s){
		StudentBase.getInstance().addStudent(s);
		MyTabbedPane.getInstance().updateViewStudent();
	}
	public void deleteStudent(int rowSelected){
		if(rowSelected < 0)
			return;
		Student s = StudentBase.getInstance().getRow(rowSelected);
		StudentBase.getInstance().deleteStudent(s);
		MyTabbedPane.getInstance().updateViewStudent();
	}
	
	public void editStudent(Student s) {
		StudentBase.getInstance().editStudent(s);
		MyTabbedPane.getInstance().updateViewStudent();
	}
	
	public Student getSelectedStudent() {
		return StudentBase.getInstance().getSelectedStudent();
	}
	
	public void addCourseToSelectedStudent(Course c) {
		StudentBase.getInstance().addCourseToSelectedStudent(c);
		MyPanelRemainingExams.getInstance().updateViewRemainingExams();
	}
	
	public Student findSelectedStudent() {
		return StudentBase.getInstance().findSelectedStudent();
	}
	
	public void deleteCourseToSelectedStudent(Course c) {
		StudentBase.getInstance().deleteCourseToSelectedStudent(c);
	}
	
	public Student findStudent(String index) {
		return StudentBase.getInstance().findStudent(index);
	} 
	
	public void addGradesToStudents(List<Grade> grades) {
		StudentBase.getInstance().addGradesToStudents(grades);
	}
	
	public void addCourseToStudent(Student student, Course course) {
		StudentBase.getInstance().addCourseToStudent(student, course);
	}
}
