package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.dialogs.DepartmentDialog;

public class MyActionListenerDepartmentDialog implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		DepartmentDialog.getInstance().setVisible(true);
		
	}

}
