package view.dialogs;

import java.awt.Dimension;
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

import localization.Language;
import model.dataBase.CourseBase;
import model.dataBase.ProfessorBase;
import model.entities.Course;
import model.entities.Professor;
import view.listeners.MyActionListenerCancelAddProfessorToCourse;
import view.listeners.MyActionListenerConfirmAddCourseToProfessor;
import view.listeners.MyActionListenerConfirmAddProfessorToCourse;

public class AddProfessorToCourseDialog extends JDialog{

	private static AddProfessorToCourseDialog instance=null;
	
	public static AddProfessorToCourseDialog getInstance() {
		if (instance == null) {
			instance = new AddProfessorToCourseDialog();
		}
		return instance;
	}
	
	private JPanel centerPanel;
	
	private JPanel labelPanel;
	private JLabel label;
	
	private JPanel listPanel;
	private JList professorList; 
	
	private JPanel buttonPanel;
	private JButton addButton;
	private JButton cancelButton;
	
	private BoxLayout box1;
	private BoxLayout box2;
	
	private List<Professor> professorsForProfessorList;
	DefaultListModel<String> dlm;
	
	private AddProfessorToCourseDialog() {
		
		setTitle(Language.getInstance().getResourceBundle().getString("addProfessorToCourse"));
		setSize(450, 400);
		setLocationRelativeTo(EditCourseDialog.getInstance());
		setModal(true);
		
		centerPanel = new JPanel();
		box1 = new BoxLayout(centerPanel, BoxLayout.Y_AXIS);
		centerPanel.setLayout(box1);
		
		labelPanel = new JPanel();
		label = new JLabel(Language.getInstance().getResourceBundle().getString("professors"));
		
		listPanel = new JPanel();
		professorList = new JList<>();
		dlm = new DefaultListModel<>();
		professorList.setModel(dlm);
		professorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		professorsForProfessorList = ProfessorBase.getInstance().getProfessorList();
	
		for(Professor p : this.professorsForProfessorList) {
			String professorString = p.getIdNumber() + " " + p.getName() + " " + p.getSurname();
			dlm.addElement(professorString);
		}
		
		JScrollPane scrollPane = new JScrollPane(professorList);
		scrollPane.setPreferredSize(new Dimension(300, 250));
		listPanel.add(scrollPane);
		centerPanel.add(Box.createVerticalStrut(20));
		centerPanel.add(listPanel);
		
		buttonPanel = new JPanel();
		box2 = new BoxLayout(buttonPanel, BoxLayout.X_AXIS);
		buttonPanel.setLayout(box2);
		addButton = new JButton(Language.getInstance().getResourceBundle().getString("add"));
		addButton.addActionListener(new MyActionListenerConfirmAddProfessorToCourse());
		cancelButton = new JButton(Language.getInstance().getResourceBundle().getString("close"));
		cancelButton.addActionListener(new MyActionListenerCancelAddProfessorToCourse());
		
		
		buttonPanel.add(Box.createHorizontalStrut(20));
		buttonPanel.add(addButton);
		buttonPanel.add(Box.createHorizontalStrut(20));
		buttonPanel.add(cancelButton);
		buttonPanel.add(Box.createHorizontalStrut(20));
		centerPanel.add(buttonPanel);
		
		add(centerPanel);
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

	public JList getProfessorList() {
		return professorList;
	}

	public void setProfessorList(JList professorList) {
		this.professorList = professorList;
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

	public List<Professor> getProfessorsForProfessorList() {
		return professorsForProfessorList;
	}

	public void setProfessorsForProfessorList(List<Professor> professorsForProfessorList) {
		this.professorsForProfessorList = professorsForProfessorList;
	}

	public DefaultListModel<String> getDlm() {
		return dlm;
	}

	public void setDlm(DefaultListModel<String> dlm) {
		this.dlm = dlm;
	}
	
	public void updateComponent() {
		this.setTitle(Language.getInstance().getResourceBundle().getString("addProfessorToCourse"));
		label.setText(Language.getInstance().getResourceBundle().getString("professors"));
		addButton.setText(Language.getInstance().getResourceBundle().getString("add"));
		cancelButton.setText(Language.getInstance().getResourceBundle().getString("close"));
	}
}
