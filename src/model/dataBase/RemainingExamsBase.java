package model.dataBase;

import java.util.ArrayList;
import java.util.List;

import model.entities.Grade;

public class RemainingExamsBase {

	private static RemainingExamsBase instance = null;

	public static RemainingExamsBase getInstance(){
		if (instance == null) {
			instance = new RemainingExamsBase();
		}
		return instance;
	}
	
	private List<Grade> gradeList = new ArrayList<>();
	private List<String> columnList;
	
	private RemainingExamsBase(){
		
		
		setColumnList(new ArrayList<>());
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
	
	public String getColumnName(int index) {
		return this.columnList.get(index);
	}
	
	public Grade getRow(int rowIndex) {
		return this.gradeList.get(rowIndex);
	}
	
}
