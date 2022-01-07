package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.ArrayList;

import controller.StudentController;
import enumerations.Status;
import model.dataBase.StudentBase;
import model.entities.Adress;
import model.entities.Grade;
import model.entities.Student;
import view.dialogs.AddStudentDialog;
import view.dialogs.EditStudentDialog;
import view.window.MyTabbedPane;
import view.window.MyTabbedPaneStudentEdit;

public class MyActionListenerConfirmEditStudent implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		int rowSelected = MyTabbedPane.getInstance().getSt().getSelectedRow();
		
		if(rowSelected < 0) {
			return;
		}
		
		String name = MyTabbedPaneStudentEdit.getInstance().getMpes().getNameText().getText();
		String surname = MyTabbedPaneStudentEdit.getInstance().getMpes().getSurnameText().getText();
		LocalDate dob = LocalDate.parse(MyTabbedPaneStudentEdit.getInstance().getMpes().getDobText().getText());
		String street = MyTabbedPaneStudentEdit.getInstance().getMpes().getCityText().getText();
		int number = Integer.parseInt(MyTabbedPaneStudentEdit.getInstance().getMpes().getNosText().getText());
		String city = MyTabbedPaneStudentEdit.getInstance().getMpes().getCityText().getText();
		String country = MyTabbedPaneStudentEdit.getInstance().getMpes().getCountryText().getText();
		Adress residentialAddress = new Adress(street, number, city, country);
		int telephoneNumber = Integer.parseInt(MyTabbedPaneStudentEdit.getInstance().getMpes().getTelText().getText());
		String eMail = MyTabbedPaneStudentEdit.getInstance().getMpes().getMailText().getText();
		String indexNumber = MyTabbedPaneStudentEdit.getInstance().getMpes().getIndexText().getText();
		int yearOfEnrollment = Integer.parseInt(MyTabbedPaneStudentEdit.getInstance().getMpes().getYoeText().getText());
		int currentYearOfStudy = 0;
		switch(MyTabbedPaneStudentEdit.getInstance().getMpes().getYear().getSelectedItem().toString()) {
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
		
		Status status = MyTabbedPaneStudentEdit.getInstance().getMpes().getStatus().getSelectedItem() == "Budžet" ? Status.B : Status.S;
		double averageGrade = 0.00;
		ArrayList<Grade> passedExams = null;
		ArrayList<String> remainingExams = null;
		
		Student student = new Student(surname, name, dob, residentialAddress, telephoneNumber, eMail, indexNumber, yearOfEnrollment, currentYearOfStudy,
				status, averageGrade, passedExams, remainingExams);
		
		StudentController.getInstance().editStudent(student);
		
		MyTabbedPaneStudentEdit.getInstance().getMpes().getNameText().setText("");
		MyTabbedPaneStudentEdit.getInstance().getMpes().getSurnameText().setText("");
		MyTabbedPaneStudentEdit.getInstance().getMpes().getDobText().setText("");
		MyTabbedPaneStudentEdit.getInstance().getMpes().getStreetText().setText("");
		MyTabbedPaneStudentEdit.getInstance().getMpes().getNosText().setText("");
		MyTabbedPaneStudentEdit.getInstance().getMpes().getCityText().setText("");
		MyTabbedPaneStudentEdit.getInstance().getMpes().getCountryText().setText("");
		MyTabbedPaneStudentEdit.getInstance().getMpes().getTelText().setText("");
		MyTabbedPaneStudentEdit.getInstance().getMpes().getMailText().setText("");
		MyTabbedPaneStudentEdit.getInstance().getMpes().getIndexText().setText("");
		MyTabbedPaneStudentEdit.getInstance().getMpes().getYoeText().setText("");
		
		EditStudentDialog.getInstance().dispose();
		EditStudentDialog.getInstance().setVisible(false);
	}

}
