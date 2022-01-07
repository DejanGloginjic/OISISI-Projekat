package view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.JOptionPane;

import model.dataBase.StudentBase;
import view.dialogs.AddStudentDialog;
import model.entities.Student;

public class MyFocusListenerIndexValidation implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(AddStudentDialog.getInstance().getIndexText().getText().matches("[a-zA-Z]{2,3}[-][0-9]{1,3}[-][0-9]{4,4}")) {
			
		}else if (AddStudentDialog.getInstance().getIndexText().getText().matches("$^")) {
			
		}else {
			AddStudentDialog.getInstance().getIndexText().setText("smijer-brojIndeksa-godinaUpisa");
			AddStudentDialog.getInstance().getIndexText().setForeground(Color.red);
		}
		String index = AddStudentDialog.getInstance().getIndexText().getText();
		List<Student> pomList = StudentBase.getInstance().getStudentList();
		for(Student s : pomList) {
			if(index.equals(s.getIndexNumber())) {
				JOptionPane.showMessageDialog(AddStudentDialog.getInstance(), "Student sa tim brojem indeka vec postoji!");
				AddStudentDialog.getInstance().getIndexText().setText("");
			}
		}
	}

}
