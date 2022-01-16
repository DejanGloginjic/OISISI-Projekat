package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.dialogs.AddCourseToStudentDialog;

public class MyActionListenerAddCourseToStudent implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		AddCourseToStudentDialog.getInstance().setVisible(true);
	}

}
