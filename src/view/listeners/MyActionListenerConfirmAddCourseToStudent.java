package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import controller.CourseController;
import controller.StudentController;
import model.dataBase.CourseBase;
import model.dataBase.StudentBase;
import model.entities.Course;
import view.dialogs.AddCourseToStudentDialog;

public class MyActionListenerConfirmAddCourseToStudent implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
        String s = (String) AddCourseToStudentDialog.getInstance().getCourseList().getSelectedValue();
        
        if(s == null) {
        	return;
        }
        
        String[] words = s.split(" ");
        String code = words[0];
        
        Course course = CourseBase.getInstance().findCourseByCode(code);
		
        StudentController.getInstance().addCourseToSelectedStudent(course);
        CourseController.getInstance().addStudentToCourse(course);
        
        AddCourseToStudentDialog.getInstance().setVisible(false);
	}

}
