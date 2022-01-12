
package view.window;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.CourseController;
import controller.ProfessorController;
import controller.StudentController;
import view.dialogs.AddCourseDialog;
import view.dialogs.AddProfessorDialog;
import view.dialogs.AddStudentDialog;
import view.listeners.MyActionListenerAddStudent;
import view.listeners.MyActionListenerDeleteStudent;
import view.listeners.MyActionListenerEditStudent;
import view.listeners.MyActionListenerFindEntities;

public class MyToolbar extends JToolBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static MyToolbar instance = null;
	private JButton bNew;
	private JButton bEdit;
	private JButton bDelete;
	private JTextField bSearch2;
	private JButton bSearch;
	
	public static MyToolbar getInstance() {
		if (instance == null) {
			instance = new MyToolbar();
		}
		return instance;
	}
	
	private MyToolbar(){
		super(SwingConstants.HORIZONTAL);
		
		setFloatable(false);
		
		bNew=new JButton();
		bEdit=new JButton();
		bDelete=new JButton();
		bSearch2=new JTextField();
		bSearch=new JButton();
		
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
		
		bNew.addActionListener(new MyActionListenerAddStudent());
		bEdit.addActionListener(new MyActionListenerEditStudent());
		bDelete.addActionListener(new MyActionListenerDeleteStudent());
		bSearch.addActionListener(new MyActionListenerFindEntities());
		
		add(bNew);
		addSeparator();
		add(bEdit);
		addSeparator();
		add(bDelete);
		add(Box.createHorizontalGlue());
		add(bSearch2);
		add(bSearch);
		
	}

	public JButton getbNew() {
		return bNew;
	}

	public void setbNew(JButton bNew) {
		this.bNew = bNew;
	}

	public JButton getbEdit() {
		return bEdit;
	}

	public void setbEdit(JButton bEdit) {
		this.bEdit = bEdit;
	}

	public JButton getbDelete() {
		return bDelete;
	}

	public void setbDelete(JButton bDelete) {
		this.bDelete = bDelete;
	}

	public JTextField getbSearch2() {
		return bSearch2;
	}

	public void setbSearch2(JTextField bSearch2) {
		this.bSearch2 = bSearch2;
	}

	public JButton getbSearch() {
		return bSearch;
	}

	public void setbSearch(JButton bSearch) {
		this.bSearch = bSearch;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setInstance(MyToolbar instance) {
		MyToolbar.instance = instance;
	}
	
}
