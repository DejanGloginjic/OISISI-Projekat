package controller;

import model.Student;
import model.StudentBase;
import view.MyTabbedPane;

public class StudentController {

	private MyTabbedPane mtp = new MyTabbedPane();
	
	private static StudentController instance = null;
	
	public static StudentController getInstance() {
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}
	
	private StudentController() {}
	
	
	public void addStudent(Student s) {
		StudentBase.getInstance().addStudent(s);
		mtp.updateViewStudent();
	}
}
