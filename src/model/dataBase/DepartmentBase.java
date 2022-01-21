package model.dataBase;

import java.util.ArrayList;
import java.util.List;

import model.entities.Department;
import model.entities.Professor;
import model.entities.Student;

public class DepartmentBase {
	
	private static DepartmentBase instance=null;
	
	public static DepartmentBase getInstance() {
		if (instance == null) {
			instance= new DepartmentBase();
		}
		return instance;
	}
	
	private List<Department> depList = new ArrayList<>();
	private List<String> columnList;
	
	private DepartmentBase() {
		
		columnList=new ArrayList<>();
		this.columnList.add("Šifra");
		this.columnList.add("Naziv");
		this.columnList.add("Šef katedre");
	}
	
	public List<Department> getDepartmentList() {
		return depList;
	}
	
	public void setDepartmentList(List<Department> depList) {
		this.depList = depList;
	}
	
	public List<String> getColumnList() {
		return columnList;
	}
	
	public void setColumnList(List<String> columnList) {
		this.columnList = columnList;
	}
	
	public int getColumnCount() {
		return 3;
	}

	public String getColumnName(int index) {
		return this.columnList.get(index);
	}
	
	public Department getRow(int rowIndex) {
		return this.depList.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
			
		Department dep = this.depList.get(row);
			
		switch (column) {
		case 0:
			return dep.getCode();
		case 1:
			return dep.getName();
		case 2:
			if(dep.getBoss().getName() == null)
				return "/";
			else
				return dep.getBoss().getName() + " " + dep.getBoss().getSurname();
		default:
			return null;
		}
	}
	
	public void addDepartment(Department dep) {
		this.depList.add(dep);
	}
	
	public void setBossOfDepartment(String code, int bossId) {
		
		for(Department d : this.depList) {
			if(d.getCode().equals(code)) {
				d.setBoss(ProfessorBase.getInstance().findProfessor(String.valueOf(bossId)));
			}
		}
		
	}
	
	public boolean bossValidation(Professor p) {
		for(Department dep : this.depList) {
			if(dep.getBoss().getIdNumber().equals(p.getIdNumber())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean nameValidation(String name) {
		for(Department dep : this.depList) {
			if(dep.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean codeValidation(String code) {
		for(Department dep : this.depList) {
			if(dep.getCode().equals(code)) {
				return true;
			}
		}
		return false;
	}
	
	public void deleteDepartment(Department d) {
		for(Department dep : this.depList) {
			if(dep.getCode().equals(d.getCode())) {
				this.depList.remove(d);
				break;
			}
		}
	}
}
