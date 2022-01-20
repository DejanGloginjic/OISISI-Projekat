package model.dataBase;

import java.util.ArrayList;
import java.util.List;

import controller.StudentController;
import model.entities.Course;
import view.panels.MyPanelRemainingExams;

public class RemainingExamsBase {

	private static RemainingExamsBase instance = null;

	public static RemainingExamsBase getInstance(){
		if (instance == null) {
			instance = new RemainingExamsBase();
		}
		return instance;
	}
	
	private List<Course> courseList = new ArrayList<>();
	private List<String> columnList;
	
	private RemainingExamsBase(){
		this.courseList = StudentController.getInstance().findSelectedStudent().getRemainingExams();
		
		setColumnList(new ArrayList<>());
		this.getColumnList().add("Šifra predmeta");
		this.getColumnList().add("Naziv predmeta");
		this.getColumnList().add("ESPB");
		this.getColumnList().add("Godina studija");
		this.getColumnList().add("Semestar");
	}

	public List<Course> getGradeList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
		MyPanelRemainingExams.getInstance().updateViewRemainingExams();
	}

	public List<String> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<String> columnList) {
		this.columnList = columnList;
	}
	
	public int getColumnCount() {
		return 5;
	}
	
	public String getValueAt(int row, int column) {
		
		Course course = this.courseList.get(row);
			
		switch (column) {
		case 0:
			return course.getCode();
		case 1:
			return course.getName();
		case 2:
			return String.valueOf(course.getNumberOfESPB());
		case 3:
			return String.valueOf(course.getYearOfTheCourse());
		case 4:
			return String.valueOf(course.getSemester());
		default:
			return null;
		}
	}
	
	public String getColumnName(int index) {
		return this.columnList.get(index);
	}
	
	public Course getRow(int rowIndex) {
		return this.courseList.get(rowIndex);
	}
	
	public void deleteCourse(String code) {
		for(Course c : this.courseList) {
			if(c.getCode().equals(code)) {
				this.courseList.remove(c);
				break;
			}
		}
	}
}
