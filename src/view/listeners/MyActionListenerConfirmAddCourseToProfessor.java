package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import controller.CourseController;
import controller.ProfessorController;
import controller.StudentController;
import model.dataBase.CourseBase;
import model.entities.Course;
import view.dialogs.AddCourseToProfessorDialog;
import view.dialogs.AddCourseToStudentDialog;

public class MyActionListenerConfirmAddCourseToProfessor implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
			List<String> stringList = AddCourseToProfessorDialog.getInstance().getCourseList().getSelectedValuesList();
	        
	        if(stringList == null) {
	        	return;
	        }
	        
	        for(int i = 0; i < stringList.size(); i++) {
		        String[] words = stringList.get(i).split(" ");
		        String code = words[0];
		        
		        Course course = CourseBase.getInstance().findCourseByCode(code);
				
		        ProfessorController.getInstance().addCourseToSelectedProfessor(course);
		        CourseController.getInstance().addSelectedProfessorToCourse(course);
		        
		        int index =  AddCourseToProfessorDialog.getInstance().getCourseList().getSelectedIndex();
		        AddCourseToProfessorDialog.getInstance().getDlm().removeElementAt(index);
	        }
	        
	        
	        
	        AddCourseToProfessorDialog.getInstance().setVisible(false);
	        
	}

}
