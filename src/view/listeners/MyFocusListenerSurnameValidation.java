package view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import view.dialogs.AddStudentDialog;

public class MyFocusListenerSurnameValidation implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		AddStudentDialog.getInstance().getSurnameText().setText("");	
		AddStudentDialog.getInstance().getSurnameText().setForeground(Color.black);
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(AddStudentDialog.getInstance().getSurnameText().getText().matches("[A-Za-z]+")) {
			
		}else if(AddStudentDialog.getInstance().getSurnameText().getText().matches("$^")) {
			
		}else {
			AddStudentDialog.getInstance().getSurnameText().setText("Samo slova su dozvoljena");
			AddStudentDialog.getInstance().getSurnameText().setForeground(Color.red);
	}
}
}

