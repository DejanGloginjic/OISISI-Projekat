package model.dataBase;

import java.util.ArrayList;
import java.util.List;

import localization.Language;
import model.entities.Course;
import model.entities.Department;
import model.entities.Professor;
import view.window.MyTabbedPane;

public class ProfessorBase {
	
	private static ProfessorBase instance=null;
	
	public static ProfessorBase getInstance() {
		if (instance == null) {
			instance= new ProfessorBase();
		}
		return instance;
	}
	
	private List<Professor> professorList;
	private List<Professor> professorListForSearch = new ArrayList<>();
	private List<String> columnList;
	
	private ProfessorBase() {
		
		columnList=new ArrayList<>();
		this.getColumnList().add(Language.getInstance().getResourceBundle().getString("nameT"));
		this.getColumnList().add(Language.getInstance().getResourceBundle().getString("surnameT"));
		this.getColumnList().add(Language.getInstance().getResourceBundle().getString("titleT"));
		this.getColumnList().add("Email");
	}

	public List<Professor> getProfessorList() {
		return this.professorList;
	}

	public void setProfessorList(List<Professor> professorList) {
		this.professorList = professorList;
		MyTabbedPane.getInstance().updateViewProfessor();
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
	
	public Professor getRow(int rowIndex) {
		return this.professorList.get(rowIndex);
	}
	
	public List<Professor> getProfessorListForSearch() {
		return professorListForSearch;
	}

	public void setProfessorListForSearch(List<Professor> professorListForSearch) {
		this.professorListForSearch = professorListForSearch;
	}

	public String getValueAt(int row,int column) {
		
		Professor professor=this.professorList.get(row);
		
		switch (column) {
		case 0:
			return professor.getName();
		case 1:
			return professor.getSurname();
		case 2:
			return professor.getTitle();
		case 3:
			return professor.geteMail();
		default:
			return null;
		}
	}
	
	public boolean checkIfUnique(String idNumber) {
		for(Professor p:professorList) {
			if(idNumber.equals(p.getIdNumber())) {
				return false;
			}
		}
		return true;
	}
	
	public void addProfessor(Professor professor) {
		this.professorList.add(professor);
	}
	
	public void deleteProfessor(String idNum) {
		for(Professor p : professorList) {
			if(p.getIdNumber().equals(idNum)) {
				professorList.remove(p);
				break;
			}
		}
	}
	
	public Professor findByIdNum(String idNum) {
		for(Professor p : professorList) {
			if(p.getIdNumber().equals(idNum)) {
				return p;
			}
		}
		return null;
	}
	
//	public void addToCourseList(Course c,Professor p) {
//		for (Course course: p.getListOfSubjects()) {
//			if (course.getCode() == c.getCode()) {
//				return;
//			}
//		}
//		p.getListOfSubjects().add(c);
//	}
	
	public void removeFromCourseList(Course c,Professor p) {
		for (Course course : p.getListOfSubjects()) {
			if(course.getCode() == c.getCode()) {
				p.getListOfSubjects().remove(course);
				return;
			}
		}
		return ;
	}
	
	public void editProfessor(Professor p) {
		for(Professor professor : professorList) {
			if(professor.getIdNumber().equals(p.getIdNumber())) {
				professor.setName(p.getName());
				professor.setSurname(p.getSurname());
				professor.setDateOfBirth(p.getDateOfBirth());
				professor.getResidentialAddress().setCity(p.getResidentialAddress().getCity());
				professor.getResidentialAddress().setCountry(p.getResidentialAddress().getCountry());
				professor.getResidentialAddress().setNumber(p.getResidentialAddress().getNumber());
				professor.getResidentialAddress().setStreet(p.getResidentialAddress().getStreet());
				professor.setTelephoneNumber(p.getTelephoneNumber());
				professor.seteMail(p.geteMail());
				professor.getOfficeAddress().setCity(p.getOfficeAddress().getCity());
				professor.getOfficeAddress().setCountry(p.getOfficeAddress().getCountry());
				professor.getOfficeAddress().setNumber(p.getOfficeAddress().getNumber());
				professor.getOfficeAddress().setStreet(p.getOfficeAddress().getStreet());
				professor.setIdNumber(p.getIdNumber());
				professor.setTitle(p.getTitle());
				professor.setYearOfTrail(p.getYearOfTrail());
			}
		}
		MyTabbedPane.getInstance().updateViewProfessor();
	}
	
	/*public List<Professor> getListOfProfessorsThatSuitTheCourse(){
		
		int rowSelected = MyTabbedPane.getInstance().getCt().getSelectedRow();
		Course c = CourseBase.getInstance().getRow(rowSelected);
		List<Professor> retList = new ArrayList<>();
		
		for (Professor p1 : this.professorList) {
			int i = 0;
			for(Professor p2 : c.getSubjectProfessor()) {
				i++;
				if(p1.)
			}
		}
		return retList;
	}*/


	public void setProfesorCoursesAfterRemovingCourse(Professor p) {
		for(Professor prof : this.professorList) {
			if(prof.getIdNumber() == p.getIdNumber()) {
				prof.setListOfSubjects(p.getListOfSubjects());
				break;
			}
		}
	}

	public void addCourseToSelectedProfessor(Course c) {
		int rowSelected = MyTabbedPane.getInstance().getPt().getSelectedRow();
		Professor p = ProfessorBase.getInstance().getRow(rowSelected);
		
		for(Professor professor : this.professorList) {
			if(professor.getIdNumber().equals(p.getIdNumber())) {
				professor.getListOfSubjects().add(c);
				break;
			}
		}
	}
	
	public Professor findProfessor(String id) {
		for(int i = 0; i < this.professorList.size(); i++) {
			if(this.professorList.get(i).getIdNumber().equals(id)) 
				return this.professorList.get(i);
		}
		return null;
	}
	
	public List<Professor> findProfessorThatSuitDepartments(){
		List<Professor> retList = new ArrayList<>();
		for(Professor p : this.professorList) {
			if(p.getTitle().equals("REDOVNI_PROFESOR") || p.getTitle().equals("VANREDNI_PROFESOR")) {
				if(p.getYearOfTrail() >= 5) {
					retList.add(p);
				}
			}
		}
		return retList;
	}
	
	public void linkCourseToProfessor(Professor p, Course c) {
		for(Professor prof : this.professorList) {
			if(p.getIdNumber().equals(prof.getIdNumber())) {
				prof.getListOfSubjects().add(c);
			}
		}
	}
	
//	public List<Professor> findProfessorsThatSuitDepartment() {
//		List<Professor> retList = new ArrayList<>();
//		
//		for(Professor p : this.professorList) {
//			
//		}
//	}
	
	public void unlinkCourseFromProfessor(Professor p, Course c) {
		for(Professor prof : this.professorList) {
			if(prof.getIdNumber().equals(p.getIdNumber())) {
				prof.getListOfSubjects().remove(c);
			}
		}
	}
}
