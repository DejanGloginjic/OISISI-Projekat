package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import view.window.MyMainFrame;

public class MyActionListenerClose implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		MyMainFrame.getInstance().dispatchEvent(new WindowEvent(MyMainFrame.getInstance(), WindowEvent.WINDOW_CLOSING));

	}

}
