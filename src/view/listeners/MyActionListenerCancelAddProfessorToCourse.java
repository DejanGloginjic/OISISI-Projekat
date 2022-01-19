package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.dialogs.AddProfessorToCourseDialog;

public class MyActionListenerCancelAddProfessorToCourse implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		AddProfessorToCourseDialog.getInstance().setVisible(false);
		
	}

}
