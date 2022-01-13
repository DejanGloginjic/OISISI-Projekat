package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.dialogs.GradeEntryDialog;
import view.panels.MyPanelRemainingExams;
import view.window.MyTabbedPaneStudentEdit;

public class MyActionListenerPassExam implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		/*int rowSelected = MyTabbedPaneStudentEdit.getInstance().getMpre().getTable().getSelectedRow();
		
		MyPanelRemainingExams.getInstance().get
		
		
		
		
		
		*/
		GradeEntryDialog ge = GradeEntryDialog.getInstance();
		ge.setVisible(true);
	}

}
