package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.CourseController;
import controller.DepartmentController;
import controller.ProfessorController;
import controller.StudentController;
import localization.Language;
import model.dataBase.CourseBase;
import model.dataBase.ProfessorBase;
import model.entities.Course;
import model.entities.Professor;
import view.window.MyMainFrame;
import view.window.MyTabbedPane;

public class MyActionListenerDeleteStudent implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(MyTabbedPane.getOpenTab()) {
		case 0:
			int rowSelected = MyTabbedPane.getInstance().getSt().getSelectedRow();
			StudentController.getInstance().deleteStudent(rowSelected);	
			break;
		case 1:
			int rowSelected1 = MyTabbedPane.getInstance().getPt().getSelectedRow();
			Professor p = ProfessorBase.getInstance().getRow(rowSelected1);
			
			if(DepartmentController.getInstance().bossValidation(p)) {
				JOptionPane.showMessageDialog(MyMainFrame.getInstance(), Language.getInstance().getResourceBundle().getString("professorValidation"));
				return;
			}
			ProfessorController.getInstance().deleteProfessor(rowSelected1);	
			for(Course c : p.getListOfSubjects()) {
				CourseController.getInstance().unlinkProfessorFromCourse(p, c);
			}
			break;
		case 2:
			int rowSelected2 = MyTabbedPane.getInstance().getCt().getSelectedRow();
			Course c = CourseBase.getInstance().getRow(rowSelected2);
			
			if(c.getSubjectProfessor() == null) {
				CourseController.getInstance().deletCourse(rowSelected2);
			}else {
				CourseController.getInstance().deletCourse(rowSelected2);
				ProfessorController.getInstance().unlinkCourseFromProfessor(c.getSubjectProfessor(), c);
			}
			
			break;
		}
	}
}
