package Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Application.Datee;

import javax.swing.JButton;

class nouvelleReservationButton extends JButton {  
public nouvelleReservationButton() {
	super("Faire une nouvelle réservation");
addActionListener(new ActionListener() {
	@Override
  public void actionPerformed(ActionEvent e) {
	JFrame mframe = new JFrame("nouvelle reservation"); 
	 mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  // mframe.setResizable(false);
   mframe.setSize(800, 650);
   mframe.setVisible(true);

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
   JTextField endDateField = new JTextField();
   panel.add(endDateLabel);
   panel.add(endDateField);
   mframe.add(panel);
   String textFieldend = endDateField.getText();
   Datee EndDateField = Datee.toDatee(textFieldend);
	JButton mesOffresButton = new JButton("Mes offres");
   	mframe.add(mesOffresButton);
   if ( Datee.avant(StartDateField,EndDateField)== false)
   {
   	JOptionPane.showMessageDialog(null, "Format de date invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
   }
   else{
   //	JButton mesOffresButton = new JButton("Mes offres");
  // 	mframe.add(mesOffresButton);
   	
   	mesOffresButton.addActionListener(new ActionListener() {
   	  @Override
   		public void actionPerformed(ActionEvent e) {
    JFrame chambreframe = new  JFrame("les chambres disponibles "); 
    chambreframe.setVisible(true);
   			JPanel chambrepanel = new JPanel();
            chambrepanel.setLayout(new GridLayout(0, 2));
          
           List<String> chambres = Fichier.findLinesWithPrefix("Chambres", "Disponible");
       
          Object[][] data = new Object[chambres.size()][4];
           for (int i = 0; i < chambres.size(); i++) {
        	   
               String chambre = chambres.get(i);
               
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
           DefaultTableModel model = new DefaultTableModel(data, columnNamess) {
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
               }
           };

           // Créer la JTable avec le modèle de table personnalisé
           JTable table = new JTable(model);
           JScrollPane scrollPane = new JScrollPane(table);
           chambrepanel.add(scrollPane);
        //   chambrepanel(table);
           
                    	   for (int i = 0; i < model.getRowCount(); i++) {
                               Boolean isChecked = (Boolean) model.getValueAt(i, 3);
                               if (isChecked) {
                                   // Traiter la réservation de la chambre
                            	   String numero =  (String)model.getValueAt(i, 0);
                                   String type = (String) model.getValueAt(i, 1);
                                   String disponibilite = (String) model.getValueAt(i, 2);
                                   double prix = (double) model.getValueAt(i, 3);
                                  // System.out.println("Réservation de la chambre : Type=" + type + ", Disponibilité=" + disponibilite + ", Prix=" + prix);
                            
                               	int intnumero = Integer.parseInt(numero);
                                String a = RentButtonFrame.line_ID;
              	               char []a2 = a.toCharArray();
              	                char IDchar = a2[0];
              	                String ID = String.valueOf(IDchar);
                               	int IDD = Integer.parseInt(ID);
                               	
                              	 Reservation reservation = new Reservation(IDD,StartDateField,EndDateField, intnumero);
                                   JOptionPane.showMessageDialog(chambreframe, "Chambre " + intnumero  + " réservée !");
                                   HashMap<Datee,Datee> map = new  HashMap<Datee,Datee>();
                                   map.put(StartDateField,EndDateField);
                                   String stringdate=  Chambre.afficherHashMap(map);
                               Fichier.replaceWordInFile("Chambres", "Disponible",stringdate);
                                   Fichier.AddLineInFile("Reservations_Clients", 1,reservation.toString());
                              }   }
                    	   chambreframe.add(chambrepanel);     }    
   	     });
 
       
            
            JScrollPane scrollPanee = new JScrollPane(panel);
            scrollPanee.setPreferredSize(new Dimension(400, 300));
            JOptionPane.showMessageDialog(mframe, scrollPanee, "Chambres disponibles", JOptionPane.PLAIN_MESSAGE);
   	
   }	

         JButton retourButton = new JButton("Retour");
         mframe.add(retourButton,BorderLayout.SOUTH);
         retourButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
               mframe.dispose();                  } });
  }});
       
}}

