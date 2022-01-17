package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import localization.Language;
import view.window.MyMainFrame;

public class MyActionListenerSerbian implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Locale.setDefault(new Locale("sr","RS"));
		Language.getInstance().changeLanguage();
		MyMainFrame.getInstance().updateLanguage();
		
	}
	
}
