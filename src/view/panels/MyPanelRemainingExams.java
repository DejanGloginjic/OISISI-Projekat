package view.panels;

import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import localization.Language;
import view.abstractTableModels.AbstractTableModelCourse;
import view.abstractTableModels.AbstractTableModelRemainingExams;
import view.listeners.MyActionListenerAddCourseToStudent;
import view.listeners.MyActionListenerDeletingCourseFromStudent;
import view.listeners.MyActionListenerPassExam;
import view.tables.TablePassedExams;
import view.tables.TableRemainingExams;

public class MyPanelRemainingExams extends JPanel{

	private static MyPanelRemainingExams instance = null;

	public static MyPanelRemainingExams getInstance(){
		if (instance == null) {
			instance = new MyPanelRemainingExams();
		}
		return instance;
	}
	
	private JPanel centerPanel;
	private JPanel tablePanel;
	private TableRemainingExams table;
	
	private JPanel btnPanel;
	private BoxLayout box;
	private BoxLayout box1;
	
	private JButton bAdd;
	private JButton bDelete;
	private JButton bPass;
	
	private MyPanelRemainingExams() {
		
		centerPanel = new JPanel();
		box = new BoxLayout(centerPanel, BoxLayout.Y_AXIS);
		centerPanel.setLayout(box);
		
		btnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		//box1 = new BoxLayout(btnPanel, BoxLayout.Y_AXIS);
		//btnPanel.setLayout(box1);
		bAdd = new JButton(Language.getInstance().getResourceBundle().getString("add"));
		bDelete = new JButton(Language.getInstance().getResourceBundle().getString("delete"));
		bPass = new JButton(Language.getInstance().getResourceBundle().getString("takingTheCourse"));
		bPass.addActionListener(new MyActionListenerPassExam());
		btnPanel.add(bAdd);
		btnPanel.add(bDelete);
		btnPanel.add(bPass);
		
		table = new TableRemainingExams();
		JScrollPane scrollPane = new JScrollPane(table);
		tablePanel = new JPanel();
		tablePanel.add(scrollPane);
		
		bAdd.addActionListener(new MyActionListenerAddCourseToStudent());
		bDelete.addActionListener(new MyActionListenerDeletingCourseFromStudent());
		
		centerPanel.add(btnPanel);
		centerPanel.add(tablePanel);
		add(centerPanel);
	}

	public JPanel getCenterPanel() {
		return centerPanel;
	}

	public void setCenterPanel(JPanel centerPanel) {
		this.centerPanel = centerPanel;
	}

	public JPanel getTablePanel() {
		return tablePanel;
	}

	public void setTablePanel(JPanel tablePanel) {
		this.tablePanel = tablePanel;
	}

	public TableRemainingExams getTable() {
		return table;
	}

	public void setTable(TableRemainingExams table) {
		this.table = table;
	}

	public JPanel getBtnPanel() {
		return btnPanel;
	}

	public void setBtnPanel(JPanel btnPanel) {
		this.btnPanel = btnPanel;
	}

	public BoxLayout getBox() {
		return box;
	}

	public void setBox(BoxLayout box) {
		this.box = box;
	}

	public BoxLayout getBox1() {
		return box1;
	}

	public void setBox1(BoxLayout box1) {
		this.box1 = box1;
	}

	public JButton getbAdd() {
		return bAdd;
	}

	public void setbAdd(JButton bAdd) {
		this.bAdd = bAdd;
	}

	public JButton getbDelete() {
		return bDelete;
	}

	public void setbDelete(JButton bDelete) {
		this.bDelete = bDelete;
	}

	public JButton getbPass() {
		return bPass;
	}

	public void setbPass(JButton bPass) {
		this.bPass = bPass;
	}

	public static void setInstance(MyPanelRemainingExams instance) {
		MyPanelRemainingExams.instance = instance;
	}
	
	public void updateViewRemainingExams() {
		AbstractTableModelRemainingExams model = (AbstractTableModelRemainingExams) table.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	public void updateComonents() {
		bAdd.setText(Language.getInstance().getResourceBundle().getString("add"));
		bDelete.setText(Language.getInstance().getResourceBundle().getString("delete"));
		bPass.setText(Language.getInstance().getResourceBundle().getString("takingTheCourse"));
	}
}
