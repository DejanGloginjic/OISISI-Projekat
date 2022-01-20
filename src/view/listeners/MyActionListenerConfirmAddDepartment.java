package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.DepartmentController;
import controller.ProfessorController;
import model.entities.Department;
import model.entities.Professor;
import view.dialogs.AddBossOfDepartmentDialog;
import view.dialogs.AddDepartmentDialog;

public class MyActionListenerConfirmAddDepartment implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String code = AddDepartmentDialog.getInstance().getCodeText().getText();
		String name = AddDepartmentDialog.getInstance().getNameText().getText();
		String word = AddDepartmentDialog.getInstance().getBossId().getSelectedItem().toString();
		String[] words = word.split(" ");
		int bossId = Integer.parseInt(words[0]);
		List<Professor> professorList = new ArrayList<>();
		Professor p = ProfessorController.getInstance().findProfessor(String.valueOf(bossId));
		
		if(DepartmentController.getInstance().nameValidation(name)) {
			JOptionPane.showMessageDialog(AddDepartmentDialog.getInstance(), "Uneseno ime katedre već postoji, promjenite ime katedre!");
			return;
		}
		
		if(DepartmentController.getInstance().codeValidation(code)) {
			JOptionPane.showMessageDialog(AddDepartmentDialog.getInstance(), "Uneseni kod katedre već postoji, promjenite kod katedre!");
			return;
		}
		
		if(DepartmentController.getInstance().bossValidation(p)) {
			JOptionPane.showMessageDialog(AddDepartmentDialog.getInstance(), "Izabrani profesor je šef druge katedre, izaberite drugog profesora!");
			return;
		}
		
		Department dep = new Department(code, name, p, professorList);
		
		DepartmentController.getInstance().addDepartment(dep);
		
		AddDepartmentDialog.getInstance().setVisible(false);
		
		AddDepartmentDialog.getInstance().getCodeText().setText("");
		AddDepartmentDialog.getInstance().getNameText().setText("");
	}

}
