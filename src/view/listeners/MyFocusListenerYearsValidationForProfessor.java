package view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import model.dataBase.ProfessorBase;
import view.dialogs.AddProfessorDialog;

public class MyFocusListenerYearsValidationForProfessor implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		AddProfessorDialog.getInstance().getYearOfTrailText().setText("");
		AddProfessorDialog.getInstance().getYearOfTrailText().setForeground(Color.black);
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(AddProfessorDialog.getInstance().getYearOfTrailText().getText().matches("[0-9]+")) {	

		}else {
			AddProfessorDialog.getInstance().getYearOfTrailText().setText("Samo su brojevi dozvoljeni");
			AddProfessorDialog.getInstance().getYearOfTrailText().setForeground(Color.red);
		}	
		
	}

}
