package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.dataBase.RemainingExamsBase;
import model.entities.Course;
import view.dialogs.GradeEntryDialog;
import view.panels.MyPanelRemainingExams;
import view.window.MyTabbedPaneStudentEdit;

public class MyActionListenerPassExam implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		int rowSelected = MyTabbedPaneStudentEdit.getInstance().getMpre().getTable().getSelectedRow();
		if (rowSelected < 0) {
			return;
		}
		
		Course c = RemainingExamsBase.getInstance().getRow(rowSelected);
		GradeEntryDialog.getInstance().getCodeText().setText(c.getCode());
		GradeEntryDialog.getInstance().getNameText().setText(c.getName());
		
		GradeEntryDialog ge = GradeEntryDialog.getInstance();
		ge.setVisible(true);
	}

}
