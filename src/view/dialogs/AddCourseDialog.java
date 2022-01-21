package view.dialogs;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import enumerations.Semester;
import localization.Language;
import model.entities.Professor;
import view.listeners.MyActionListenerCancelStudent;
import view.listeners.MyActionListenerCofirmStudent;
import view.listeners.MyActionListenerConfirmCourse;
import view.listeners.MyFocusListenerCodeValidationForCourse;
import view.listeners.MyFocusListenerESPBValidationForCourse;
import view.listeners.MyFocusListenerNameValidation;
import view.listeners.MyFocusListenerNameValidationForCourse;
import view.window.MyMainFrame;

public class AddCourseDialog extends JDialog{
	
	private static AddCourseDialog instance = null;

	public static AddCourseDialog getInstance() {
		if (instance == null) {
			instance = new AddCourseDialog();
		}
		return instance;
	}
	
	private JPanel panelCenter;
	private BoxLayout boxLayout;
	
	private JPanel codePan;
	private JLabel codeLab;
	private JTextField codeText;
	
	private JPanel namePan;
	private JLabel nameLab;
	private JTextField nameText;
	
	private JPanel yearOfTheCoursePan;
	private JLabel yearOfTheCourseLab;
	private JComboBox<String> yearOfTheCourse;
	private DefaultComboBoxModel<String> yearOfTheCourseModel;
	
	private JPanel semesterPan;
	private JLabel semesterLab;
	private JComboBox<String> semester;
	private DefaultComboBoxModel<String> semesterModel;
	
	private JPanel numberOfESPBPan;
	private JLabel numberOfESPBLab;
	private JTextField numberOfESPBText;
	
	private JPanel buttonPanel;
	private JButton cancel;
	private JButton confirm;
	
	private AddCourseDialog() {
		
		setTitle( Language.getInstance().getResourceBundle().getString("courseAdd"));
		setSize(350, 250);
		setLocationRelativeTo(MyMainFrame.getInstance());
		setModal(true);
		
		Dimension dim = new Dimension(150, 20);
		
		panelCenter = new JPanel();
		boxLayout = new BoxLayout(panelCenter, BoxLayout.Y_AXIS);
		panelCenter.setLayout(boxLayout);
		add(panelCenter);
		
		codePan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		codeLab = new JLabel(Language.getInstance().getResourceBundle().getString("courseCode*"));
		codeLab.setPreferredSize(dim);
		codeText = new JTextField();
		codeText.setPreferredSize(dim);
		codeText.addFocusListener(new MyFocusListenerCodeValidationForCourse());
		codePan.add(codeLab);
		codePan.add(codeText);
		panelCenter.add(codePan);
		
		namePan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		nameLab = new JLabel(Language.getInstance().getResourceBundle().getString("courseName*"));
		nameLab.setPreferredSize(dim);
		nameText = new JTextField();
		nameText.setPreferredSize(dim);
		nameText.addFocusListener(new MyFocusListenerNameValidationForCourse());
		namePan.add(nameLab);
		namePan.add(nameText);
		panelCenter.add(namePan);
		
		yearOfTheCoursePan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		yearOfTheCourseLab = new JLabel(Language.getInstance().getResourceBundle().getString("courseYear*"));
		yearOfTheCourseLab.setPreferredSize(dim);
		yearOfTheCourse = new JComboBox<String>();
		yearOfTheCourseModel = new DefaultComboBoxModel<String>();
		yearOfTheCourseModel.addElement(Language.getInstance().getResourceBundle().getString("first"));
		yearOfTheCourseModel.addElement(Language.getInstance().getResourceBundle().getString("second"));
		yearOfTheCourseModel.addElement(Language.getInstance().getResourceBundle().getString("third"));
		yearOfTheCourseModel.addElement(Language.getInstance().getResourceBundle().getString("fourth"));
		yearOfTheCourseModel.addElement(Language.getInstance().getResourceBundle().getString("fifth"));
		yearOfTheCourseModel.addElement(Language.getInstance().getResourceBundle().getString("sixth"));
		yearOfTheCourse.setModel(yearOfTheCourseModel);
		yearOfTheCourse.setSelectedIndex(0);
		yearOfTheCourse.setPreferredSize(dim);
		yearOfTheCoursePan.add(yearOfTheCourseLab);
		yearOfTheCoursePan.add(yearOfTheCourse);
		panelCenter.add(yearOfTheCoursePan);
		
		semesterPan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		semesterLab = new JLabel(Language.getInstance().getResourceBundle().getString("semester"));
		semesterLab.setPreferredSize(dim);
		semester = new JComboBox<String>();
		semesterModel = new DefaultComboBoxModel<String>();
		semesterModel.addElement(Language.getInstance().getResourceBundle().getString("summer"));
		semesterModel.addElement(Language.getInstance().getResourceBundle().getString("winter"));
		semester.setModel(semesterModel);
		semester.setSelectedIndex(0);
		semester.setPreferredSize(dim);
		semesterPan.add(semesterLab);
		semesterPan.add(semester);
		panelCenter.add(semesterPan);
		
		numberOfESPBPan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		numberOfESPBLab = new JLabel("ESPB*");
		numberOfESPBLab.setPreferredSize(dim);
		numberOfESPBText = new JTextField();
		numberOfESPBText.setPreferredSize(dim);
		numberOfESPBText.addFocusListener(new MyFocusListenerESPBValidationForCourse());
		numberOfESPBPan.add(numberOfESPBLab);
		numberOfESPBPan.add(numberOfESPBText);
		panelCenter.add(numberOfESPBPan);
		
		buttonPanel = new JPanel();
		confirm = new JButton(Language.getInstance().getResourceBundle().getString("confirm"));
		confirm.addActionListener(new MyActionListenerConfirmCourse());
		//confirm.setEnabled(false);
		cancel = new JButton(Language.getInstance().getResourceBundle().getString("cancel"));
		//cancel.addActionListener(new MyActionListenerCancelStudent());
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

	public JPanel getCodePan() {
		return codePan;
	}

	public void setCodePan(JPanel codePan) {
		this.codePan = codePan;
	}

	public JLabel getCodeLab() {
		return codeLab;
	}

	public void setCodeLab(JLabel codeLab) {
		this.codeLab = codeLab;
	}

	public JTextField getCodeText() {
		return codeText;
	}

	public void setCodeText(JTextField codeText) {
		this.codeText = codeText;
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

	public JPanel getYearOfTheCoursePan() {
		return yearOfTheCoursePan;
	}

	public void setYearOfTheCoursePan(JPanel yearOfTheCoursePan) {
		this.yearOfTheCoursePan = yearOfTheCoursePan;
	}

	public JLabel getYearOfTheCourseLab() {
		return yearOfTheCourseLab;
	}

	public void setYearOfTheCourseLab(JLabel yearOfTheCourseLab) {
		this.yearOfTheCourseLab = yearOfTheCourseLab;
	}

	public JComboBox<String> getYearOfTheCourse() {
		return yearOfTheCourse;
	}

	public void setYearOfTheCourse(JComboBox<String> yearOfTheCourse) {
		this.yearOfTheCourse = yearOfTheCourse;
	}

	public DefaultComboBoxModel<String> getYearOfTheCourseModel() {
		return yearOfTheCourseModel;
	}

	public void setYearOfTheCourseModel(DefaultComboBoxModel<String> yearOfTheCourseModel) {
		this.yearOfTheCourseModel = yearOfTheCourseModel;
	}

	public JPanel getSemesterPan() {
		return semesterPan;
	}

	public void setSemesterPan(JPanel semesterPan) {
		this.semesterPan = semesterPan;
	}

	public JLabel getSemesterLab() {
		return semesterLab;
	}

	public void setSemesterLab(JLabel semesterLab) {
		this.semesterLab = semesterLab;
	}

	public JComboBox<String> getSemester() {
		return semester;
	}

	public void setSemester(JComboBox<String> semester) {
		this.semester = semester;
	}

	public DefaultComboBoxModel<String> getSemesterModel() {
		return semesterModel;
	}

	public void setSemesterModel(DefaultComboBoxModel<String> semesterModel) {
		this.semesterModel = semesterModel;
	}

	public JPanel getNumberOfESPBPan() {
		return numberOfESPBPan;
	}

	public void setNumberOfESPBPan(JPanel numberOfESPBPan) {
		this.numberOfESPBPan = numberOfESPBPan;
	}

	public JLabel getNumberOfESPBLab() {
		return numberOfESPBLab;
	}

	public void setNumberOfESPBLab(JLabel numberOfESPBLab) {
		this.numberOfESPBLab = numberOfESPBLab;
	}

	public JTextField getNumberOfESPBText() {
		return numberOfESPBText;
	}

	public void setNumberOfESPBText(JTextField numberOfESPBText) {
		this.numberOfESPBText = numberOfESPBText;
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

	public static void setInstance(AddCourseDialog instance) {
		AddCourseDialog.instance = instance;
	}
	
	public void updateComponent() {
		
		this.setTitle( Language.getInstance().getResourceBundle().getString("courseAdd"));
		codeLab.setText(Language.getInstance().getResourceBundle().getString("courseCode*"));
		nameLab.setText(Language.getInstance().getResourceBundle().getString("courseName*"));
		yearOfTheCourseLab.setText(Language.getInstance().getResourceBundle().getString("courseYear*"));
		codeLab.setText(Language.getInstance().getResourceBundle().getString("courseCode*"));
		codeLab.setText(Language.getInstance().getResourceBundle().getString("courseCode*"));
		this.yearOfTheCourseModel.removeAllElements();
		yearOfTheCourseModel.addElement(Language.getInstance().getResourceBundle().getString("first"));
		yearOfTheCourseModel.addElement(Language.getInstance().getResourceBundle().getString("second"));
		yearOfTheCourseModel.addElement(Language.getInstance().getResourceBundle().getString("third"));
		yearOfTheCourseModel.addElement(Language.getInstance().getResourceBundle().getString("fourth"));
		yearOfTheCourseModel.addElement(Language.getInstance().getResourceBundle().getString("fifth"));
		yearOfTheCourseModel.addElement(Language.getInstance().getResourceBundle().getString("sixth"));
		semesterLab.setText(Language.getInstance().getResourceBundle().getString("semester"));
		cancel.setText(Language.getInstance().getResourceBundle().getString("cancel"));
		confirm.setText(Language.getInstance().getResourceBundle().getString("confirm"));
		this.semesterModel.removeAllElements();
		semesterModel.addElement(Language.getInstance().getResourceBundle().getString("summer"));
		semesterModel.addElement(Language.getInstance().getResourceBundle().getString("winter"));
	}
}
