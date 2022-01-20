package view.window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import localization.Language;
import model.dataBase.StudentBase;
import view.dialogs.AddStudentDialog;
import view.dialogs.EditStudentDialog;
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
		
		Image img=kit.getImage("images/ikonica.jpeg");
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
		AddStudentDialog.getInstance().updateComponents();
	}
	
}
