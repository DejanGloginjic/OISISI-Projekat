package view.window;

import javax.swing.JTabbedPane;

import localization.Language;
import view.panels.MyPanelEditStudent;
import view.panels.MyPanelPassedExams;
import view.panels.MyPanelRemainingExams;


public class MyTabbedPaneStudentEdit extends JTabbedPane{
	
	private MyPanelEditStudent mpes = new MyPanelEditStudent();
	private MyPanelPassedExams mppe = MyPanelPassedExams.getInstance();
	private MyPanelRemainingExams mpre = MyPanelRemainingExams.getInstance();
	
	private static MyTabbedPaneStudentEdit instance = null;
	
	public static MyTabbedPaneStudentEdit getInstance() {
		if (instance == null) {
			instance = new MyTabbedPaneStudentEdit();
		}
		return instance;
	}
	
	private MyTabbedPaneStudentEdit() {
		
		addTab(Language.getInstance().getResourceBundle().getString("informations"), mpes);
		addTab(Language.getInstance().getResourceBundle().getString("passed"), mppe);
		addTab(Language.getInstance().getResourceBundle().getString("failed"), mpre);
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

	public MyPanelRemainingExams getMpre() {
		return mpre;
	}

	public void setMpre(MyPanelRemainingExams mpre) {
		this.mpre = mpre;
	}

	public void updateComponents() {
		this.setTitleAt(0, Language.getInstance().getResourceBundle().getString("informations"));
		this.setTitleAt(1, Language.getInstance().getResourceBundle().getString("passed"));
		this.setTitleAt(2, Language.getInstance().getResourceBundle().getString("failed"));
		mpes.updateComponents();
		mppe.updateComponents();
		mpre.updateComonents();
	}

	
	
}
