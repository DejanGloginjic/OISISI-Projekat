package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProfessorBase {
	
	private static ProfessorBase instance=null;
	
	public static ProfessorBase getInstance() {
		if (instance == null) {
			instance= new ProfessorBase();
		}
		return instance;
	}
	
	private List<Professor> professorList;
	private List<String> columnList;
	
	private ProfessorBase() {
		initProfessors();
		
		columnList=new ArrayList<>();
		this.getColumnList().add("Ime");
		this.getColumnList().add("Prezime");
		this.getColumnList().add("Zvanje");
		this.getColumnList().add("E-mail");
	}

	private void initProfessors() {
		this.professorList=new ArrayList<>();
		
		Adress adresa1 = new Adress("Sportska ulica", 12, "Novi Sad", "Srbija");
		Adress adresa2 = new Adress("Strazilovska", 2, "Novi Sad", "Srbija");
		Adress adresa3 = new Adress("Ulica kralja Petra", 16, "Novi Sad", "Srbija");
		Adress adresa4 = new Adress("Bulevar oslobodjenja", 6, "Novi Sad", "Srbija");
		
		professorList.add(new Professor("Milan","Rapaic", LocalDate.of(1970, 1, 1),adresa1,12,"brankakukic@yahoo.com",adresa1,"2","Diplomirani inzenjer elektrotehnike",10,null));
		professorList.add(new Professor("Zoran","Jelicic", LocalDate.of(1960, 1, 1),adresa2,56,"zoranjelicic@yahoo.com",adresa2,"2","Diplomirani inzenjer elektrotehnike",10,null));
		professorList.add(new Professor("Milan","Vidakovic", LocalDate.of(1952, 1, 1),adresa3,24,"milanvidakovic@yahoo.com",adresa3,"2","Diplomirani inzenjer elektrotehnike",10,null));
		professorList.add(new Professor("Nebojsa","Ralevic", LocalDate.of(1959, 1, 1),adresa4,15,"nebojsaralevic@yahoo.com",adresa4,"2","Diplomirani inzenjer elektrotehnike",10,null));
	}

	public List<Professor> getProfessorList() {
		return professorList;
	}

	public void setProfessorList(List<Professor> professorList) {
		this.professorList = professorList;
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
	
	public void addProfessor(Professor professor) {
		this.professorList.add(professor);
	}
}
