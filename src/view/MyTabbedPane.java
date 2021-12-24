package view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.MyStatusBar;

public class MyTabbedPane extends JTabbedPane{
	
	public MyTabbedPane() {
		
		addTab("Studenti", new JPanel());
		addTab("Profesori", new JPanel());
		addTab("Predmeti", new JPanel());
		
		ChangeListener changeListener = new ChangeListener() {
		      public void stateChanged(ChangeEvent changeEvent) {
		        JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
		        int index = sourceTabbedPane.getSelectedIndex();
		        
		        switch(index) {
		        case 0:
		        	MyStatusBar.setTabLabel("Studenti");
		        	break;
		        case 1:
		        	MyStatusBar.setTabLabel("Profesori");
		        	break;	
		        case 2:
		        	MyStatusBar.setTabLabel("Predmeti");
		        	break;
		        }
		      }
		    };
		
		addChangeListener(changeListener);
	}
	
}
