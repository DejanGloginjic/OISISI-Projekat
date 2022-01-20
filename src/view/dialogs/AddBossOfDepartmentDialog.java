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

import model.dataBase.ProfessorBase;
import model.entities.Professor;
import view.dialogs.AddCourseDialog;
import view.listeners.MyActionListenerAddBossOfDepartment;
import view.listeners.MyActionListenerConfirmAddBossOfDepartment;
import view.listeners.MyFocusListenerCodeValidationForCourse;
import view.window.MyMainFrame;

public class AddBossOfDepartmentDialog extends JDialog{
	
	private static AddBossOfDepartmentDialog instance = null;

	public static AddBossOfDepartmentDialog getInstance() {
		if (instance == null) {
			instance = new AddBossOfDepartmentDialog();
		}
		return instance;
	}
	
	private JPanel panelCenter;
	private BoxLayout boxLayout;
	
	private JPanel bossIdPan;
	private JLabel bossIdLab;
	private JComboBox<String> bossId;
	private DefaultComboBoxModel<String> bossIdModel;
	
	private JPanel buttonPanel;
	private JButton cancel;
	private JButton confirm;
	
	private AddBossOfDepartmentDialog() {
		
		setTitle("Dodavanje šefa katedre");
		setSize(350, 150);
		setLocationRelativeTo(AddDepartmentDialog.getInstance());
		setModal(true);
		
		Dimension dim = new Dimension(150, 20);
		
		panelCenter = new JPanel();
		boxLayout = new BoxLayout(panelCenter, BoxLayout.Y_AXIS);
		panelCenter.setLayout(boxLayout);
		add(panelCenter);
		
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
		confirm.addActionListener(new MyActionListenerConfirmAddBossOfDepartment());
		cancel = new JButton("Odustani");
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

	public static void setInstance(AddBossOfDepartmentDialog instance) {
		AddBossOfDepartmentDialog.instance = instance;
	}
	
	
}
