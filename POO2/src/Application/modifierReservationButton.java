package Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class modifierReservationButton extends JButton{
	public modifierReservationButton() {
		super("Modifier mes réservations");
		
		addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
JFrame nframe = new JFrame("Liste des réservations");
	             JPanel npanel = new JPanel();
	             npanel.setLayout(new BoxLayout(npanel, BoxLayout.Y_AXIS));

	
			 List<Reservation>  reservations = filereaderredervation.readReservationsFromFile();
	            for (Reservation reservation : reservations) { 
	                 JPanel reservationPanel = new JPanel();
	                 reservationPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

	                 JLabel reservationLabel = new JLabel(reservation.toString();                              
	                 JButton modifierButton = new JButton("Modifier mes dates");
	                 JButton annulerButton = new JButton("Annuler la réservation");

	                 modifierButton.addActionListener(new ActionListener() {
	                     @Override
	                     public void actionPerformed(ActionEvent e) {
	                      
	                  
	                    	 JFrame frame = new JFrame("modification de dates");
	                         JPanel panel = new JPanel(new GridLayout(3, 2));
	                         JLabel debutLabel = new JLabel("Date de début (dd/MM/yyyy) :");
	                         JTextField debutField = new JTextField();
	                         JLabel finLabel = new JLabel("Date de fin (dd/MM/yyyy) :");
	                         JTextField finField = new JTextField();
	                         JButton validerButton = new JButton("Valider");

	                         validerButton.addActionListener(new ActionListener() {
	                             @Override
	                             public void actionPerformed(ActionEvent e) {
	                                 String debutText = debutField.getText();
	                                 String finText = finField.getText();
                                                Datee debut =  Datee.toDatee(debutText);
	                                         Datee fin = Datee.toDatee(finText);
	                              
	                                     if ( reservation.c.getdisponibiltéchambre(debut,fin)) {
	                                         JOptionPane.showMessageDialog(frame, "Réservation enregistrée !");
	                                     } else {
	                                         JOptionPane.showMessageDialog(frame, "Chambre indisponible.");
	                                     }
	                            
	                             }
	                         });

	                         panel.add(debutLabel);
	                         panel.add(debutField);
	                         panel.add(finLabel);
	                         panel.add(finField);
	                         panel.add(new JLabel()); // Espace vide pour l'esthétique
	                         panel.add(validerButton);

	                         frame.add(panel);
	                         frame.setSize(400, 200);
	                         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                         frame.setVisible(true);
	                     }
	 
	                     
	                     
	                     });

	                 annulerButton.addActionListener(new ActionListener() {
	                     @Override
	                     public void actionPerformed(ActionEvent e) {
	                         // Code pour annuler la réservation
	                    	 Fichier.deleteLineContainingWord(Reservations_Clients,reservation);
	                         JOptionPane.showMessageDialog(nframe, "Réservation annulée : " + reservation);
	                     }
	                 });

	                 reservationPanel.add(reservationLabel);
	                 reservationPanel.add(modifierButton);
	                 reservationPanel.add(annulerButton);

	                 npanel.add(reservationPanel);
	             }

	             JScrollPane scrollPane = new JScrollPane(npanel);
	             nframe.add(scrollPane);
	             nframe.setSize(400, 300);
	             nframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	             nframe.setVisible(true);
	       


			
	        } });
	}
}
