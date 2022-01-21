package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import controller.CourseController;
import controller.ProfessorCoursesController;
import model.dataBase.ProfesorCoursesBase;
import model.dataBase.ProfessorBase;
import model.entities.Course;
import model.entities.Professor;
import view.dialogs.EditProfessorDialog;
import view.panels.MyPanelProfessorCourses;
import view.window.MyTabbedPane;

public class MyActionListenerDeleteCourseFromProfessor implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int dialogResult = JOptionPane.showConfirmDialog(EditProfessorDialog.getInstance(), "Da li ste sigurni?", "Ukloni predmet", JOptionPane.YES_NO_OPTION);
		if(dialogResult == JOptionPane.YES_OPTION){
			int[] rowsSelected = MyPanelProfessorCourses.getInstance().getTable().getSelectedRows();
			if(rowsSelected.length == 0)
				return;
			
			for(int i = rowsSelected.length - 1; i >= 0; i--) {
				Course c = ProfesorCoursesBase.getInstance().getRow(rowsSelected[i]);
				ProfessorCoursesController.getInstance().deleteProfessorCourse(c);
				CourseController.getInstance().removeSelectedProfessorFromCourse(c);
			}
			
			int rowSelected1 = MyTabbedPane.getInstance().getPt().getSelectedRow();
			Professor p = ProfessorBase.getInstance().getRow(rowSelected1);
			List<Course> courseList = ProfesorCoursesBase.getInstance().getCourseList();
			p.setListOfSubjects(courseList);
			ProfessorBase.getInstance().setProfesorCoursesAfterRemovingCourse(p);
			
		}
	}

}
