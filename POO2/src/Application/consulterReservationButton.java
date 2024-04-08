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

	        	   // Créer une nouvelle fenêtre pour afficher les réservations
                JFrame frame = new JFrame("Mes réservations");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(400, 300);

                // Panel principal
                JPanel mainPanel = new JPanel();
                mainPanel.setLayout(new BorderLayout());

                // Panel pour la liste des réservations
                JPanel reservationsPanel = new JPanel();
                reservationsPanel.setLayout(new BoxLayout(reservationsPanel, BoxLayout.Y_AXIS));
                List<Reservation> reservations = filereaderredervation.readReservationsFromFile();
                // Liste des réservations (exemple)
               // List<Reservation> reservations = getReservations();

                // Ajouter chaque réservation à la liste
                for (Reservation reservation : reservations) {
                	// add something  to this  getIdClient
                	  if (reservation.getId() == Client.getIdClient) {
      	              JLabel reservationLabel = new JLabel(reservation.toString());
                      reservationsPanel.add(reservationLabel);
      	            }
      	     
      	      
                    
                }

                // Ajouter la liste des réservations au panel principal
                mainPanel.add(new JScrollPane(reservationsPanel), BorderLayout.CENTER);

                // Panel pour la facture
                JPanel facturePanel = new JPanel();
                facturePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
                 String s =Fichier.findLineContainingWord("Factures" ,Client.getIdClient);
                JLabel factureLabel = new JLabel(s); 
                facturePanel.add(factureLabel);

                // Ajouter la facture en bas
                mainPanel.add(facturePanel, BorderLayout.SOUTH);

                // Bouton de retour
                JButton retourButton = new JButton("Retour");
                retourButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose(); // Fermer la fenêtre actuelle
                    }
                });
                mainPanel.add(retourButton, BorderLayout.SOUTH);

                // Ajouter le panel principal à la fenêtre
                frame.add(mainPanel);
                frame.setVisible(true);
            }
      


		
        } });
}
}
