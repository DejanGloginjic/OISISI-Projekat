package controller;

import model.dataBase.ProfessorBase;
import model.entities.Professor;
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
}
