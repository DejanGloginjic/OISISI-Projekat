package view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JOptionPane;

import view.dialogs.AddProfessorDialog;

public class MyFocusListenerNameValidationForProfessor implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		AddProfessorDialog.getInstance().getNameText().setText("");	
		AddProfessorDialog.getInstance().getNameText().setForeground(Color.black);
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(AddProfessorDialog.getInstance().getNameText().getText().matches("[a-zA-Z]+")) {
			
		}else {
			AddProfessorDialog.getInstance().getNameText().setText("Samo slova su dozvoljena");
			AddProfessorDialog.getInstance().getNameText().setForeground(Color.red);
		}	
	}

}
