package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.DepartmentController;
import controller.ProfessorController;
import model.dataBase.DepartmentBase;
import model.entities.Department;
import model.entities.Professor;
import view.dialogs.AddBossOfDepartmentDialog;
import view.dialogs.AddDepartmentDialog;
import view.dialogs.DepartmentDialog;

public class MyActionListenerConfirmAddBossOfDepartment implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String word = AddBossOfDepartmentDialog.getInstance().getBossId().getSelectedItem().toString();
		String[] words = word.split(" ");
		int bossId = Integer.parseInt(words[0]);
		
		int rowSelected = DepartmentDialog.getInstance().getTable().getSelectedRow();
		Department dep = DepartmentBase.getInstance().getRow(rowSelected);
		
		String code = dep.getCode();
		Professor p = ProfessorController.getInstance().findProfessor(String.valueOf(bossId));
		if(DepartmentController.getInstance().bossValidation(p)) {
			JOptionPane.showMessageDialog(AddBossOfDepartmentDialog.getInstance(), "Izabrani profesor je šef druge katedre, izaberite drugog profesora!");
			return;
		}
		
		DepartmentController.getInstance().setBossOfDepartment(code, bossId);
		
		AddBossOfDepartmentDialog.getInstance().setVisible(false);
	}

}
