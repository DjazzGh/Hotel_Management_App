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

	         
	          
	                 JPanel reservationPanel = new JPanel();
	                 reservationPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	                 String a = RentButton.line_ID;
	                 char []a2 = a.toCharArray();
	                 char IDchar = a2[0];
	                 String ID = String.valueOf(IDchar);
	                     
              
                ArrayList<String> reservationamodifier = Fichier.findalltheLinesContainingWord("Reservations_Clients",ID);
                for( String reservation : reservationamodifier ) {
	                 JLabel reservationLabel = new JLabel( reservation);                              
	                 JButton modifierdatesButton = new JButton("Modifier mes dates");
	                 JButton modifierchambresButton = new JButton("Modifier mes chambres");
	                 JButton annulerButton = new JButton("Annuler la réservation");

	                 modifierdatesButton.addActionListener(new ActionListener() {
	                     @Override
	                     public void actionPerformed(ActionEvent e) {
	                      
	                  
	                    	 JFrame frame = new JFrame("modification de dates");
	                         JPanel panel = new JPanel(new GridLayout(3, 2));
	                         JLabel debutLabel = new JLabel("Date de début (dd/MM/yyyy) :");
	                         JTextField debutField = new JTextField();
	                         JLabel finLabel = new JLabel("Date de fin (dd/MM/yyyy) :");
	                         JTextField finField = new JTextField();
	                         JButton validerButton = new JButton("Valider");
	                         JButton ValiderButton = new JButton("valider");
	                       
	                         
	                         validerButton.addActionListener(new ActionListener() {
	                             @Override
	                             public void actionPerformed(ActionEvent e) {
	                                 String debutText = debutField.getText();
	                                 String finText = finField.getText();
                                             Datee debut =  Datee.toDatee(debutText);
	                                         Datee fin = Datee.toDatee(finText);	
                                         
	                                         boolean valide = Datee.avant(debut, fin);
	                                         if(!valide) {
	                                        	 JOptionPane.showMessageDialog(frame," les dates invalide");
	                                         }
	                                         
	                                         else {	
	                                        	 String[] parts = reservation.split(" ");

	                                        	
	                                        	 String datedebut = parts[1];
	                                        	 String datefin = parts[2];
	                                        	 String chambre = parts[3];
	             
	                                        	
	                             
	                                        	if( Client.DemandeReservation(ID,datedebut, datefin,chambre) ==true) {
	                                         JOptionPane.showMessageDialog(frame, "Réservation enregistrée !");
	                                         Client.ModifierDateReservation(ID, datedebut, datefin, chambre ); 
	                                         
	                                        	} else {
	                                         JOptionPane.showMessageDialog(frame, "Chambre indisponible.");}
	                               
	                            }
	                           }   
	                         });
	                         modifierchambresButton.addActionListener(new ActionListener() {
	    	                     @Override
	    	                     public void actionPerformed(ActionEvent e) {
	    	                    	 JFrame framechambre = new JFrame();
	    	                    	 framechambre.setVisible(true);
	    	                    	   ArrayList<String> chambresdisponibles = Fichier.findalltheLinesContainingWord("Chambres","Disponible");
	    	                        
	    	                           
	    	                           for (String nouvellechambre  :chambresdisponibles){
	    	                                         JLabel label = new JLabel(nouvellechambre);
	    	                                         JButton reserverButton = new JButton("+");
	    	                                         JPanel panelchambre = new JPanel();
	    	                                         panelchambre.add(label);
	    	                                         panelchambre.add(reserverButton);
	    	                                         framechambre.add( panelchambre);
	    	                                     
	    	                                         reserverButton.addActionListener(new ActionListener() {
	    	                                             @Override
	    	                                             public void actionPerformed(ActionEvent e) {
	    	                                               
	    	                                            	 String[] parts = reservation.split(" ");
    
	    		                                        	 String chambre = parts[3];
	    	                                                 JOptionPane.showMessageDialog(framechambre, "Chambre réservée !");
	    	                                                Fichier.replaceWordInFile("Chambres", chambre,nouvellechambre);
	    	                                             }
	    	                                         });

	    	                           } } 
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
	                    	 
	                    
	                    	 
	                    	try {
	                    	//	Client.AnnulerReservation(reservation);
	                    	Fichier.deleteLineContainingWord("Reservations_Clients",reservation);
	                         JOptionPane.showMessageDialog(nframe, "Réservation annulée : " + reservation);
	                    	} catch ( Exception a)
	                    	{
	                    		System.out.println("erreur");
	                    	}
	                     }
	                     
	                 });

	                 reservationPanel.add(reservationLabel);
	                 reservationPanel.add(modifierdatesButton);
	                 reservationPanel.add(modifierchambresButton);
	                 reservationPanel.add(annulerButton);

	                 npanel.add(reservationPanel);
	          
                }
	             JScrollPane scrollPane = new JScrollPane(npanel);
	             nframe.add(scrollPane);
	             nframe.setSize(400, 300);
	             nframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	             nframe.setVisible(true);

		}	
       } });
	}
}
