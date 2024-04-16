package Application;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class consulterReservationButton extends JButton{
	static String toutelesreservations;
public consulterReservationButton() {
	super("Consulter mes réservations");
	
	//code apparence bouton
	
	addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("Mes réservations");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(400, 300);
                frame.setLayout(new BorderLayout());
                
                
                JPanel p1= new JPanel();
                
                JPanel p2= new JPanel();
                
                //Acceder aux reservations du client
                String a = RentButtonFrame.line_ID;
                char []a2=a.toCharArray();
               char IDchar=a2[0];
                String ID = String.valueOf(IDchar);
                try {
                 String reservation =Fichier.findLineContainingWord("Reservations_Clients", ID);
                JLabel reservationss = new JLabel(reservation);
                p1.add(reservationss);
                
                toutelesreservations=reservation;
                
                
                //Acceder a la facture du client
                String facture =Fichier.findLineContainingWord("Factures_Clients", ID);
                char []b=facture.toCharArray();
           
                char[] prix = new char[b.length]; 

                int i = 0, j = 0; 
                while (b[i] != ' ') {
                    i++;
                }
                i++;

                while (i < b.length && j < prix.length) {
                    prix[j] = b[i];
                    i++;
                    j++;
                }
                prix = Arrays.copyOfRange(prix, 0, j);
                String prixtotal = String.valueOf(prix);
                JLabel Facturee = new JLabel(prixtotal);
                p2.add(Facturee);
                }
                catch(IOException ex) {
                	System.out.println("Erreur");
                }
                JButton Retour = new JButton("Retour");
                Retour.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	frame.dispose();
                    }});


                frame.add(p1,BorderLayout.NORTH);
                frame.add(p2,BorderLayout.SOUTH);
                frame.setVisible(true);
            }
      


		
         });
}
}
