package view.abstractTableModels;

import javax.swing.table.AbstractTableModel;

import model.dataBase.StudentBase;

public class AbstractTableModelStudent extends AbstractTableModel{

	@Override
	public int getRowCount() {
		return StudentBase.getInstance().getStudentList().size();
	}

	@Override
	public int getColumnCount() {
		return StudentBase.getInstance().getColumnCount();
	}
	
	@Override
	public String getColumnName(int column) {
		return StudentBase.getInstance().getColumnName(column); 
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return StudentBase.getInstance().getValueAt(rowIndex, columnIndex);
	}

}
