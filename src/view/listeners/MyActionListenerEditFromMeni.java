package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import model.dataBase.CourseBase;
import model.dataBase.PassedExamsBase;
import model.dataBase.ProfesorCoursesBase;
import model.dataBase.ProfessorBase;
import model.dataBase.RemainingExamsBase;
import model.dataBase.StudentBase;
import model.entities.Course;
import model.entities.Professor;
import model.entities.Student;
import view.dialogs.AddCourseDialog;
import view.dialogs.AddCourseToProfessorDialog;
import view.dialogs.AddCourseToStudentDialog;
import view.dialogs.AddProfessorDialog;
import view.dialogs.AddStudentDialog;
import view.dialogs.EditCourseDialog;
import view.dialogs.EditProfessorDialog;
import view.dialogs.EditStudentDialog;
import view.panels.MyPanelPassedExams;
import view.window.MyTabbedPane;
import view.window.MyTabbedPaneProfessorEdit;
import view.window.MyTabbedPaneStudentEdit;

public class MyActionListenerEditFromMeni implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(MyTabbedPane.getOpenTab()) {
		case 0:
			int rowSelected1 = MyTabbedPane.getInstance().getSt().getSelectedRow();
			
			if(rowSelected1 < 0)
				return;
			
			Student s = StudentBase.getInstance().getRow(rowSelected1);
			StudentBase.getInstance().setSelectedStudent(s);

			PassedExamsBase.getInstance().setGradeList(s.getPassedExams());
			RemainingExamsBase.getInstance().setCourseList(s.getRemainingExams());
			MyPanelPassedExams.getInstance().calculateAverageGrade();
			PassedExamsBase.getInstance().setNumberOfESPB();
			
			List<Course> coursesForCourseList = CourseBase.getInstance().getListOfCoursesThatSuitTheStudent();
			AddCourseToStudentDialog.getInstance().getDlm().removeAllElements();
			for(Course c : coursesForCourseList) {
				String courseString = c.getCode() + " " + c.getName();
				AddCourseToStudentDialog.getInstance().getDlm().addElement(courseString);
			}
			
			MyTabbedPaneStudentEdit.getInstance().getMpes().getNameText().setText(s.getName());
			MyTabbedPaneStudentEdit.getInstance().getMpes().getSurnameText().setText(s.getSurname());
			MyTabbedPaneStudentEdit.getInstance().getMpes().getDobText().setText(s.getDateOfBirth().toString());
			MyTabbedPaneStudentEdit.getInstance().getMpes().getStreetText().setText(s.getResidentialAddress().getStreet());
			MyTabbedPaneStudentEdit.getInstance().getMpes().getNosText().setText(String.valueOf(s.getResidentialAddress().getNumber()));
			MyTabbedPaneStudentEdit.getInstance().getMpes().getCityText().setText(s.getResidentialAddress().getCity());
			MyTabbedPaneStudentEdit.getInstance().getMpes().getCountryText().setText(s.getResidentialAddress().getCountry());
			MyTabbedPaneStudentEdit.getInstance().getMpes().getTelText().setText(String.valueOf(s.getTelephoneNumber()));
			MyTabbedPaneStudentEdit.getInstance().getMpes().getMailText().setText(s.geteMail());
			MyTabbedPaneStudentEdit.getInstance().getMpes().getIndexText().setText(s.getIndexNumber());
			MyTabbedPaneStudentEdit.getInstance().getMpes().getYoeText().setText(String.valueOf(s.getYearOfEnrollment()));
			
			switch(s.getCurrentYearOfStudy()) {
			case 1:
				MyTabbedPaneStudentEdit.getInstance().getMpes().getYearModel().setSelectedItem("I (prva)");
				break;
			case 2:
				MyTabbedPaneStudentEdit.getInstance().getMpes().getYearModel().setSelectedItem("II (druga)");
				break;
			case 3:
				MyTabbedPaneStudentEdit.getInstance().getMpes().getYearModel().setSelectedItem("III (treća)");
				break;
			case 4:
				MyTabbedPaneStudentEdit.getInstance().getMpes().getYearModel().setSelectedItem("IV (četvrta)");
				break;	
			case 5:
				MyTabbedPaneStudentEdit.getInstance().getMpes().getYearModel().setSelectedItem("V (peta)");
				break;	
			case 6:
				MyTabbedPaneStudentEdit.getInstance().getMpes().getYearModel().setSelectedItem("VI (šesta)");
				break;	
			}
			
			switch(s.getStatus()) {
			case B:
				MyTabbedPaneStudentEdit.getInstance().getMpes().getStatusModel().setSelectedItem("Budžet");
				break;
			case S:
				MyTabbedPaneStudentEdit.getInstance().getMpes().getStatusModel().setSelectedItem("Samofinansiranje");
				break;
			}
			
			EditStudentDialog.getInstance().setVisible(true);
			break;	
		case 1:
			
			int rowSelected = MyTabbedPane.getInstance().getPt().getSelectedRow();
			
			if(rowSelected < 0)
				return;
			
			Professor p = ProfessorBase.getInstance().getRow(rowSelected);
			ProfesorCoursesBase.getInstance().setCourseList(p.getListOfSubjects());
			
			List<Course> coursesForCourseList1 = CourseBase.getInstance().getListOfCoursesThatSuitTheProfessor();
			AddCourseToProfessorDialog.getInstance().getDlm().removeAllElements();
			
			for(Course c : coursesForCourseList1) {
				String courseString = c.getCode() + " " + c.getName();
				AddCourseToProfessorDialog.getInstance().getDlm().addElement(courseString);
			}

			MyTabbedPaneProfessorEdit.getInstance().getMpep().getNameText().setText(p.getName());
			MyTabbedPaneProfessorEdit.getInstance().getMpep().getSurnameText().setText(p.getSurname());
			MyTabbedPaneProfessorEdit.getInstance().getMpep().getDateOfBirthText().setText(p.getDateOfBirth().toString());
			MyTabbedPaneProfessorEdit.getInstance().getMpep().getStreetText().setText(p.getResidentialAddress().getStreet());
			MyTabbedPaneProfessorEdit.getInstance().getMpep().getNosText().setText(String.valueOf(p.getResidentialAddress().getNumber()));
			MyTabbedPaneProfessorEdit.getInstance().getMpep().getCityText().setText(p.getResidentialAddress().getCity());
			MyTabbedPaneProfessorEdit.getInstance().getMpep().getCountryText().setText(p.getResidentialAddress().getCountry());
			MyTabbedPaneProfessorEdit.getInstance().getMpep().getTelephoneNumberText().setText(String.valueOf(p.getTelephoneNumber()));
			MyTabbedPaneProfessorEdit.getInstance().getMpep().geteMailText().setText(p.geteMail());
			MyTabbedPaneProfessorEdit.getInstance().getMpep().getStreetOfficeText().setText(p.getResidentialAddress().getStreet());
			MyTabbedPaneProfessorEdit.getInstance().getMpep().getNosOfficeText().setText(String.valueOf(p.getResidentialAddress().getNumber()));			MyTabbedPaneProfessorEdit.getInstance().getMpep().getCityOfficeText().setText(p.getResidentialAddress().getCity());
			MyTabbedPaneProfessorEdit.getInstance().getMpep().getCountryOfficeText().setText(p.getResidentialAddress().getCountry());
			MyTabbedPaneProfessorEdit.getInstance().getMpep().getIdNumberText().setText(p.getIdNumber());
			MyTabbedPaneProfessorEdit.getInstance().getMpep().getTitleText().setText(p.getIdNumber());
			MyTabbedPaneProfessorEdit.getInstance().getMpep().getYearOfTrailText().setText(String.valueOf(p.getYearOfTrail()));
			
			EditProfessorDialog epd = EditProfessorDialog.getInstance();
			epd.setVisible(true);
			break;
		case 2:
			int rowSelected2 = MyTabbedPane.getInstance().getCt().getSelectedRow();
			
			if(rowSelected2 < 0)
				return;
			
			Course c = CourseBase.getInstance().getRow(rowSelected2);
			
			EditCourseDialog.getInstance().getCodeText().setText(String.valueOf(c.getCode()));
			EditCourseDialog.getInstance().getNameText().setText(c.getName());
			switch(c.getYearOfTheCourse()) {
			case 1:
				EditCourseDialog.getInstance().getYearOfTheCourse().setSelectedItem("I (prva)");
				break;
			case 2:
				EditCourseDialog.getInstance().getYearOfTheCourse().setSelectedItem("II (druga)");
				break;
			case 3:
				EditCourseDialog.getInstance().getYearOfTheCourse().setSelectedItem("III (treća)");
				break;
			case 4:
				EditCourseDialog.getInstance().getYearOfTheCourse().setSelectedItem("IV (četvrta)");
				break;	
			case 5:
				EditCourseDialog.getInstance().getYearOfTheCourse().setSelectedItem("V (peta)");
				break;	
			case 6:
				EditCourseDialog.getInstance().getYearOfTheCourse().setSelectedItem("VI (šesta)");
				break;	
			}
			
			switch(c.getSemester()) {
			case SUMMER:
				EditCourseDialog.getInstance().getSemesterModel().setSelectedItem("SUMMER");
				break;
			case WINTER:
				EditCourseDialog.getInstance().getSemesterModel().setSelectedItem("WINTER");
				break;
			}
			
			EditCourseDialog.getInstance().getNumberOfESPBText().setText(String.valueOf(c.getNumberOfESPB()));
			if (c.getSubjectProfessor() != null) {
				EditCourseDialog.getInstance().getSubjectProfessorText().setText(c.getSubjectProfessor().getName() + " " + c.getSubjectProfessor().getSurname());
			}else {
				EditCourseDialog.getInstance().getSubjectProfessorText().setText("-");
			}
			
			
			EditCourseDialog  ecd= EditCourseDialog.getInstance();
			ecd.setVisible(true);
			break;	

		}
	}
}

