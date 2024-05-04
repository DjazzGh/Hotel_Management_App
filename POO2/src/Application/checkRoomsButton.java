
package Application;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class checkRoomsButton extends JButton{
public checkRoomsButton() {
	  addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  

			  JFrame frameChambre = new JFrame("List of rooms");

			 
			  frameChambre.setResizable(false);
			  frameChambre.getContentPane().setBackground(new Color(255, 255, 255));
			  frameChambre.setLayout(new GridLayout(2,1));
			  frameChambre.setSize(950, 400);
			  
			 
			  try (BufferedReader br = new BufferedReader(new FileReader("Chambres"))) {
				  String ligne;
				  while ((ligne = br.readLine()) != null) {
				    
				    String[] elements = ligne.split(" ");

				    
				    if (elements.length >= 3) {
				      try {
				        Chambre chambre = new Chambre(Type.valueOf(elements[1]), Double.parseDouble(elements[2]));
				        // Ajouter la chambre à la liste
				        Hotel.listChambres.add(chambre);
				      } catch (NumberFormatException ex) {
				        
				        System.err.println("Error parsing price for line: " + ligne);
				      
				      }
				    } else {
				    
				      System.err.println("Warning: Line has less than 4 elements: " + ligne);
				    }
				  }
				} catch (IOException ex) {
				  ex.printStackTrace();
				}

			  
			  String[] columnNames = {"Number of the room", "Type of the room","Price"};
			  ChambreTableModel model = new ChambreTableModel(Hotel.getListChambres());
			  JTable table = new JTable(model);
			  for (int i = 0; i < columnNames.length; i++) {
				  table.getColumnModel().getColumn(i).setHeaderValue(columnNames[i]);
			  }
			  


			  JScrollPane scrollPane = new JScrollPane(table);
			  JPanel panel11 = new JPanel();
			  panel11.setBounds(600, 600, 600, 600);
			  panel11.setBackground(Color.white);
			  panel11.setLayout(new BorderLayout());
			  panel11.add(scrollPane,BorderLayout.NORTH);
			  frameChambre.add(panel11);
			  frameChambre.setVisible(true);
		

			  JButton b3 = new JButton();
			  JPanel p1=new JPanel(new GridLayout(1,2));
			  for (int i = 0; i < 2; i++) {
				  JButton b1 = new JButton();
				 
				  if (i == 0) {
					  b1.setText(" + add a room");
					  b1.setBounds(250, 250, 250, 250);
					  b1.setOpaque(true);
					  b1.setBorderPainted(false);
					  b1.setForeground(Color.white);
					  b1.setFont(new Font("Kannada MN", Font.BOLD, 16));
					  b1.setBackground(new Color(200, 0, 0));
					  b1.addActionListener(new ActionListener() {
						  @Override
						  public void actionPerformed(ActionEvent e) {
							  JFrame frameAjouter = new JFrame("Add a room");
							  frameAjouter.setSize(450, 250);
							  frameAjouter.setVisible(true);
							  frameAjouter.getContentPane().setBackground(new Color(255, 255, 255));

							  
							  frameAjouter.setLayout(new GridLayout(3, 1));
							  frameAjouter.getContentPane().setBackground(Color.white);
							  

							  JLabel l2 = new JLabel(" Type of the room");
							  l2.setFont(new Font("Kannada MN", Font.ROMAN_BASELINE, 22));
							  l2.setForeground(Color.black);
							  frameAjouter.add(l2);
							  
							  Type[] options = Type.values();
						        JComboBox<Type> typeComboBox = new JComboBox<>(options);
						        typeComboBox.setPreferredSize(new Dimension(220, 70));
						        Font font = new Font("Kannada MN", Font.PLAIN, 17); 
						        typeComboBox.setFont(font);    
						        JPanel panel = new JPanel(); 				        
						        panel.add(typeComboBox);
						        frameAjouter.add(panel);
							 


							  JLabel l4 = new JLabel("       Price");
							  l4.setFont(new Font("Kannada MN", Font.ROMAN_BASELINE, 22));
							  l4.setForeground(Color.black);
							  JTextField j4 = new JTextField();
							  frameAjouter.add(l4);
							  frameAjouter.add(j4);

							  JButton b4 = new JButton();
							  b4.setText(" Confirm");
							  b4.setBounds(300, 300, 300, 300);
							  b4.setOpaque(true);
							  b4.setBorderPainted(false);
							  b4.setForeground(Color.white);
							  b4.setFont(new Font("Georgia", Font.BOLD, 22));
							  b4.setBackground(new Color(0, 50, 0));

							  frameAjouter.add(b4);
							  
							  b4.addActionListener(new ActionListener() {
								  @Override
								  public void actionPerformed(ActionEvent e) {
									  if(j4.getText().matches("\\d+(\\.\\d+)?")){
									  frameAjouter.dispose();
									  int selectedIndex = typeComboBox.getSelectedIndex();
									  Type selectedType = Type.values()[selectedIndex];
									  //JComboBox<Type> choixType = new JComboBox<>(Type.values());

									  Chambre c=new Chambre(selectedType,Double.parseDouble(j4.getText()));
									  Fichier.addToFile("Chambres",c.toString1());
                                     // Hotel.listChambres.add(c);
									 
                                      model.addRow(c);


									  }else {
										  JOptionPane.showMessageDialog(null, "You have to enter a number !", "Wrong Entry", JOptionPane.WARNING_MESSAGE);
									  }
									  }
							  });


						  }
					  });
					  p1.add(b1);
				  }
				  if (i == 1) {

					  b1.setText("-delete a room ");
					  b1.setBounds(250, 250, 250, 250);
					  b1.setOpaque(true);
					  b1.setBorderPainted(false);
					  b1.setForeground(Color.white);
					  b1.setFont(new Font("Kannada MN", Font.BOLD, 16));
					  b1.setBackground(new Color(200, 0, 0));
					JButton b2=new JButton("Get room's availability");
					b2.setBounds(250, 250, 250, 250);
					  b2.setOpaque(true);
					  b2.setBorderPainted(false);
					  b2.setForeground(Color.white);
					  b2.setFont(new Font("Kannada MN", Font.BOLD, 16));
					  b2.setBackground(new Color(200, 0, 0));

							  b1.addActionListener(new ActionListener() {
								  @Override
								  public void actionPerformed(ActionEvent e) {
									  JFrame frameRecuperer = new JFrame("Get the room number ");
									  frameRecuperer.setSize(400, 200);
									  frameRecuperer.setVisible(true);
									  frameRecuperer.getContentPane().setBackground(Color.white);
									  frameRecuperer.setLayout(new GridLayout(2, 2));

									  JLabel j = new JLabel("  Room Number :");
									  j.setFont(new Font("Kannada MN", Font.ROMAN_BASELINE, 22));
									  j.setForeground(Color.black);
									  JTextField t = new JTextField();
									  frameRecuperer.add(j);
									  frameRecuperer.add(t);
									  JButton bb = new JButton();
									  bb.setText("Confirm");
									  bb.setBounds(300, 300, 300, 300);
									  bb.setOpaque(true);
									  bb.setBorderPainted(false);
									  bb.setForeground(Color.white);
									  bb.setFont(new Font("Kannada MN", Font.BOLD, 25));
									  bb.setBackground(new Color(0, 50, 0));
									  frameRecuperer.add(bb);
									 
									  bb.addActionListener(new ActionListener() {
										  
										  public void actionPerformed(ActionEvent e) {
											  
											  int reponse = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this room ?", "Confirmation", JOptionPane.YES_NO_OPTION);

										        if (reponse == JOptionPane.NO_OPTION) {
										           frameRecuperer.dispose();
										        } else {
									
										        	if(t.getText().matches("\\d+")) {
									
											  Administrateur.SupprimerChambre(Integer.parseInt(t.getText()));
											  for (int i = Hotel.listChambres.size() - 1; i >= 0; i--) {
												  Chambre chambre = Hotel.listChambres.get(i);
												  if(chambre.getnumerochambre()==(Integer.parseInt(t.getText())))
												  {
													  model.removeRow(chambre);
												  }

											  }
										
											 
										  
											  }else {
												  JOptionPane.showMessageDialog(null, "You have to enter a room number !", "Wrong", JOptionPane.WARNING_MESSAGE);
											  }
											  }}
									  });


								  }
							  });
							  
							  
							  b2.addActionListener(new ActionListener() {
								  @Override
								  public void actionPerformed(ActionEvent e) {
									  JFrame frameRecuperer = new JFrame("Get the room number ");
									  frameRecuperer.setSize(400, 140);
									  frameRecuperer.setVisible(true);
									  frameRecuperer.getContentPane().setBackground(Color.white);
									  frameRecuperer.setLayout(new GridLayout(2, 2));

									  JLabel j = new JLabel("  Room Number :");
									  j.setFont(new Font("Kannada MN", Font.ROMAN_BASELINE, 22));
									  j.setForeground(Color.black);
									  JTextField t = new JTextField();
									  frameRecuperer.add(j);
									  frameRecuperer.add(t);
									  JButton bb = new JButton();
									  bb.setText("Confirm");
									  bb.setBounds(300, 300, 300, 300);
									  bb.setOpaque(true);
									  bb.setBorderPainted(false);
									  bb.setForeground(Color.white);
									  bb.setFont(new Font("Kannada MN", Font.BOLD, 22));
									  bb.setBackground(new Color(0, 50, 0));
									  frameRecuperer.add(bb);
									 
									  bb.addActionListener(new ActionListener() {
										  
										  public void actionPerformed(ActionEvent e) {
											  if(t.getText().matches("\\d+")) {
												  int room_number = Integer.valueOf(t.getText());
												  String line = Fichier.findLinesWithPrefixCombined("Chambres", String.valueOf(t.getText()));
												  System.out.println(line);
													String datesReserve="";
												 
											        int startIndex = 0;
											        while (true) {
											            int debutIndex = line.indexOf("Début: ", startIndex);
											            if (debutIndex == -1) {
											            	
											                break;
											            }
											            int endIndex = line.indexOf(" Début: ", debutIndex);
											            if (endIndex == -1) {
											                endIndex = line.length();
											            }
											            String range = line.substring(debutIndex, endIndex);
											            String[] parts = range.split("-");
											            String debut = parts[0].trim().replace("Début: ", "");
											            String fin = parts[1].trim().replace("Fin: ", "");
											            datesReserve+="Start Date: " + debut +"- End Date: "+ fin +"\n";
											            startIndex = endIndex;
											        }
											    
											if(datesReserve=="") {
											      datesReserve="Room not booked";}

												  JFrame frame = new JFrame("Dates when the room is booked ");
												  frame.setSize(500, 300);

												  JTextArea textArea = new JTextArea(datesReserve);
												  textArea.setFont(new Font("Kannada MN", Font.PLAIN, 18));
											      
												  textArea.setEditable(false); 
												 
												  frame.add(textArea);
												  frame.setVisible(true);
											  
											  }else {
												  JOptionPane.showMessageDialog(null, "You have to enter a room number !", "Wrong Entry", JOptionPane.WARNING_MESSAGE);
											  }
											  
											  
											  
											  }
									  });


								  }
							  });
						 
					  p1.add(b1);
					  p1.add(b2);
					  

				  }
				  	
					   b3.setText("  Modify a room");
					  b3.setBounds(250, 250, 350, 250);
					  b3.setOpaque(true);
					  b3.setBorderPainted(false);
					  b3.setForeground(Color.white);
					  b3.setFont(new Font("Georgia", Font.BOLD, 15));
					  b3.setBackground(new Color(200, 0, 0));
					  p1.add(b3);
					 
					  b3.addActionListener(new ActionListener() {
						  @Override
						  public void actionPerformed(ActionEvent e) {
							  JFrame frameModifier = new JFrame("Information to modify the room");
							  frameModifier.setSize(550, 200);
							  
							 
							  frameModifier.setLayout(new GridLayout(3, 1));
							  frameModifier.getContentPane().setBackground(Color.white);

							  JLabel l1 = new JLabel(" Number of the room:");
							  l1.setFont(new Font("Kannada MN", Font.BOLD, 21));
							  l1.setForeground(Color.black);
							  JTextField j1 = new JTextField();
							  frameModifier.add(l1);
							  frameModifier.add(j1);
							  
							  JLabel l3 = new JLabel("New price of the room :");
							  l3.setFont(new Font("Kannada MN", Font.BOLD, 21));
							  l3.setForeground(Color.black);
							  JTextField j3 = new JTextField();
							  frameModifier.add(l3);
							  frameModifier.add(j3);

							  JButton b4 = new JButton();
							  b4.setText(" Confirm");
							  b4.setBounds(300, 300, 300, 300);
							  b4.setOpaque(true);
							  b4.setBorderPainted(false);
							  b4.setForeground(Color.white);
							  b4.setFont(new Font("Kannada MN", Font.BOLD, 25));
							  b4.setBackground(new Color(0, 50, 0));

							
							
							  b4.addActionListener(new ActionListener() {
								  @Override
								  public void actionPerformed(ActionEvent e) {
									frameModifier.dispose();
                                    try { 
                                    	String line=Fichier.findLinesWithPrefixCombined("Chambres", String.valueOf(j1.getText()) );
                  						System.out.println(String.valueOf(j1.getText()));
                  						String[] chambre=line.split(" ");
                  						String oldprice=chambre[2];
                  						System.out.println(oldprice);
                                                                                	
										  int n=Fichier.findLineNumberWithWord("Chambres",j1.getText());										  
										  Fichier.replaceInLine("Chambres",n,oldprice,j3.getText());
										  Hotel.listChambres.get(n-1).setPrix(Double.parseDouble(j3.getText()));
										  model.setValueAt(Double.parseDouble(j3.getText()),n-1, 2);
										  model.fireTableCellUpdated(n-1, 2);

										

                                                                                  } catch (IOException ex) {
                                                                                    throw new RuntimeException(ex);
                                                                                  }


								  }
							  });
							  frameModifier.add(b4);
							    frameModifier.setVisible(true);




						  }
					  });
					  
				  

				  
			  }
			  
			  frameChambre.setLayout(new BorderLayout());
			  frameChambre.add(p1, BorderLayout.SOUTH);
			  frameChambre.getContentPane().add(panel11, BorderLayout.NORTH);

			   
		  }

	  });
}
}
