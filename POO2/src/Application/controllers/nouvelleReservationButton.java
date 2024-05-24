package Application.controllers;
import Application.model.Datee;
import Application.model.Fichier;
import Application.model.Chambre;
import Application.model.Administrateur;
import Application.model.Reservation;
import Application.model.Demande;
import Application.model.Type;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
//import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


//import javax.swing.JButton;

public class nouvelleReservationButton extends JButton  {
    private javax.swing.JPanel BottomPanel;
    private javax.swing.JComboBox<String> ComboBoxanneedebut;
    private javax.swing.JComboBox<String> ComboBoxanneefin;
    private javax.swing.JComboBox<String> ComboBoxjourfin;
    private javax.swing.JComboBox<String> ComboBoxjourdebut;
    private javax.swing.JComboBox<String> ComboBoxmoisdebut;
    private javax.swing.JComboBox<String> ComboBoxmoisfin;
    private javax.swing.JLabel EndDateLabel;
    private javax.swing.JButton Retour;
    private javax.swing.JLabel StartDateLabel;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JLabel TopLabel;
    private javax.swing.JPanel TopPanel;
    private javax.swing.JPanel chambrepanel;
    private javax.swing.JButton confirmer;

    private javax.swing.JButton mesOffres;
    private javax.swing.JScrollPane scrollPane;
public nouvelleReservationButton() {
	super("Faire une nouvelle réservation");
	
	addActionListener(new ActionListener() {
	
  public void actionPerformed(ActionEvent e) {
	  
	  JFrame mframe = new JFrame("nouvelle reservation"); 
		
	  mframe.setSize(new Dimension(1000, 500));
	  mframe.setResizable(false);

	   TopPanel = new javax.swing.JPanel();
       TopPanel.setBackground(new java.awt.Color(0, 102, 51));


       TitleLabel = new javax.swing.JLabel();
       TitleLabel.setFont(new java.awt.Font("Kannada MN", 1, 18)); 
       TitleLabel.setForeground(new java.awt.Color(255, 255, 255));
       TitleLabel.setText("The available rooms ");
       
       javax.swing.GroupLayout TopPanelLayout = new javax.swing.GroupLayout(TopPanel);
       TopPanel.setLayout(TopPanelLayout);
       TopPanelLayout.setHorizontalGroup(
           TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopPanelLayout.createSequentialGroup()
               .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(TitleLabel)
               .addGap(174, 174, 174))
       );
       TopPanelLayout.setVerticalGroup(
               TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopPanelLayout.createSequentialGroup()
                   .addContainerGap(15, Short.MAX_VALUE)
                   .addComponent(TitleLabel)
                   .addGap(14, 14, 14))
           );
       
       BottomPanel = new javax.swing.JPanel();
       BottomPanel.setBackground(new java.awt.Color(0, 102, 51));

       
       Retour = new javax.swing.JButton();
       Retour.setFont(new java.awt.Font("Kannada MN", 1, 15)); // NOI18N
       Retour.setForeground(new java.awt.Color(0, 102, 51));
       Retour.setText("Back");
       Retour.addActionListener(new ActionListener() {
    		
    	   public void actionPerformed(ActionEvent e) {
    		   mframe.dispose();
    	   }});
       
       javax.swing.GroupLayout BottomPanelLayout = new javax.swing.GroupLayout(BottomPanel);
       BottomPanel.setLayout(BottomPanelLayout);
       BottomPanelLayout.setHorizontalGroup(
           BottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BottomPanelLayout.createSequentialGroup()
               .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(Retour, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(15, 15, 15))
       );
       BottomPanelLayout.setVerticalGroup(
           BottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(BottomPanelLayout.createSequentialGroup()
               .addContainerGap()
               .addComponent(Retour)
               .addContainerGap(12, Short.MAX_VALUE))
       );  
       
       StartDateLabel = new javax.swing.JLabel();
       StartDateLabel.setFont(new java.awt.Font("Kannada MN", 1, 18)); // NOI18N
       StartDateLabel.setText("Start Date :");
       
       mesOffres = new javax.swing.JButton();
       mesOffres.setBackground(new java.awt.Color(0, 102, 51));
       mesOffres.setFont(new java.awt.Font("Kannada MN", 1, 15)); 
       mesOffres.setForeground(new java.awt.Color(255, 255, 255));
       mesOffres.setText("Enter");
       
       
       ComboBoxjourdebut = new javax.swing.JComboBox<>();
       ComboBoxjourdebut.setFont(new java.awt.Font("Kailasa", 1, 13)); // NOI18N
       ComboBoxjourdebut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
       
       
       ComboBoxmoisdebut = new javax.swing.JComboBox<>();
       ComboBoxmoisdebut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
       
       ComboBoxanneedebut = new javax.swing.JComboBox<>();
       ComboBoxanneedebut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040" }));
       
       ComboBoxjourfin = new javax.swing.JComboBox<>();
       ComboBoxjourfin.setFont(new java.awt.Font("Kailasa", 1, 13)); // NOI18N
       ComboBoxjourfin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
       
       ComboBoxmoisfin = new javax.swing.JComboBox<>();
       ComboBoxmoisfin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
       
       ComboBoxanneefin = new javax.swing.JComboBox<>();
       ComboBoxanneefin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040" }));
       
       EndDateLabel = new javax.swing.JLabel();
       EndDateLabel.setFont(new java.awt.Font("Kannada MN", 1, 18)); 
       EndDateLabel.setText("End Date :");
       
       TopLabel = new javax.swing.JLabel();
       TopLabel.setFont(new java.awt.Font("Kannada MN", 1, 18));
       TopLabel.setText("Enter the dates of your reservation :");
       
       chambrepanel = new javax.swing.JPanel();
       chambrepanel.setBackground(new java.awt.Color(102, 102, 0));
       
       confirmer = new javax.swing.JButton();
       confirmer.setFont(new java.awt.Font("Kannada MN", 1, 18)); 
       confirmer.setForeground(new java.awt.Color(0, 102, 0));
       confirmer.setText("Confirm");
    
       mesOffres.addActionListener(new ActionListener() {
        	  
        		public void actionPerformed(ActionEvent e) {
        		String textFieldstart = ComboBoxjourdebut.getSelectedItem().toString()+"/"+ComboBoxmoisdebut.getSelectedItem().toString()+"/"+ComboBoxanneedebut.getSelectedItem().toString();
        	   Datee StartDateField= Datee.toDatee(textFieldstart);

        	   String textFieldend = ComboBoxjourfin.getSelectedItem().toString()+"/"+ComboBoxmoisfin.getSelectedItem().toString()+"/"+ComboBoxanneefin.getSelectedItem().toString();
        	   Datee EndDateField = Datee.toDatee(textFieldend);
        	   if ( Datee.avant(StartDateField,EndDateField)== false)
        	   {
        	   	JOptionPane.showMessageDialog(null, "The dates are wrongly placed", "Error", JOptionPane.ERROR_MESSAGE);
        	   }
        	   else{
        		 

                 try {
             	  String periode="Début: "+textFieldstart+"-Fin: "+textFieldend;
                List<String> chambres = Fichier.filterLines("Chambres",periode);
                for (String chambre : chambres) {
             	    System.out.println(chambre);
             	}

               
            
               Object[][] data = new Object[chambres.size()][4];
                for (int j = 0; j < chambres.size(); j++) {
             	   
                    String chambre = chambres.get(j);
                    
           
                    if (chambre.equals("Dates: Vide")) {
                        continue; // Skip "Dates: Vide" line
                    }
                    
                    String[] parts = chambre.split(" ");
                    
                    // Handle cases with less than 2 parts
                    if (parts.length < 2) {
                        // You can handle lines with less than 2 parts here (e.g., print a message)
                        continue;
                    }
                    
                   
               	 String numero = parts[0];
               	 String type = parts[1];
               	 String prix = parts[2];
                    
                   
                    data[j][0] = numero;
                    data[j][1] = type;
                    data[j][2] =  prix;
                    data[j][3] = false; // Par défaut, les cases à cocher sont décochées
                    
              
                }
                
                // Créer les noms de colonnes
                String[] columnNamess = {"Number" ,"Type", "Price", "Réserver"};

                // Créer le modèle de table
                DefaultTableModel model = new DefaultTableModel(data, columnNamess) {
                    private static final long serialVersionUID = 1L;

     			@Override
                    public  Class<?> getColumnClass(int columnIndex) {
                        if (columnIndex == 3) {
                            return Boolean.class; // La colonne des cases à cocher est de type Boolean
                        }
                        return super.getColumnClass(columnIndex);
                    };

                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return column == 3; // Seule la colonne des cases à cocher est éditable
                    }
                };
                
                // Créer la JTable avec le modèle de table personnalisé
                JTable table = new JTable(model);                 
                scrollPane = new javax.swing.JScrollPane(table);
               
                javax.swing.GroupLayout chambrepanelLayout = new javax.swing.GroupLayout(chambrepanel);
                chambrepanel.setLayout(chambrepanelLayout);
                chambrepanelLayout.setHorizontalGroup(
                    chambrepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane)
                    .addGroup(chambrepanelLayout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(confirmer)
                        .addContainerGap(218, Short.MAX_VALUE))
                );
                chambrepanelLayout.setVerticalGroup(
                    chambrepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chambrepanelLayout.createSequentialGroup()
                        .addComponent(scrollPane)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(confirmer)
                        .addGap(10, 10, 10))
                );
                
                         
                         	 
          					  confirmer.setBounds(250, 250, 250, 250);
          					  confirmer.setOpaque(true);
          					  confirmer.setBorderPainted(false);
          					  confirmer.setForeground(Color.white);
          					  confirmer.setFont(new Font("Kannada MN", Font.BOLD, 16));
          					  confirmer.setBackground(new Color(200, 0, 0));
          					 confirmer.addActionListener(new ActionListener() {
          						 public void actionPerformed(ActionEvent e) {
          							for (int i = 0; i < model.getRowCount(); i++) {
          								

                                         Boolean isChecked = (Boolean) model.getValueAt(i, 3);
                                         if (isChecked != null && isChecked) {
                                             // Traiter la réservation de la chambre
                                      	   String numero_c =  (String)model.getValueAt(i, 0);
                                             String type_c = (String) model.getValueAt(i, 1);
                                             String prix_c = (String) model.getValueAt(i, 2);
                                            
                                      
                                         	int intnumero = Integer.parseInt(numero_c);
                                          String a = RentButtonFrame.line_ID;
                        	               char []a2 = a.toCharArray();
                        	                char IDchar = a2[0];
                        	                String ID = String.valueOf(IDchar);
                                         	int IDD = Integer.parseInt(ID);
                                         	
                                         	Chambre c =new Chambre(Integer.valueOf(numero_c),Type.valueOf(type_c),Double.valueOf(prix_c));
                                        	 Reservation reservation = new Reservation(IDD,StartDateField,EndDateField, c);
                                             JOptionPane.showMessageDialog(null, "Chambre " + intnumero  + " réservée !");
                                             Administrateur.TraiterDemande(new Demande(IDD,StartDateField,EndDateField, c));
                                             Fichier.addToFile("Reservations_Clients",reservation.toString());
                                             Chambre.updateRoomavailability(intnumero);
                                             Fichier.removeDuplicates("Reservations_Clients");
                                             }
                                          
	           								
          						 }        
          						 }
          					  });
                
                         	  
                  } catch(IOException ex) {
                 	  System.out.println("Erreur");
                  }
                
        	  } }
        	  });
      
       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(mframe.getContentPane());
       mframe.getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addComponent(TopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
           .addComponent(BottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
           .addGroup(layout.createSequentialGroup()
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addGroup(layout.createSequentialGroup()
                       .addContainerGap()
                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addComponent(StartDateLabel)
                           .addComponent(EndDateLabel))
                       .addGap(26, 26, 26)
                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addGroup(layout.createSequentialGroup()
                               .addComponent(ComboBoxjourdebut, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                               .addGap(18, 18, 18)
                               .addComponent(ComboBoxmoisdebut, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                               .addGap(18, 18, 18)
                               .addComponent(ComboBoxanneefin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                           .addGroup(layout.createSequentialGroup()
                               .addComponent(ComboBoxjourfin, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                               .addGap(18, 18, 18)
                               .addComponent(ComboBoxmoisfin, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                               .addGap(18, 18, 18)
                               .addComponent(ComboBoxanneedebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                   .addGroup(layout.createSequentialGroup()
                       .addGap(94, 94, 94)
                       .addComponent(mesOffres, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                       .addContainerGap()
                       .addComponent(TopLabel)))
               .addGap(18, 18, 18)
               .addComponent(chambrepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addComponent(TopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addGroup(layout.createSequentialGroup()
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                       .addComponent(TopLabel)
                       .addGap(40, 40, 40)
                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                           .addComponent(ComboBoxjourdebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addComponent(ComboBoxmoisdebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addComponent(ComboBoxanneefin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addComponent(StartDateLabel))
                       .addGap(35, 35, 35)
                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                           .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                               .addComponent(ComboBoxjourfin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                               .addComponent(ComboBoxmoisfin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                               .addComponent(ComboBoxanneedebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                           .addComponent(EndDateLabel))
                       .addGap(41, 41, 41)
                       .addComponent(mesOffres, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addGap(77, 77, 77))
                   .addGroup(layout.createSequentialGroup()
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       .addComponent(chambrepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                       .addGap(2, 2, 2)))
               .addComponent(BottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
       );
                	   




       mframe.setVisible(true);

                         

         
           
           
	}});
       
}}  
