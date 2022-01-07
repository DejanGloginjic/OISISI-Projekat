package view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JOptionPane;

import view.dialogs.AddProfessorDialog;
import view.dialogs.AddStudentDialog;

public class MyFocusListenerStreetValidation implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		AddStudentDialog.getInstance().getStreetText().setText("");	
		AddStudentDialog.getInstance().getStreetText().setForeground(Color.black);
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(AddStudentDialog.getInstance().getStreetText().getText().matches("[a-zA-Z]+")) {
			
		}else if(AddStudentDialog.getInstance().getStreetText().getText().matches("$^")) {
			
		}else {
			AddStudentDialog.getInstance().getStreetText().setText("Samo slova su dozvoljena");
			AddStudentDialog.getInstance().getStreetText().setForeground(Color.red);
		}
	}

}
