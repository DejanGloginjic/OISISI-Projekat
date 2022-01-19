package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.dataBase.CourseBase;
import model.dataBase.ProfessorBase;
import model.entities.Course;
import model.entities.Professor;
import view.dialogs.AddProfessorToCourseDialog;
import view.dialogs.EditCourseDialog;
import view.dialogs.EditProfessorDialog;
import view.window.MyTabbedPane;

public class MyActionListenerAddProfessorToCourse implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int rowSelected = MyTabbedPane.getInstance().getCt().getSelectedRow();
		Course c = CourseBase.getInstance().getRow(rowSelected);
		
		if (c.getSubjectProfessor() == null) {
			AddProfessorToCourseDialog.getInstance().setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "Profesor vec postoji na ovom predmetu.");
		}
		
			
	}

}
