package controller;

import model.dataBase.CourseBase;
import model.dataBase.PassedExamsBase;
import model.dataBase.RemainingExamsBase;
import model.entities.Course;
import view.panels.MyPanelRemainingExams;
import view.window.MyTabbedPane;

public class RemainingExamsController {

private static RemainingExamsController instance = null;
	
	public static RemainingExamsController getInstance() {
		if (instance == null) {
			instance = new RemainingExamsController();
		}
		return instance;
	}
	
	public RemainingExamsController() {}
	
	public void deletCourse(Course c){
		if (c==null) {
			return;
		}
		RemainingExamsBase.getInstance().deleteCourse(c.getCode());
		MyPanelRemainingExams.getInstance().updateViewRemainingExams();
	}
	
	public void addCourse(Course c){
		RemainingExamsBase.getInstance().addCourse(c);
		MyPanelRemainingExams.getInstance().updateViewRemainingExams();	
	}
}
