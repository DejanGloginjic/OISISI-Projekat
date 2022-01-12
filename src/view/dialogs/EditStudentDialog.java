package view.dialogs;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.dataBase.StudentBase;
import model.entities.Student;
import view.panels.MyPanelPassedExams;
import view.window.MyMainFrame;
import view.window.MyTabbedPane;
import view.window.MyTabbedPaneStudentEdit;

public class EditStudentDialog extends JDialog{
	
	MyTabbedPaneStudentEdit mtpse = MyTabbedPaneStudentEdit.getInstance();
	private JPanel panelCenter = new JPanel();
	
	private static EditStudentDialog instance = null;
	
	public static EditStudentDialog getInstance() {
		if (instance == null) {
			instance = new EditStudentDialog();
		}
		return instance;
	}
	
	private EditStudentDialog() {
		setTitle("Izmjena studenta");
		setSize(500, 575);
		setLocationRelativeTo(MyMainFrame.getInstance());
		setModal(true);
		
		panelCenter.add(mtpse);
		add(panelCenter);
	}
}
