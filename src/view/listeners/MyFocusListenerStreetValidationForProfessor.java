package view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import view.dialogs.AddProfessorDialog;

public class MyFocusListenerStreetValidationForProfessor implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		AddProfessorDialog.getInstance().getStreetText().setText("");	
		AddProfessorDialog.getInstance().getStreetText().setForeground(Color.black);
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(AddProfessorDialog.getInstance().getStreetText().getText().matches("[a-zA-Z]+")) {
			
		}else if(AddProfessorDialog.getInstance().getStreetText().getText().matches("$^")) {
			
		}else {
			AddProfessorDialog.getInstance().getStreetText().setText("Samo slova su dozvoljena");
			AddProfessorDialog.getInstance().getStreetText().setForeground(Color.red);
		}	
	}

}
