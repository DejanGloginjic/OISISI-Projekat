package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import controller.CourseController;
import enumerations.Semester;
import model.entities.Course;
import model.entities.Professor;
import model.entities.Student;
import view.dialogs.AddCourseDialog;
import view.dialogs.AddStudentDialog;

public class MyActionListenerConfirmCourse implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String code = AddCourseDialog.getInstance().getCodeText().getText();
		String name = AddCourseDialog.getInstance().getNameText().getText();
		Semester semester = Semester.SUMMER;
		switch(AddCourseDialog.getInstance().getSemester().getSelectedItem().toString()) {
		case "Ljeto":
			semester = Semester.SUMMER;
			break;
		case "Zima":
			semester = Semester.WINTER;
			break;
		}
		
		int yearOfTheCourse = 0;
		switch(AddCourseDialog.getInstance().getSemester().getSelectedItem().toString()) {
		case "I (prva)":
			yearOfTheCourse = 1;
			break;
		case "II (druga)":
			yearOfTheCourse = 2;
			break;
		case "III (treća)":
			yearOfTheCourse = 3;
			break;
		case "IV (četvrta)":
			yearOfTheCourse = 4;
			break;
		case "V (peta)":
			yearOfTheCourse = 5;
			break;
		case "VI (šesta)":
			yearOfTheCourse = 6;
			break;
		}
		
		int espb = Integer.parseInt(AddCourseDialog.getInstance().getNumberOfESPBText().getText());
		Professor p = new Professor();
		
		Course course = new Course(code, name, semester, yearOfTheCourse, p, espb, null, null);
		
		CourseController.getInstance().addCourse(course);
		
		AddCourseDialog.getInstance().getCodeText().setText("");
		AddCourseDialog.getInstance().getNameText().setText("");
		AddCourseDialog.getInstance().getNumberOfESPBText().setText("");
		
		AddCourseDialog.getInstance().setVisible(false);
	}

}
