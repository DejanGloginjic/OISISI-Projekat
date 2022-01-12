package view.abstractTableModels;

import javax.swing.table.AbstractTableModel;

import model.dataBase.ProfesorCoursesBase;

public class AbstractTableModelProfessorCourses extends AbstractTableModel{
	
	@Override
	public int getRowCount() {
		return ProfesorCoursesBase.getInstance().getCourseList().size();
	}

	@Override
	public int getColumnCount() {
		return ProfesorCoursesBase.getInstance().getColumnCount();
	}
	
	@Override
	public String getColumnName(int column) {
		return ProfesorCoursesBase.getInstance().getColumnName(column); 
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return ProfesorCoursesBase.getInstance().getValueAt(rowIndex, columnIndex);
	}
}
