package view.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyStatusBar extends JPanel{

private static JLabel tabLabel = new JLabel("Studenti");
	
	public MyStatusBar() {
      
    	JLabel clock = new JLabel();
    	JLabel name = new JLabel("Studentska sluzba  -  ");
    	
    	BoxLayout bl = new BoxLayout(this, BoxLayout.X_AXIS);
    	setLayout(bl);
    	
    	clock.setText(DateFormat.getDateTimeInstance().format(new Date()));
    	
    	add(Box.createHorizontalStrut(5));
    	add(name);
    	add(tabLabel);
    	add(Box.createHorizontalGlue());
    	add(clock);
    	add(Box.createHorizontalStrut(7));
    	
    	
    	Timer timer = new Timer(500, new ActionListener() {
    	@Override
        public void actionPerformed(ActionEvent e) {
        	clock.setText(DateFormat.getDateTimeInstance().format(new Date()));
        }
        });
    	timer.setRepeats(true);
    	timer.setCoalesce(true);
    	timer.setInitialDelay(0);
    	timer.start();
    }
	
	public static void setTabLabel(String tabName) {
		tabLabel.setText(tabName);
	}
	
}
