package view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import view.dialogs.AddCourseDialog;
import view.dialogs.AddStudentDialog;

public class MyFocusListenerNameValidationForCourse implements FocusListener{
	
	@Override
	public void focusGained(FocusEvent e) {
		AddCourseDialog.getInstance().getNameText().setText("");	
		AddCourseDialog.getInstance().getNameText().setForeground(Color.black);
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(AddCourseDialog.getInstance().getNameText().getText().matches("[a-zA-Z0-9]+")) {
			
		}else if(AddCourseDialog.getInstance().getNameText().getText().matches("$^")) {
			
		}else{
			AddCourseDialog.getInstance().getNameText().setText("Samo slova i brojevi su dozvoljeni");
			AddCourseDialog.getInstance().getNameText().setForeground(Color.red);
		}
	}
}
