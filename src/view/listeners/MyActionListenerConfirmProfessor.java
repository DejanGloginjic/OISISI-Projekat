package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import controller.ProfessorController;
import model.entities.Adress;
import model.entities.Course;
import model.entities.Professor;
import view.dialogs.AddProfessorDialog;

public class MyActionListenerConfirmProfessor implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String surname=AddProfessorDialog.getInstance().getSurnameText().getText();
		String name=AddProfessorDialog.getInstance().getNameText().getText();
		LocalDate dateOfBirth = LocalDate.parse(AddProfessorDialog.getInstance().getDateOfBirthText().getText());
		String street = AddProfessorDialog.getInstance().getStreetText().getText();
		int number = Integer.parseInt(AddProfessorDialog.getInstance().getNosText().getText());
		String city = AddProfessorDialog.getInstance().getCityText().getText();
		String country = AddProfessorDialog.getInstance().getCountryText().getText();
		Adress residentialAddress = new Adress(street, number, city, country);
		int telephoneNumber=Integer.parseInt(AddProfessorDialog.getInstance().getTelephoneNumberText().getText());	
		String eMail = AddProfessorDialog.getInstance().geteMailText().getText();
		String streetOffice = AddProfessorDialog.getInstance().getStreetOfficeText().getText();
		int numberOffice = Integer.parseInt(AddProfessorDialog.getInstance().getNosOfficeText().getText());
		String cityOffice = AddProfessorDialog.getInstance().getCityOfficeText().getText();
		String countryOffice = AddProfessorDialog.getInstance().getCountryOfficeText().getText();
		Adress officeAddress = new Adress(streetOffice, numberOffice, cityOffice, countryOffice);
		String idNumber=AddProfessorDialog.getInstance().getIdNumberText().getText();
		String title=AddProfessorDialog.getInstance().getTitleText().getText();
		int yearOfTrail=Integer.parseInt(AddProfessorDialog.getInstance().getYearOfTrailText().getText());
		ArrayList<Course> listOfSubjects = null;
		
		Professor professor=new Professor(surname,name,dateOfBirth,residentialAddress,telephoneNumber,eMail,officeAddress,idNumber,title,yearOfTrail,listOfSubjects);
		ProfessorController.getInstance().addProfessor(professor);
		
	}

}
