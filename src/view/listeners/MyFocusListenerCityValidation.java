package view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JOptionPane;

import view.dialogs.AddProfessorDialog;
import view.dialogs.AddStudentDialog;

public class MyFocusListenerCityValidation implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		AddStudentDialog.getInstance().getCityText().setText("");		
		AddStudentDialog.getInstance().getCityText().setForeground(Color.black);
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(AddStudentDialog.getInstance().getCityText().getText().matches("[a-zA-Z]+")) {
			
		}else if(AddStudentDialog.getInstance().getCityText().getText().matches("$^")) {
			
		}else {
			AddStudentDialog.getInstance().getCityText().setText("Samo slova su dozvoljena");
			AddStudentDialog.getInstance().getCityText().setForeground(Color.red);
		}	
	}
	
}
