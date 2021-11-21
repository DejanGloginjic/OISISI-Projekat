package functionalities;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MyMenuBar extends JMenuBar{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3002850029195278353L;

	public MyMenuBar() {
		
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");
		
		JMenuItem miNew = new JMenuItem("New");
		JMenuItem miSave = new JMenuItem("Save");
		JMenu open = new JMenu("Open");
		JMenuItem miStudenti = new JMenuItem("Studenti");
		JMenuItem miPredmeti = new JMenuItem("Predmeti");
		JMenuItem miProfesori = new JMenuItem("Profesori");
		JMenuItem miKatedre = new JMenuItem("Katedre");
		JMenuItem miClose = new JMenuItem("Close");
		
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
		
		JMenuItem miEdit = new JMenuItem("Edit");
		JMenuItem miDelete = new JMenuItem("Delete");
		
		edit.add(miEdit);
		edit.addSeparator();
		edit.add(miDelete);
		
		JMenuItem miHelp = new JMenuItem("Help");
		JMenuItem miAbout = new JMenuItem("About");
		
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
		
		file.setMnemonic('F');
		edit.setMnemonic('E');
		help.setMnemonic('H');
		
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		miSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		
		add(file);
		add(edit);
		add(help);
	}
}
