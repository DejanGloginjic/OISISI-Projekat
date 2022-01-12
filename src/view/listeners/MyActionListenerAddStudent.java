package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.dialogs.AddCourseDialog;
import view.dialogs.AddProfessorDialog;
import view.dialogs.AddStudentDialog;
import view.window.MyTabbedPane;

public class MyActionListenerAddStudent implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(MyTabbedPane.getOpenTab()) {
		case 0:
			AddStudentDialog sd = AddStudentDialog.getInstance();
			sd.setVisible(true);
			break;
		case 1:
			AddProfessorDialog pd = AddProfessorDialog.getInstance();
			pd.setVisible(true);
			break;
		case 2:
			AddCourseDialog cd = AddCourseDialog.getInstance();
			cd.setVisible(true);
			break;
		}
		
	}
}
