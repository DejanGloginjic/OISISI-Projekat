package view.abstractTableModels;

import javax.swing.table.AbstractTableModel;

import model.dataBase.RemainingExamsBase;

public class AbstractTableModelRemainingExams extends AbstractTableModel{

	@Override
	public int getRowCount() {
		return RemainingExamsBase.getInstance().getGradeList().size();
	}

	@Override
	public int getColumnCount() {
		return RemainingExamsBase.getInstance().getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return RemainingExamsBase.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int column) {
		return RemainingExamsBase.getInstance().getColumnName(column); 
	}

}
