package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import controller.RemainingExamsController;
import controller.StudentController;
import model.dataBase.PassedExamsBase;
import model.dataBase.ProfessorBase;
import model.dataBase.RemainingExamsBase;
import model.dataBase.StudentBase;
import model.entities.Course;
import model.entities.Grade;
import model.entities.Professor;
import model.entities.Student;
import view.dialogs.AddStudentDialog;
import view.dialogs.GradeEntryDialog;
import view.window.MyTabbedPane;
import view.window.MyTabbedPaneStudentEdit;

public class MyActionListenerConfirmPassingExam implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String code = GradeEntryDialog.getInstance().getCodeText().getText();
		
		Course c = RemainingExamsBase.getInstance().findByCode(code);
		RemainingExamsController.getInstance().deletCourse(c);
		
		int rowSelected = MyTabbedPane.getInstance().getSt().getSelectedRow();
		Student s = StudentBase.getInstance().getRow(rowSelected);
		int value = Integer.parseInt(GradeEntryDialog.getInstance().getGrade());
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		LocalDate examDate = LocalDate.parse(GradeEntryDialog.getInstance().getDateText().getText());
		
		//LocalDate dateOfBirth = LocalDate.parse(AddStudentDialog.getInstance().getDobText().getText());
		
		Grade g = new Grade(s,c,value,examDate);
		StudentController.getInstance().addPassedExamsToStudent(s, g);
		
		GradeEntryDialog.getInstance().setVisible(false);
	}
}
