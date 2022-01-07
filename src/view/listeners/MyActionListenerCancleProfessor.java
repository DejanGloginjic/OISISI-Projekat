package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.dialogs.AddProfessorDialog;

public class MyActionListenerCancleProfessor implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		AddProfessorDialog.getInstance().getNameText().setText("");
		AddProfessorDialog.getInstance().getSurnameText().setText("");
		AddProfessorDialog.getInstance().getDateOfBirthText().setText("");
		AddProfessorDialog.getInstance().getStreetText().setText("");
		AddProfessorDialog.getInstance().getNosText().setText("");
		AddProfessorDialog.getInstance().getCityText().setText("");
		AddProfessorDialog.getInstance().getCountryText().setText("");
		AddProfessorDialog.getInstance().getTelephoneNumberText().setText("");
		AddProfessorDialog.getInstance().geteMailText().setText("");
		AddProfessorDialog.getInstance().getStreetOfficeText().setText("");
		AddProfessorDialog.getInstance().getNosOfficeText().setText("");
		AddProfessorDialog.getInstance().getCityOfficeText().setText("");
		AddProfessorDialog.getInstance().getCountryOfficeText().setText("");
		AddProfessorDialog.getInstance().getIdNumberText().setText("");
		AddProfessorDialog.getInstance().getTitleText().setText("");
		AddProfessorDialog.getInstance().getYearOfTrailText().setText("");
		AddProfessorDialog.getInstance().setVisible(true);
	}

}
