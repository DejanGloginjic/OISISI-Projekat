package view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import view.dialogs.AddProfessorDialog;

public class MyFocusListenerEmailValidationForProfessor implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		AddProfessorDialog.getInstance().geteMailText().setText("");
		AddProfessorDialog.getInstance().geteMailText().setForeground(Color.black);
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(AddProfessorDialog.getInstance().geteMailText().getText().matches("[a-zA-Z0-9]+@[a-zA-Z0-9]+")) {	
		}else {
			AddProfessorDialog.getInstance().geteMailText().setText("imail@gmail.com");
			AddProfessorDialog.getInstance().geteMailText().setForeground(Color.red);
		}
	}

}
