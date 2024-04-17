package Application;
import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JTextField;

public class checkRoomsButton extends JButton{
public checkRoomsButton() {
	  addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  

			  JFrame frameChambre = new JFrame("List of rooms");

			  frameChambre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			  frameChambre.getContentPane().setBackground(new Color(255, 255, 255));
			  frameChambre.setLayout(new GridLayout(2,1));
			  frameChambre.setSize(800, 400);
			  
			 
			  try (BufferedReader br = new BufferedReader(new FileReader("Chambres"))) {
				  String ligne;
				  while ((ligne = br.readLine()) != null) {
				    // Découper la ligne en fonction des séparateurs
				    String[] elements = ligne.split(" ");

				    
				    if (elements.length >= 4) {
				      try {
				        Chambre chambre = new Chambre(Type.valueOf(elements[1]), Double.parseDouble(elements[3]));
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

			  
			  String[] columnNames = {"Number of the room", "Type of the room", "Availability", "Price"};
			  JTable table = new JTable(new ChambreTableModel(Hotel.getListChambres()));
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
		


			  JPanel p1=new JPanel(new GridLayout(1,2));
			  for (int i = 0; i < 2; i++) {
				  JButton b1 = new JButton();
				  if (i == 0) {
					  b1.setText(" + ajouter des chambres");
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
							  frameAjouter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							  frameAjouter.setVisible(true);
							  frameAjouter.getContentPane().setBackground(new Color(255, 255, 255));

							  
							  frameAjouter.setLayout(new GridLayout(3, 1));
							  frameAjouter.getContentPane().setBackground(Color.white);
							  

							  JLabel l2 = new JLabel(" Type of the room");
							  l2.setFont(new Font("Kannada MN", Font.ROMAN_BASELINE, 22));
							  l2.setForeground(Color.black);
							  JTextField j2 = new JTextField();
							  frameAjouter.add(l2);
							  frameAjouter.add(j2);


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
									  if(j2.getText().equals(Type.Simple.toString())==false && j2.getText().equals(Type.Double.toString())==false && j2.getText().equals(Type.Triple.toString())==false) {
										  JOptionPane.showMessageDialog(null, "The type you entered doesn't exist !", "Wrong Type", JOptionPane.ERROR_MESSAGE);
									  }else {
									  frameAjouter.dispose();
									  JFrame frameValider = new JFrame("New List of rooms");
									  frameValider.setVisible(true);
									  frameValider.setSize(800, 400);
									  frameValider.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									  frameValider.setVisible(true);
									  frameValider.getContentPane().setBackground(new Color(255, 255, 255));

									  
									  Chambre c = Administrateur.AjouterChambre1(Type.valueOf(j2.getText()), Double.parseDouble(j4.getText()));

									  Fichier.addToFile("Chambres",c.toString());
                                      Hotel.listChambres.add(c);
									  String[] columnNames = {"Numéro de la chambre", "type de la chambre", "disponibilite", "Prix"};
									  JTable table = new JTable(new ChambreTableModel(Hotel.listChambres));
									  for (int i = 0; i < columnNames.length; i++) {
										  table.getColumnModel().getColumn(i).setHeaderValue(columnNames[i]);
									  }


									  JScrollPane scrollPane = new JScrollPane(table);
									  JPanel panel11 = new JPanel();
									  panel11.setBounds(500, 500, 500, 500);
									  panel11.setBackground(Color.white);
									  panel11.setLayout(new BorderLayout());
									  panel11.add(scrollPane, BorderLayout.NORTH);
									  frameValider.add(panel11);
									  


									  }}
							  });


						  }
					  });
					  p1.add(b1);
				  }
				  if (i == 1) {

					  b1.setText("-supprimer des chambres");
					  b1.setBounds(250, 250, 250, 250);
					  b1.setOpaque(true);
					  b1.setBorderPainted(false);
					  b1.setForeground(Color.white);
					  b1.setFont(new Font("Kannada MN", Font.BOLD, 16));
					  b1.setBackground(new Color(200, 0, 0));
							  

							  b1.addActionListener(new ActionListener() {
								  @Override
								  public void actionPerformed(ActionEvent e) {
									  JFrame frameRecuperer = new JFrame("Get the room number ");
									  frameRecuperer.setSize(400, 200);
									  frameRecuperer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		  
											  if(t.getText().isBlank()) {
												  JOptionPane.showMessageDialog(null, "Enter the room number !", "Empty", JOptionPane.WARNING_MESSAGE);

											  }else {
											  JFrame frameSV = new JFrame("New list of rooms ");
											  frameSV.setSize(800, 400);
											  frameSV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
											  frameSV.setVisible(true);
											  frameSV.getContentPane().setBackground(new Color(255, 255, 255));
											  Administrateur.SupprimerChambre(Integer.parseInt(t.getText()));
											  for (int i = Hotel.listChambres.size() - 1; i >= 0; i--) {
												  Chambre chambre = Hotel.listChambres.get(i);
												  if(chambre.getnumerochambre()==(Integer.parseInt(t.getText())))
												  {
													  Hotel.listChambres.remove(i);
												  }

											  }
										       String[] columnNames = {"Numéro de la chambre", "type de la chambre", "disponibilite", "Prix"};
          	                                   JTable table = new JTable(new ChambreTableModel(Hotel.getListChambres()));
											    for (int i = 0; i < columnNames.length; i++) {
												  table.getColumnModel().getColumn(i).setHeaderValue(columnNames[i]);
											    }
											  JScrollPane scrollPane = new JScrollPane(table);
											  JPanel panel11 = new JPanel();
											  panel11.setBounds(500, 500, 500, 500);
											  panel11.setBackground(Color.white);
											  panel11.setLayout(new BorderLayout());
											  panel11.add(scrollPane, BorderLayout.NORTH);
											  frameSV.add(panel11);
										  
											  }}
									  });


								  }
							  });
						 
					  p1.add(b1);

				  }

				  
			  }
			  
			  frameChambre.setLayout(new BorderLayout());
			  frameChambre.add(p1, BorderLayout.SOUTH);
			  frameChambre.getContentPane().add(panel11, BorderLayout.NORTH);

			   
		  }

	  });
}
}
