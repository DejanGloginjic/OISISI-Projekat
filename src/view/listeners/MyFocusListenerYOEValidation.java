package view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import view.dialogs.AddProfessorDialog;
import view.dialogs.AddStudentDialog;

public class MyFocusListenerYOEValidation implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		AddStudentDialog.getInstance().getYoeText().setText("");	
		AddStudentDialog.getInstance().getYoeText().setForeground(Color.black);
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(AddStudentDialog.getInstance().getYoeText().getText().matches("[0-9]+")) {
			
		}else if(AddStudentDialog.getInstance().getYoeText().getText().matches("$^")) {
			
		}else {
			AddStudentDialog.getInstance().getYoeText().setText("Samo brojevi su dozvoljeni");
			AddStudentDialog.getInstance().getYoeText().setForeground(Color.red);
		}
		
	}
}
