package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.dataBase.DepartmentBase;
import model.dataBase.PassedExamsBase;
import model.dataBase.ProfessorBase;
import model.dataBase.StudentBase;
import model.entities.Department;
import model.entities.Professor;
import model.entities.Student;
import view.dialogs.AddBossOfDepartmentDialog;
import view.dialogs.DepartmentDialog;
import view.window.MyTabbedPane;

public class MyActionListenerAddBossOfDepartment implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int rowSelected = DepartmentDialog.getInstance().getTable().getSelectedRow();
		Department dep = DepartmentBase.getInstance().getRow(rowSelected);
		
		AddBossOfDepartmentDialog.getInstance().setVisible(true);
		
	}

}
