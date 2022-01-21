package model.dataBase;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.CourseController;
import controller.ProfessorController;
import controller.StudentController;
import enumerations.Semester;
import enumerations.Status;
import model.entities.Adress;
import model.entities.Course;
import model.entities.Department;
import model.entities.Grade;
import model.entities.Professor;
import model.entities.Student;

public class DatabaseReader {
	
	private static DatabaseReader instance = null;
	
	public static DatabaseReader getInstance() {
		if(instance == null){
			instance = new DatabaseReader();
		}
		return instance;
	}
	
	private DatabaseReader() {
		
		try {
			
			StudentBase.getInstance().setStudentList(readStudentDatabase());
			StudentBase.getInstance().setStudentListForSearch(readStudentDatabase());
			ProfessorBase.getInstance().setProfessorList(readProfessorDatabase());
			ProfessorBase.getInstance().setProfessorListForSearch(readProfessorDatabase());
			CourseBase.getInstance().setCourseList(readCourseDatabase());
			CourseBase.getInstance().setCourseListForSearch(readCourseDatabase());
			StudentController.getInstance().addGradesToStudents(readGradesForStudent());
			DepartmentBase.getInstance().setDepartmentList(readDepartmentDatabase());
			linkRemainingExamsToStudent();
			linkCoursesToProfessors();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Student> readStudentDatabase() throws Exception{
		File text = new File("src/files/students.txt");
		List<Student> students = new ArrayList<>();
        Scanner scanner;
		scanner = new Scanner(text);
        while(scanner.hasNextLine()){
            String studentInfo = scanner.nextLine();
            String[] studentData = trimData(studentInfo.split(","));
            List<Grade> passedExams = new ArrayList<>();
            List<Course> remainingExams = new ArrayList<>();
            students.add(new Student(studentData[0], studentData[1], LocalDate.parse(studentData[2]), stringToAddress(studentData[3]), studentData[4], studentData[5], 
            		studentData[6], Integer.parseInt(studentData[7]), Integer.parseInt(studentData[8]), (studentData[9] == "B") ? Status.B : Status.S, Double.parseDouble(studentData[10]), passedExams, remainingExams));
        }  
        scanner.close();
		return students;
	}
	
	private Adress stringToAddress(String text) {
		String[] addressData = text.split("#");
		Adress address = new Adress(addressData[0], addressData[1], addressData[2], addressData[3]);
		return address;
	}
	
	private String[] trimData(String[] text) {
		for(int i = 0; i < text.length; i++) {
			text[i] = text[i].trim();
		}
		return text;
	}
	
	public List<Professor> readProfessorDatabase() throws Exception{
		File text = new File("src/files/professors.txt");
		List<Professor> professors = new ArrayList<>();
        Scanner scanner;
		scanner = new Scanner(text);
        while(scanner.hasNextLine()){
            String professorInfo = scanner.nextLine();
            String[] professorData = trimData(professorInfo.split(","));
            List<Course> courseList = new ArrayList<>();
            professors.add(new Professor(professorData[0], professorData[1], LocalDate.parse(professorData[2]), 
            		stringToAddress(professorData[3]), professorData[4], professorData[5], 
            		stringToAddress(professorData[6]), professorData[7], (professorData[8]), 
            		Integer.parseInt(professorData[9] ), courseList));
        }  
        scanner.close();
		return professors;
	}
	
	public List<Course> readCourseDatabase() throws Exception{
		File text = new File("src/files/courses.txt");
		List<Course> subjects = new ArrayList<>();
        Scanner scanner = new Scanner(text);
        while(scanner.hasNextLine()){
            String subjectInfo = scanner.nextLine();
            String[] subjectData = trimData(subjectInfo.split(","));
            List<Student> studentsWhoHavePassedTheExam = new ArrayList<>();
            List<Student> studentsWhoHaveNotPassedTheExam = new ArrayList<>();
            subjects.add(new Course(subjectData[0], subjectData[1], subjectData[5] == "ZIMSKI" ? Semester.WINTER : Semester.SUMMER, Integer.parseInt(subjectData[2]), ProfessorController.getInstance().findProfessor(subjectData[4]), Integer.parseInt(subjectData[3]), studentsWhoHavePassedTheExam, studentsWhoHaveNotPassedTheExam));
        }  
        scanner.close();
		return subjects;
	}
	
	public List<Department> readDepartmentDatabase() throws Exception{
		File text = new File("src/files/departments.txt");
		List<Department> departments = new ArrayList<>();
		Scanner scanner = new Scanner(text);
		while(scanner.hasNextLine()){
			String departmentInfo = scanner.nextLine();
			String[] departmentData = trimData(departmentInfo.split(","));

			departments.add(new Department(departmentData[0], departmentData[1], ProfessorController.getInstance().findProfessor(departmentData[2])));
		}
		scanner.close();
		return departments;
	}
	
	public List<Grade> readGradesForStudent() throws Exception {
		File text = new File("src/files/grades.txt");
		List<Grade> grades = new ArrayList<>();
		Scanner scanner;
		scanner = new Scanner(text);
		while(scanner.hasNextLine()){
			String gradeInfo = scanner.nextLine();
			String[] gradeData = trimData(gradeInfo.split(","));
			Grade grade = new Grade(StudentController.getInstance().findStudent(gradeData[0]), CourseController.getInstance().findCourse(gradeData[1]), Integer.parseInt(gradeData[2]), LocalDate.parse(gradeData[3]));
			grades.add(grade);
		}
		scanner.close();
		return grades;
	}
	
	private void linkRemainingExamsToStudent() throws Exception {
		File text = new File("src/files/remainingExams.txt");
		Scanner scanner;
		scanner = new Scanner(text);
		while(scanner.hasNextLine()){
			String subj = scanner.nextLine();
			String[] subjData = trimData(subj.split(","));
			Student student = StudentController.getInstance().findStudent(subjData[0]);
			Course c = CourseController.getInstance().findCourse(subjData[1]);
			StudentController.getInstance().addCourseToStudent(student, c);
		}
		scanner.close();
		
	}
	
	private void linkCoursesToProfessors() throws Exception {
		File text = new File("src/files/professorsCourses.txt");
		Scanner scanner;
		scanner = new Scanner(text);
		while(scanner.hasNextLine()){
			String subj = scanner.nextLine();
			String[] subjData = trimData(subj.split(","));
			Professor p = ProfessorController.getInstance().findProfessor(subjData[0]);
			Course c = CourseController.getInstance().findCourse(subjData[1]);
			ProfessorController.getInstance().linkCourseToProfessor(p, c);
		}
		scanner.close();
		
	}
	
}
