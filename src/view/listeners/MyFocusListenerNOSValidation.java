package view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import view.dialogs.AddProfessorDialog;
import view.dialogs.AddStudentDialog;

public class MyFocusListenerNOSValidation implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		AddStudentDialog.getInstance().getNosText().setText("");	
		AddStudentDialog.getInstance().getNosText().setForeground(Color.black);
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(AddStudentDialog.getInstance().getNosText().getText().matches("[0-9]+")) {	
		}else if(AddStudentDialog.getInstance().getNosText().getText().matches("$^")) {
			
		}else {
			AddStudentDialog.getInstance().getNosText().setText("Samo brojevi su dozvoljeni");
			AddStudentDialog.getInstance().getNosText().setForeground(Color.red);
		}
		
	}
}
