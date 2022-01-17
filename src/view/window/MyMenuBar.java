package view.window;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import localization.Language;
import view.listeners.MyActionListenerAddStudent;
import view.listeners.MyActionListenerEnglish;
import view.listeners.MyActionListenerSerbian;

public class MyMenuBar extends JMenuBar{
	
		public JMenu file;

	public MyMenuBar() {
		
		file = new JMenu(Language.getInstance().getResourceBundle().getString("file"));
		JMenu edit = new JMenu(Language.getInstance().getResourceBundle().getString("edit"));
		JMenu help = new JMenu(Language.getInstance().getResourceBundle().getString("help"));
		JMenu language = new JMenu(Language.getInstance().getResourceBundle().getString("language"));
		
		JMenuItem miNew = new JMenuItem(Language.getInstance().getResourceBundle().getString("new"));
		JMenuItem miSave = new JMenuItem(Language.getInstance().getResourceBundle().getString("save"));
		JMenu open = new JMenu(Language.getInstance().getResourceBundle().getString("open"));
		JMenuItem miStudenti = new JMenuItem(Language.getInstance().getResourceBundle().getString("students"));
		JMenuItem miPredmeti = new JMenuItem(Language.getInstance().getResourceBundle().getString("courses"));
		JMenuItem miProfesori = new JMenuItem(Language.getInstance().getResourceBundle().getString("professors"));
		JMenuItem miKatedre = new JMenuItem(Language.getInstance().getResourceBundle().getString("departments"));
		JMenuItem miClose = new JMenuItem(Language.getInstance().getResourceBundle().getString("close"));
		JMenuItem serbian = new JMenuItem(Language.getInstance().getResourceBundle().getString("serbian"));
		JMenuItem english = new JMenuItem(Language.getInstance().getResourceBundle().getString("english"));
		
		serbian.addActionListener(new MyActionListenerSerbian());
		english.addActionListener(new MyActionListenerEnglish());
		
		file.add(miNew);
		file.add(open);
		open.add(miStudenti);
		open.add(miPredmeti);
		open.add(miProfesori);
		open.add(miKatedre);
		file.addSeparator();
		file.add(miSave);
		file.addSeparator();
		file.add(miClose);
	    language.add(serbian);
	    language.add(english);
		
		JMenuItem miEdit = new JMenuItem(Language.getInstance().getResourceBundle().getString("edit"));
		JMenuItem miDelete = new JMenuItem(Language.getInstance().getResourceBundle().getString("delete"));
		
		edit.add(miEdit);
		edit.addSeparator();
		edit.add(miDelete);
		
		JMenuItem miHelp = new JMenuItem(Language.getInstance().getResourceBundle().getString("help"));
		JMenuItem miAbout = new JMenuItem(Language.getInstance().getResourceBundle().getString("about"));
		
		help.add(miHelp);
		help.addSeparator();
		help.add(miAbout);
		
		miNew.setIcon(new ImageIcon("images/newf.png"));
		miSave.setIcon(new ImageIcon("images/savef.png"));
		miClose.setIcon(new ImageIcon("images/closef.png"));
		miHelp.setIcon(new ImageIcon("images/helpf.png"));
		miDelete.setIcon(new ImageIcon("images/deletef.png"));
		miEdit.setIcon(new ImageIcon("images/editf.png"));
		miAbout.setIcon(new ImageIcon("images/aboutf.png"));
		open.setIcon(new ImageIcon("images/openf.png"));
		miStudenti.setIcon(new ImageIcon("images/studentf.png"));
		miPredmeti.setIcon(new ImageIcon("images/predmetf.png"));
		miProfesori.setIcon(new ImageIcon("images/profesorf.png"));
		miKatedre.setIcon(new ImageIcon("images/katedraf.png"));
		
		file.setMnemonic('E');
		edit.setMnemonic('E');
		help.setMnemonic('H');
		miNew.setMnemonic('N');
		miSave.setMnemonic('S');
		miClose.setMnemonic('C');
		open.setMnemonic('O');
		miHelp.setMnemonic('H');
		miDelete.setMnemonic('D');
		miEdit.setMnemonic('i');
		miAbout.setMnemonic('A');
		miStudenti.setMnemonic('u');
		miProfesori.setMnemonic('P');
		miPredmeti.setMnemonic('r');
		miKatedre.setMnemonic('K');
		
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		miSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		miStudenti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
		miPredmeti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		miProfesori.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		miKatedre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
		
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		
		miNew.addActionListener(new MyActionListenerAddStudent());
		
		add(file);
		add(edit);
		add(help);
		add(language);
	}

	public void updateComponents() {
		file.setText(Language.getInstance().getResourceBundle().getString("file"));
	}
}
