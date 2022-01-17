package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.dataBase.CourseBase;
import view.dialogs.AddCourseToProfessorDialog;

public class MyActionListenerAddCourseToProfesor implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		AddCourseToProfessorDialog.getInstance().setVisible(true);
		
	}

}
