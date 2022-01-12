package view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JOptionPane;

import model.dataBase.CourseBase;
import view.dialogs.AddCourseDialog;

public class MyFocusListenerESPBValidationForCourse implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		AddCourseDialog.getInstance().getNumberOfESPBText().setText("");	
		AddCourseDialog.getInstance().getNumberOfESPBText().setForeground(Color.black);
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(AddCourseDialog.getInstance().getNumberOfESPBText().getText().matches("[0-9]+")) {
			
		}else if(AddCourseDialog.getInstance().getNumberOfESPBText().getText().matches("$^")) {
			
		}else {
			AddCourseDialog.getInstance().getNumberOfESPBText().setText("Samo brojevi su dozvoljeni");
			AddCourseDialog.getInstance().getNumberOfESPBText().setForeground(Color.red);
		}
		
	}
}
