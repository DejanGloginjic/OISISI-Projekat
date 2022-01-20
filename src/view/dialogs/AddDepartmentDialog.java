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

import localization.Language;
import model.dataBase.ProfessorBase;
import model.entities.Professor;
import view.dialogs.AddCourseDialog;
import view.listeners.MyActionListenerConfirmAddDepartment;
import view.listeners.MyActionListenerConfirmCourse;
import view.listeners.MyFocusListenerCodeValidationForCourse;
import view.listeners.MyFocusListenerNameValidationForCourse;
import view.window.MyMainFrame;

public class AddDepartmentDialog extends JDialog{
	private static AddDepartmentDialog instance = null;

	public static AddDepartmentDialog getInstance() {
		if (instance == null) {
			instance = new AddDepartmentDialog();
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
	
	private JPanel bossIdPan;
	private JLabel bossIdLab;
	private JComboBox<String> bossId;
	private DefaultComboBoxModel<String> bossIdModel;
	
	private JPanel buttonPanel;
	private JButton cancel;
	private JButton confirm;
	
	private AddDepartmentDialog() {
		
		setTitle("Dodavanje katedre");
		setSize(350, 250);
		setLocationRelativeTo(DepartmentDialog.getInstance());
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
		//codeText.addFocusListener(new MyFocusListenerCodeValidationForCourse());
		codePan.add(codeLab);
		codePan.add(codeText);
		panelCenter.add(codePan);
		
		namePan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		nameLab = new JLabel("Naziv*");
		nameLab.setPreferredSize(dim);
		nameText = new JTextField();
		nameText.setPreferredSize(dim);
		//nameText.addFocusListener(new MyFocusListenerNameValidationForCourse());
		namePan.add(nameLab);
		namePan.add(nameText);
		panelCenter.add(namePan);
		
		bossIdPan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		bossIdLab = new JLabel("ID šefa katedre");
		bossIdLab.setPreferredSize(dim);
		bossId = new JComboBox<String>();
		bossIdModel = new DefaultComboBoxModel<String>();
		for(Professor p : ProfessorBase.getInstance().getProfessorList()) {
			bossIdModel.addElement(p.getIdNumber() +" " + p.getName() + " " + p.getSurname());
		}
		bossId.setModel(bossIdModel);
		bossId.setSelectedIndex(0);
		//bossIdText.addFocusListener(new MyFocusListenerNameValidationForCourse());
		bossIdPan.add(bossIdLab);
		bossIdPan.add(bossId);
		panelCenter.add(bossIdPan);
		
		buttonPanel = new JPanel();
		confirm = new JButton("Potvrdi");
		confirm.addActionListener(new MyActionListenerConfirmAddDepartment());
		//confirm.setEnabled(false);
		cancel = new JButton("Odustani");
		//cancel.addActionListener(new MyActionListenerAddBossOfDepartment());
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

	public JPanel getBossIdPan() {
		return bossIdPan;
	}

	public void setBossIdPan(JPanel bossIdPan) {
		this.bossIdPan = bossIdPan;
	}

	public JLabel getBossIdLab() {
		return bossIdLab;
	}

	public void setBossIdLab(JLabel bossIdLab) {
		this.bossIdLab = bossIdLab;
	}
	
	public JComboBox<String> getBossId() {
		return bossId;
	}

	public void setBossId(JComboBox<String> bossId) {
		this.bossId = bossId;
	}

	public DefaultComboBoxModel<String> getBossIdModel() {
		return bossIdModel;
	}

	public void setBossIdModel(DefaultComboBoxModel<String> bossIdModel) {
		this.bossIdModel = bossIdModel;
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

	public static void setInstance(AddDepartmentDialog instance) {
		AddDepartmentDialog.instance = instance;
	}
	
	
}
