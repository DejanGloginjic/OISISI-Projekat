package view.window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import model.dataBase.StudentBase;

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
	
	private MyMainFrame() {
		super();
		
		setTitle("Studentska služba");
		
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
		
		setVisible(true);
	}
	
	
}
