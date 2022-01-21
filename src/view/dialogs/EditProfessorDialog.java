package view.dialogs;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import localization.Language;
import model.dataBase.ProfessorBase;
import model.entities.Professor;

import view.window.MyMainFrame;
import view.window.MyTabbedPane;
import view.window.MyTabbedPaneProfessorEdit;
import view.window.MyTabbedPaneStudentEdit;

public class EditProfessorDialog extends JDialog{
	
	MyTabbedPaneProfessorEdit mtppe=MyTabbedPaneProfessorEdit.getInstance();
	
	private JPanel panelCenter = new JPanel();
	
	private static EditProfessorDialog instance=null;
	
	public static EditProfessorDialog getInstance() {
		if (instance == null) {
			instance = new EditProfessorDialog();
		}
		return instance;
	}
	
	private EditProfessorDialog() {
		
		setTitle(Language.getInstance().getResourceBundle().getString("editProfessor"));

		setSize(500, 600);
		setLocationRelativeTo(MyMainFrame.getInstance());
		setModal(true);
		
		panelCenter.add(mtppe);
		add(panelCenter);

	}
	
	public void updateComponent() {
		this.setTitle(Language.getInstance().getResourceBundle().getString("editProfessor"));
	}
}
