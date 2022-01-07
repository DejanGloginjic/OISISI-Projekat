package view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import view.dialogs.AddProfessorDialog;

public class MyFocusListenerCountryValidationForProfessor implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		AddProfessorDialog.getInstance().getCountryText().setText("");
		AddProfessorDialog.getInstance().getCountryText().setForeground(Color.black);
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(AddProfessorDialog.getInstance().getCountryText().getText().matches("[a-zA-Z]+")) {

		}else {
			AddProfessorDialog.getInstance().getCountryText().setText("Samo slova su dozvoljena");
			AddProfessorDialog.getInstance().getCountryText().setForeground(Color.red);
		}	
		
	}

}
