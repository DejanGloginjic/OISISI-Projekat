package view.window;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import localization.Language;
import view.abstractTableModels.AbstractTableModelCourse;
import view.abstractTableModels.AbstractTableModelProfessor;
import view.abstractTableModels.AbstractTableModelStudent;
import view.tables.CourseTable;
import view.tables.ProfessorTable;
import view.tables.StudentTable;

public class MyTabbedPane extends JTabbedPane{
	
	private StudentTable st = new StudentTable();
	private ProfessorTable pt= new ProfessorTable();
	private CourseTable ct= new CourseTable();

	private static int openTab;
	
	private static MyTabbedPane instance = null;
	
	public static MyTabbedPane getInstance() {
		if (instance == null) {
			instance = new MyTabbedPane();
		}
		return instance;
	}
	
	private MyTabbedPane() {
		
		JScrollPane scrollPane = new JScrollPane(st);
		JScrollPane scrollPane1 = new JScrollPane(pt);
		JScrollPane scrollPane2 = new JScrollPane(ct);
		
		//TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(pt.getModel());
		//pt.setRowSorter(sorter);
		
		addTab(Language.getInstance().getResourceBundle().getString("students"), scrollPane);
		updateViewStudent();
		addTab(Language.getInstance().getResourceBundle().getString("professors"), scrollPane1);
		updateViewProfessor();
		addTab(Language.getInstance().getResourceBundle().getString("courses"), scrollPane2);
		updateViewCourse();
		
		
		ChangeListener changeListener = new ChangeListener() {
		      public void stateChanged(ChangeEvent changeEvent) {
		        JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
		        int index = sourceTabbedPane.getSelectedIndex();
		        
		        switch(index) {
		        case 0:
		        	MyStatusBar.setTabLabel(Language.getInstance().getResourceBundle().getString("students"));
		        	openTab = 0;
		        	break;
		        case 1:
		        	MyStatusBar.setTabLabel(Language.getInstance().getResourceBundle().getString("professors"));
		        	openTab = 1;
		        	break;	
		        case 2:
		        	MyStatusBar.setTabLabel(Language.getInstance().getResourceBundle().getString("courses"));
		        	openTab = 2;
		        	break;
		        }
		      }
		    };
		
		addChangeListener(changeListener);
	}
	
	public void updateViewStudent() {
		AbstractTableModelStudent model = (AbstractTableModelStudent) st.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	public void updateViewProfessor() {
		AbstractTableModelProfessor model = (AbstractTableModelProfessor) pt.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	public void updateViewCourse() {
		AbstractTableModelCourse model = (AbstractTableModelCourse) ct.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	
	public static int getOpenTab() {
		return openTab;
	}

	public StudentTable getSt() {
		return this.st;
	}

	public void setSt(StudentTable st) {
		this.st = st;
	}

	public ProfessorTable getPt() {
		return pt;
	}

	public void setPt(ProfessorTable pt) {
		this.pt = pt;
	}

	public CourseTable getCt() {
		return ct;
	}

	public void setCt(CourseTable ct) {
		this.ct = ct;
	}
	
	public void updateComponents() {
		this.setTitleAt(0, Language.getInstance().getResourceBundle().getString("students"));
		this.setTitleAt(1, Language.getInstance().getResourceBundle().getString("professors"));
		this.setTitleAt(2, Language.getInstance().getResourceBundle().getString("courses"));
	}
}
