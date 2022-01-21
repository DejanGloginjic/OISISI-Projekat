package view.window;

import javax.swing.JTabbedPane;

import localization.Language;
import view.panels.MyPanelEditProfessor;
import view.panels.MyPanelEditStudent;
import view.panels.MyPanelProfessorCourses;


public class MyTabbedPaneProfessorEdit extends JTabbedPane{
	
	private MyPanelEditProfessor mpep =new MyPanelEditProfessor();

	private MyPanelProfessorCourses mppc = MyPanelProfessorCourses.getInstance();

	
	private static MyTabbedPaneProfessorEdit instance = null;
	
	public static MyTabbedPaneProfessorEdit getInstance() {
		if (instance == null) {
			instance = new MyTabbedPaneProfessorEdit();
		}
		return instance;
	}
	
	private MyTabbedPaneProfessorEdit() {
		
		addTab(Language.getInstance().getResourceBundle().getString("informations"), mpep);
		addTab(Language.getInstance().getResourceBundle().getString("courses"), mppc);

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
	
	public void updateComponents() {
		this.setTitleAt(0, Language.getInstance().getResourceBundle().getString("informations"));
		this.setTitleAt(1, Language.getInstance().getResourceBundle().getString("courses"));
		mpep.updateComponent();
		mppc.updateComponents();
	}
}
