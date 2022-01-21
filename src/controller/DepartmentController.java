package controller;

import controller.StudentController;
import model.dataBase.DepartmentBase;
import model.dataBase.StudentBase;
import model.entities.Department;
import model.entities.Professor;
import model.entities.Student;
import view.dialogs.DepartmentDialog;
import view.window.MyTabbedPane;

public class DepartmentController {
	
	private static DepartmentController instance = null;
	
	public static DepartmentController getInstance() {
		if (instance == null) {
			instance = new DepartmentController();
		}
		return instance;
	}
	
	private DepartmentController() {}
	
	
	public void addDepartment(Department dep){
		DepartmentBase.getInstance().addDepartment(dep);
		DepartmentDialog.getInstance().updateViewDepartment();
	}
	
	public void setBossOfDepartment(String code, int bossId) {
		DepartmentBase.getInstance().setBossOfDepartment(code, bossId);
		DepartmentDialog.getInstance().updateViewDepartment();
	} 
	
	public boolean bossValidation(Professor p) {
		return DepartmentBase.getInstance().bossValidation(p);
	}
	
	public boolean nameValidation(String name) {
		return DepartmentBase.getInstance().nameValidation(name);
	}
	
	public boolean codeValidation(String code) {
		return DepartmentBase.getInstance().codeValidation(code);
	}
	
	public void deleteDepartment(Department d) {
		DepartmentBase.getInstance().deleteDepartment(d);
		DepartmentDialog.getInstance().updateViewDepartment();
	}
}
