package Application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class LoginButton extends JButton {
    public LoginButton() {
        super("Login as Admin");
        setBounds(600, 40, 100, 100);
        setOpaque(true);
        setBorderPainted(false);
        setBackground(new Color(200, 0, 0));
        setFocusable(false);
        setFont(new Font("Georgia", Font.BOLD, 16));
        setForeground(Color.white);

        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JFrame loginFrame = new JFrame("Admin Login");
                loginFrame.setSize(500, 200);
                loginFrame.setLayout(new GridLayout(3, 2));
                loginFrame.getContentPane().setBackground(new Color(0,50,0));
                
                JTextField usernameField = new JTextField();
                JPasswordField passwordField = new JPasswordField();
                
                
                JLabel username = new JLabel("  Nom d'utilisateur: ");
                username.setFont(new Font("Georgia", Font.ROMAN_BASELINE, 19));
                username.setForeground(Color.white);
                loginFrame.add(username);
                loginFrame.add(usernameField);
                
                JLabel password = new JLabel("  Mot de passe: ");
                password.setFont(new Font("Georgia", Font.ROMAN_BASELINE, 19));
                password.setForeground(Color.white);
                loginFrame.add(password);
                loginFrame.add(passwordField);

               
                JButton submitButton = new JButton("Enregistrer");
                loginFrame.add(submitButton);
                submitButton.setForeground(Color.white);
                submitButton.setFont(new Font("Georgia", Font.BOLD, 17));
                submitButton.setOpaque(true);
                submitButton.setBorderPainted(false);
                submitButton.setBackground(new Color (200,0,0)); 

                loginFrame.setVisible(true);
              
                
                submitButton.addActionListener(new ActionListener() {
                	
                	
					  public void actionPerformed(ActionEvent e) {
						  String user=usernameField.getText();
		                    char[] passwordChars = passwordField.getPassword();
		                    String motdepasse = new String(passwordChars).trim();
						  if (Utilisateur.AuthentificationAdmin(user,motdepasse)==false) {
			JOptionPane.showMessageDialog(null, "Une erreur est survenue.", "Erreur", JOptionPane.ERROR_MESSAGE);
						  }
						  else {
						  JFrame frameAdmin = new JFrame("Gerer les donnees");
						  frameAdmin.setSize(450, 250);
						  frameAdmin.setVisible(true);
						  frameAdmin.getContentPane().setBackground(new Color(255, 255, 255));
						  frameAdmin.setLayout(new GridLayout(2, 1));
						  frameAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

						  JPanel panel1 = new JPanel();
						  JPanel panel2 = new JPanel();

						  // Définition de la couleur de fond pour différencier les panneaux
						  panel1.setBackground(Color.white);
						  panel2.setBackground(Color.white);


						  checkRoomsButton boutonconsulterchambres= new checkRoomsButton();//Bouton Consulter les chambres
						  panel1.add(boutonconsulterchambres, BorderLayout.CENTER);


						  JButton CheckClients = new JButton();
						  CheckClients.setText("GERER LES RESERVATIONS");
						  CheckClients.setBounds(600, 50, 100, 100);
						  CheckClients.setBackground(new Color(200, 0, 0));
						  CheckClients.setForeground(Color.white);
						  CheckClients.setFont(new Font("Georgia", Font.BOLD, 22));
						  CheckClients.setHorizontalAlignment(JButton.CENTER);
						  CheckClients.setVerticalAlignment(JButton.BOTTOM);
						  CheckClients.setOpaque(true);
						  CheckClients.setBorderPainted(false);

						  panel2.add(CheckClients, BorderLayout.CENTER);

						  frameAdmin.add(panel1);
						  frameAdmin.add(panel2);


						  CheckClients.addActionListener(new ActionListener() {
							  public void actionPerformed(ActionEvent e) {
								  JFrame frameClients = new JFrame("liste de clients");

								  frameClients.setSize(450, 600);
								  frameClients.setVisible(true);
								  frameClients.getContentPane().setBackground(new Color(255, 255, 255));
								  frameClients.setLayout(new GridLayout(2, 1));
								  frameClients.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

								  Datee d = new Datee(2, 2, 2002);
								  Client c1 = null;
								  try {
									  c1 = new Client("khene", "rania", "khenerania@gmail.com", "0587654322", d);
								  } catch (Numerotelephone ex) {
									  throw new RuntimeException(ex);
								  }
									   /*catch (ageverification ex) {
                                        throw new RuntimeException(ex);*/

								  Hotel.listClients.add(c1);
								  TableModel model = new AbstractTableModel() {
									  @Override
									  public int getRowCount() {
										  return Hotel.listClients.size();
									  }

									  @Override
									  public int getColumnCount() {
										  return 6;
									  }

									  @Override
									  public Object getValueAt(int rowIndex, int columnIndex) {
										  Client client = Hotel.listClients.get(rowIndex);
										  switch (columnIndex) {
											  case 0:
												  return client.ID;
											  case 1:
												  return client.Nom;
											  case 2:
												  return client.Prenom;
											  case 3:
												  return client.Email;
											  case 4:
												  return client.getDatenaissance();
											  case 5:
												  return client.NumeroTelephone;
											  default:
												  return null;
										  }
									  }

									  public String getColumnName(int columnIndex) {
										  switch (columnIndex) {
											  case 0:
												  return "ID Client";
											  case 1:
												  return "Nom";
											  case 2:
												  return "Prénom";
											  case 3:
												  return "Email";
											  case 4:
												  return "Date de naissance";
											  case 5:
												  return "Numero de telephone";
											  default:
												  return null;
										  }
									  }

								  };
								  JTable table = new JTable(model);
								  JScrollPane scrollPane = new JScrollPane(table);
								  frameClients.add(scrollPane);


								  JButton b = new JButton();
								  b.setText("recuperer l'id de client");
								  b.setBounds(300, 300, 300, 300);
								  b.setOpaque(true);
								  b.setBorderPainted(false);
								  b.setForeground(Color.white);
								  b.setFont(new Font("Georgia", Font.BOLD, 30));
								  b.setBackground(new Color(200, 0, 0));
								  JPanel l = new JPanel();
								  l.setLayout(new BorderLayout());
								  l.add(b, BorderLayout.SOUTH);
								  l.setBounds(250, 250, 250, 250);
								  frameClients.add(l);
								  b.addActionListener(new ActionListener() {
									  @Override
									  public void actionPerformed(ActionEvent e) {
										  JFrame frameRecuperer = new JFrame("recuperer l'id de client");
										  frameRecuperer.setSize(450, 250);
										  frameRecuperer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
										  frameRecuperer.setVisible(true);
										  frameRecuperer.getContentPane().setBackground(new Color(0, 50, 0));
										  frameRecuperer.setLayout(new GridLayout(2, 2));

										  JLabel j = new JLabel("  ID de client");
										  j.setFont(new Font("Georgia", Font.ROMAN_BASELINE, 19));
										  j.setForeground(Color.white);
										  JTextField t = new JTextField();
										  frameRecuperer.add(j);
										  frameRecuperer.add(t);
										  JButton bb = new JButton();
										  bb.setText("valider");
										  bb.setBounds(300, 300, 300, 300);
										  bb.setOpaque(true);
										  bb.setBorderPainted(false);
										  bb.setForeground(Color.white);
										  bb.setFont(new Font("Georgia", Font.BOLD, 30));
										  bb.setBackground(new Color(200, 0, 0));
										  frameRecuperer.add(bb);
										  bb.addActionListener(new ActionListener() {
											  @Override
											  public void actionPerformed(ActionEvent e) {
												  JFrame framereservation = new JFrame("les reservations du client");
												  framereservation.setSize(450, 250);
												  framereservation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
												  framereservation.setVisible(true);
												  framereservation.getContentPane().setBackground(new Color(255, 255, 255));
												  //.setLayout(new GridLayout(,2));

											  }
										  });


									  }
								  });


/////////////////liste de clients


							  }

						  });
					  }




					  }


				  });

		  }




//ta3 if

});

    }
}
