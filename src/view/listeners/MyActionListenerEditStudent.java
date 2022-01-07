package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.dialogs.AddProfessorDialog;
import view.dialogs.AddStudentDialog;
import view.dialogs.EditStudentDialog;
import view.window.MyTabbedPane;

public class MyActionListenerEditStudent implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(MyTabbedPane.getOpenTab()) {
		case 0:
			EditStudentDialog esd = EditStudentDialog.getInstance();
			esd.setVisible(true);
			break;			
		}
	}
}
