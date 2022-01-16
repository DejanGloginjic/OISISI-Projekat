package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.StudentController;
import enumerations.Status;
import model.entities.Adress;
import model.entities.Course;
import model.entities.Grade;
import model.entities.Student;
import view.dialogs.AddStudentDialog;

public class MyActionListenerCofirmStudent implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String surname = AddStudentDialog.getInstance().getSurnameText().getText();
		String name = AddStudentDialog.getInstance().getNameText().getText();
		LocalDate dateOfBirth = LocalDate.parse(AddStudentDialog.getInstance().getDobText().getText());
		String street = AddStudentDialog.getInstance().getCityText().getText();
		int number = Integer.parseInt(AddStudentDialog.getInstance().getNosText().getText());
		String city = AddStudentDialog.getInstance().getCityText().getText();
		String country = AddStudentDialog.getInstance().getCountryText().getText();
		Adress residentialAddress = new Adress(street, number, city, country);
		int telephoneNumber = Integer.parseInt(AddStudentDialog.getInstance().getTelText().getText());
		String eMail = AddStudentDialog.getInstance().getMailText().getText();
		String indexNumber = AddStudentDialog.getInstance().getIndexText().getText();
		int yearOfEnrollment = Integer.parseInt(AddStudentDialog.getInstance().getYoeText().getText());
		
		int currentYearOfStudy = 0;
		switch(AddStudentDialog.getInstance().getYear().getSelectedItem().toString()) {
		case "I (prva)":
			currentYearOfStudy = 1;
			break;
		case "II (druga)":
			currentYearOfStudy = 2;
			break;
		case "III (treća)":
			currentYearOfStudy = 3;
			break;
		case "IV (četvrta)":
			currentYearOfStudy = 4;
			break;
		case "V (peta)":
			currentYearOfStudy = 5;
			break;
		case "VI (šesta)":
			currentYearOfStudy = 6;
			break;
		}
		
		Status status = AddStudentDialog.getInstance().getStatus().getSelectedItem() == "Budžet" ? Status.B : Status.S;
		List<Grade> passedExams = null;
		List<Course> remainingExams = null;
		
		Student student = new Student(surname, name, dateOfBirth, residentialAddress, telephoneNumber, eMail, indexNumber, yearOfEnrollment, currentYearOfStudy,
				status, passedExams, remainingExams);
		
		StudentController.getInstance().addStudent(student);
		
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
