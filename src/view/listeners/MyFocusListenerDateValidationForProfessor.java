package view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JOptionPane;

import view.dialogs.AddProfessorDialog;

public class MyFocusListenerDateValidationForProfessor implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		AddProfessorDialog.getInstance().getDateOfBirthText().setText("");
		AddProfessorDialog.getInstance().getDateOfBirthText().setForeground(Color.black);
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(!AddProfessorDialog.getInstance().getDateOfBirthText().getText().matches("\s*[0-9]{4,4}[-][0-9]{2,2}[-][0-9]{2,2}")) {
			AddProfessorDialog.getInstance().getDateOfBirthText().setText(" yyyy-mm-dd ");
			AddProfessorDialog.getInstance().getDateOfBirthText().setForeground(Color.red);
		}	
	}

}
