package model.dataBase;

import java.util.ArrayList;
import java.util.List;

import model.dataBase.StudentBase;
import model.entities.Course;
import model.entities.Grade;
import model.entities.Student;
import view.panels.MyPanelPassedExams;

public class PassedExamsBase {

	private static PassedExamsBase instance = null;

	public static PassedExamsBase getInstance(){
		if (instance == null) {
			instance = new PassedExamsBase();
		}
		return instance;
	}
	
	private List<Grade> gradeList = new ArrayList<>();
	private List<String> columnList;
	
	private PassedExamsBase(){
		
		
		columnList = new ArrayList<>();
		this.getColumnList().add("Šifra predmeta");
		this.getColumnList().add("Naziv predmeta");
		this.getColumnList().add("ESPB");
		this.getColumnList().add("Ocjena");
		this.getColumnList().add("Datum");
	}
	
	public List<Grade> getGradeList() {
		return gradeList;
	}
	
	public void setGradeList(List<Grade> gradeList) {
		this.gradeList = gradeList;
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

	public String getColumnName(int index) {
		return this.columnList.get(index);
	}
	
	public Grade getRow(int rowIndex) {
		return this.gradeList.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		
		Grade grade = this.gradeList.get(row);
			
		switch (column) {
		case 0:
			return String.valueOf(grade.getCourse().getCode());
		case 1:
			return grade.getCourse().getName();
		case 2:
			return String.valueOf(grade.getCourse().getNumberOfESPB());
		case 3:
			return String.valueOf(grade.getValue());
		case 4:
			return grade.getExamDate().toString();
		default:
			return null;
		}
		
	}
	
	public void setNumberOfESPB() {
		int total = 0;
		for(Grade g : this.gradeList) {
			total += g.getCourse().getNumberOfESPB();
		}
		MyPanelPassedExams.getInstance().getValue().setText(String.valueOf(total));
	}
}
