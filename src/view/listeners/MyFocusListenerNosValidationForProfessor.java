package view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import view.dialogs.AddProfessorDialog;

public class MyFocusListenerNosValidationForProfessor implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		AddProfessorDialog.getInstance().getNosText().setText("");	
		AddProfessorDialog.getInstance().getNosText().setForeground(Color.black);
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(AddProfessorDialog.getInstance().getNosText().getText().matches("[0-9]+")) {	
		}else {
			AddProfessorDialog.getInstance().getNosText().setText("Samo brojevi su dozvoljeni");
			AddProfessorDialog.getInstance().getNosText().setForeground(Color.red);
		}
		
	}

}
