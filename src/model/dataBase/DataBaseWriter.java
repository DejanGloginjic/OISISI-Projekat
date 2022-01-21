package model.dataBase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import model.entities.Course;
import model.entities.Department;
import model.entities.Grade;
import model.entities.Professor;
import model.entities.Student;

public class DataBaseWriter {

	public DataBaseWriter() {}
		
	public static void WriteStudent(ArrayList<Student> students) throws IOException {
		FileWriter f = new FileWriter("src" + File.separator + "files" + File.separator + "students.txt");
		BufferedWriter writer = new BufferedWriter(f);
		try {
			for(Student s:students) {
				writer.write(s.toString());
				writer.newLine();
			}
			}catch(IOException  e) {
				e.printStackTrace();
		} finally {
			writer.close();
		}
	}

	public static void WriteProfessor(ArrayList<Professor> professor) throws IOException {
		FileWriter f = new FileWriter("src" + File.separator + "files" + File.separator + "professors.txt");
		BufferedWriter writer = new BufferedWriter(f);
		try {
			for(Professor p:professor) {
				writer.write(p.toStringForDataBaseWriter());
				writer.newLine();
			}
			}catch(IOException  e) {
				e.printStackTrace();
		} finally {
			writer.close();
		}
	}
	
	public static void WriteCourse(ArrayList<Course> course) throws IOException {
		FileWriter f = new FileWriter("src" + File.separator + "files" + File.separator + "courses.txt");
		BufferedWriter writer = new BufferedWriter(f);
		try {
			for(Course c:course) {
				writer.write(c.toString());
				writer.newLine();
			}
			}catch(IOException  e) {
				e.printStackTrace();
		} finally {
			writer.close();
		}
	}
	
	public static void WriteDepartment(ArrayList<Department> departments) throws IOException {
		FileWriter f = new FileWriter("src" + File.separator + "files" + File.separator + "departments.txt");
		BufferedWriter writer = new BufferedWriter(f);
		try {
			for(Department d:departments) {
				writer.write(d.toString());
				writer.newLine();
			}
			}catch(IOException  e) {
				e.printStackTrace();
		} finally {
			writer.close();
		}
	}
	
	public static void WriteGrade() throws IOException {
		FileWriter f = new FileWriter("src" + File.separator + "files" + File.separator + "grades.txt");
		BufferedWriter writer = new BufferedWriter(f);
		try {
			for(Student s:StudentBase.getInstance().getStudentList()) {
				for(Grade g:s.getPassedExams()) {
					writer.write(g.toString());
					writer.newLine();
				}
			}
			}catch(IOException  e) {
				e.printStackTrace();
		} finally {
			writer.close();
		}
	}
	
	public static void WriteRemainingExams() throws IOException {
		FileWriter f = new FileWriter("src" + File.separator + "files" + File.separator + "remainingExams.txt");
		BufferedWriter writer = new BufferedWriter(f);
		try {
			for(Student s:StudentBase.getInstance().getStudentList()) {
				for(Course c:s.getRemainingExams()) {
					writer.write(s.getIndexNumber() + ", " + c.getCode());
					writer.newLine();
				}
			}
			}catch(IOException  e) {
				e.printStackTrace();
		} finally {
			writer.close();
		}
	}
	
	public static void WriteProfessorsCourses() throws IOException {
		FileWriter f = new FileWriter("src" + File.separator + "files" + File.separator + "professorsCourses.txt");
		BufferedWriter writer = new BufferedWriter(f);
		try {
			for(Professor p:ProfessorBase.getInstance().getProfessorList()) {
				for(Course c:p.getListOfSubjects()) {
					writer.write(p.getIdNumber() + ", " + c.getCode());
					writer.newLine();
				}
			}
			}catch(IOException  e) {
				e.printStackTrace();
		} finally {
			writer.close();
		}
	}
	
}
