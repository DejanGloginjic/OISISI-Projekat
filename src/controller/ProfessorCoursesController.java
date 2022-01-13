package controller;

import model.dataBase.ProfesorCoursesBase;
import model.dataBase.StudentBase;
import model.entities.Course;
import model.entities.Student;
import view.panels.MyPanelProfessorCourses;
import view.window.MyTabbedPane;

public class ProfessorCoursesController {

	private static ProfessorCoursesController instance = null;
	
	public static ProfessorCoursesController getInstance() {
		if (instance == null) {
			instance = new ProfessorCoursesController();
		}
		return instance;
	}
	
	private ProfessorCoursesController() {}
	
	public void deleteProfessorCourse(Course c){
		ProfesorCoursesBase.getInstance().deleteProfessorCourse(c);;
		MyPanelProfessorCourses.getInstance().updateViewProfessorCourses();
	}
}
