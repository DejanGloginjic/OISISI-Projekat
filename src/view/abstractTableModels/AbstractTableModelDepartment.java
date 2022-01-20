package view.abstractTableModels;

import javax.swing.table.AbstractTableModel;

import model.dataBase.DepartmentBase;
import model.dataBase.StudentBase;

public class AbstractTableModelDepartment extends AbstractTableModel{
	@Override
	public int getRowCount() {
		return DepartmentBase.getInstance().getDepartmentList().size();
	}

	@Override
	public int getColumnCount() {
		return DepartmentBase.getInstance().getColumnCount();
	}
	
	@Override
	public String getColumnName(int column) {
		return DepartmentBase.getInstance().getColumnName(column); 
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return DepartmentBase.getInstance().getValueAt(rowIndex, columnIndex);
	}
}
