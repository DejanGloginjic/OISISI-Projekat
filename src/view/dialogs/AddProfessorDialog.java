package view.dialogs;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ProfessorController;
import localization.Language;
import model.entities.Adress;
import model.entities.Course;
import model.entities.Professor;
import view.listeners.MyActionListenerCancleProfessor;
import view.listeners.MyActionListenerConfirmProfessor;
import view.listeners.MyFocusListenerCityValidationForProfessor;
import view.listeners.MyFocusListenerCountryValidationForProfessor;
import view.listeners.MyFocusListenerDateValidationForProfessor;
import view.listeners.MyFocusListenerEmailValidationForProfessor;
import view.listeners.MyFocusListenerIdNumberValidationForProfessor;
import view.listeners.MyFocusListenerNameValidationForProfessor;
import view.listeners.MyFocusListenerNosValidationForProfessor;
import view.listeners.MyFocusListenerStreetValidationForProfessor;
import view.listeners.MyFocusListenerSurnameValidationForProfessor;
import view.listeners.MyFocusListenerTelephoneValidationForProfessor;
import view.listeners.MyFocusListenerYearsValidationForProfessor;
import view.window.MyMainFrame;

public class AddProfessorDialog extends JDialog{
	
	private static AddProfessorDialog instance=null;
	
	public static AddProfessorDialog getInstance() {
		if (instance == null) {
			instance = new AddProfessorDialog();
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
	
	private AddProfessorDialog() {
		setTitle(Language.getInstance().getResourceBundle().getString("addProfessor"));
		setSize(450,600);
		setLocationRelativeTo(MyMainFrame.getInstance());
		setModal(true);
		
		Dimension dim = new Dimension(150, 20);
		
		panelCenter = new JPanel();
		boxLayout = new BoxLayout(panelCenter, BoxLayout.Y_AXIS);
		panelCenter.setLayout(boxLayout);
		add(panelCenter);
		
		namePan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		nameLab = new JLabel(Language.getInstance().getResourceBundle().getString("name"));
		nameLab.setPreferredSize(dim);
		nameText = new JTextField();
		nameText.addFocusListener(new MyFocusListenerNameValidationForProfessor());
		nameText.setPreferredSize(dim);
		
		namePan.add(nameLab);
		namePan.add(nameText);
		panelCenter.add(namePan);
		
		surnamePan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		surnameLab = new JLabel(Language.getInstance().getResourceBundle().getString("surname"));
		surnameLab.setPreferredSize(dim);
		surnameText = new JTextField();
		surnameText.addFocusListener(new MyFocusListenerSurnameValidationForProfessor());
		surnameText.setPreferredSize(dim);
		surnamePan.add(surnameLab);
		surnamePan.add(surnameText);
		panelCenter.add(surnamePan);
		
		dateOfBirthPan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		dateOfBirthLab = new JLabel(Language.getInstance().getResourceBundle().getString("dateofBirth"));
		dateOfBirthLab.setPreferredSize(dim);
		dateOfBirthText = new JTextField();
		dateOfBirthText.addFocusListener(new MyFocusListenerDateValidationForProfessor());
		dateOfBirthText.setPreferredSize(dim);
		dateOfBirthPan.add(dateOfBirthLab);
		dateOfBirthPan.add(dateOfBirthText);
		panelCenter.add(dateOfBirthPan);

		streetPan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		streetLab = new JLabel(Language.getInstance().getResourceBundle().getString("street"));
		streetLab.setPreferredSize(dim);
		streetText = new JTextField();
		streetText.addFocusListener(new MyFocusListenerStreetValidationForProfessor());
		streetText.setPreferredSize(dim);
		streetPan.add(streetLab);
		streetPan.add(streetText);
		panelCenter.add(streetPan);
		
		nosPan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		nosLab = new JLabel(Language.getInstance().getResourceBundle().getString("nos"));
		nosLab.setPreferredSize(dim);
		nosText = new JTextField();
		nosText.setPreferredSize(dim);
		nosText.addFocusListener(new MyFocusListenerNosValidationForProfessor());
		nosPan.add(nosLab);
		nosPan.add(nosText);
		panelCenter.add(nosPan);
		
		cityPan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cityLab = new JLabel(Language.getInstance().getResourceBundle().getString("city"));
		cityLab.setPreferredSize(dim);
		cityText = new JTextField();
		cityText.addFocusListener(new MyFocusListenerCityValidationForProfessor());
		cityText.setPreferredSize(dim);
		cityPan.add(cityLab);
		cityPan.add(cityText);
		panelCenter.add(cityPan);
		
		countryPan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		countryLab = new JLabel(Language.getInstance().getResourceBundle().getString("country"));
		countryLab.setPreferredSize(dim);
		countryText = new JTextField();
		countryText.addFocusListener(new MyFocusListenerCountryValidationForProfessor());
		countryText.setPreferredSize(dim);
		countryPan.add(countryLab);
		countryPan.add(countryText);
		panelCenter.add(countryPan);
		
		telephoneNumberPan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		telephoneNumberLab = new JLabel(Language.getInstance().getResourceBundle().getString("tel"));
		telephoneNumberLab.setPreferredSize(dim);
		telephoneNumberText = new JTextField();
		telephoneNumberText.setPreferredSize(dim);
		telephoneNumberText.addFocusListener(new MyFocusListenerTelephoneValidationForProfessor());
		telephoneNumberPan.add(telephoneNumberLab);
		telephoneNumberPan.add(telephoneNumberText);
		panelCenter.add(telephoneNumberPan);
		
		eMailPan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		eMailLab = new JLabel(Language.getInstance().getResourceBundle().getString("email"));
		eMailLab.setPreferredSize(dim);
		eMailText = new JTextField();
		eMailText.setPreferredSize(dim);
		eMailText.addFocusListener(new MyFocusListenerEmailValidationForProfessor());
		eMailPan.add(eMailLab);
		eMailPan.add(eMailText);
		panelCenter.add(eMailPan);
		
		streetOfficePan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		streetOfficeLab = new JLabel(Language.getInstance().getResourceBundle().getString("streetO"));
		streetOfficeLab.setPreferredSize(dim);
		streetOfficeText = new JTextField();
		streetOfficeText.setPreferredSize(dim);
		streetOfficePan.add(streetOfficeLab);
		streetOfficePan.add(streetOfficeText);
		panelCenter.add(streetOfficePan);
		
		nosOfficePan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		nosOfficeLab = new JLabel(Language.getInstance().getResourceBundle().getString("nosO"));
		nosOfficeLab.setPreferredSize(dim);
		nosOfficeText = new JTextField();
		nosOfficeText.setPreferredSize(dim);
		nosOfficePan.add(nosOfficeLab);
		nosOfficePan.add(nosOfficeText);
		panelCenter.add(nosOfficePan);
		
		cityOfficePan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cityOfficeLab = new JLabel(Language.getInstance().getResourceBundle().getString("cityO"));
		cityOfficeLab.setPreferredSize(dim);
		cityOfficeText = new JTextField();
		cityOfficeText.setPreferredSize(dim);
		cityOfficePan.add(cityOfficeLab);
		cityOfficePan.add(cityOfficeText);
		panelCenter.add(cityOfficePan);
		
		countryOfficePan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		countryOfficeLab = new JLabel(Language.getInstance().getResourceBundle().getString("countryO"));
		countryOfficeLab.setPreferredSize(dim);
		countryOfficeText = new JTextField();
		countryOfficeText.setPreferredSize(dim);
		countryOfficePan.add(countryOfficeLab);
		countryOfficePan.add(countryOfficeText);
		panelCenter.add(countryOfficePan);
		
		IdNumberPan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		IdNumberLab = new JLabel(Language.getInstance().getResourceBundle().getString("idNum"));
		IdNumberLab.setPreferredSize(dim);
		IdNumberText = new JTextField();
		IdNumberText.setPreferredSize(dim);
		IdNumberText.addFocusListener(new MyFocusListenerIdNumberValidationForProfessor());
		IdNumberPan.add(IdNumberLab);
		IdNumberPan.add(IdNumberText);
		panelCenter.add(IdNumberPan);
		
		titlePan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		titleLab = new JLabel(Language.getInstance().getResourceBundle().getString("title"));
		titleLab.setPreferredSize(dim);
		titleText = new JTextField();
		titleText.setPreferredSize(dim);
		titlePan.add(titleLab);
		titlePan.add(titleText);
		panelCenter.add(titlePan);
		
		yearOfTrailPan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		yearOfTrailLab = new JLabel(Language.getInstance().getResourceBundle().getString("years"));
		yearOfTrailLab.setPreferredSize(dim);
		yearOfTrailText = new JTextField();
		yearOfTrailText.setPreferredSize(dim);
		yearOfTrailText.addFocusListener(new MyFocusListenerYearsValidationForProfessor());
		yearOfTrailPan.add(yearOfTrailLab);
		yearOfTrailPan.add(yearOfTrailText);
		panelCenter.add(yearOfTrailPan);
		
		buttonPanel = new JPanel();
		confirm = new JButton(Language.getInstance().getResourceBundle().getString("confirm"));
		confirm.addActionListener(new MyActionListenerConfirmProfessor());
		cancel = new JButton(Language.getInstance().getResourceBundle().getString("cancel"));
		cancel.addActionListener(new MyActionListenerCancleProfessor());
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
	public JPanel getDateOfBirthPan() {
		return dateOfBirthPan;
	}
	public void setDateOfBirthPan(JPanel dateOfBirthPan) {
		this.dateOfBirthPan = dateOfBirthPan;
	}
	public JLabel getDateOfBirthLab() {
		return dateOfBirthLab;
	}
	public void setDateOfBirthLab(JLabel dateOfBirthLab) {
		this.dateOfBirthLab = dateOfBirthLab;
	}
	public JTextField getDateOfBirthText() {
		return dateOfBirthText;
	}
	public void setDateOfBirthText(JTextField dateOfBirthText) {
		this.dateOfBirthText = dateOfBirthText;
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

	public JPanel getNosOfficePan() {
		return nosOfficePan;
	}

	public void setNosOfficePan(JPanel nosOfficePan) {
		this.nosOfficePan = nosOfficePan;
	}

	public JLabel getNosOfficeLab() {
		return nosOfficeLab;
	}

	public void setNosOfficeLab(JLabel nosOfficeLab) {
		this.nosOfficeLab = nosOfficeLab;
	}

	public JTextField getNosOfficeText() {
		return nosOfficeText;
	}

	public void setNosOfficeText(JTextField nosOfficeText) {
		this.nosOfficeText = nosOfficeText;
	}

	public JPanel getCityOfficePan() {
		return cityOfficePan;
	}

	public void setCityOfficePan(JPanel cityOfficePan) {
		this.cityOfficePan = cityOfficePan;
	}

	public JLabel getCityOfficeLab() {
		return cityOfficeLab;
	}

	public void setCityOfficeLab(JLabel cityOfficeLab) {
		this.cityOfficeLab = cityOfficeLab;
	}

	public JTextField getCityOfficeText() {
		return cityOfficeText;
	}

	public void setCityOfficeText(JTextField cityOfficeText) {
		this.cityOfficeText = cityOfficeText;
	}

	public JPanel getCountryOfficePan() {
		return countryOfficePan;
	}

	public void setCountryOfficePan(JPanel countryOfficePan) {
		this.countryOfficePan = countryOfficePan;
	}

	public JLabel getCountryOfficeLab() {
		return countryOfficeLab;
	}

	public void setCountryOfficeLab(JLabel countryOfficeLab) {
		this.countryOfficeLab = countryOfficeLab;
	}

	public JTextField getCountryOfficeText() {
		return countryOfficeText;
	}

	public void setCountryOfficeText(JTextField countryOfficeText) {
		this.countryOfficeText = countryOfficeText;
	}

	public JPanel getTelephoneNumberPan() {
		return telephoneNumberPan;
	}
	public void setTelephoneNumberPan(JPanel telephoneNumberPan) {
		this.telephoneNumberPan = telephoneNumberPan;
	}
	public JLabel getTelephoneNumberLab() {
		return telephoneNumberLab;
	}
	public void setTelephoneNumberLab(JLabel telephoneNumberLab) {
		this.telephoneNumberLab = telephoneNumberLab;
	}
	public JTextField getTelephoneNumberText() {
		return telephoneNumberText;
	}
	public void setTelephoneNumberText(JTextField telephoneNumberText) {
		this.telephoneNumberText = telephoneNumberText;
	}
	public JPanel geteMailPan() {
		return eMailPan;
	}
	public void seteMailPan(JPanel eMailPan) {
		this.eMailPan = eMailPan;
	}
	public JLabel geteMailLab() {
		return eMailLab;
	}
	public void seteMailLab(JLabel eMailLab) {
		this.eMailLab = eMailLab;
	}
	public JTextField geteMailText() {
		return eMailText;
	}
	public void seteMailText(JTextField eMailText) {
		this.eMailText = eMailText;
	}
	public JPanel getIdNumberPan() {
		return IdNumberPan;
	}
	public void setIdNumberPan(JPanel idNumberPan) {
		IdNumberPan = idNumberPan;
	}
	public JLabel getIdNumberLab() {
		return IdNumberLab;
	}
	public void setIdNumberLab(JLabel idNumberLab) {
		IdNumberLab = idNumberLab;
	}
	public JTextField getIdNumberText() {
		return IdNumberText;
	}
	public void setIdNumberText(JTextField idNumberText) {
		IdNumberText = idNumberText;
	}
	public JPanel getTitlePan() {
		return titlePan;
	}
	public void setTitlePan(JPanel titlePan) {
		this.titlePan = titlePan;
	}
	public JLabel getTitleLab() {
		return titleLab;
	}
	public void setTitleLab(JLabel titleLab) {
		this.titleLab = titleLab;
	}
	public JTextField getTitleText() {
		return titleText;
	}
	public void setTitleText(JTextField titleText) {
		this.titleText = titleText;
	}
	public JPanel getYearOfTrailPan() {
		return yearOfTrailPan;
	}
	public void setYearOfTrailPan(JPanel yearOfTrailPan) {
		this.yearOfTrailPan = yearOfTrailPan;
	}
	public JLabel getYearOfTrailLab() {
		return yearOfTrailLab;
	}
	public void setYearOfTrailLab(JLabel yearOfTrailLab) {
		this.yearOfTrailLab = yearOfTrailLab;
	}
	public JTextField getYearOfTrailText() {
		return yearOfTrailText;
	}
	public void setYearOfTrailText(JTextField yearOfTrailText) {
		this.yearOfTrailText = yearOfTrailText;
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
	public static void setInstance(AddProfessorDialog instance) {
		AddProfessorDialog.instance = instance;
	}

	public JPanel getStreetOfficePan() {
		return streetOfficePan;
	}

	public void setStreetOfficePan(JPanel streetOfficePan) {
		this.streetOfficePan = streetOfficePan;
	}

	public JLabel getStreetOfficeLab() {
		return streetOfficeLab;
	}

	public void setStreetOfficeLab(JLabel streetOfficeLab) {
		this.streetOfficeLab = streetOfficeLab;
	}

	public JTextField getStreetOfficeText() {
		return streetOfficeText;
	}

	public void setStreetOfficeText(JTextField streetOfficeText) {
		this.streetOfficeText = streetOfficeText;
	}
	
	public void updateComponent() {
		
		this.setTitle(Language.getInstance().getResourceBundle().getString("addProfessor"));
		nameLab.setText(Language.getInstance().getResourceBundle().getString("name"));
		surnameLab.setText(Language.getInstance().getResourceBundle().getString("surname"));
		dateOfBirthLab.setText(Language.getInstance().getResourceBundle().getString("dateofBirth"));
		streetLab.setText(Language.getInstance().getResourceBundle().getString("street"));
		nosLab.setText(Language.getInstance().getResourceBundle().getString("nos"));
		cityLab.setText(Language.getInstance().getResourceBundle().getString("city"));
		countryLab.setText(Language.getInstance().getResourceBundle().getString("country"));
		telephoneNumberLab.setText(Language.getInstance().getResourceBundle().getString("tel"));
		eMailLab.setText(Language.getInstance().getResourceBundle().getString("email"));
		streetOfficeLab.setText(Language.getInstance().getResourceBundle().getString("streetO"));
		nosOfficeLab.setText(Language.getInstance().getResourceBundle().getString("nosO"));
		cityOfficeLab.setText(Language.getInstance().getResourceBundle().getString("cityO"));
		countryOfficeLab.setText(Language.getInstance().getResourceBundle().getString("countryO"));
		IdNumberLab.setText(Language.getInstance().getResourceBundle().getString("idNum"));
		titleLab.setText(Language.getInstance().getResourceBundle().getString("title"));
		yearOfTrailLab.setText(Language.getInstance().getResourceBundle().getString("years"));
		confirm.setText(Language.getInstance().getResourceBundle().getString("confirm"));
		cancel.setText(Language.getInstance().getResourceBundle().getString("cancel"));

	}
}
