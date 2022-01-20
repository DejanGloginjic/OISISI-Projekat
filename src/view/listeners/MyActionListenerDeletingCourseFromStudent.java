package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.CourseController;
import controller.RemainingExamsController;
import controller.StudentController;
import model.dataBase.CourseBase;
import model.dataBase.RemainingExamsBase;
import model.entities.Course;
import view.dialogs.EditProfessorDialog;
import view.dialogs.EditStudentDialog;
import view.panels.MyPanelRemainingExams;

public class MyActionListenerDeletingCourseFromStudent implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		int dialogResult = JOptionPane.showConfirmDialog(EditStudentDialog.getInstance(), "Da li ste sigurni da želite da uklonite predmet?", "Uklanjenje predmeta", JOptionPane.YES_NO_OPTION);
		if(dialogResult == JOptionPane.YES_OPTION){
			int rowSelected = MyPanelRemainingExams.getInstance().getTable().getSelectedRow();
			Course c = RemainingExamsBase.getInstance().getRow(rowSelected);
			
			if(rowSelected < 0) {
				return;
			}
			
			RemainingExamsController.getInstance().deletCourse(c);
			StudentController.getInstance().deleteCourseToSelectedStudent(c);
			CourseController.getInstance().deleteStudentFromCourse(c);
		}
	}

}
