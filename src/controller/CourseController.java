package controller;

import model.dataBase.CourseBase;
import model.dataBase.StudentBase;
import model.entities.Course;
import model.entities.Student;
import view.window.MyTabbedPane;

public class CourseController {

	private static CourseController instance = null;
	
	public static CourseController getInstance() {
		if (instance == null) {
			instance = new CourseController();
		}
		return instance;
	}

	public CourseController() {}
	
	public void addCourse(Course c){
		CourseBase.getInstance().addCourse(c);
		MyTabbedPane.getInstance().updateViewCourse();
	}
	
	public void deletCourse(int rowSelected){
		if(rowSelected < 0)
			return;
		Course c = CourseBase.getInstance().getRow(rowSelected);
		CourseBase.getInstance().deleteCourse(c.getCode());
		MyTabbedPane.getInstance().updateViewCourse();
	}
	
	public void editCourse(Course c) {
		CourseBase.getInstance().editCourse(c);
		MyTabbedPane.getInstance().updateViewCourse();
	}
	
	public Course findCourseByCode(String code) {
		return CourseBase.getInstance().findCourseByCode(code);
	}
	
	public void addStudentToCourse(Course c) {
		CourseBase.getInstance().addStudentToCourse(c);
	}
}
