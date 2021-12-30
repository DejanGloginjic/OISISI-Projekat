package view.abstractTableModels;

import javax.swing.table.AbstractTableModel;

import model.dataBase.CourseBase;

public class AbstractTableModelCourse extends AbstractTableModel{

	@Override
	public int getRowCount() {
		return CourseBase.getInstance().getCourseList().size();
	}

	@Override
	public int getColumnCount() {
		return CourseBase.getInstance().getColumnCount();
	}

	@Override
	public String getColumnName(int column) {
		return CourseBase.getInstance().getColumnName(column); 
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return CourseBase.getInstance().getValueAt(rowIndex, columnIndex);
	}

}
