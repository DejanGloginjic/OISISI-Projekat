package view.dialogs;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import localization.Language;
import model.dataBase.CourseBase;
import model.entities.Course;
import view.listeners.MyActionListenerAddCourseToStudent;
import view.listeners.MyActionListenerConfirmAddCourseToStudent;
import view.window.MyMainFrame;

public class AddCourseToStudentDialog extends JDialog{

	private static AddCourseToStudentDialog instance=null;
	
	public static AddCourseToStudentDialog getInstance() {
		if (instance == null) {
			instance = new AddCourseToStudentDialog();
		}
		return instance;
	}
	
	private JPanel centerPanel;
	
	private JPanel listPanel;
	private JList courseList; 
	private DefaultListModel<String> dlm;
	
	private JPanel buttonPanel;
	private JButton addButton;
	private JButton cancelButton;
	
	private BoxLayout box1;
	private BoxLayout box2;
	
	private List<Course> coursesForCourseList;
	
	private AddCourseToStudentDialog() {
		
		setTitle(Language.getInstance().getResourceBundle().getString("addCourseToStudent"));
		setSize(450, 400);
		setLocationRelativeTo(EditStudentDialog.getInstance());
		setModal(true);
		
		centerPanel = new JPanel();
		box1 = new BoxLayout(centerPanel, BoxLayout.Y_AXIS);
		centerPanel.setLayout(box1);
		
		listPanel = new JPanel();
		courseList = new JList<>();
		dlm = new DefaultListModel<>();
		courseList.setModel(dlm);
		
		coursesForCourseList = CourseBase.getInstance().getListOfCoursesThatSuitTheStudent();
		
		for(Course c : coursesForCourseList) {
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
		addButton = new JButton(Language.getInstance().getResourceBundle().getString("add"));
		addButton.addActionListener(new MyActionListenerConfirmAddCourseToStudent());
		cancelButton = new JButton(Language.getInstance().getResourceBundle().getString("close"));
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddCourseToStudentDialog.getInstance().setVisible(false);
				
			}
		});
		buttonPanel.add(Box.createHorizontalStrut(20));
		buttonPanel.add(addButton);
		buttonPanel.add(Box.createHorizontalStrut(20));
		buttonPanel.add(cancelButton);
		buttonPanel.add(Box.createHorizontalStrut(20));
		centerPanel.add(buttonPanel);
		
		add(centerPanel);
	}

	public List<Course> getCoursesForCourseList() {
		return coursesForCourseList;
	}

	public void setCoursesForCourseList(List<Course> coursesForCourseList) {
		this.coursesForCourseList = coursesForCourseList;
	}

	public JPanel getCenterPanel() {
		return centerPanel;
	}

	public void setCenterPanel(JPanel centerPanel) {
		this.centerPanel = centerPanel;
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

	public static void setInstance(AddCourseToStudentDialog instance) {
		AddCourseToStudentDialog.instance = instance;
	}

	public DefaultListModel<String> getDlm() {
		return dlm;
	}

	public void setDlm(DefaultListModel<String> dlm) {
		this.dlm = dlm;
	}
	
	public void updateComponent() {
		this.setTitle(Language.getInstance().getResourceBundle().getString("addCourseToStudent"));
		addButton.setText(Language.getInstance().getResourceBundle().getString("add"));
		cancelButton.setText(Language.getInstance().getResourceBundle().getString("close"));
	}
}
