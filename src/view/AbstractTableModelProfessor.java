package view;

import javax.swing.table.AbstractTableModel;

import model.ProfessorBase;
import model.StudentBase;

public class AbstractTableModelProfessor extends AbstractTableModel{
	
	@Override
	public int getRowCount() {
		return ProfessorBase.getInstance().getProfessorList().size();
	}

	@Override
	public int getColumnCount() {
		return ProfessorBase.getInstance().getColumnCount();
	}

	@Override
	public String getColumnName(int column) {
		return ProfessorBase.getInstance().getColumnName(column); 
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return ProfessorBase.getInstance().getValueAt(rowIndex, columnIndex);
	}
}