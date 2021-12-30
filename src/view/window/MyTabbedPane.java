package view.window;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.abstractTableModels.AbstractTableModelProfessor;
import view.abstractTableModels.AbstractTableModelStudent;
import view.tables.ProfessorTable;
import view.tables.StudentTable;

public class MyTabbedPane extends JTabbedPane{
	
	StudentTable st = new StudentTable();
	ProfessorTable pt=new ProfessorTable();
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
		
		addTab("Studenti", scrollPane);
		updateViewStudent();
		addTab("Profesori", scrollPane1);
		updateViewProfessor();
		addTab("Predmeti", new JPanel());
		
		ChangeListener changeListener = new ChangeListener() {
		      public void stateChanged(ChangeEvent changeEvent) {
		        JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
		        int index = sourceTabbedPane.getSelectedIndex();
		        
		        switch(index) {
		        case 0:
		        	MyStatusBar.setTabLabel("Studenti");
		        	openTab = 0;
		        	break;
		        case 1:
		        	MyStatusBar.setTabLabel("Profesori");
		        	openTab = 1;
		        	break;	
		        case 2:
		        	MyStatusBar.setTabLabel("Predmeti");
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
	
	
	public static int getOpenTab() {
		return openTab;
	}
	
}
