package view.panels;

import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
		
		table = new TableProfessorCourses();
		JScrollPane scrollPane = new JScrollPane(table);
		tablePanel = new JPanel();
		tablePanel.add(scrollPane);
		centerPanel.add(tablePanel);
		
		add(centerPanel);
	}
}
