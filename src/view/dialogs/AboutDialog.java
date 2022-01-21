package view.dialogs;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import localization.Language;
import view.window.MyMainFrame;

public class AboutDialog extends JDialog{

	private static AboutDialog instance = null;

	public static AboutDialog getInstance() {
		if (instance == null) {
			instance = new AboutDialog();
		}
		return instance;
	}
	
	private JPanel centerPanel;
	private JTextArea text;
	
	private AboutDialog() {
		
		setTitle(Language.getInstance().getResourceBundle().getString("about"));
		setSize(1920, 1080);
		setLocationRelativeTo(MyMainFrame.getInstance());
		setModal(false);
		
		centerPanel = new JPanel();
		text = new JTextArea("Opis:\r\n"
				+ "Tamara Antić je rođena 23.05.2000. godine u Banjaluci. Završila je osnovnu školu  „Branko Radicevic“ u Banjaluci 2015. godine  i Gimnaziju, smjer opšti, u Banjaluci 2019. godine.\r\n"
				+ "Nakon završetka srednje škole upisala je Fakultet tehničkih nauka u Novom Sadu, odsjek Računarstvo i automatika, usmjerenje Primijenjene računarske nauke i informatika.\r\n"
				+ "\r\n"
				+ "Dejan Gloginjic je rođen 10.10.2000. godine u Mrkonjic Gradu. Završio je osnovnu školu  „Branko Ćopić“ u Mrkonjic Gradu 2015. godine  i Gimnaziju, smjer opšti, u Mrkonjic Gradu 2019. godine.\r\n"
				+ "Nakon završetka srednje škole upisalo je Fakultet tehničkih nauka u Novom Sadu, odsjek Računarstvo i automatika, usmjerenje Primijenjene računarske nauke i informatika.\r\n"
				+ "\r\n"
				+ "Opis aplikacije:\r\n"
				+ "Informacioni sistem studentske službe Fakulteta tehničkih nauka. Pomenuti sistem implementiran je u vidu aplikacije namenjene za upotrebu od strane referenta studentske službe.\r\n"
				+ "Aplikacija je implementirana upotrebom Java programskog jezika, Swing biblioteke. Razvoj aplikacije je razvijen u skladu sa MVC šablonom (engl. Model View Controller).\r\n"
				+ "\r\n"
				+ "Prevod:\r\n"
				+ "Tamara Antić was born on May 23, 2000. years in Banja Luka. She finished elementary school \"Branko Radicevic\" in Banja Luka in 2015 and high school, general, in Banja Luka in 2019.\r\n"
				+ "After graduating from high school, she enrolled at the Faculty of Technical Sciences in Novi Sad, Department of Computer Science and Automation, majoring in Applied Computer Science and Informatics.\r\n"
				+ "\r\n"
				+ "Dejan Gloginjic was born on October 10, 2000. in Mrkonjic Grad. He finished elementary school \"Branko Ćopić\" in Mrkonjic Grad in 2015 and high school, general direction, in Mrkonjic Grad in 2019.\r\n"
				+ "After graduating from high school, she enrolled at the Faculty of Technical Sciences in Novi Sad, Department of Computer Science and Automation, majoring in Applied Computer Science and Informatics.\r\n"
				+ "\r\n"
				+ "Information system of the student service of the Faculty of Technical Sciences. The mentioned system was implemented in the form of an application intended for use by the student service officer.\r\n"
				+ "The application is implemented using the Java programming language, the Swing library. The development of the application was developed in accordance with the MVC template (Model View Controller).");
		text.setEditable(false);
		JScrollPane jsp = new JScrollPane(text);
		centerPanel.add(jsp);
		add(centerPanel);
		
	}
}
