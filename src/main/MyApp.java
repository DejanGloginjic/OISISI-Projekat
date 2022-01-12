package main;

import controller.CourseController;
import controller.ProfessorController;
import model.dataBase.CourseBase;
import model.dataBase.ProfessorBase;
import model.dataBase.StudentBase;
import view.window.MyMainFrame;

public class MyApp {

	public static void main(String[] args) throws Exception{
	
		MyMainFrame mf = MyMainFrame.getInstance();
		StudentBase sb = StudentBase.getInstance();
		ProfessorBase pb = ProfessorBase.getInstance();
		CourseBase cb = CourseBase.getInstance();
	}

}
