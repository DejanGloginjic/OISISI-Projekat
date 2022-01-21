package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.GradeController;
import controller.RemainingExamsController;
import model.dataBase.PassedExamsBase;
import model.dataBase.RemainingExamsBase;
import model.dataBase.StudentBase;
import model.entities.Course;
import model.entities.Grade;
import model.entities.Student;
import view.dialogs.EditProfessorDialog;
import view.dialogs.EditStudentDialog;
import view.panels.MyPanelPassedExams;
import view.panels.MyPanelProfessorCourses;
import view.window.MyTabbedPane;

public class MyActionListenerUndoGrade implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int rowSelected = MyPanelPassedExams.getInstance().getTable().getSelectedRow();
		if(rowSelected < 0)
			return;
		int dialogResult = JOptionPane.showConfirmDialog(EditStudentDialog.getInstance(), "Da li ste sigurni?", "Poništi ocenu", JOptionPane.YES_NO_OPTION);
		if(dialogResult == JOptionPane.YES_OPTION){
			int rowSelected1 = MyPanelPassedExams.getInstance().getTable().getSelectedRow();
			if(rowSelected1 < 0)
				return;
			Grade g = PassedExamsBase.getInstance().getRow(rowSelected);
		
			RemainingExamsController.getInstance().addCourse(g.getCourse());
			GradeController.getInstance().deletGrade(g);
		
		}
	}

}
