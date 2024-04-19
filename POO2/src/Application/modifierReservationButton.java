package Application;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
//import javax.swing.BorderLayout;
  class modifierReservationButton extends JButton  {
	  Datee debut;
	  Datee fin ;
	public modifierReservationButton() {
		super("Modifier mes réservations");
		addActionListener(new ActionListener() {
		 @Override
	     public void actionPerformed(ActionEvent e) {
	        
	 JFrame nframe = new JFrame("Liste des réservations");
	 nframe.setSize(200, 300);
	        	  nframe.setVisible(true);
	           JPanel npanel = new JPanel();
	             npanel.setLayout(new BoxLayout(npanel, BoxLayout.Y_AXIS));

	                 JPanel reservationPanel = new JPanel();
	                 reservationPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	              String a = RentButtonFrame.line_ID;
	               char []a2 = a.toCharArray();
	              char IDchar = a2[0];
	               String ID = String.valueOf(IDchar);
	            //  String ID ="2";     
           List<String> reservationamodifier = Fichier.findalltheLinesContainingWord("Reservations_Clients",ID);
                
	          
           DefaultTableModel model = new DefaultTableModel(new String[]{"Id Client", "Date Begining", "Date End", "Room Number", "Modifier chambre", "Modifier date", " annuler la reservation",}, 0) {
               @Override
               public Class<?> getColumnClass(int columnIndex) {
                   int columIndex;
				if (columnIndex == 4 || columnIndex == 5 || columIndex == 6 ) {
                       return Boolean.class; // Column type is Boolean for checkboxes
                   }
                   return super.getColumnClass(columnIndex);
               }

               @Override
               public boolean isCellEditable(int row, int column) {
                   int columIndex;
				return column == 4 || column == 5|| columIndex == 6; // Allow editing only for checkboxes
               }
           };

           // Read data from file and add rows to table model
           try (BufferedReader br = new BufferedReader(new FileReader("Reservations_Clients"))) {
               String line;
               while ((line = br.readLine()) != null) {
                   String[] parts = line.split(",");
                   model.addRow(new Object[]{parts[0], parts[1], parts[2], parts[3], false, false,false});
               }
           } catch (Exception ee) {
               ee.printStackTrace();
           }

           JTable table = new JTable(model);
           JScrollPane scrollPane = new JScrollPane(table);
       //   nframe.add(scrollPane, BorderLayout.CENTER);
           nframe.add(scrollPane);
             for (int i = 0; i < model.getRowCount(); i++) {
              Boolean modifierChambre = (Boolean) model.getValueAt(i, 4);
              Boolean modifierDate = (Boolean) model.getValueAt(i, 5);
            String  idd = (String) model.getValueAt(i, 0);
            String datedebut  = (String) model.getValueAt(i, 1);
            String  datefin = (String) model.getValueAt(i, 2);
            String  numerochambree = (String) model.getValueAt(i, 3);
            Boolean annulerreservation= (Boolean) model.getValueAt(i, 6);
            
              if (modifierDate) {
                  // Traiter la modification de chambre pour la ligne i
                  System.out.println("Modifier chambre pour la ligne " + i);
            
             	 JFrame frame = new JFrame("modification de dates");
                 JPanel panel = new JPanel(new GridLayout(3, 2));
                 JLabel debutLabel = new JLabel("Date de début (dd/MM/yyyy) :");
                 JTextField debutField = new JTextField();
                 JLabel finLabel = new JLabel("Date de fin (dd/MM/yyyy) :");
                 JTextField finField = new JTextField();
                 JButton validerButton = new JButton("Valider");
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
                 
                 validerButton.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                         String debutText = debutField.getText();
                         String finText = finField.getText();
                                 Datee debut =  Datee.toDatee(debutText);
                                 Datee fin = Datee.toDatee(finText);	
                             
                                 boolean valide = Datee.avant(debut, fin);
                                 if(!valide) {
                                	 JOptionPane.showMessageDialog(frame," les dates invalide");    }
                                 else {	
                                 String anciennedatedebut = datedebut;
                                	 String anciennedatefin = datefin;
                                	 String numerochambre = numerochambre ;
                                	 String chambre = Fichier.findLineWithoutWord("Chambres",  numerochambre );
                                	 String[] parts = chambre.split(" ");

                                   	 String numero = parts[1];
                                   	 String type = parts[2];
                                   	 String prix = parts[4];
                                   	double prixformedouble = Double.parseDouble(prix);
                                   	Type typeformetype = Type.valueOf(type);
                                	 Chambre chambreformechambre = new Chambre(typeformetype,prixformedouble);
                                		int intID = Integer.parseInt(ID); 
                                	if( Client.DemandeReservation(intID,debut, fin,chambreformechambre) ==true) {
                                 JOptionPane.showMessageDialog(frame, "Réservation enregistrée !");
                                 Client.ModifierDateReservation(intID,debut , fin , chambreformechambre ); 
                                 
                                	} else {
                                 JOptionPane.showMessageDialog(frame, "Chambre indisponible.");}
                    }     }     });
              
              
             
              }             
              
             
              if (modifierChambre) {
                  // Traiter la modification de date pour la ligne i
                
                  JFrame framechambre = new JFrame();
             	 framechambre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                framechambre.setVisible(true);
             	  JPanel panelchambre = new JPanel();
                   List<String> chambres = Fichier.findLinesWithPrefix("Chambres", "Disponible");
                    String[] columnNames = {"type", "Disponibilite", "prix", "reserver"};
                    Object[][] data = new Object[chambres.size()][4];
                    for (int j = 0; j < chambres.size(); j++) {
                 	   
                        String chambre = chambres.get(j);  
                        String[] parts = chambre.split(" ");

                   	 String numero = parts[1];
                   	 String type = parts[2];
                   	 String prix = parts[4];
                       
                        data[i][0] = numero;
                        data[i][1] = type;
                        data[i][2] = "Disponible";
                        data[i][3] =  prix;
                        data[i][3] = false; // Par défaut, les cases à cocher sont décochées
                    }
       
                    // Créer les noms de colonnes
                    String[] columnNamess = {"Numero" ,"Type", "Disponibilité", "Prix", "Réserver"};

                    // Créer le modèle de table
                    DefaultTableModel modell = new DefaultTableModel(data, columnNamess) {
                        @Override
                        public  Class<?> getColumnClass(int columnIndex) {
                            if (columnIndex == 4) {
                                return Boolean.class; // La colonne des cases à cocher est de type Boolean
                            }
                            return super.getColumnClass(columnIndex);
                        };

                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return column == 4; // Seule la colonne des cases à cocher est éditable
                        }   };
                    
                    // Créer la JTable avec le modèle de table personnalisé
                    JTable tablee = new JTable(modell);
                 //   chambrepanel(table);
                    framechambre.add(panelchambre);
                JButton  reserverButton = new  JButton("+");
                   reserverButton.addActionListener(new ActionListener() {
                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                    	   for (int i = 0; i < modell.getRowCount(); i++) {

                                     	 Boolean isChecked = (Boolean) model.getValueAt(i, 3);
                                          if (isChecked) {
                                              // Traiter la réservation de la chambre
                                       	   String numero =  (String)model.getValueAt(i, 0);
                                              String type = (String) model.getValueAt(i, 1);
                                              String disponibilite = (String) model.getValueAt(i, 2);
                                              double prix = (double) model.getValueAt(i, 3);
                                       
                                          	int intnumero = Integer.parseInt(numero);
                                           String a = RentButtonFrame.line_ID;
                         	               char []a2 = a.toCharArray();
                         	                char IDchar = a2[0];
                         	                String ID = String.valueOf(IDchar);
                                          	int IDD = Integer.parseInt(ID);
                                        
                                     	String NumeroNouvelleChambre = Fichier.findLineWithoutWord("Chambres", numero );
                                          JOptionPane.showMessageDialog(framechambre, "Chambre réservée !");
                                          HashMap<Datee,Datee> map = new   HashMap<Datee,Datee>();
                                          map.put(debut,fin);
                                          String stringdate=  Chambre.afficherHashMap(map);
                                      Fichier.replaceWordInFile("Chambres", "Disponible",stringdate);
                                       Fichier.replaceWordInFile("Reservations_Clients",numero, NumeroNouvelleChambre);
                                          }   
                                      }}
                                });    }
        
              if( annulerreservation ) {
      			try {
                  	
      				int iddint =  Integer.parseInt(idd );
      	        Datee datedebutdate=  Datee.toDatee(datedebut);  
      	      Datee datefindate=  Datee.toDatee(datefin); 
      	       
      	          int numeroint=  Integer.parseInt(numerochambree);
      	            Reservation reservation = new Reservation (iddint,datedebutdate, datefindate,numeroint);
                  	Fichier.deleteLineContainingWord("Reservations_Clients",reservation.toString());
                       JOptionPane.showMessageDialog(nframe, "Réservation annulée : " + reservation.toString());
                  	} catch ( Exception z)
                  	{
                  		System.out.println("erreur");
                  	}
                   }  
             
             
             }     
		
        nframe.setSize(400, 300);

        
        nframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		 
		 }
	
		
	});	
		
	
   
	        
		
}}
