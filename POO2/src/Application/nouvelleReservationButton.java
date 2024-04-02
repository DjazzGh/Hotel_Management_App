package Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class nouvelleReservationButton extends JButton{
public nouvelleReservationButton() {
	super("Faire une nouvelle réservation");
	
	
	addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	
        } });
}
}
