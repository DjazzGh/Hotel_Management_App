package Application.controllers;
import Application.model.Datee;
import Application.model.Fichier;
import Application.model.Chambre;
import Application.model.Client;
import Application.model.Demande;
import Application.model.Reservation;
import Application.model.Administrateur;
import Application.model.Type;


import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;


  class modifierReservationButton extends JButton  {
	  Datee debut;
	  Datee fin ;
	  static boolean modifier;
	public modifierReservationButton() {
		super("Modifier mes réservations");
		addActionListener(new ActionListener() {
	 public void actionPerformed(ActionEvent e) {
	        
	   JFrame nframe = new JFrame("listes des réservations");
	   nframe.setSize(1000, 400);
	   nframe.setResizable(true);

	  
	   String ID = RentButtonFrame.line_ID;
	         int firstSpaceIndex = ID.indexOf(' ');
	         String extractedID;

	         if (firstSpaceIndex != -1) {
	           extractedID = ID.substring(0, firstSpaceIndex);
	         } else {
	           extractedID = ID;
	         }
	         System.out.println(extractedID);
	              
         try { List<String> reservationamodifier = Fichier.findLinesWithPrefix("Reservations_Clients",extractedID);
                
           DefaultTableModel model = new DefaultTableModel(new String[]{"Id Client", "Date Begining", "Date End", "Room Number", "Change room", "Change date", " Cancel reservation",}, 0) {
               @Override
               public Class<?> getColumnClass(int columnIndex) {
              if (columnIndex == 4 || columnIndex == 5 || columnIndex == 6 ) {
                       return Boolean.class; // Column type is Boolean for checkboxes
                   }
                   return super.getColumnClass(columnIndex);
               }

               @Override
               public boolean isCellEditable(int row, int column) {
             	return column == 4 || column == 5 || column == 6; // Allow editing only for checkboxes
               }
           };
           
           
           for (String reservation : reservationamodifier) {
                   String[] parts = reservation.split(" ");
                   model.addRow(new Object[]{parts[0], parts[1], parts[2], parts[3], false, false,false});
               }
         

           JTable table = new JTable(model);
           JScrollPane scrollPane = new JScrollPane(table);

           nframe.add(scrollPane);
           nframe.setVisible(true);

            
    		 model.addTableModelListener(new TableModelListener() {
 			    public void tableChanged(TableModelEvent e) {
 			        int row = e.getFirstRow();
 			        int column = e.getColumn();
 			        if (column == 4) { 
 			        	
 			            Boolean checked = (Boolean) model.getValueAt(row, column);
 			            if (checked) {
 			            	String NUMERO = (String) model.getValueAt(row, 3); //numero de l'ancienne chambre
 			            	String datedeb  = (String) model.getValueAt(row, 1);
 			                String  datefi = (String) model.getValueAt(row, 2);
 			                
 			                
 			               String datedebut=Datee.formatDate(datedeb);
 			             String  datefin=Datee.formatDate(datefi);
 			                 JFrame framechambre = new JFrame("modifier chambre "); 			                 
 			                 framechambre.setSize(700, 400);
 			                 framechambre.setLayout(new BorderLayout());
 			                try {
 			              	  String periode="Début: "+datedebut+"-Fin: "+datefin;
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
 			                     if (parts.length < 2 || parts[0].equals(NUMERO)) {
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
 			                 DefaultTableModel model2 = new DefaultTableModel(data, columnNamess) {
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
 			                 JTable table = new JTable(model2);                 
 			                 JScrollPane scrollPane = new javax.swing.JScrollPane(table);
 			                framechambre.add(scrollPane,BorderLayout.NORTH);

 			           							model2.addTableModelListener(new TableModelListener() {
 			           			 			    public void tableChanged(TableModelEvent e) {
 			           			 			   int row2 = e.getFirstRow();
 			           	 			           int column2 = e.getColumn();
 			           							
 			           								if(column2==3) {
 			                                          Boolean isChecked = (Boolean) model2.getValueAt(row2, 3);
 			                                          if (isChecked) {
 			                                              // Traiter la réservation de la chambre
 			                                       	   String numero_c =  (String)model2.getValueAt(row2, 0);
 			                                              String type_c = (String) model2.getValueAt(row2, 1);
 			                                              String prix_c = (String) model2.getValueAt(row2, 2);
 			                                             
 			                                          	int intnumero = Integer.parseInt(numero_c);
 			                                           String a = RentButtonFrame.line_ID;
 			                         	               char []a2 = a.toCharArray();
 			                         	                char IDchar = a2[0];
 			                         	                String ID = String.valueOf(IDchar);
 			                                          	int IDD = Integer.parseInt(ID);
 			                                          	
 			                                          	Chambre c =new Chambre(intnumero,Type.valueOf(type_c),Double.valueOf(prix_c));
 			                                          	//System.out.println("This is the reservation we are entering  :"+IDD+Datee.toDatee(datedebut)+Datee.toDatee(datefin)+ c+NUMERO);
 			                                          	Client.ModifierChambreReservation(IDD, Datee.toDatee(datedebut), Datee.toDatee(datefin), c,NUMERO);
 			                                          	Chambre.updateRoomavailability(intnumero);
 			                                          	Chambre.updateRoomavailability(Integer.valueOf(NUMERO));
 			                                          	model.setValueAt(numero_c, row, 3);
 			                                              JOptionPane.showMessageDialog(null, "Chambre " + intnumero  + " réservée !");
 			                                             
 			                                              framechambre.dispose();
 			                                            

 			                                              }
 			                                           
 			                                         
 			                                            }
 			           			 			    }}); 
 			                 
 			                          	  
 			                   } catch(IOException ex) {
 			                  	  System.out.println("Erreur");
 			                   }
 			                 
 			         	   framechambre.pack();
 			                 framechambre.setVisible(true);
 			            }	  
 			    }
 			       if (column == 5) { 
 			    	  Boolean checked = (Boolean) model.getValueAt(row, column);
			            if (checked) {    
			            JFrame framedate = new JFrame();
			           String  numerochambree = (String) model.getValueAt(row, 3);
			           framedate.setSize(700,500);
			      	   
			      	   framedate.setResizable(true);
			      	   framedate.setLayout(new BorderLayout());
			           framedate.setVisible(true);	
			           JPanel inputPanel = new JPanel(new GridBagLayout());
			           GridBagConstraints gbc = new GridBagConstraints();
			           gbc.insets = new Insets(5, 5, 5, 5); 
			           JLabel label = new JLabel("Enter the new dates of your reservation:");

	                     framedate.add(label, BorderLayout.NORTH);
			           // Add Start Date Label and Combo Boxes
			           gbc.gridx = 0;
			           gbc.gridy = 0;
			           inputPanel.add(new JLabel("Start Date:"),gbc);

			           gbc.gridx = 1;
			           JComboBox<String>  ComboBoxjourdebut = new JComboBox<>(new String[] { "01", "02", "03","O4", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"});
			           inputPanel.add(ComboBoxjourdebut,gbc);

			           gbc.gridx = 2;
			           JComboBox<String>  ComboBoxmoisdebut = new  JComboBox<>(new String[] { "01", "02", "03","04", "05", "06", "07", "08", "09", "10", "11", "12"});
			           inputPanel.add(ComboBoxmoisdebut, gbc);

			           gbc.gridx = 3;
			           JComboBox<String>  ComboBoxanneedebut= new JComboBox<> (new String[] {"2024", "2025", "2026", "2027","2028","2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040"});
			           inputPanel.add(ComboBoxanneedebut, gbc);

			           // Add End Date Label and Combo Boxes
			           gbc.gridx = 0;
			           gbc.gridy = 1;
			           inputPanel.add(new JLabel("End Date:"), gbc);

			           gbc.gridx = 1;
			           JComboBox<String>  ComboBoxjourfin = new JComboBox<>(new String[] { "01", "02", "03","04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" });
			           inputPanel.add(ComboBoxjourfin, gbc);

			           gbc.gridx = 2;
			           JComboBox<String>  ComboBoxmoisfin = new  JComboBox<>(new String[] { "01", "02", "03", "04" , "05", "06", "07", "08", "09", "10", "11", "12" });
			           inputPanel.add(ComboBoxmoisfin, gbc);

			           gbc.gridx = 3;
			           JComboBox<String> ComboBoxanneefin= new JComboBox<> (new String[] {"2024", "2025", "2026", "2027","2028","2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040"});

			           inputPanel.add(ComboBoxanneefin,gbc);
   
			           framedate.add(inputPanel, BorderLayout.WEST);

			        JButton  valider = new JButton();
			           valider.setFont(new java.awt.Font("Kannada MN", 1, 18)); 
			           valider.setForeground(new java.awt.Color(0, 102, 0));
			           valider.setText("valider");
				        valider.addActionListener(new ActionListener() {
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
						        		String numero_chambre= (String) model.getValueAt(row, 3);
						            	String datedeb  = (String) model.getValueAt(row, 1);
						                String  datefi = (String) model.getValueAt(row, 2);
						                String datedebut=Datee.formatDate(datedeb);
						                String  datefin=Datee.formatDate(datefi);
						                

						                String chambre = Fichier.findLinesWithPrefixCombined("Chambres",numero_chambre);
			                           
			                            String parts[]=chambre.split(" ");
								     Chambre c=new Chambre(Integer.valueOf(parts[0]),Type.valueOf(parts[1]),Double.valueOf(parts[2]));
								     
						        		Demande dem = new Demande(Integer.valueOf(extractedID),StartDateField,EndDateField,c);
						        	    if (Administrateur.TraiterDemande(dem)==true) {
						        	    	model.setValueAt(StartDateField.toString(), row, 1);
							            	model.setValueAt(EndDateField.toString(), row, 2);
						        	    	Client.ModifierDateReservation(Integer.valueOf (extractedID), StartDateField, EndDateField,c);	
						        	    	Chambre.updateRoomavailability(Integer.valueOf(numero_chambre));
						        	    	JOptionPane.showMessageDialog(null, "Reservation completed ","reserved", JOptionPane.INFORMATION_MESSAGE);
						        	    	framedate.dispose();
						        	    		        			
					        			 	
							        	}else {
						        				JOptionPane.showMessageDialog(null, "the room is already reserved in this period", "Error", JOptionPane.ERROR_MESSAGE);
						        				framedate.dispose();
						        			}
						        	    }catch(Exception ee) {
						        			ee.getMessage();	}
						        	   }
						          
						     }}); 

			         
			           
			        framedate.add(valider,BorderLayout.SOUTH);   
			       framedate.pack();  
	             }
			            }
 			      if (column == 6) { 
			            Boolean checked = (Boolean) model.getValueAt(row, column);
			            if (checked) { 			            	
			            	 int reponse = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this reservation ?", "Confirmation", JOptionPane.YES_NO_OPTION);

						        if (reponse == JOptionPane.YES_OPTION) {
						     String  idd = (String) model.getValueAt(row, 0);
						     String datedebut  = (String) model.getValueAt(row, 1);
						     String  datefin = (String) model.getValueAt(row, 2);
						     String  numerochambree = (String) model.getValueAt(row, 3);
						     
						     String ligne = Fichier.findLinesWithPrefixCombined("Chambres", numerochambree);
						     String parts[]=ligne.split(" ");
						     Chambre ch=new Chambre(Integer.valueOf(parts[0]),Type.valueOf(parts[1]),Double.valueOf(parts[2]));						     
						     Reservation r = new Reservation(Integer.valueOf(idd),Datee.toDatee(datedebut),Datee.toDatee(datefin),ch);	
			            	Client.AnnulerReservation(r);
			            	

			            	
			            	model.removeRow(row);
			            	
			            	
			           
			            	
			            }
			            }
		    
 			    }
 			    }});

             
             
             
             
             }catch(IOException ex) {
            	System.out.println("Erreur");
            }
         
       
        
	 }});}}



