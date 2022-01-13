package view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.JOptionPane;

import model.dataBase.StudentBase;
import model.entities.Student;
import view.dialogs.AddProfessorDialog;
import view.dialogs.AddStudentDialog;

public class MyFocusListenerEmailValidation implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		AddStudentDialog.getInstance().getMailText().setText("");
		AddStudentDialog.getInstance().getMailText().setForeground(Color.black);

		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(AddStudentDialog.getInstance().getMailText().getText().matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
			
		}else if(AddStudentDialog.getInstance().getMailText().getText().matches("$^")) {
			
		}else {
			AddStudentDialog.getInstance().getMailText().setText("imail@gmail.com");
			AddStudentDialog.getInstance().getMailText().setForeground(Color.red);
		}
		
		String mail = AddStudentDialog.getInstance().getMailText().getText();
		List<Student> pomList = StudentBase.getInstance().getStudentList();
		for(Student s : pomList) {
			if(mail.equals(s.geteMail())) {
				JOptionPane.showMessageDialog(AddStudentDialog.getInstance(), "Uneseni e-Mail već postoji!");
				AddStudentDialog.getInstance().getMailText().setText("");
			}
		}
	}

}
