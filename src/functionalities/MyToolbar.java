package functionalities;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

public class MyToolbar extends JToolBar{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1209699209668701828L;
	
	public MyToolbar(){
		super(SwingConstants.HORIZONTAL);
		
		setFloatable(false);
		
		JButton bNew=new JButton();
		JButton bEdit=new JButton();
		JButton bDelete=new JButton();
		JTextField bSearch2=new JTextField();
		JButton bSearch=new JButton();
		
		bNew.setToolTipText("New");
		bEdit.setToolTipText("Edit");
		bDelete.setToolTipText("Delete");
		bSearch2.setToolTipText("Search");
		bSearch.setToolTipText("Search");
		
		bNew.setIcon(new ImageIcon("images/plus.png"));
		bEdit.setIcon(new ImageIcon("images/pencilstraight.png"));
		bDelete.setIcon(new ImageIcon("images/trash.png"));
		bSearch.setIcon(new ImageIcon("images/magnifyingglass.png"));
		
		bSearch2.setPreferredSize(new Dimension(130,30));
		bSearch2.setMaximumSize(new Dimension(130,30));
		
		add(bNew);
		addSeparator();
		add(bEdit);
		addSeparator();
		add(bDelete);
		add(Box.createHorizontalGlue());
		add(bSearch2);
		add(bSearch);
		
	}
}
