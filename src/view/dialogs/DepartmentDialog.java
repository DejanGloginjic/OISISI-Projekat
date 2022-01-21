package view.dialogs;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import localization.Language;
import view.abstractTableModels.AbstractTableModelCourse;
import view.abstractTableModels.AbstractTableModelDepartment;
import view.abstractTableModels.AbstractTableModelProfessor;
import view.abstractTableModels.AbstractTableModelProfessorCourses;
import view.listeners.MyActionListenerAddBossOfDepartment;
import view.listeners.MyActionListenerAddDepartment;
import view.listeners.MyActionListenerDeleteCourseFromProfessor;
import view.listeners.MyActionListenerDeleteDepartment;
import view.panels.MyPanelProfessorCourses;
import view.tables.DepartmentTable;
import view.tables.TableProfessorCourses;
import view.window.MyMainFrame;

public class DepartmentDialog extends JDialog{
	
	private static DepartmentDialog instance = null;

	public static DepartmentDialog getInstance(){
		if (instance == null) {
			instance = new DepartmentDialog();
		}
		return instance;
	}
	
	private JPanel centerPanel;
	
	private JPanel btnPanel;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	
	private JPanel tablePanel;
	private DepartmentTable table;
	
	private BoxLayout box1;
	private BoxLayout box2;
	
	private DepartmentDialog() {
		
		setTitle(Language.getInstance().getResourceBundle().getString("departments"));
		setSize(480, 500);
		setLocationRelativeTo(MyMainFrame.getInstance());
		setModal(true);
		
		centerPanel = new JPanel();
		
		box1 = new BoxLayout(centerPanel, BoxLayout.Y_AXIS);
		centerPanel.setLayout(box1);
		
		centerPanel.add(Box.createVerticalStrut(7));
		
		btnPanel = new JPanel();
		box2 = new BoxLayout(btnPanel, BoxLayout.X_AXIS);
		btnPanel.setLayout(box2);
		btn1 = new JButton(Language.getInstance().getResourceBundle().getString("addDepartment"));
		btn2 = new JButton(Language.getInstance().getResourceBundle().getString("addEditBossOfDepartment"));
		btn3 = new JButton(Language.getInstance().getResourceBundle().getString("deleteDepartment"));
		btnPanel.add(Box.createHorizontalStrut(5));
		btnPanel.add(btn1);
		btnPanel.add(Box.createHorizontalStrut(10));
		btnPanel.add(btn2);
		btnPanel.add(Box.createHorizontalStrut(5));
		btnPanel.add(btn3);
		btnPanel.add(Box.createHorizontalGlue());
		centerPanel.add(btnPanel);
		
		btn1.addActionListener(new MyActionListenerAddDepartment());
		btn2.addActionListener(new MyActionListenerAddBossOfDepartment());
		btn3.addActionListener(new MyActionListenerDeleteDepartment());
		
		table = new DepartmentTable();
		JScrollPane scrollPane = new JScrollPane(table);
		tablePanel = new JPanel();
		tablePanel.add(scrollPane);
		centerPanel.add(tablePanel);
		
		add(centerPanel);
	}

	public JPanel getCenterPanel() {
		return centerPanel;
	}

	public void setCenterPanel(JPanel centerPanel) {
		this.centerPanel = centerPanel;
	}

	public JPanel getBtnPanel() {
		return btnPanel;
	}

	public void setBtnPanel(JPanel btnPanel) {
		this.btnPanel = btnPanel;
	}

	public JButton getBtn1() {
		return btn1;
	}

	public void setBtn1(JButton btn1) {
		this.btn1 = btn1;
	}

	public JButton getBtn2() {
		return btn2;
	}

	public void setBtn2(JButton btn2) {
		this.btn2 = btn2;
	}

	public JPanel getTablePanel() {
		return tablePanel;
	}

	public void setTablePanel(JPanel tablePanel) {
		this.tablePanel = tablePanel;
	}

	public DepartmentTable getTable() {
		return table;
	}

	public void setTable(DepartmentTable table) {
		this.table = table;
	}

	public BoxLayout getBox1() {
		return box1;
	}

	public void setBox1(BoxLayout box1) {
		this.box1 = box1;
	}

	public BoxLayout getBox2() {
		return box2;
	}

	public void setBox2(BoxLayout box2) {
		this.box2 = box2;
	}

	public static void setInstance(DepartmentDialog instance) {
		DepartmentDialog.instance = instance;
	}
	
	public void updateViewDepartment() {
		AbstractTableModelDepartment model = (AbstractTableModelDepartment) table.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	public void updateComponent() {
		this.setTitle(Language.getInstance().getResourceBundle().getString("departments"));
		btn1.setText(Language.getInstance().getResourceBundle().getString("addDepartment"));
		btn2.setText(Language.getInstance().getResourceBundle().getString("addEditBossOfDepartment"));
		btn3.setText(Language.getInstance().getResourceBundle().getString("deleteDepartment"));
	}
}
