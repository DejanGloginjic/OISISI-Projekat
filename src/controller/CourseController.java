package controller;

import model.dataBase.CourseBase;
import model.entities.Course;
import view.window.MyTabbedPane;

public class CourseController {

	private static CourseController instance = null;
	
	public static CourseController getInstance() {
		if (instance == null) {
			instance = new CourseController();
		}
		return instance;
	}

	public CourseController() {

	}
	
	public void deletCourse(int rowSelected){
		if(rowSelected < 0)
			return;
		Course c = CourseBase.getInstance().getRow(rowSelected);
		CourseBase.getInstance().deleteCourse(c.getCode());
		MyTabbedPane.getInstance().updateViewCourse();
	}
}
