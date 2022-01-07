package view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import view.dialogs.AddProfessorDialog;
import view.dialogs.AddStudentDialog;

public class MyFocusListenerTelValidation implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		AddStudentDialog.getInstance().getTelText().setText("");	
		AddStudentDialog.getInstance().getTelText().setForeground(Color.black);
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(AddStudentDialog.getInstance().getTelText().getText().matches("[0-9]+")) {
			
		}else if(AddStudentDialog.getInstance().getTelText().getText().matches("$^")) {
			
		}else {
			AddStudentDialog.getInstance().getTelText().setText("Samo brojevi su dozvoljeni");
			AddStudentDialog.getInstance().getTelText().setForeground(Color.red);
		}
		
	}

}
