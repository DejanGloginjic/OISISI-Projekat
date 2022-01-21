package controller;

import java.util.List;

import model.dataBase.ProfessorBase;
import model.dataBase.StudentBase;
import model.entities.Course;
import model.entities.Professor;
import model.entities.Student;
import view.panels.MyPanelProfessorCourses;
import view.window.MyTabbedPane;

public class ProfessorController {
	
	private static ProfessorController instance = null;
	
	public static ProfessorController getInstance() {
		if (instance == null) {
			instance = new ProfessorController();
		}
		return instance;
	}
	private ProfessorController() {
	
	}
	public void addProfessor(Professor p) {
		ProfessorBase.getInstance().addProfessor(p);
		MyTabbedPane.getInstance().updateViewProfessor();
	}
	public void deleteProfessor(int rowSelected1){
		if(rowSelected1 < 0)
			return;
		Professor p = ProfessorBase.getInstance().getRow(rowSelected1);
		ProfessorBase.getInstance().deleteProfessor(p.getIdNumber());
		MyTabbedPane.getInstance().updateViewProfessor();
	}
	public void editProfessor(Professor p) {
		ProfessorBase.getInstance().editProfessor(p);
		MyTabbedPane.getInstance().updateViewProfessor();
	}
	
	public void addCourseToSelectedProfessor(Course c) {
		ProfessorBase.getInstance().addCourseToSelectedProfessor(c);
		MyPanelProfessorCourses.getInstance().updateViewProfessorCourses();
	}
	
	public Professor findProfessor(String id) {
		return ProfessorBase.getInstance().findProfessor(id);
	}
	
	public List<Professor> findProfessorThatSuitDepartments(){
		return ProfessorBase.getInstance().findProfessorThatSuitDepartments();
	}
	
	public void linkCourseToProfessor(Professor p, Course c) {
		ProfessorBase.getInstance().linkCourseToProfessor(p, c);
	}
	
	public void unlinkCourseFromProfessor(Professor p, Course c) {
		ProfessorController.getInstance().unlinkCourseFromProfessor(p, c);
	}
}
