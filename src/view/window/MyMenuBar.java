package view.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;


import localization.Language;
import view.dialogs.AboutDialog;
import view.dialogs.HelpDialog;
import view.listeners.MyActionListenerAddStudent;
import view.listeners.MyActionListenerClose;
import view.listeners.MyActionListenerDeleteFromMenu;
import view.listeners.MyActionListenerEditFromMeni;
import view.listeners.MyActionListenerEnglish;
import view.listeners.MyActionListenerSave;
import view.listeners.MyActionListenerSerbian;
import view.listeners.MyWindowListener;

public class MyMenuBar extends JMenuBar{
	
		public JMenu file;
		private JMenu edit;
		private JMenu help;
		private JMenu language;
		private JMenuItem miNew;
		private JMenuItem miSave;
		private JMenu open;
		private JMenuItem miStudenti;
		private JMenuItem miPredmeti;
		private JMenuItem miProfesori;
		private JMenuItem miKatedre;
		private JMenuItem miClose;
		private JMenuItem serbian;
		private JMenuItem english;
		private JMenuItem miEdit;
		private JMenuItem miDelete;
		private JMenuItem miHelp;
		private JMenuItem miAbout;

	public MyMenuBar() {
		
		file = new JMenu(Language.getInstance().getResourceBundle().getString("file"));
		edit = new JMenu(Language.getInstance().getResourceBundle().getString("edit"));
		help = new JMenu(Language.getInstance().getResourceBundle().getString("help"));
		language = new JMenu(Language.getInstance().getResourceBundle().getString("language"));
		
		miNew = new JMenuItem(Language.getInstance().getResourceBundle().getString("new"));
		miSave = new JMenuItem(Language.getInstance().getResourceBundle().getString("save"));
		open = new JMenu(Language.getInstance().getResourceBundle().getString("open"));
		miStudenti = new JMenuItem(Language.getInstance().getResourceBundle().getString("students"));
		miPredmeti = new JMenuItem(Language.getInstance().getResourceBundle().getString("courses"));
		miProfesori = new JMenuItem(Language.getInstance().getResourceBundle().getString("professors"));
		miKatedre = new JMenuItem(Language.getInstance().getResourceBundle().getString("departments"));
		miClose = new JMenuItem(Language.getInstance().getResourceBundle().getString("close"));
		serbian = new JMenuItem(Language.getInstance().getResourceBundle().getString("serbian"));
		english = new JMenuItem(Language.getInstance().getResourceBundle().getString("english"));
		
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
		
		miEdit = new JMenuItem(Language.getInstance().getResourceBundle().getString("edit"));
		miDelete = new JMenuItem(Language.getInstance().getResourceBundle().getString("delete"));
		
		edit.add(miEdit);
		edit.addSeparator();
		edit.add(miDelete);
		
		miHelp = new JMenuItem(Language.getInstance().getResourceBundle().getString("help"));
		miAbout = new JMenuItem(Language.getInstance().getResourceBundle().getString("about"));
		
		help.add(miHelp);
		help.addSeparator();
		help.add(miAbout);
		
		miNew.setIcon(new ImageIcon("images"+ File.separator +"newf.png"));
		miSave.setIcon(new ImageIcon("images"+ File.separator +"savef.png"));
		miClose.setIcon(new ImageIcon("images"+ File.separator +"closef.png"));
		miHelp.setIcon(new ImageIcon("images"+ File.separator +"helpf.png"));
		miDelete.setIcon(new ImageIcon("images"+ File.separator +"deletef.png"));
		miEdit.setIcon(new ImageIcon("images"+ File.separator +"editf.png"));
		miAbout.setIcon(new ImageIcon("images"+ File.separator +"aboutf.png"));
		open.setIcon(new ImageIcon("images"+ File.separator +"openf.png"));
		miStudenti.setIcon(new ImageIcon("images"+ File.separator +"studentf.png"));
		miPredmeti.setIcon(new ImageIcon("images"+ File.separator +"predmetf.png"));
		miProfesori.setIcon(new ImageIcon("images"+ File.separator +"profesorf.png"));
		miKatedre.setIcon(new ImageIcon("images"+ File.separator +"katedraf.png"));
		
		file.setMnemonic('F');
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
		language.setMnemonic('L');
		serbian.setMnemonic('S');
		english.setMnemonic('E');
		
		serbian.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		english.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
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
		miClose.addActionListener(new MyActionListenerClose());
		miEdit.addActionListener(new MyActionListenerEditFromMeni());
		miSave.addActionListener(new MyActionListenerSave());
		miDelete.addActionListener(new MyActionListenerDeleteFromMenu());
		miKatedre.addActionListener(new view.listeners.MyActionListenerDepartmentDialog());
		miHelp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				HelpDialog.getInstance().setVisible(true);
				
			}
		});
		
		miStudenti.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					MyTabbedPane.getInstance().setSelectedIndex(0);
				
			}	
		});
		
		miProfesori.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					MyTabbedPane.getInstance().setSelectedIndex(1);
				
			}
		});
		
		miPredmeti.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					MyTabbedPane.getInstance().setSelectedIndex(2);
				
			}
		});
		
		
		miAbout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AboutDialog.getInstance().setVisible(true);
				
			}
		});
		add(file);
		add(edit);
		add(help);
		add(language);
	}

	public void updateComponents() {
		file.setText(Language.getInstance().getResourceBundle().getString("file"));
		edit.setText(Language.getInstance().getResourceBundle().getString("edit"));
		help.setText(Language.getInstance().getResourceBundle().getString("help"));
		language.setText(Language.getInstance().getResourceBundle().getString("language"));
		miNew.setText(Language.getInstance().getResourceBundle().getString("new"));
		miSave.setText(Language.getInstance().getResourceBundle().getString("save"));
		miStudenti.setText(Language.getInstance().getResourceBundle().getString("students"));
		open.setText(Language.getInstance().getResourceBundle().getString("open"));
		miProfesori.setText(Language.getInstance().getResourceBundle().getString("professors"));
		miPredmeti.setText(Language.getInstance().getResourceBundle().getString("courses"));
		miKatedre.setText(Language.getInstance().getResourceBundle().getString("departments"));
		miClose.setText(Language.getInstance().getResourceBundle().getString("close"));
		serbian.setText(Language.getInstance().getResourceBundle().getString("serbian"));
		english.setText(Language.getInstance().getResourceBundle().getString("english"));
		miEdit.setText(Language.getInstance().getResourceBundle().getString("edit"));
		miDelete.setText(Language.getInstance().getResourceBundle().getString("delete"));
		miHelp.setText(Language.getInstance().getResourceBundle().getString("help"));
		miAbout.setText(Language.getInstance().getResourceBundle().getString("about"));
		
	}
}
