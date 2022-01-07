package view.window;

import javax.swing.JTabbedPane;

import view.MyPanelEditStudent;

public class MyTabbedPaneStudentEdit extends JTabbedPane{
	
	private MyPanelEditStudent mpes = new MyPanelEditStudent();
	
	private static MyTabbedPaneStudentEdit instance = null;
	
	public static MyTabbedPaneStudentEdit getInstance() {
		if (instance == null) {
			instance = new MyTabbedPaneStudentEdit();
		}
		return instance;
	}
	
	private MyTabbedPaneStudentEdit() {
		
		addTab("Informacije", mpes);
	}

	public MyPanelEditStudent getMpes() {
		return mpes;
	}

	public void setMpes(MyPanelEditStudent mpes) {
		this.mpes = mpes;
	}

	public static void setInstance(MyTabbedPaneStudentEdit instance) {
		MyTabbedPaneStudentEdit.instance = instance;
	}
	
	
}
