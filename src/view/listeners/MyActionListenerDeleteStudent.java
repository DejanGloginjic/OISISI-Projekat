package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.CourseController;
import controller.ProfessorController;
import controller.StudentController;
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
			ProfessorController.getInstance().deleteProfessor(rowSelected1);	
			break;
		case 2:
			int rowSelected2 = MyTabbedPane.getInstance().getCt().getSelectedRow();
			CourseController.getInstance().deletCourse(rowSelected2);
			break;
		}
	}
}
