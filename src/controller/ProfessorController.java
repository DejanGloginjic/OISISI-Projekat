package controller;

import model.Professor;
import view.MyTabbedPane;
import model.ProfessorBase;

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
}
