package view.window;

import javax.swing.JTabbedPane;

import view.MyPanelEditProfessor;
import view.MyPanelEditStudent;

public class MyTabbedPaneProfessorEdit extends JTabbedPane{
	
	private MyPanelEditProfessor mpep =new MyPanelEditProfessor();
	
	private static MyTabbedPaneProfessorEdit instance = null;
	
	public static MyTabbedPaneProfessorEdit getInstance() {
		if (instance == null) {
			instance = new MyTabbedPaneProfessorEdit();
		}
		return instance;
	}
	
	private MyTabbedPaneProfessorEdit() {
		
		addTab("Informacije", mpep);
		//addTab("Predmeti",);
	}
	public MyPanelEditProfessor getMpep() {
		return mpep;
	}

	public void setMpep(MyPanelEditProfessor mpep) {
		this.mpep = mpep;
	}

	public static void setInstance(MyTabbedPaneProfessorEdit instance) {
		MyTabbedPaneProfessorEdit.instance = instance;
	}
}
