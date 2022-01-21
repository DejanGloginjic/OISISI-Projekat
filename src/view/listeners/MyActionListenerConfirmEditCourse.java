package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.CourseController;
import controller.ProfessorController;
import enumerations.Semester;
import model.dataBase.CourseBase;
import model.entities.Course;
import model.entities.Professor;
import view.dialogs.EditCourseDialog;
import view.window.MyTabbedPaneStudentEdit;

public class MyActionListenerConfirmEditCourse implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String code = EditCourseDialog.getInstance().getCodeText().getText();
		String name = EditCourseDialog.getInstance().getNameText().getText();
		Semester s = EditCourseDialog.getInstance().getSemester().getSelectedItem() == "SUMMER" ? Semester.SUMMER : Semester.WINTER;
		
		int year = 0;
		switch(EditCourseDialog.getInstance().getYearOfTheCourse().getSelectedItem().toString()) {
		case "I (prva)":
			year = 1;
			break;
		case "II (druga)":
			year = 2;
			break;
		case "III (treća)":
			year = 3;
			break;
		case "IV (četvrta)":
			year = 4;
			break;
		case "V (peta)":
			year = 5;
			break;
		case "VI (šesta)":
			year = 6;
			break;
		}
		
		int espb = Integer.parseInt(EditCourseDialog.getInstance().getNumberOfESPBText().getText());
		String[] words = EditCourseDialog.getInstance().getSubjectProfessorText().getText().split(" ");
		String id =  words[0];
		Professor p = ProfessorController.getInstance().findProfessor(id);
		
		
		Course c = new Course(code, name, s, year, p, espb);
		//CourseBase.getInstance().addSelectedProfessorToCourse(c);
		CourseController.getInstance().editCourse(c);
		
		EditCourseDialog.getInstance().setVisible(false);
		
	}

}
