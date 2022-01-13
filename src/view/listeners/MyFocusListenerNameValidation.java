package view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import view.dialogs.AddStudentDialog;

public class MyFocusListenerNameValidation implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		AddStudentDialog.getInstance().getNameText().setText("");	
		AddStudentDialog.getInstance().getNameText().setForeground(Color.black);
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(AddStudentDialog.getInstance().getNameText().getText().matches("[a-zA-Z]+")) {
			
		}else if(AddStudentDialog.getInstance().getNameText().getText().matches("$^")) {
			
		}else{
			AddStudentDialog.getInstance().getNameText().setText("Samo slova su dozvoljena");
			AddStudentDialog.getInstance().getNameText().setForeground(Color.red);
		}
	}



}
