
package view.window;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import view.listeners.MyActionListenerAddStudent;
import view.listeners.MyActionListenerDeleteStudent;
import view.listeners.MyActionListenerEdit;
import view.listeners.MyActionListenerFindEntities;
import controller.CourseController;
import controller.ProfessorController;
import controller.StudentController;
import localization.Language;
import view.dialogs.AddCourseDialog;
import view.dialogs.AddProfessorDialog;
import view.dialogs.AddStudentDialog;


public class MyToolbar extends JToolBar{
	
	private JButton bNew=new JButton();
	private JButton bEdit=new JButton();
	private JButton bDelete=new JButton();
	private JTextField bSearch2=new JTextField();
	private JButton bSearch=new JButton();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static MyToolbar instance = null;

	public static MyToolbar getInstance() {
		if (instance == null) {
			instance = new MyToolbar();
		}
		return instance;
	}
	
	private MyToolbar(){
		super(SwingConstants.HORIZONTAL);
		
		setFloatable(false);
		
		bNew.setToolTipText(Language.getInstance().getResourceBundle().getString("new"));
		bEdit.setToolTipText(Language.getInstance().getResourceBundle().getString("edit"));
		bDelete.setToolTipText(Language.getInstance().getResourceBundle().getString("delete"));
		bSearch2.setToolTipText(Language.getInstance().getResourceBundle().getString("search"));
		bSearch.setToolTipText(Language.getInstance().getResourceBundle().getString("search"));
		
		bNew.setIcon(new ImageIcon("images/plus.png"));
		bEdit.setIcon(new ImageIcon("images/pencilstraight.png"));
		bDelete.setIcon(new ImageIcon("images/trash.png"));
		bSearch.setIcon(new ImageIcon("images/magnifyingglass.png"));
		
		bSearch2.setPreferredSize(new Dimension(130,30));
		bSearch2.setMaximumSize(new Dimension(130,30));
		
		bNew.addActionListener(new MyActionListenerAddStudent());
		bEdit.addActionListener(new MyActionListenerEdit());
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
	
	public void updateComponents() {
		
		bNew.setToolTipText(Language.getInstance().getResourceBundle().getString("new"));
		bEdit.setToolTipText(Language.getInstance().getResourceBundle().getString("edit"));
		bDelete.setToolTipText(Language.getInstance().getResourceBundle().getString("delete"));
		bSearch2.setToolTipText(Language.getInstance().getResourceBundle().getString("search"));
		bSearch.setToolTipText(Language.getInstance().getResourceBundle().getString("search"));
	}
	
}
