package Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class nouvelleReservationButton extends JButton{
public nouvelleReservationButton() {
	super("Faire une nouvelle réservation");
	
	
	addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
 public void actionPerformed(ActionEvent e) {
		        	JFrame mframe = new JFrame("nouvelle reservation"); 
		        			 mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        mframe.setResizable(false);
			        mframe.setSize(800, 650);

			        // Création du panneau principal
			        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));

			        // Étiquette et champ de saisie pour la date de début
			        JLabel startDateLabel = new JLabel("Date de début:");
			       JTextField  startDateField = new JTextField();
			        panel.add(startDateLabel);
			        panel.add(startDateField);
                               String textFieldstart = startDateField.getText();
			        Datee StartDateField= Datee.toDatee(textFieldstart);
			        // Étiquette et champ de saisie pour la date de fin
			        JLabel endDateLabel = new JLabel("Date de fin:");
			       JTextField  endDateField = new JTextField();
	                       panel.add(endDateLabel);
			        panel.add(endDateField);
		                
			        mframe.add(panel);
		                  String textFieldend = endDateField.getText();
			        Datee EndDateField = Datee.toDatee(textFieldend); 
                    
                    if ( Date.avant(StartDateField,EndDateField)== false)
                    {
                    	JOptionPane.showMessageDialog(null, "Format de date invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                    	JButton mesOffresButton = new JButton("Mes offres");
                    	mframe.add(mesOffresButton);
                    	
                    	mesOffresButton.addActionListener(new ActionListener() {
                    		public void actionPerformed(ActionEvent e) {
                         JPanel panel1 = new JPanel();
                             panel1.setLayout(new GridLayout(0, 2));
                             // affichage depuis le fichier 
                           ArrayList  <Chambre> listChambres = new ArrayList <>();
                             listChambres= ChambreFileReader.readChambresFromFile(Chambres);
                             for (Chambre chambre :listChambres()) {
                                 JLabel label = new JLabel("Chambre " + chambre.getNumero() + ", Type: " + chambre.getTypeChambre() + ", Prix: " + chambre.getPrix());
                                 JButton reserverButton = new JButton("+");
                                 reserverButton.addActionListener(new ActionListener() {
                                     @Override
                                     public void actionPerformed(ActionEvent e) {
                                         // Code pour réserver la chambre
                                    	 // je suis pas sur 
                                    	 Rerservation rerservation = new Rerservation(StartDateField,EndDateField,chambre,ID);
                                         JOptionPane.showMessageDialog(frame, "Chambre " + chambre.getNumero() + " réservée !");
                                          AddLineInFile("Reservations_clients", 1,rerservation);
				     }
                                 });

                                 panel.add(label);
                                 panel.add(reserverButton);
                             }

                             JScrollPane scrollPane = new JScrollPane(panel);
                             scrollPane.setPreferredSize(new Dimension(400, 300));
                             JOptionPane.showMessageDialog(frame, scrollPane, "Chambres disponibles", JOptionPane.PLAIN_MESSAGE);
                    		}	} 	  });

                    
		        
                          JButton retourButton = new JButton("Retour");
                          retourButton.addActionListener(new ActionListener() {
                              @Override
                              public void actionPerformed(ActionEvent e) {
                                  ((JButton)e.getSource()).getRootPane().getParent().setVisible(false); // Cache la fenêtre principale
                                  inscriptionFrame.setVisible(true); // Affiche la fenêtre d'inscription
                             
   
                          } });
                    
		      

		
        } });
}
}
