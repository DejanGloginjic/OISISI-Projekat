package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.MyStatusBar;

public class MyTabbedPane extends JTabbedPane{
	
	StudentTable st = new StudentTable();
	private static int openTab;
	
	public MyTabbedPane() {
		
		JScrollPane scrollPane = new JScrollPane(st);
		
		addTab("Studenti", scrollPane);
		updateViewStudent();
		addTab("Profesori", new JPanel());
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
	
	public static int getOpenTab() {
		return openTab;
	}
	
}
