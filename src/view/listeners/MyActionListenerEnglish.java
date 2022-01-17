package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class MyActionListenerEnglish implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		Locale.setDefault(new Locale("en","US"));
		
	}

}
