package Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class consulterReservationButton extends JButton{
public consulterReservationButton() {
	super("Consulter mes réservations");
	
	//code apparence bouton
	
	addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	
        } });
}
}
