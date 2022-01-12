package model.dataBase;

import java.util.ArrayList;
import java.util.List;

import enumerations.Semester;
import model.entities.Course;
import model.entities.Professor;
import model.entities.Student;
import view.window.MyTabbedPane;

public class CourseBase {

	private static CourseBase instance=null;
	
	public static CourseBase getInstance() {
		if (instance == null) {
			instance= new CourseBase();
		}
		return instance;
	}
	
	private List<Course> courseList;
	private List<String> columnList;
	
	private CourseBase() {
		initCourse();
		
		columnList=new ArrayList<>();
		this.getColumnList().add("Šifra predmeta");
		this.getColumnList().add("Naziv predmeta");
		this.getColumnList().add("Broj ESPB bodova");
		this.getColumnList().add("Godina na kojoj se predmet izvodi");
		this.getColumnList().add("Semestar u kome se predmet izvodi");
	}

	private void initCourse() {
		this.courseList=new ArrayList<>();
		
		Professor p1 = new Professor();
		courseList.add(new Course("1","Baze podataka",Semester.WINTER,3,p1,8,null,null));
		courseList.add(new Course("2","Metode optimizacije",Semester.WINTER,3,p1,8,null,null));
		courseList.add(new Course("3","Programski prevodioci",Semester.WINTER,3,p1,6,null,null));
		courseList.add(new Course("4","OISISI",Semester.WINTER,3,p1,5,null,null));
		
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	
	public Course getRow(int rowIndex) {
		return this.courseList.get(rowIndex);
	}

	public List<String> getColumnList() {
		return columnList;
	}
	
	public int getColumnCount() {
		return 5;
	}
	
	public void setColumnList(List<String> columnList) {
		this.columnList = columnList;
	}
	
	public String getColumnName(int index) {
		return this.columnList.get(index);
	}
	
	public String getValueAt(int row,int column) {
		
		Course course=this.courseList.get(row);
		
		switch (column) {
		case 0:
			return course.getCode();
		case 1:
			return course.getName();
		case 2:
			return Integer.toString(course.getNumberOfESPB());
		case 3:
			return Integer.toString(course.getYearOfTheCourse());
		case 4:
			return course.getSemester().name();
		default:
			return null;
		}
	}
	
	public void addCourse(Course c) {
		this.courseList.add(c);
		
	}
	
	public void deleteCourse(String code) {
		for(Course c : courseList) {
			if(c.getCode().equals(code))
				courseList.remove(code);
				break;
		}
	}
	
	public boolean checkIfUnique(String code) {
		for(Course c: courseList) {
			if(code.equals(c.getCode())) {
				return true;
			}
		}
		return false;
	}
	
	public void editCourse(Course c) {
		for(Course course : this.courseList) {
			if(course.getCode().equals(c.getCode())) {
				course.setCode(c.getCode());
				course.setName(c.getName());
				course.setNumberOfESPB(c.getNumberOfESPB());
				course.setSemester(c.getSemester());
				course.setYearOfTheCourse(c.getYearOfTheCourse());
				course.setSubjectProfessor(c.getSubjectProfessor());
				course.setStudentsWhoHaveNotPassedTheExam(null);
				course.setStudentsWhoHavePassedTheExam(null);
				break;
			}
		
		}
	}
}
