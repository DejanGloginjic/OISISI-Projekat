package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import model.dataBase.CourseBase;
import model.dataBase.ProfessorBase;
import model.entities.Course;
import model.entities.Professor;
import view.dialogs.EditCourseDialog;
import view.window.MyTabbedPane;

public class MyActionListenerDeleteProfessorFromCourse implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {


		int rowSelected = MyTabbedPane.getInstance().getCt().getSelectedRow();
		Course c = CourseBase.getInstance().getRow(rowSelected);
		
		String string = EditCourseDialog.getInstance().getSubjectProfessorText().getText(); 
		
		String[] words = string.split(" ");
		String idNum = words[0];
		String name = words[1];
		String surname = words[2];
		
		Professor professor = ProfessorBase.getInstance().findByIdNum(idNum);
		c.setSubjectProfessor(null);
		ProfessorBase.getInstance().removeFromCourseList(c, professor);
		EditCourseDialog.getInstance().getSubjectProfessorText().setText("-");
	}

}
