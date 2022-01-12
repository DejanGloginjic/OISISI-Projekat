package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import model.dataBase.CourseBase;
import model.dataBase.ProfessorBase;
import model.dataBase.StudentBase;
import model.entities.Course;
import model.entities.Grade;
import model.entities.Professor;

import model.entities.Student;
import view.window.MyTabbedPane;
import view.window.MyToolbar;

public class MyActionListenerFindEntities implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(MyTabbedPane.getOpenTab()) {
		case 0:
			String query = MyToolbar.getInstance().getbSearch2().getText();

			String[] words = query.split(", ");

			if(words.length == 1) {
				String surname = words[0];
				List<Student> studentList = StudentBase.getInstance().getStudentListForSearch();
				List<Student> retList = new ArrayList<>();
				for(Student s : studentList) {
					if(s.getSurname().contains(surname)) {
						retList.add(s);
					}
				}
				StudentBase.getInstance().setStudentList(retList);
				
			}else if(words.length == 2) {
				String surname = words[0];
				String name = words[1];
				List<Student> studentList = StudentBase.getInstance().getStudentListForSearch();
				List<Student> retList = new ArrayList<>();
				for(Student s : studentList) {
					if(s.getSurname().contains(surname) && s.getName().contains(name)) {
						retList.add(s);
					}
				}
				StudentBase.getInstance().setStudentList(retList);
				
			}else if(words.length == 3) {
				String surname = words[2];
				String name = words[1];
				String index = words[0];
				List<Student> studentList = StudentBase.getInstance().getStudentListForSearch();
				List<Student> retList = new ArrayList<>();
				for(Student s : studentList) {
					if(s.getSurname().contains(surname) && s.getName().contains(name) && s.getIndexNumber().contains(index)) {
						retList.add(s);
					}
				}
				StudentBase.getInstance().setStudentList(retList);

			}else if(words.length == 0) {
				break;
			}
			break;
		case 1:
			String query1 = MyToolbar.getInstance().getbSearch2().getText();
			String[] words1 = query1.split(",");
			if(words1.length == 1) {
				String surname = words1[0];
				List<Professor> professorList = ProfessorBase.getInstance().getProfessorListForSearch();
				List<Professor> retList1 = new ArrayList<>();
				for(Professor p : professorList) {
					if(p.getSurname().contains(surname)) {
						retList1.add(p);
					}
				}
				ProfessorBase.getInstance().setProfessorList(retList1);
				
			}else if(words1.length == 2) {
				String surname = words1[0];
				String name = words1[1];
				List<Professor> professorList = ProfessorBase.getInstance().getProfessorListForSearch();
				List<Professor> retList1 = new ArrayList<>();
				for(Professor p : professorList) {
					if(p.getSurname().contains(surname) && p.getName().contains(name)) {
						retList1.add(p);
					}
				}
				ProfessorBase.getInstance().setProfessorList(retList1);
			}
			break;
		case 2:
			String query2 = MyToolbar.getInstance().getbSearch2().getText();
			String[] words2 = query2.split(",");
			if(words2.length == 1) {
				String name = words2[0];
				List<Course> courseList = CourseBase.getInstance().getCourseListForSearch();
				List<Course> retList2 = new ArrayList<>();
				for(Course c : courseList) {
					if(c.getName().contains(name)) {
						retList2.add(c);
					}
				}
				CourseBase.getInstance().setCourseList(retList2);
				
			}else if(words2.length == 2) {
				String name = words2[0];
				String code = words2[1];
				List<Course> courseList = CourseBase.getInstance().getCourseListForSearch();
				List<Course> retList2 = new ArrayList<>();
				for(Course c : courseList) {
					if(c.getName().contains(name) && c.getCode().contains(code)) {
						retList2.add(c);
					}
				}
				CourseBase.getInstance().setCourseList(retList2);
			}
			
		}
	}
   
}
