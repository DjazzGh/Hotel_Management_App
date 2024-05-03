package Application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LoginButton extends JFrame {
    public LoginButton() {
    	super("Admin Login");          	
           setSize(400,300);
    	   setResizable(false);
           setVisible(true);
          // setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
   
                JTextField jTextField1 = new javax.swing.JTextField();
                JPasswordField jPasswordField1 = new javax.swing.JPasswordField();
                

                JLabel jLabel1 = new javax.swing.JLabel();
                jLabel1.setFont(new java.awt.Font("Hiragino Mincho ProN", 1, 18)); 
                jLabel1.setText("Username :");
                add(jLabel1);
                
                JLabel jLabel2 = new javax.swing.JLabel();
                jLabel2.setFont(new java.awt.Font("Hiragino Mincho ProN", 1, 18)); 
                jLabel2.setText("Password : ");
                add(jLabel2);
                
                JPanel jPanel1 = new javax.swing.JPanel();
                jPanel1.setBackground(new java.awt.Color(0, 50,0));
                
                JLabel jLabel3 = new javax.swing.JLabel();
                jLabel3.setFont(new java.awt.Font("Songti SC", 1, 20)); 
                jLabel3.setForeground(new java.awt.Color(255, 255, 255));
                add(jLabel3);
                
                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                );
                add(jPanel1);
                
                JButton submitButton = new javax.swing.JButton();
                submitButton.setBackground(new java.awt.Color(0, 50,0));
                submitButton.setFont(new java.awt.Font("ITF Devanagari Marathi", 1, 18)); 
                submitButton.setOpaque(true);
                submitButton.setBorderPainted(false);
                submitButton.setForeground(new java.awt.Color(255, 255, 255));
                submitButton.setText("Confirm");
                add(submitButton);
                
                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(50, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                );

            
       	                    
                submitButton.addActionListener(new ActionListener() {               	
                	
					  public void actionPerformed(ActionEvent e) {
						  String user=jTextField1.getText();
		                    char[] passwordChars = jPasswordField1.getPassword();
		                    String motdepasse = new String(passwordChars).trim();
						  if (Utilisateur.AuthentificationAdmin(user,motdepasse)==false) {
			JOptionPane.showMessageDialog(null, "Une erreur est survenue.", "Erreur", JOptionPane.ERROR_MESSAGE);
						  }
						  else {
							  JFrame options = new JFrame();
			        			options.setSize(500,400);
			        	        options.setResizable(false);
			        	        options.setVisible(true);
			        	        
			        	        JButton CheckClients = new javax.swing.JButton();
			        	        checkRoomsButton jButton2 = new checkRoomsButton();

			        	       // setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

			        	        CheckClients.setBackground(Color.white);
			        	        CheckClients.setFont(new java.awt.Font("Kannada MN", 1, 16)); 
			        	        CheckClients.setText("Check Clients");
			        	        CheckClients.setOpaque(true);
			        	        CheckClients.setBorderPainted(false);

			        	        jButton2.setBackground(Color.white);
			        	        jButton2.setFont(new java.awt.Font("Kannada MN", 1, 16)); 
			        	        jButton2.setText("Check Rooms");
			        	        jButton2.setOpaque(true);
			        	        jButton2.setBorderPainted(false);

			        	        
			        	        
			        	        ImageIcon imageIcon = new ImageIcon("Logo.png");
			        	        Image resizedImage = imageIcon.getImage().getScaledInstance(500, 400, Image.SCALE_SMOOTH);
			        	        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
			        	        JLabel imageLabel = new JLabel(resizedImageIcon);
			        	        imageLabel.setBounds(0, 0, 500, 400);
			        	        imageLabel.setOpaque(false);
			        	        
			        	        
			        	        
			        	        options.add(imageLabel);

			        	        
			        	        options.add(jButton2);
			        	        options.add(CheckClients);
			        	        dispose();
			        	        javax.swing.GroupLayout layout2 = new javax.swing.GroupLayout(options.getContentPane());
			        	        options.getContentPane().setLayout(layout2);
			        	        layout2.setHorizontalGroup(
			        	        layout2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			        	        .addGroup(layout2.createSequentialGroup()
			        	        .addGap(85, 85, 85)
			        	        .addGroup(layout2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			        	        .addComponent(CheckClients, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
			        	        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
			        	        .addContainerGap(85, Short.MAX_VALUE))
			        	        );
			        	        layout2.setVerticalGroup(
			        	        layout2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			        	        .addGroup(layout2.createSequentialGroup()
			        	        .addGap(83, 83, 83)
			        	        .addComponent(CheckClients, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
			        	        .addGap(26, 26, 26)
			        	        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
			        	        .addContainerGap(83, Short.MAX_VALUE))
			        	        			        	        		);
			        	        
			        	        CheckClients.addActionListener(new ActionListener() {
									  public void actionPerformed(ActionEvent e) {
										  JFrame frameClients = new JFrame("List of customers");
										  frameClients.setSize(800, 450);
										  frameClients.setVisible(true);
										  frameClients.getContentPane().setBackground(new Color(255, 255, 255));
										  frameClients.setLayout(new GridLayout(2, 1));
										  //frameClients.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


										  try (BufferedReader br = new BufferedReader(new FileReader("Clients"))) {

											  // Lire chaque ligne du fichier
											  String ligne;
											  while ((ligne = br.readLine()) != null) {

												  // Découper la ligne en fonction des séparateurs
												  String[] elements = ligne.split(" ");
												  Client c =Client.creerClient(elements);

												  Hotel.listClients.add(c);
											  }

										  } catch (IOException ex) {
											  ex.printStackTrace();
										  } catch (NumeroTelephone ex) {
		                                      throw new RuntimeException(ex);
		                                  }
										  for (int i = 0; i < Hotel.listClients.size(); i++) {
											  System.out.println(Hotel.listClients.get(i));
											}

										  
			           String[] columnNames = {"ID", "Last Name", "First Name", "Email","Phone number","Date of birth"};
										  JTable table = new JTable(new ClientTableModel(Hotel.getMyList()));
										  for (int i = 0; i < columnNames.length; i++) {
											  table.getColumnModel().getColumn(i).setHeaderValue(columnNames[i]);
										  }

										  JScrollPane scrollPane = new JScrollPane(table);
										  JPanel panel11 = new JPanel();
										  panel11.setBounds(600, 600, 600, 600);
										  panel11.setBackground(Color.white);
										  panel11.setLayout(new BorderLayout());
										  panel11.add(scrollPane,BorderLayout.NORTH);
										  frameClients.add(panel11);
										  frameClients.setVisible(true);


		                                  JButton b = new JButton();
										  b.setText("Enter the client's id to retrieve his reservations");
										  b.setBounds(300, 300, 300, 300);
										  b.setOpaque(true);
										  b.setBorderPainted(false);
										  b.setForeground(Color.white);
										  b.setFont(new Font("Kannada MN", Font.BOLD, 24));
										  b.setBackground(new Color(200, 0, 0));
										  JPanel l = new JPanel();
										  l.setLayout(new BorderLayout());
										  l.add(b, BorderLayout.SOUTH);
										  l.setBounds(250, 250, 250, 250);
										  frameClients.add(l);
										  b.addActionListener(new ActionListener() {
											
											  public void actionPerformed(ActionEvent e) {
												  JFrame frameRecuperer = new JFrame("Get client's ID");
												  frameRecuperer.setSize(400, 160);
												 // frameRecuperer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
												  frameRecuperer.setVisible(true);
												  frameRecuperer.getContentPane().setBackground(Color.white);
												  frameRecuperer.setLayout(new GridLayout(2, 2));

												  JLabel j = new JLabel("  Client's ID :");
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
														  if(t.getText().matches("\\d+")) {
														  JFrame framereservation = new JFrame("The client's reservations");
														  framereservation.setSize(450, 250);
														 // framereservation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
														  framereservation.setVisible(true);
														  framereservation.getContentPane().setBackground(new Color(255, 255, 255));

		                                                  try {
		                                                	  System.out.println(t.getText().toString());
		                                                      List<String> r= Fichier.findLinesWithPrefix("Reservations_Clients", t.getText().toString());
															  
		                                                      if(r.isEmpty()) {
		                                                    	  framereservation.setVisible(false);
														        	 JOptionPane.showMessageDialog(null, "This client has no reservations", "Reservations Not Found", JOptionPane.ERROR_MESSAGE);
														        }else {
															  JTextArea textArea = new JTextArea();
														        textArea.setFont(new Font("Kannada MN", Font.PLAIN, 15));
														        textArea.append("ID StartDate EndDate RoomNumber" + "\n");
														        

														        for (String line : r) {
														            textArea.append(line + "\n"); 
														        }

														        framereservation.add(textArea);
														        pack();
														        }

		                                                  } catch (IOException ex) {
		                                                      throw new RuntimeException(ex);
		                                                  } 
		                                                  }else {
		                                                	  JOptionPane.showMessageDialog(null, "You have to enter a number !", "Wrong Entry", JOptionPane.WARNING_MESSAGE);
		                                                  }
		                                                  


													  }
												  });
											  }
										  });
										  



			        	       

			            }
			        	}
						  );
			        	
						  };

						  }  });
    }} 

