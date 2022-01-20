package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import controller.ProfessorController;
import controller.StudentController;
import enumerations.Status;
import model.entities.Adress;
import model.entities.Course;
import model.entities.Grade;
import model.entities.Professor;
import model.entities.Student;
import view.dialogs.AddProfessorDialog;
import view.dialogs.EditProfessorDialog;
import view.dialogs.EditStudentDialog;
import view.window.MyTabbedPane;
import view.window.MyTabbedPaneProfessorEdit;
import view.window.MyTabbedPaneStudentEdit;

public class MyActionListenerConfirmEditProfessor  implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		int rowSelected = MyTabbedPane.getInstance().getPt().getSelectedRow();
		
		if(rowSelected < 0) {
			return;
		}
		
		String name = MyTabbedPaneProfessorEdit.getInstance().getMpep().getNameText().getText();
		String surname = MyTabbedPaneProfessorEdit.getInstance().getMpep().getSurnameText().getText();
		LocalDate dob = LocalDate.parse(MyTabbedPaneProfessorEdit.getInstance().getMpep().getDateOfBirthText().getText());
		String street = MyTabbedPaneProfessorEdit.getInstance().getMpep().getStreetText().getText();
		String number = MyTabbedPaneProfessorEdit.getInstance().getMpep().getNosText().getText();
		String city = MyTabbedPaneProfessorEdit.getInstance().getMpep().getCityText().getText();
		String country = MyTabbedPaneProfessorEdit.getInstance().getMpep().getCountryText().getText();
		Adress residentialAddress = new Adress(street, number, city, country);
		String telephoneNumber = MyTabbedPaneProfessorEdit.getInstance().getMpep().getTelephoneNumberText().getText();
		String eMail = MyTabbedPaneProfessorEdit.getInstance().getMpep().geteMailText().getText();
		String street1 = MyTabbedPaneProfessorEdit.getInstance().getMpep().getStreetOfficeText().getText();
		String number1 = MyTabbedPaneProfessorEdit.getInstance().getMpep().getNosOfficeText().getText();
		String city1 = MyTabbedPaneProfessorEdit.getInstance().getMpep().getCityOfficeText().getText();
		String country1 = MyTabbedPaneProfessorEdit.getInstance().getMpep().getCountryOfficeText().getText();
		Adress officelAddress = new Adress(street1, number1, city1, country1);
		String idNumber = MyTabbedPaneProfessorEdit.getInstance().getMpep().getIdNumberText().getText();
		String title = MyTabbedPaneProfessorEdit.getInstance().getMpep().getTitleText().getText();
		int yearsOfTrail = Integer.parseInt(MyTabbedPaneProfessorEdit.getInstance().getMpep().getYearOfTrailText().getText());

		ArrayList<Course> listOfCourse = null;
		
		Professor professor = new Professor(surname, name, dob, residentialAddress, telephoneNumber, eMail, officelAddress, idNumber, title, yearsOfTrail, listOfCourse);
		
		ProfessorController.getInstance().editProfessor(professor);
		
		MyTabbedPaneProfessorEdit.getInstance().getMpep().getNameText().setText("");
		MyTabbedPaneProfessorEdit.getInstance().getMpep().getSurnameText().setText("");
		MyTabbedPaneProfessorEdit.getInstance().getMpep().getDateOfBirthText().setText("");
		MyTabbedPaneProfessorEdit.getInstance().getMpep().getStreetText().setText("");
		MyTabbedPaneProfessorEdit.getInstance().getMpep().getNosText().setText("");
		MyTabbedPaneProfessorEdit.getInstance().getMpep().getCityText().setText("");
		MyTabbedPaneProfessorEdit.getInstance().getMpep().getCountryText().setText("");
		MyTabbedPaneProfessorEdit.getInstance().getMpep().getTelephoneNumberText().setText("");
		MyTabbedPaneProfessorEdit.getInstance().getMpep().geteMailText().setText("");
		MyTabbedPaneProfessorEdit.getInstance().getMpep().getStreetOfficeText().setText("");
		MyTabbedPaneProfessorEdit.getInstance().getMpep().getNosOfficeText().setText("");
		MyTabbedPaneProfessorEdit.getInstance().getMpep().getCityOfficeText().setText("");
		MyTabbedPaneProfessorEdit.getInstance().getMpep().getCountryOfficeText().setText("");
		MyTabbedPaneProfessorEdit.getInstance().getMpep().getIdNumberText().setText("");
		MyTabbedPaneProfessorEdit.getInstance().getMpep().getTitleText().setText("");
		MyTabbedPaneProfessorEdit.getInstance().getMpep().getYearOfTrailText().setText("");
		
		EditProfessorDialog.getInstance().dispose();
		EditProfessorDialog.getInstance().setVisible(false);
		
	}

}
