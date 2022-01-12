package view.panels;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import view.tables.TablePassedExams;

public class MyPanelPassedExams extends JPanel{

	private JPanel centerPanel;
	
	private JPanel btnPanel;
	private JButton btn1;
	
	private JPanel tablePanel;
	private TablePassedExams table;
	
	private JPanel avggPanel;
	private JLabel averageGrade;
	private JLabel grade;
	
	private JPanel espbPanel;
	private JLabel value;
	private JLabel espb;
	
	private BoxLayout box;
	private BoxLayout box1;
	private BoxLayout box2;
	private BoxLayout box3;
	
	private static MyPanelPassedExams instance = null;

	public static MyPanelPassedExams getInstance(){
		if (instance == null) {
			instance = new MyPanelPassedExams();
		}
		return instance;
	}
	
	private MyPanelPassedExams() {
		
		centerPanel = new JPanel();
		box = new BoxLayout(centerPanel, BoxLayout.Y_AXIS);
		centerPanel.setLayout(box);
		
		btnPanel = new JPanel();
		box1 = new BoxLayout(btnPanel, BoxLayout.Y_AXIS);
		btnPanel.setLayout(box1);
		btn1 = new JButton("Poništi ocijenu");
		btnPanel.add(Box.createHorizontalStrut(5));
		btnPanel.add(btn1);
		btnPanel.add(Box.createHorizontalGlue());
		
		table = new TablePassedExams();
		JScrollPane scrollPane = new JScrollPane(table);
		tablePanel = new JPanel();
		tablePanel.add(scrollPane);
		
		avggPanel = new JPanel();
		averageGrade = new JLabel("Prosječna ocjena: ");
		grade = new JLabel("1");
		box2 = new BoxLayout(avggPanel, BoxLayout.X_AXIS);
		avggPanel.setLayout(box2);
		avggPanel.add(Box.createHorizontalGlue());
		avggPanel.add(averageGrade);
		avggPanel.add(grade);
		avggPanel.add(Box.createHorizontalStrut(8));
		
		espbPanel = new JPanel();
		espb = new JLabel("Ukupno ESPB: ");
		value = new JLabel();
		box3 = new BoxLayout(espbPanel, BoxLayout.X_AXIS);
		espbPanel.setLayout(box3);
		espbPanel.add(Box.createHorizontalGlue());
		espbPanel.add(espb);
		espbPanel.add(value);
		espbPanel.add(Box.createHorizontalStrut(8));
		
		centerPanel.add(btnPanel);
		centerPanel.add(tablePanel);
		centerPanel.add(avggPanel);
		centerPanel.add(espbPanel);
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

	public JPanel getTablePanel() {
		return tablePanel;
	}

	public void setTablePanel(JPanel tablePanel) {
		this.tablePanel = tablePanel;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(TablePassedExams table) {
		this.table = table;
	}

	public JPanel getAvggPanel() {
		return avggPanel;
	}

	public void setAvggPanel(JPanel avggPanel) {
		this.avggPanel = avggPanel;
	}

	public JLabel getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(JLabel averageGrade) {
		this.averageGrade = averageGrade;
	}

	public JLabel getGrade() {
		return grade;
	}

	public void setGrade(JLabel grade) {
		this.grade = grade;
	}

	public JPanel getEspbPanel() {
		return espbPanel;
	}

	public void setEspbPanel(JPanel espbPanel) {
		this.espbPanel = espbPanel;
	}

	public JLabel getValue() {
		return value;
	}

	public void setValue(JLabel value) {
		this.value = value;
	}

	public JLabel getEspb() {
		return espb;
	}

	public void setEspb(JLabel espb) {
		this.espb = espb;
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

	public BoxLayout getBox2() {
		return box2;
	}

	public void setBox2(BoxLayout box2) {
		this.box2 = box2;
	}

	public BoxLayout getBox3() {
		return box3;
	}

	public void setBox3(BoxLayout box3) {
		this.box3 = box3;
	}

	public static void setInstance(MyPanelPassedExams instance) {
		MyPanelPassedExams.instance = instance;
	}
	
	
}
