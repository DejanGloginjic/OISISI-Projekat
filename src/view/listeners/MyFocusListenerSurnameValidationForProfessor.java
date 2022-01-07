package view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import view.dialogs.AddProfessorDialog;

public class MyFocusListenerSurnameValidationForProfessor implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		AddProfessorDialog.getInstance().getSurnameText().setText("");	
		AddProfessorDialog.getInstance().getSurnameText().setForeground(Color.black);
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(AddProfessorDialog.getInstance().getSurnameText().getText().matches("[a-zA-Z]+")) {
			
		}else if(AddProfessorDialog.getInstance().getSurnameText().getText().matches("$^")) {
			
		}else {
			//JOptionPane.showMessageDialog(AddProfessorDialog.getInstance(), "Samo slova su dozvoljena!");
			AddProfessorDialog.getInstance().getSurnameText().setText("Samo slova su dozvoljena");
			AddProfessorDialog.getInstance().getSurnameText().setForeground(Color.red);
		}			
	}
	

}
