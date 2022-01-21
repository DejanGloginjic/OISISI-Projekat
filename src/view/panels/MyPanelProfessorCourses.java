package view.panels;

import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import localization.Language;
import view.abstractTableModels.AbstractTableModelProfessorCourses;
import view.abstractTableModels.AbstractTableModelStudent;
import view.listeners.MyActionListenerAddCourseToProfesor;
import view.listeners.MyActionListenerDeleteCourseFromProfessor;
import view.listeners.MyActionListenerDeleteStudent;
import view.panels.MyPanelPassedExams;
import view.tables.TableProfessorCourses;


public class MyPanelProfessorCourses extends JPanel{

	private static MyPanelProfessorCourses instance = null;

	public static MyPanelProfessorCourses getInstance(){
		if (instance == null) {
			instance = new MyPanelProfessorCourses();
		}
		return instance;
	}
	
	private JPanel centerPanel;
	
	private JPanel btnPanel;
	private JButton btn1;
	private JButton btn2;
	
	private JPanel tablePanel;
	private TableProfessorCourses table;
	
	private BoxLayout box1;
	private BoxLayout box2;
	
	private MyPanelProfessorCourses() {
		
		centerPanel = new JPanel();
		
		box1 = new BoxLayout(centerPanel, BoxLayout.Y_AXIS);
		centerPanel.setLayout(box1);
		
		btnPanel = new JPanel();
		box2 = new BoxLayout(btnPanel, BoxLayout.X_AXIS);
		btnPanel.setLayout(box2);
		btn1 = new JButton("Dodaj predmet");
		btn2 = new JButton("Ukloni predmet");
		btnPanel.add(Box.createHorizontalStrut(5));
		btnPanel.add(btn1);
		btnPanel.add(Box.createHorizontalStrut(10));
		btnPanel.add(btn2);
		btnPanel.add(Box.createHorizontalGlue());
		centerPanel.add(btnPanel);
		
		btn1.addActionListener(new MyActionListenerAddCourseToProfesor());
		btn2.addActionListener(new MyActionListenerDeleteCourseFromProfessor());
		
		table = new TableProfessorCourses();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
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

	public TableProfessorCourses getTable() {
		return table;
	}

	public void setTable(TableProfessorCourses table) {
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

	public static void setInstance(MyPanelProfessorCourses instance) {
		MyPanelProfessorCourses.instance = instance;
	}
	
	public void updateViewProfessorCourses() {
		AbstractTableModelProfessorCourses model = (AbstractTableModelProfessorCourses) table.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	public void updateComponents() {
		btn1.setText(Language.getInstance().getResourceBundle().getString("addCourse"));
		btn2.setText(Language.getInstance().getResourceBundle().getString("deleteCourse"));
	}
}
