package view.dialogs;

import javax.swing.JDialog;
import javax.swing.JPanel;

import localization.Language;
import model.dataBase.StudentBase;
import model.entities.Student;
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
		setTitle(Language.getInstance().getResourceBundle().getString("editStudent"));
		setSize(500, 575);
		setLocationRelativeTo(MyMainFrame.getInstance());
		setModal(true);
		
		panelCenter.add(mtpse);
		add(panelCenter);
	}

	public void updateComponents() {
		this.setTitle(Language.getInstance().getResourceBundle().getString("editStudent"));
		mtpse.updateComponents();
		
	}
}
