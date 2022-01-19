package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.dataBase.CourseBase;
import model.dataBase.ProfessorBase;
import model.entities.Course;
import model.entities.Professor;
import view.dialogs.AddProfessorToCourseDialog;
import view.dialogs.EditCourseDialog;
import view.window.MyTabbedPane;

public class MyActionListenerConfirmAddProfessorToCourse implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String string = (String) AddProfessorToCourseDialog.getInstance().getProfessorList().getSelectedValue();
		
		if (string == null) {
			return;
		}
		
		String[] words = string.split(" ");
		String idNum = words[0];
		String name = words[1];
		String surname = words[2];
		
		int rowSelected = MyTabbedPane.getInstance().getCt().getSelectedRow();
		Course c = CourseBase.getInstance().getRow(rowSelected);
		
		Professor professor = ProfessorBase.getInstance().findByIdNum(idNum);
		c.setSubjectProfessor(professor);
		ProfessorBase.getInstance().addToCourseList(c,professor);
		
		EditCourseDialog.getInstance().getSubjectProfessorText().setText(professor.toString());
		
		AddProfessorToCourseDialog.getInstance().setVisible(false);
	}
	
}
