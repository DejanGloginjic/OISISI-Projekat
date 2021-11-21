package functionalities;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MyMainFrame extends JFrame{
	public MyMainFrame() {
		super();
		
		setTitle("Studentska služba");
		
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension dimension=kit.getScreenSize();
		setSize(3*dimension.width/4, 3*dimension.height/4);
		
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		Image img=kit.getImage("images/ikonica.jpeg");
		setIconImage(img);
		
		MyMenuBar mb=new MyMenuBar();
		this.setJMenuBar(mb);
		
		setVisible(true);
		}
}
