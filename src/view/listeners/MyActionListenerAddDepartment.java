package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.dialogs.AddDepartmentDialog;

public class MyActionListenerAddDepartment implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		AddDepartmentDialog.getInstance().setVisible(true);
		
	}

}
