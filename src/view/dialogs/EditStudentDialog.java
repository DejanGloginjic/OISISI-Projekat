package view.dialogs;

import javax.swing.JDialog;
import javax.swing.JPanel;

import model.dataBase.StudentBase;
import model.entities.Student;
import view.window.MyMainFrame;
import view.window.MyTabbedPane;
import view.window.MyTabbedPaneStudentEdit;

public class EditStudentDialog extends JDialog{
	
	MyTabbedPaneStudentEdit mtpse = MyTabbedPaneStudentEdit.getInstance();
	private JPanel panelCenter = new JPanel();
	
	private static EditStudentDialog instance = null;
	
	public static EditStudentDialog getInstance() {
		if (instance == null) {
			instance = new EditStudentDialog();
		}
		return instance;
	}
	
	private EditStudentDialog() {
		setTitle("Izmjena studenta");
		setSize(500, 575);
		setLocationRelativeTo(MyMainFrame.getInstance());
		setModal(true);
		
		int rowSelected = MyTabbedPane.getInstance().getSt().getSelectedRow();
		Student s = StudentBase.getInstance().getRow(rowSelected);
		
		MyTabbedPaneStudentEdit.getInstance().getMpes().getNameText().setText(s.getName());
		MyTabbedPaneStudentEdit.getInstance().getMpes().getSurnameText().setText(s.getSurname());
		MyTabbedPaneStudentEdit.getInstance().getMpes().getDobText().setText(s.getDateOfBirth().toString());
		MyTabbedPaneStudentEdit.getInstance().getMpes().getStreetText().setText(s.getResidentialAddress().getStreet());
		MyTabbedPaneStudentEdit.getInstance().getMpes().getNosText().setText(String.valueOf(s.getResidentialAddress().getNumber()));
		MyTabbedPaneStudentEdit.getInstance().getMpes().getCityText().setText(s.getResidentialAddress().getCity());
		MyTabbedPaneStudentEdit.getInstance().getMpes().getCountryText().setText(s.getResidentialAddress().getCountry());
		MyTabbedPaneStudentEdit.getInstance().getMpes().getTelText().setText(String.valueOf(s.getTelephoneNumber()));
		MyTabbedPaneStudentEdit.getInstance().getMpes().getMailText().setText(s.geteMail());
		MyTabbedPaneStudentEdit.getInstance().getMpes().getIndexText().setText(s.getIndexNumber());
		MyTabbedPaneStudentEdit.getInstance().getMpes().getYoeText().setText(String.valueOf(s.getYearOfEnrollment()));
		
		switch(s.getCurrentYearOfStudy()) {
		case 1:
			MyTabbedPaneStudentEdit.getInstance().getMpes().getYearModel().setSelectedItem("I (prva)");
			break;
		case 2:
			MyTabbedPaneStudentEdit.getInstance().getMpes().getYearModel().setSelectedItem("II (druga)");
			break;
		case 3:
			MyTabbedPaneStudentEdit.getInstance().getMpes().getYearModel().setSelectedItem("III (treća)");
			break;
		case 4:
			MyTabbedPaneStudentEdit.getInstance().getMpes().getYearModel().setSelectedItem("IV (četvrta)");
			break;	
		case 5:
			MyTabbedPaneStudentEdit.getInstance().getMpes().getYearModel().setSelectedItem("V (peta)");
			break;	
		case 6:
			MyTabbedPaneStudentEdit.getInstance().getMpes().getYearModel().setSelectedItem("VI (šesta)");
			break;	
		}
		
		switch(s.getStatus()) {
		case B:
			MyTabbedPaneStudentEdit.getInstance().getMpes().getStatusModel().setSelectedItem("Budžet");
			break;
		case S:
			MyTabbedPaneStudentEdit.getInstance().getMpes().getStatusModel().setSelectedItem("Samofinansiranje");
			break;
		}
		
		panelCenter.add(mtpse);
		add(panelCenter);
	}
}
