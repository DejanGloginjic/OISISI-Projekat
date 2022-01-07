package view.dialogs;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditProfessorDialog extends JDialog{

	private static EditProfessorDialog instance=null;
	
	public static EditProfessorDialog getInstance() {
		if (instance == null) {
			instance = new EditProfessorDialog();
		}
		return instance;
	}
	
	private JPanel panelCenter;
	private BoxLayout boxLayout;
	
	private JPanel surnamePan;
	private JLabel surnameLab;
	private JTextField surnameText;
	
	private JPanel namePan;
	private JLabel nameLab;
	private JTextField nameText;
	
	private JPanel dateOfBirthPan;
	private JLabel dateOfBirthLab;
	private JTextField dateOfBirthText;
	
	private JPanel streetPan;
	private JLabel streetLab;
	private JTextField streetText;
	
	private JPanel nosPan;
	private JLabel nosLab;
	private JTextField nosText;
	
	private JPanel cityPan;
	private JLabel cityLab;
	private JTextField cityText;
	
	private JPanel countryPan;
	private JLabel countryLab;
	private JTextField countryText;
	
	private JPanel telephoneNumberPan;
	private JLabel telephoneNumberLab;
	private JTextField telephoneNumberText;
	
	private JPanel eMailPan;
	private JLabel eMailLab;
	private JTextField eMailText;
	
	private JPanel streetOfficePan;
	private JLabel streetOfficeLab;
	private JTextField streetOfficeText;
	
	private JPanel nosOfficePan;
	private JLabel nosOfficeLab;
	private JTextField nosOfficeText;
	
	private JPanel cityOfficePan;
	private JLabel cityOfficeLab;
	private JTextField cityOfficeText;
	
	private JPanel countryOfficePan;
	private JLabel countryOfficeLab;
	private JTextField countryOfficeText;
	
	private JPanel IdNumberPan;
	private JLabel IdNumberLab;
	private JTextField IdNumberText;
	
	private JPanel titlePan;
	private JLabel titleLab;
	private JTextField titleText;
	
	private JPanel yearOfTrailPan;
	private JLabel yearOfTrailLab;
	private JTextField yearOfTrailText;
	
	private JPanel buttonPanel;
	private JButton cancel;
	private JButton confirm;
	
	
	private EditProfessorDialog() {
		
		
	}
}
