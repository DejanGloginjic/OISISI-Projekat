package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import model.dataBase.StudentBase;
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
			}
		}
	}

}
