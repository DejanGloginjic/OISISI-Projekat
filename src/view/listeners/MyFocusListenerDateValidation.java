package view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JOptionPane;

import view.dialogs.AddProfessorDialog;
import view.dialogs.AddStudentDialog;

public class MyFocusListenerDateValidation implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		AddStudentDialog.getInstance().getDobText().setText("");
		AddStudentDialog.getInstance().getDobText().setForeground(Color.black);
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(AddStudentDialog.getInstance().getDobText().getText().matches("\s*[0-9]{4,4}[-][0-9]{2,2}[-][0-9]{2,2}")) {
		
		}else if(AddStudentDialog.getInstance().getDobText().getText().matches("$^")) {
			
		}else {
			AddStudentDialog.getInstance().getDobText().setText(" yyyy-mm-dd ");
			AddStudentDialog.getInstance().getDobText().setForeground(Color.red);
		}	
	}

}
