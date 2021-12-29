package main;

import java.awt.BorderLayout;

import controller.ProfessorController;
import model.ProfessorBase;
import model.Student;
import model.StudentBase;
import view.MyMainFrame;

public class MyApp {

	public static void main(String[] args) {
	
		MyMainFrame mf = MyMainFrame.getInstance();
		StudentBase sb = StudentBase.getInstance();
		ProfessorBase pb = ProfessorBase.getInstance();
		ProfessorController pc = ProfessorController.getInstance();
	}

}
