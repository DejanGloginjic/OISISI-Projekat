package view.dialogs;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.dataBase.ProfessorBase;
import model.entities.Professor;

import view.window.MyMainFrame;
import view.window.MyTabbedPane;
import view.window.MyTabbedPaneProfessorEdit;
import view.window.MyTabbedPaneStudentEdit;

public class EditProfessorDialog extends JDialog{
	
	MyTabbedPaneProfessorEdit mtppe=MyTabbedPaneProfessorEdit.getInstance();
	
	private JPanel panelCenter = new JPanel();
	
	private static EditProfessorDialog instance=null;
	
	public static EditProfessorDialog getInstance() {
		if (instance == null) {
			instance = new EditProfessorDialog();
		}
		return instance;
	}
	
	private EditProfessorDialog() {
		
		setTitle("Izmjena profesora");

		setSize(450, 600);
		setLocationRelativeTo(MyMainFrame.getInstance());
		setModal(true);
		
		int rowSelected = MyTabbedPane.getInstance().getPt().getSelectedRow();

		Professor p = ProfessorBase.getInstance().getRow(rowSelected);

		MyTabbedPaneProfessorEdit.getInstance().getMpep().getNameText().setText(p.getName());
		MyTabbedPaneProfessorEdit.getInstance().getMpep().getSurnameText().setText(p.getSurname());
		MyTabbedPaneProfessorEdit.getInstance().getMpep().getDateOfBirthText().setText(p.getDateOfBirth().toString());
		MyTabbedPaneProfessorEdit.getInstance().getMpep().getStreetText().setText(p.getResidentialAddress().getStreet());
		MyTabbedPaneProfessorEdit.getInstance().getMpep().getNosText().setText(String.valueOf(p.getResidentialAddress().getNumber()));
		MyTabbedPaneProfessorEdit.getInstance().getMpep().getCityText().setText(p.getResidentialAddress().getCity());
		MyTabbedPaneProfessorEdit.getInstance().getMpep().getCountryText().setText(p.getResidentialAddress().getCountry());
		MyTabbedPaneProfessorEdit.getInstance().getMpep().getTelephoneNumberText().setText(String.valueOf(p.getTelephoneNumber()));
		MyTabbedPaneProfessorEdit.getInstance().getMpep().geteMailText().setText(p.geteMail());
		MyTabbedPaneProfessorEdit.getInstance().getMpep().getStreetOfficeText().setText(p.getResidentialAddress().getStreet());
		MyTabbedPaneProfessorEdit.getInstance().getMpep().getNosOfficeText().setText(String.valueOf(p.getResidentialAddress().getNumber()));			MyTabbedPaneProfessorEdit.getInstance().getMpep().getCityOfficeText().setText(p.getResidentialAddress().getCity());
		MyTabbedPaneProfessorEdit.getInstance().getMpep().getCountryOfficeText().setText(p.getResidentialAddress().getCountry());
		MyTabbedPaneProfessorEdit.getInstance().getMpep().getIdNumberText().setText(p.getIdNumber());
		MyTabbedPaneProfessorEdit.getInstance().getMpep().getTitleText().setText(p.getIdNumber());
		MyTabbedPaneProfessorEdit.getInstance().getMpep().getYearOfTrailText().setText(String.valueOf(p.getYearOfTrail()));

			
		panelCenter.add(mtppe);
		add(panelCenter);

	}
}
