package view.dialogs;

import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import model.dataBase.CourseBase;
import model.entities.Course;
import view.listeners.MyActionListenerConfirmAddCourseToProfessor;
import view.listeners.MyActionListenerConfirmAddCourseToStudent;

public class AddCourseToProfessorDialog extends JDialog{

	private static AddCourseToProfessorDialog instance=null;
	
	public static AddCourseToProfessorDialog getInstance() {
		if (instance == null) {
			instance = new AddCourseToProfessorDialog();
		}
		return instance;
	}
	
	private JPanel centerPanel;
	
	private JPanel labelPanel;
	private JLabel label;
	
	private JPanel listPanel;
	private JList courseList; 
	
	private JPanel buttonPanel;
	private JButton addButton;
	private JButton cancelButton;
	
	private BoxLayout box1;
	private BoxLayout box2;
	
	private List<Course> coursesForCourseList;
	DefaultListModel<String> dlm;
	
	private AddCourseToProfessorDialog() {
		
		setTitle("Dodavanje predmeta");
		setSize(450, 400);
		setLocationRelativeTo(EditProfessorDialog.getInstance());
		setModal(true);
		
		centerPanel = new JPanel();
		box1 = new BoxLayout(centerPanel, BoxLayout.Y_AXIS);
		centerPanel.setLayout(box1);
		
		labelPanel = new JPanel();
		label = new JLabel("Predmeti");
		
		listPanel = new JPanel();
		courseList = new JList<>();
		dlm = new DefaultListModel<>();
		courseList.setModel(dlm);
		courseList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		coursesForCourseList = CourseBase.getInstance().getListOfCoursesThatSuitTheProfessor();
		
		for(Course c : this.coursesForCourseList) {
			String courseString = c.getCode() + " " + c.getName();
			dlm.addElement(courseString);
		}
		
		JScrollPane scrollPane = new JScrollPane(courseList);
		scrollPane.setPreferredSize(new Dimension(300, 250));
		listPanel.add(scrollPane);
		centerPanel.add(Box.createVerticalStrut(20));
		centerPanel.add(listPanel);
		
		buttonPanel = new JPanel();
		box2 = new BoxLayout(buttonPanel, BoxLayout.X_AXIS);
		buttonPanel.setLayout(box2);
		addButton = new JButton("Dodaj");
		addButton.addActionListener(new MyActionListenerConfirmAddCourseToProfessor());
		cancelButton = new JButton("Odustani");
		
		buttonPanel.add(Box.createHorizontalStrut(20));
		buttonPanel.add(addButton);
		buttonPanel.add(Box.createHorizontalStrut(20));
		buttonPanel.add(cancelButton);
		buttonPanel.add(Box.createHorizontalStrut(20));
		centerPanel.add(buttonPanel);
		
		add(centerPanel);
		
		this.addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
				setCoursesForCourseList(CourseBase.getInstance().getListOfCoursesThatSuitTheProfessor());
				
			}
		});
	}

	public JPanel getCenterPanel() {
		return centerPanel;
	}

	public void setCenterPanel(JPanel centerPanel) {
		this.centerPanel = centerPanel;
	}

	public JPanel getLabelPanel() {
		return labelPanel;
	}

	public void setLabelPanel(JPanel labelPanel) {
		this.labelPanel = labelPanel;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JPanel getListPanel() {
		return listPanel;
	}

	public void setListPanel(JPanel listPanel) {
		this.listPanel = listPanel;
	}

	public JList getCourseList() {
		return courseList;
	}

	public void setCourseList(JList courseList) {
		this.courseList = courseList;
	}

	public JPanel getButtonPanel() {
		return buttonPanel;
	}

	public void setButtonPanel(JPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
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

	public static void setInstance(AddCourseToProfessorDialog instance) {
		AddCourseToProfessorDialog.instance = instance;
	}

	public List<Course> getCoursesForCourseList() {
		return coursesForCourseList;
	}

	public void setCoursesForCourseList(List<Course> coursesForCourseList) {
		this.coursesForCourseList = coursesForCourseList;
	}

	public DefaultListModel<String> getDlm() {
		return dlm;
	}

	public void setDlm(DefaultListModel<String> dlm) {
		this.dlm = dlm;
	}	
	
	
}
