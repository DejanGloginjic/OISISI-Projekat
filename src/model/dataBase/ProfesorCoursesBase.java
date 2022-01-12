package model.dataBase;

import java.util.ArrayList;
import java.util.List;

import model.entities.Course;
import model.entities.Grade;
import model.dataBase.PassedExamsBase;

public class ProfesorCoursesBase {
	
	private static ProfesorCoursesBase instance = null;

	public static ProfesorCoursesBase getInstance(){
		if (instance == null) {
			instance = new ProfesorCoursesBase();
		}
		return instance;
	}
	
	private List<Course> courseList = new ArrayList<>();
	private List<String> columnList;
	
	private ProfesorCoursesBase(){
		
		
		columnList = new ArrayList<>();
		this.getColumnList().add("Šifra");
		this.getColumnList().add("Naziv");
		this.getColumnList().add("Godina studija");
		this.getColumnList().add("Semestar");
	}
	
	public List<Course> getCourseList() {
		return courseList;
	}
	
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	
	public List<String> getColumnList() {
		return columnList;
	}
	
	public void setColumnList(List<String> columnList) {
		this.columnList = columnList;
	}
	
	public int getColumnCount() {
		return 4;
	}

	public String getColumnName(int index) {
		return this.columnList.get(index);
	}
	
	public Course getRow(int rowIndex) {
		return this.courseList.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		
		Course course = this.courseList.get(row);
			
		switch (column) {
		case 0:
			return course.getCode();
		case 1:
			return course.getName();
		case 2:
			return String.valueOf(course.getYearOfTheCourse());
		case 3:
			return course.getSemester().toString();
		default:
			return null;
		}
		
	}
}
