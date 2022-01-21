package model.dataBase;

import java.util.ArrayList;
import java.util.List;

import controller.StudentController;
import enumerations.Semester;
import localization.Language;
import model.entities.Course;
import model.entities.Grade;
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
	private List<Course> courseListForSearch = new ArrayList<>();
	private List<String> columnList;
	
	private CourseBase() {
		
		columnList=new ArrayList<>();
		this.getColumnList().add(Language.getInstance().getResourceBundle().getString("courseCode"));
		this.getColumnList().add(Language.getInstance().getResourceBundle().getString("courseName"));
		this.getColumnList().add(Language.getInstance().getResourceBundle().getString("espb"));
		this.getColumnList().add(Language.getInstance().getResourceBundle().getString("courseYear"));
		this.getColumnList().add(Language.getInstance().getResourceBundle().getString("courseSemestar"));
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
		MyTabbedPane.getInstance().updateViewCourse();
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
	
	public List<Course> getCourseListForSearch() {
		return courseListForSearch;
	}

	public void setCourseListForSearch(List<Course> courseListForSearch) {
		this.courseListForSearch = courseListForSearch;
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
			if(c.getCode().equals(code)) {
				courseList.remove(c);
				break;
			}
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

	public List<Course> getListOfCoursesThatSuitTheStudent(){
		List<Course> retList = new ArrayList<>();
		int rowSelected1 = MyTabbedPane.getInstance().getSt().getSelectedRow();
		
		if(rowSelected1 < 0) {
			return new ArrayList<>();
		}else {
			Student s = StudentBase.getInstance().getRow(rowSelected1);
			
			//prvi slucaj: ako je prazna i lista remainingExams i passedExams kod studenta
			if(s.getRemainingExams().size() == 0 && s.getPassedExams().size() == 0) {
				for(Course c1 : this.courseList) {
					if(c1.getYearOfTheCourse() <= s.getCurrentYearOfStudy()) {
						retList.add(c1);
					}
				}
				return retList;
			}
			
			//drugi slucaj: ako je prazna lista remainingExams kod studenta
			if(s.getRemainingExams().size() == 0) {
				for(Course c1 : this.courseList) {
					int j = 0;
					for(Grade g : s.getPassedExams()) {
						j++;
						if(g.getCourse().getCode().equals(c1.getCode())) {
							break;
						}
						if(j == s.getPassedExams().size()) {
							//ako se nalazimo na ovoj tacki znaci da se predmet c1 ne nalazi u listi polozenih ispita
							//sad jos trebamo ispitati da li predemet c1 odgovara godini studija studenta
							if(c1.getYearOfTheCourse() > s.getCurrentYearOfStudy()) {
								break;
							}else {
								retList.add(c1);
							}
						}
					}
				}
				return retList;
			}
			
			//treci slicaj: ako je prazna lista passedExams kod studenta
			if(s.getPassedExams().size() == 0) {
				for(Course c1 : this.courseList) {
					int i = 0;
					for(Course c2 : s.getRemainingExams()) {
						i++;
						if(c1.getCode().equals(c2.getCode())) {
							break;
						}
						if(i == s.getRemainingExams().size()) {
							//ako se nalazimo na ovoj tacki znaci da se predmet c1 ne nalazi u listi nepolozenih predmeta datog studenta
							//sad ispitujemo da li se predemet c1 nalazi u listi polozenih ispita
							if(c1.getYearOfTheCourse() > s.getCurrentYearOfStudy()) {
								break;
							}else {
								retList.add(c1);
							}
						}
					}
				}
			}
			
			//cetvrti slucaj: nista od gore navedenog
			for(Course c1 : this.courseList) {
				int i1 = 0;
				for(Course c2 : s.getRemainingExams()) {
					i1++;
					if(c1.getCode().equals(c2.getCode())) {
						break;
					}
					if(i1 == s.getRemainingExams().size()) {
						//ako se nalazimo na ovoj tacki znaci da se predmet c1 ne nalazi u listi nepolozenih predmeta datog studenta
						//sad ispitujemo da li se predemet c1 nalazi u listi polozenih ispita
						int j = 0;
						for(Grade g : s.getPassedExams()) {
							j++;
							if(g.getCourse().getCode().equals(c1.getCode())) {
								break;
							}
							if(j == s.getPassedExams().size()) {
								//ako se nalazimo na ovoj tacki znaci da se predmet c1 ne nalazi ni u listi polozenih ispita
								//sad jos trebamo ispitati da li predemet c1 odgovara godini studija studenta
								if(c1.getYearOfTheCourse() > s.getCurrentYearOfStudy()) {
									break;
								}else {
									retList.add(c1);
								}
							}
						}
						break;
					}
					
				}
			}
		}
		return retList;
	}
	
	public Course findCourseByCode(String code) {
		Course course = new Course();
		for(Course c : this.courseList) {
        	if(c.getCode().equals(code)) {
        		course = c;
        	}
        }
		return course;
	}
	
	public void addStudentToCourse(Course c) {
		for(Course course : this.courseList) {
        	if(c.getCode().equals(course.getCode())) {
        		course.getStudentsWhoHaveNotPassedTheExam().add(StudentBase.getInstance().findSelectedStudent());
        		break;
        	}
        }
	}
	
	//brisanje predmeta iz studenta
	public void deleteStudentFromCourse(Course c) {
		for(Course course : this.courseList) {
			if(c.getCode().equals(course.getCode())) {
				course.getStudentsWhoHaveNotPassedTheExam().remove(StudentBase.getInstance().getSelectedStudent());
				break;
			}
		}
	}
	
	public List<Course> getListOfCoursesThatSuitTheProfessor(){
		int rowSelected = MyTabbedPane.getInstance().getPt().getSelectedRow();
		List<Course> retList = new ArrayList<>();
		
		if(rowSelected < 0) {
			return new ArrayList<>();
		}else {
		
			Professor p = ProfessorBase.getInstance().getRow(rowSelected);
			
			List<Course> pomList = new ArrayList<>();
			for(Professor prof : ProfessorBase.getInstance().getProfessorList()) {
				for(Course c : prof.getListOfSubjects()) {
					pomList.add(c);
				}
			}
			
			
			if(ProfessorBase.getInstance().getProfessorList().isEmpty()){
				System.out.println("aaaaaa");
			}
			for(Course c1 : this.courseList) {
				int i = 0;
				for(Course c2 : pomList) {
					i++;
					if(c1.getCode().equals(c2.getCode())) {
						break;
					}
				}
				if(i == pomList.size()) {
					retList.add(c1);
				}
			}
			
		}
		return retList;
		
	}

	public Course findCourse(String id) {
		if(id.equals("")) {
			return null;
		}
		for(int i = 0; i < this.courseList.size(); i++) {
			if (this.courseList.get(i).getCode().equals(id)) {
				return this.courseList.get(i);
			}
		}
		return null;
	}
	
	public void addSelectedProfessorToCourse(Course c) {
		int index = MyTabbedPane.getInstance().getPt().getSelectedRow();
		Professor p = ProfessorBase.getInstance().getRow(index);
		
		for(Course course : this.courseList) {
			if(course.getCode().equals(c.getCode())) {
				course.setSubjectProfessor(p);
				break;
			}
		}
	}
	
	public void removeSelectedProfessorFromCourse(Course c) {
		for(Course course : this.courseList) {
			if(course.getCode().equals(c.getCode())) {
				course.setSubjectProfessor(null);
				break;
			}
		}
	}
	
	public void addProfessorToCourse(Professor p, Course c) {
		
		if(c == null) 
			return;
		
		for(Course course : this.courseList) {
			if(course.getCode().equals(c.getCode())) {
				course.setSubjectProfessor(p);
				break;
			}
		}
	}

	
	public void unlinkProfessorFromCourse(Professor p, Course c) {
		for(Course course : this.getCourseList()) {
			if(course.getCode().equals(c.getCode())) {
				course.setSubjectProfessor(null);
			}
		}
	}
}
