package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import model.dataBase.CourseBase;
import model.dataBase.DataBaseWriter;
import model.dataBase.DepartmentBase;
import model.dataBase.ProfessorBase;
import model.dataBase.StudentBase;
import model.entities.Course;
import model.entities.Department;
import model.entities.Professor;
import model.entities.Student;

public class MyActionListenerSave implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			DataBaseWriter.WriteStudent((ArrayList<Student>) StudentBase.getInstance().getStudentList());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			DataBaseWriter.WriteProfessor((ArrayList<Professor>) ProfessorBase.getInstance().getProfessorList());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			DataBaseWriter.WriteCourse((ArrayList<Course>) CourseBase.getInstance().getCourseList());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			DataBaseWriter.WriteDepartment((ArrayList<Department>) DepartmentBase.getInstance().getDepartmentList());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			DataBaseWriter.WriteGrade();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			DataBaseWriter.WriteRemainingExams();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			DataBaseWriter.WriteProfessorsCourses();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
