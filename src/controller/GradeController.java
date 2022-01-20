package controller;

import model.dataBase.CourseBase;
import model.dataBase.PassedExamsBase;
import model.entities.Course;
import model.entities.Grade;
import view.panels.MyPanelPassedExams;
import view.window.MyTabbedPane;

public class GradeController {

	
	private static GradeController instance = null;
	
	public static GradeController getInstance() {
		if (instance == null) {
			instance = new GradeController();
		}
		return instance;
	}

	public GradeController() {}
	
	public void deletGrade(Grade g){
		PassedExamsBase.getInstance().deleteGrade(g.getCourse().getCode());
		MyPanelPassedExams.getInstance().updateViewPassedExams();
	}
	
}
