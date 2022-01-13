package view.listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import view.dialogs.AddStudentDialog;

public class MyKeyListenerYOEValidation implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char ch = e.getKeyChar();
        if(Character.isDigit(ch)){
        }
        else{
            JOptionPane.showMessageDialog(null, "Samo brojevi su dozvoljeni!");
            AddStudentDialog.getInstance().getYoeText().setText(" ");
        }
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
