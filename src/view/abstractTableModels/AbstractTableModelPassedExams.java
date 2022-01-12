package view.abstractTableModels;

import javax.swing.table.AbstractTableModel;

import model.dataBase.PassedExamsBase;

public class AbstractTableModelPassedExams extends AbstractTableModel{
	@Override
	public int getRowCount() {
		return PassedExamsBase.getInstance().getGradeList().size();
	}

	@Override
	public int getColumnCount() {
		return PassedExamsBase.getInstance().getColumnCount();
	}
	
	@Override
	public String getColumnName(int column) {
		return PassedExamsBase.getInstance().getColumnName(column); 
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return PassedExamsBase.getInstance().getValueAt(rowIndex, columnIndex);
	}
}
