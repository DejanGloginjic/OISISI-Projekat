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

import view.panels.MyPanelRemainingExams;


public class GradeEntryDialog extends JDialog{

	
	private static GradeEntryDialog instance = null;

	public static GradeEntryDialog getInstance() {
		if (instance == null) {
			instance = new GradeEntryDialog();
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
	
	private JPanel gradePan;
	private JLabel gradeLab;
	private JComboBox<String> grade;
	private DefaultComboBoxModel<String> gradeModel;
	
	private JPanel datePan;
	private JLabel dateLab;
	private JTextField dateText;
	
	private JPanel buttonPanel;
	private JButton cancel;
	private JButton confirm;
	
	private GradeEntryDialog() {
		
		setTitle("Unos ocene");
		setSize(350, 250);
		setLocationRelativeTo(EditStudentDialog.getInstance());
		setModal(true);
		
		Dimension dim = new Dimension(150, 20);
		
		panelCenter = new JPanel();
		boxLayout = new BoxLayout(panelCenter, BoxLayout.Y_AXIS);
		panelCenter.setLayout(boxLayout);
		add(panelCenter);
		
		codePan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		codeLab = new JLabel("Šifra*");
		codeLab.setPreferredSize(dim);
		codeText = new JTextField();
		codeText.setPreferredSize(dim);
		codePan.add(codeLab);
		codePan.add(codeText);
		panelCenter.add(codePan);
		
		namePan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		nameLab = new JLabel("Naziv*");
		nameLab.setPreferredSize(dim);
		nameText = new JTextField();
		nameText.setPreferredSize(dim);
		namePan.add(nameLab);
		namePan.add(nameText);
		panelCenter.add(namePan);
		
		gradePan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		gradeLab = new JLabel("Ocena*");
		gradeLab.setPreferredSize(dim);
		grade = new JComboBox<String>();
		gradeModel = new DefaultComboBoxModel<String>();
		gradeModel.addElement("6");
		gradeModel.addElement("7");
		gradeModel.addElement("8");
		gradeModel.addElement("9");
		gradeModel.addElement("10");
		grade.setModel(gradeModel);
		grade.setSelectedIndex(0);
		grade.setPreferredSize(dim);
		gradePan.add(gradeLab);
		gradePan.add(grade);
		panelCenter.add(gradePan);
		
		
		datePan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		dateLab = new JLabel("Datum*");
		dateLab.setPreferredSize(dim);
		dateText = new JTextField();
		dateText.setPreferredSize(dim);
		datePan.add(dateLab);
		datePan.add(dateText);
		panelCenter.add(datePan);
		
		buttonPanel = new JPanel();
		confirm = new JButton("Potvrdi");
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

	public JPanel getGradePan() {
		return gradePan;
	}

	public void setGradePan(JPanel gradePan) {
		this.gradePan = gradePan;
	}

	public JLabel getGradeLab() {
		return gradeLab;
	}

	public void setGradeLab(JLabel gradeLab) {
		this.gradeLab = gradeLab;
	}

	public JComboBox<String> getGrade() {
		return grade;
	}

	public void setGrade(JComboBox<String> grade) {
		this.grade = grade;
	}

	public DefaultComboBoxModel<String> getGradeModel() {
		return gradeModel;
	}

	public void setGradeModel(DefaultComboBoxModel<String> gradeModel) {
		this.gradeModel = gradeModel;
	}

	public JPanel getDatePan() {
		return datePan;
	}

	public void setDatePan(JPanel datePan) {
		this.datePan = datePan;
	}

	public JLabel getDateLab() {
		return dateLab;
	}

	public void setDateLab(JLabel dateLab) {
		this.dateLab = dateLab;
	}

	public JTextField getDateText() {
		return dateText;
	}

	public void setDateText(JTextField dateText) {
		this.dateText = dateText;
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

	public static void setInstance(GradeEntryDialog instance) {
		GradeEntryDialog.instance = instance;
	}

}