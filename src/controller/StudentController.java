package controller;

import model.dataBase.StudentBase;
import model.entities.Student;
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
		StudentBase.getInstance().deleteStudent(s.getIndexNumber());
		MyTabbedPane.getInstance().updateViewStudent();
	}
}