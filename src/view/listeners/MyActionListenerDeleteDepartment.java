package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.DepartmentController;
import model.dataBase.DepartmentBase;
import model.entities.Department;
import view.dialogs.DepartmentDialog;

public class MyActionListenerDeleteDepartment implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int rowSelected = DepartmentDialog.getInstance().getTable().getSelectedRow();
		Department d = DepartmentBase.getInstance().getRow(rowSelected);
		
		DepartmentController.getInstance().deleteDepartment(d);
	}

}
