package view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JOptionPane;

import view.dialogs.AddProfessorDialog;
import view.dialogs.AddStudentDialog;

public class MyFocusListenerCountyValidation implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		AddStudentDialog.getInstance().getCountryText().setText("");
		AddStudentDialog.getInstance().getCountryText().setForeground(Color.black);
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(AddStudentDialog.getInstance().getCountryText().getText().matches("[a-zA-Z]+")) {

		}else if(AddStudentDialog.getInstance().getCountryText().getText().matches("$^")) {
			
		}else {
			AddStudentDialog.getInstance().getCountryText().setText("Samo slova su dozvoljena");
			AddStudentDialog.getInstance().getCountryText().setForeground(Color.red);
		}	
		
	}
}
