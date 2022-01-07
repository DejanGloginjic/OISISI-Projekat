package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.dialogs.AddStudentDialog;

public class MyActionListenerCancelStudent implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		AddStudentDialog.getInstance().getNameText().setText("");
		AddStudentDialog.getInstance().getSurnameText().setText("");
		AddStudentDialog.getInstance().getDobText().setText("");
		AddStudentDialog.getInstance().getStreetText().setText("");
		AddStudentDialog.getInstance().getNosText().setText("");
		AddStudentDialog.getInstance().getCityText().setText("");
		AddStudentDialog.getInstance().getCountryText().setText("");
		AddStudentDialog.getInstance().getTelText().setText("");
		AddStudentDialog.getInstance().getMailText().setText("");
		AddStudentDialog.getInstance().getIndexText().setText("");
		AddStudentDialog.getInstance().getYoeText().setText("");
		AddStudentDialog.getInstance().setVisible(false);
		
	}

}
