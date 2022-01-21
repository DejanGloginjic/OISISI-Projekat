package view.window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import localization.Language;
import model.dataBase.DatabaseReader;
import view.dialogs.AddBossOfDepartmentDialog;
import view.dialogs.AddCourseDialog;
import view.dialogs.AddCourseToProfessorDialog;
import view.dialogs.AddCourseToStudentDialog;
import view.dialogs.AddDepartmentDialog;
import view.dialogs.AddProfessorDialog;
import view.dialogs.AddProfessorToCourseDialog;
import view.dialogs.AddStudentDialog;
import view.dialogs.DepartmentDialog;
import view.dialogs.EditCourseDialog;
import view.dialogs.EditProfessorDialog;
import view.dialogs.EditStudentDialog;
import view.dialogs.GradeEntryDialog;
import view.listeners.MyWindowListener;

public class MyMainFrame extends JFrame{
	
	private static MyMainFrame instance = null;

	public static MyMainFrame getInstance() {
		if (instance == null) {
			instance = new MyMainFrame();
		}
		return instance;
	}
	private MyMenuBar mb=new MyMenuBar();
	private MyToolbar tb=MyToolbar.getInstance();
	private MyStatusBar sb = new MyStatusBar();
	private MyTabbedPane tp = MyTabbedPane.getInstance();
	
	//AddStudentDialog addStudentDialog = new AddStudentDialog();
	//EditStudentDialog editStudentDialog = EditStudentDialog.getInstance();
	//MyPanelEditStudent myPanelEditStudent = new MyPanelEditStudent();
	
	private MyMainFrame() {
		super();
		
		setTitle(Language.getInstance().getResourceBundle().getString("studentskaSluzba"));
		
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension dimension=kit.getScreenSize();
		setSize(3*dimension.width/4, 3*dimension.height/4);
		
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		Image img=kit.getImage("images" + File.separator + "ikonica.jpeg");
		setIconImage(img);
	
		this.setJMenuBar(mb);
		
		add(tb, BorderLayout.NORTH);
		add(sb, BorderLayout.SOUTH);
		add(MyTabbedPane.getInstance());
		addWindowListener(new MyWindowListener());
		setVisible(true);
	}
	
	public void updateLanguage() {
		
		ResourceBundle resourceBundle = Language.getInstance().getResourceBundle();
		mb.updateComponents();
		tb.updateComponents();
		sb.updateComponents();
		tp.updateComponents();
		AddBossOfDepartmentDialog.getInstance().updateComponents();
		MyTabbedPaneProfessorEdit.getInstance().updateComponents();
		AddCourseDialog.getInstance().updateComponent();
		AddCourseToProfessorDialog.getInstance().updateComponent();
		AddCourseToStudentDialog.getInstance().updateComponent();
		AddDepartmentDialog.getInstance().updateComponent();
		AddProfessorDialog.getInstance().updateComponent();
		AddProfessorToCourseDialog.getInstance().updateComponent();
		AddStudentDialog.getInstance().updateComponents();
		DepartmentDialog.getInstance().updateComponent();
		EditCourseDialog.getInstance().updateComponent();
		EditProfessorDialog.getInstance().updateComponent();
		EditStudentDialog.getInstance().updateComponents();
		GradeEntryDialog.getInstance().updateComponents();
		//StudentBase.getInstance().updateComponent();

	}
	
}
