package view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import model.dataBase.ProfessorBase;
import view.dialogs.AddProfessorDialog;

public class MyFocusListenerIdNumberValidationForProfessor implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		AddProfessorDialog.getInstance().getIdNumberText().setText("");
		AddProfessorDialog.getInstance().getIdNumberText().setForeground(Color.black);
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(ProfessorBase.getInstance().checkIfUnique(AddProfessorDialog.getInstance().getIdNumberText().getText())) {

		}else {
			AddProfessorDialog.getInstance().getIdNumberText().setText("Broj licne karte mora biti jedinstven");
			AddProfessorDialog.getInstance().getIdNumberText().setForeground(Color.red);
		}	
		
	}

}
