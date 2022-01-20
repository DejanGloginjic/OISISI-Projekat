package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private String code; 
	private String name;
	private Professor  boss;
	private List<Professor> listOfProfessors;
	public Department(String code, String name, Professor boss, List<Professor> listOfProfessors) {
		super();
		this.code = code;
		this.name = name;
		this.boss = boss;
		this.listOfProfessors = listOfProfessors;
	}
	
	public Department(String code, String name, Professor boss) {
		super();
		this.code = code;
		this.name = name;
		this.boss = boss;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Professor getBoss() {
		return boss;
	}
	public void setBoss(Professor boss) {
		this.boss = boss;
	}
	public List<Professor> getListOfProfessors() {
		return listOfProfessors;
	}
	public void setListOfProfessors(List<Professor> listOfProfessors) {
		this.listOfProfessors = listOfProfessors;
	}
//e47,katedra za autimatiku,500500544
	@Override
	public String toString() {
		return  code + ", " + name + ", " + boss;
	}

	
}
