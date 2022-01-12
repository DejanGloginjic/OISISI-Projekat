package view.window;

import javax.swing.JTabbedPane;

import view.panels.MyPanelEditStudent;
import view.panels.MyPanelPassedExams;

public class MyTabbedPaneStudentEdit extends JTabbedPane{
	
	private MyPanelEditStudent mpes = new MyPanelEditStudent();
	MyPanelPassedExams mppe = MyPanelPassedExams.getInstance();
	
	private static MyTabbedPaneStudentEdit instance = null;
	
	public static MyTabbedPaneStudentEdit getInstance() {
		if (instance == null) {
			instance = new MyTabbedPaneStudentEdit();
		}
		return instance;
	}
	
	private MyTabbedPaneStudentEdit() {
		
		addTab("Informacije", mpes);
		addTab("Položeni", mppe);
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
