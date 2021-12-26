package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.StudentController;
import enumerations.Status;
import model.Adress;
import model.Grade;
import model.Student;
import enumerations.Status;

public class AddStudentDialog extends JDialog{
	
	private static AddStudentDialog instance = null;

	public static AddStudentDialog getInstance() {
		if (instance == null) {
			instance = new AddStudentDialog();
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
	
	private JPanel dobPan;
	private JLabel dobLab;
	private JTextField dobText;
	
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
	
	private JPanel telPan;
	private JLabel telLab;
	private JTextField telText;
	
	private JPanel mailPan;
	private JLabel mailLab;
	private JTextField mailText;
	
	private JPanel indexPan;
	private JLabel indexLab;
	private JTextField indexText;
	
	private JPanel yoePan;
	private JLabel yoeLab;
	private JTextField yoeText;
	
	private JPanel cyosPan;
	private JLabel cyosLab;
	private JComboBox<String> year;
	private DefaultComboBoxModel<String> yearModel;
	
	private JPanel statusPan;
	private JLabel statusLab;
	private JComboBox<String> status;
	private DefaultComboBoxModel<String> statusModel;
	
	private JPanel buttonPanel;
	private JButton cancel;
	private JButton confirm;
	
	
	private AddStudentDialog(){
		
		setTitle("Dodavanje studenta");
		setSize(450, 600);
		setLocationRelativeTo(MyMainFrame.getInstance());
		setModal(true);
		
		Dimension dim = new Dimension(150, 20);
		
		panelCenter = new JPanel();
		boxLayout = new BoxLayout(panelCenter, BoxLayout.Y_AXIS);
		panelCenter.setLayout(boxLayout);
		add(panelCenter);
		
		namePan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		nameLab = new JLabel("Ime*");
		nameLab.setPreferredSize(dim);
		nameText = new JTextField();
		nameText.setPreferredSize(dim);
		namePan.add(nameLab);
		namePan.add(nameText);
		panelCenter.add(namePan);
		
		surnamePan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		surnameLab = new JLabel("Prezime*");
		surnameLab.setPreferredSize(dim);
		surnameText = new JTextField();
		surnameText.setPreferredSize(dim);
		surnamePan.add(surnameLab);
		surnamePan.add(surnameText);
		panelCenter.add(surnamePan);
		
		dobPan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		dobLab = new JLabel("Datum rodjenja*");
		dobLab.setPreferredSize(dim);
		dobText = new JTextField();
		dobText.setPreferredSize(dim);
		dobPan.add(dobLab);
		dobPan.add(dobText);
		panelCenter.add(dobPan);

		streetPan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		streetLab = new JLabel("Ulica*");
		streetLab.setPreferredSize(dim);
		streetText = new JTextField();
		streetText.setPreferredSize(dim);
		streetPan.add(streetLab);
		streetPan.add(streetText);
		panelCenter.add(streetPan);
		
		nosPan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		nosLab = new JLabel("Broj adrese*");
		nosLab.setPreferredSize(dim);
		nosText = new JTextField();
		nosText.setPreferredSize(dim);
		nosPan.add(nosLab);
		nosPan.add(nosText);
		panelCenter.add(nosPan);
		
		cityPan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cityLab = new JLabel("Grad*");
		cityLab.setPreferredSize(dim);
		cityText = new JTextField();
		cityText.setPreferredSize(dim);
		cityPan.add(cityLab);
		cityPan.add(cityText);
		panelCenter.add(cityPan);
		
		countryPan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		countryLab = new JLabel("Dr�ava*");
		countryLab.setPreferredSize(dim);
		countryText = new JTextField();
		countryText.setPreferredSize(dim);
		countryPan.add(countryLab);
		countryPan.add(countryText);
		panelCenter.add(countryPan);
		
		telPan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		telLab = new JLabel("Broj telefona*");
		telLab.setPreferredSize(dim);
		telText = new JTextField();
		telText.setPreferredSize(dim);
		telPan.add(telLab);
		telPan.add(telText);
		panelCenter.add(telPan);
		
		mailPan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		mailLab = new JLabel("Mail*");
		mailLab.setPreferredSize(dim);
		mailText = new JTextField();
		mailText.setPreferredSize(dim);
		mailPan.add(mailLab);
		mailPan.add(mailText);
		panelCenter.add(mailPan);
		
		indexPan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		indexLab = new JLabel("Broj indeksa*");
		indexLab.setPreferredSize(dim);
		indexText = new JTextField();
		indexText.setPreferredSize(dim);
		indexPan.add(indexLab);
		indexPan.add(indexText);
		panelCenter.add(indexPan);
		
		yoePan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		yoeLab = new JLabel("Godina upisa*");
		yoeLab.setPreferredSize(dim);
		yoeText = new JTextField();
		yoeText.setPreferredSize(dim);
		yoePan.add(yoeLab);
		yoePan.add(yoeText);
		panelCenter.add(yoePan);
		
		
		cyosPan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cyosLab = new JLabel("Godina upisa*");
		cyosLab.setPreferredSize(dim);
		year = new JComboBox<String>();
		yearModel = new DefaultComboBoxModel<String>();
		yearModel.addElement("I (prva)");
		yearModel.addElement("II (druga)");
		yearModel.addElement("III (tre�a)");
		yearModel.addElement("IV (�etvrta)");
		yearModel.addElement("V (peta)");
		yearModel.addElement("IV (�esta)");
		year.setModel(yearModel);
		year.setSelectedIndex(0);
		year.setPreferredSize(dim);
		cyosPan.add(cyosLab);
		cyosPan.add(year);
		panelCenter.add(cyosPan);
		
		statusPan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		statusLab = new JLabel("Status*");
		statusLab.setPreferredSize(dim);
		status = new JComboBox<String>();
		statusModel = new DefaultComboBoxModel<String>();
		statusModel.addElement("Bud�et");
		statusModel.addElement("Samofinansiranje");
		status.setModel(statusModel);
		status.setSelectedIndex(0);
		status.setPreferredSize(dim);
		statusPan.add(statusLab);
		statusPan.add(status);
		panelCenter.add(statusPan);
		
		buttonPanel = new JPanel();
		confirm = new JButton("Potvrdi");
		confirm.addActionListener(new ActionListener() {
			
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
				int currentYearOfStudy = 1;
				Status status = AddStudentDialog.getInstance().getStatus().getSelectedItem() == "Bud�et" ? Status.B : Status.S;
				double averageGrade = 0.00;
				ArrayList<Grade> passedExams = null;
				ArrayList<String> remainingExams = null;
				
				Student student = new Student(surname, name, dateOfBirth, residentialAddress, telephoneNumber, eMail, indexNumber, yearOfEnrollment, currentYearOfStudy,
						status, averageGrade, passedExams, remainingExams);
				
				StudentController.getInstance().addStudent(student);
			}
		});
		cancel = new JButton("Odustani");
		buttonPanel.add(confirm);
		buttonPanel.add(cancel);
		panelCenter.add(buttonPanel);
	}


	public JPanel getPanelCenter() {
		return panelCenter;
	}


	public void setPanelCenter(JPanel panelCenter) {
		this.panelCenter = panelCenter;
	}


	public BoxLayout getBoxLayout() {
		return boxLayout;
	}


	public void setBoxLayout(BoxLayout boxLayout) {
		this.boxLayout = boxLayout;
	}


	public JPanel getSurnamePan() {
		return surnamePan;
	}


	public void setSurnamePan(JPanel surnamePan) {
		this.surnamePan = surnamePan;
	}


	public JLabel getSurnameLab() {
		return surnameLab;
	}


	public void setSurnameLab(JLabel surnameLab) {
		this.surnameLab = surnameLab;
	}


	public JTextField getSurnameText() {
		return surnameText;
	}


	public void setSurnameText(JTextField surnameText) {
		this.surnameText = surnameText;
	}


	public JPanel getNamePan() {
		return namePan;
	}


	public void setNamePan(JPanel namePan) {
		this.namePan = namePan;
	}


	public JLabel getNameLab() {
		return nameLab;
	}


	public void setNameLab(JLabel nameLab) {
		this.nameLab = nameLab;
	}


	public JTextField getNameText() {
		return nameText;
	}


	public void setNameText(JTextField nameText) {
		this.nameText = nameText;
	}


	public JPanel getDobPan() {
		return dobPan;
	}


	public void setDobPan(JPanel dobPan) {
		this.dobPan = dobPan;
	}


	public JLabel getDobLab() {
		return dobLab;
	}


	public void setDobLab(JLabel dobLab) {
		this.dobLab = dobLab;
	}


	public JTextField getDobText() {
		return dobText;
	}


	public void setDobText(JTextField dobText) {
		this.dobText = dobText;
	}


	public JPanel getStreetPan() {
		return streetPan;
	}


	public void setStreetPan(JPanel streetPan) {
		this.streetPan = streetPan;
	}


	public JLabel getStreetLab() {
		return streetLab;
	}


	public void setStreetLab(JLabel streetLab) {
		this.streetLab = streetLab;
	}


	public JTextField getStreetText() {
		return streetText;
	}


	public void setStreetText(JTextField streetText) {
		this.streetText = streetText;
	}


	public JPanel getNosPan() {
		return nosPan;
	}


	public void setNosPan(JPanel nosPan) {
		this.nosPan = nosPan;
	}


	public JLabel getNosLab() {
		return nosLab;
	}


	public void setNosLab(JLabel nosLab) {
		this.nosLab = nosLab;
	}


	public JTextField getNosText() {
		return nosText;
	}


	public void setNosText(JTextField nosText) {
		this.nosText = nosText;
	}


	public JPanel getCityPan() {
		return cityPan;
	}


	public void setCityPan(JPanel cityPan) {
		this.cityPan = cityPan;
	}


	public JLabel getCityLab() {
		return cityLab;
	}


	public void setCityLab(JLabel cityLab) {
		this.cityLab = cityLab;
	}


	public JTextField getCityText() {
		return cityText;
	}


	public void setCityText(JTextField cityText) {
		this.cityText = cityText;
	}


	public JPanel getCountryPan() {
		return countryPan;
	}


	public void setCountryPan(JPanel countryPan) {
		this.countryPan = countryPan;
	}


	public JLabel getCountryLab() {
		return countryLab;
	}


	public void setCountryLab(JLabel countryLab) {
		this.countryLab = countryLab;
	}


	public JTextField getCountryText() {
		return countryText;
	}


	public void setCountryText(JTextField countryText) {
		this.countryText = countryText;
	}


	public JPanel getTelPan() {
		return telPan;
	}


	public void setTelPan(JPanel telPan) {
		this.telPan = telPan;
	}


	public JLabel getTelLab() {
		return telLab;
	}


	public void setTelLab(JLabel telLab) {
		this.telLab = telLab;
	}


	public JTextField getTelText() {
		return telText;
	}


	public void setTelText(JTextField telText) {
		this.telText = telText;
	}


	public JPanel getMailPan() {
		return mailPan;
	}


	public void setMailPan(JPanel mailPan) {
		this.mailPan = mailPan;
	}


	public JLabel getMailLab() {
		return mailLab;
	}


	public void setMailLab(JLabel mailLab) {
		this.mailLab = mailLab;
	}


	public JTextField getMailText() {
		return mailText;
	}


	public void setMailText(JTextField mailText) {
		this.mailText = mailText;
	}


	public JPanel getIndexPan() {
		return indexPan;
	}


	public void setIndexPan(JPanel indexPan) {
		this.indexPan = indexPan;
	}


	public JLabel getIndexLab() {
		return indexLab;
	}


	public void setIndexLab(JLabel indexLab) {
		this.indexLab = indexLab;
	}


	public JTextField getIndexText() {
		return indexText;
	}


	public void setIndexText(JTextField indexText) {
		this.indexText = indexText;
	}


	public JPanel getYoePan() {
		return yoePan;
	}


	public void setYoePan(JPanel yoePan) {
		this.yoePan = yoePan;
	}


	public JLabel getYoeLab() {
		return yoeLab;
	}


	public void setYoeLab(JLabel yoeLab) {
		this.yoeLab = yoeLab;
	}


	public JTextField getYoeText() {
		return yoeText;
	}


	public void setYoeText(JTextField yoeText) {
		this.yoeText = yoeText;
	}


	public JPanel getCyosPan() {
		return cyosPan;
	}


	public void setCyosPan(JPanel cyosPan) {
		this.cyosPan = cyosPan;
	}


	public JLabel getCyosLab() {
		return cyosLab;
	}


	public void setCyosLab(JLabel cyosLab) {
		this.cyosLab = cyosLab;
	}


	public JComboBox<String> getYear() {
		return year;
	}


	public void setYear(JComboBox<String> year) {
		this.year = year;
	}


	public DefaultComboBoxModel<String> getYearModel() {
		return yearModel;
	}


	public void setYearModel(DefaultComboBoxModel<String> yearModel) {
		this.yearModel = yearModel;
	}


	public JPanel getStatusPan() {
		return statusPan;
	}


	public void setStatusPan(JPanel statusPan) {
		this.statusPan = statusPan;
	}


	public JLabel getStatusLab() {
		return statusLab;
	}


	public void setStatusLab(JLabel statusLab) {
		this.statusLab = statusLab;
	}


	public JComboBox<String> getStatus() {
		return status;
	}


	public void setStatus(JComboBox<String> status) {
		this.status = status;
	}


	public DefaultComboBoxModel<String> getStatusModel() {
		return statusModel;
	}


	public void setStatusModel(DefaultComboBoxModel<String> statusModel) {
		this.statusModel = statusModel;
	}


	public JPanel getButtonPanel() {
		return buttonPanel;
	}


	public void setButtonPanel(JPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
	}


	public JButton getCancel() {
		return cancel;
	}


	public void setCancel(JButton cancel) {
		this.cancel = cancel;
	}


	public JButton getConfirm() {
		return confirm;
	}


	public void setConfirm(JButton confirm) {
		this.confirm = confirm;
	}
	
	
}
