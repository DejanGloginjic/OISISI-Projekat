package view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import view.dialogs.AddProfessorDialog;

public class MyFocusListenerTelephoneValidationForProfessor implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		AddProfessorDialog.getInstance().getTelephoneNumberText().setText("");	
		AddProfessorDialog.getInstance().getTelephoneNumberText().setForeground(Color.black);
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(AddProfessorDialog.getInstance().getTelephoneNumberText().getText().matches("[0-9]+")) {	
		}else {
			AddProfessorDialog.getInstance().getTelephoneNumberText().setText("Samo brojevi su dozvoljeni");
			AddProfessorDialog.getInstance().getTelephoneNumberText().setForeground(Color.red);
		}
		
	}

}
