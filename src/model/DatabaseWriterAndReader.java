package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.entities.Student;

public class DatabaseWriterAndReader {
	
	private List<Student> studentList;
	
	private static DatabaseWriterAndReader instance = null;

	public static DatabaseWriterAndReader getInstance() throws Exception {
		if (instance == null) {
			instance = new DatabaseWriterAndReader();
		}
		return instance;
	}
	
	private DatabaseWriterAndReader() {}
	
	public List<Student> readStudentFromFileWriteToList() throws Exception {
		List<Student> retList = new ArrayList<>();
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("src" + File.separator + "students.txt")));
		try {
			Student[] students = (Student[])ois.readObject();	
			for(Student s : students)
				retList.add(s);
			}finally {
				ois.close();
			}
			return retList;
	}
	
	public void writeStudentToFile(List<Student> students) throws Exception{
		Student s[] = new Student[students.size()];
		for(Student s1 : students) {
			int i = 0;
			s[i] = s1;
			i++;
		}
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("src" + File.separator + "students.txt")));
		try {
			oos.writeObject(s);
		} finally {
			oos.close(); 
		}

	}
}
