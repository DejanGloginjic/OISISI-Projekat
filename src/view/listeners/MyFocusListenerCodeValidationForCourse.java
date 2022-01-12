package view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JOptionPane;

import model.dataBase.CourseBase;
import view.dialogs.AddCourseDialog;
import view.dialogs.AddStudentDialog;

public class MyFocusListenerCodeValidationForCourse implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		AddCourseDialog.getInstance().getCodeText().setText("");
		AddCourseDialog.getInstance().getCodeText().setForeground(Color.black);
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(AddCourseDialog.getInstance().getCodeText().getText().matches("[0-9a-zA-Z]+")) {
			
		}else if(AddCourseDialog.getInstance().getCodeText().getText().matches("$^")) {
			
		}else {
				AddCourseDialog.getInstance().getCodeText().setText("Samo brojevi i slova su dozvoljeni");
				AddCourseDialog.getInstance().getCodeText().setForeground(Color.red);
		}
		
		try {
			String code = AddCourseDialog.getInstance().getCodeText().getText();
			
			if(CourseBase.getInstance().checkIfUnique(code)) {
				JOptionPane.showMessageDialog(AddCourseDialog.getInstance(), "Predmet sa tim kodom vec postoji!");
				AddCourseDialog.getInstance().getCodeText().setText("");
			}	
		}catch(Exception ee) {}
		
	}
}
