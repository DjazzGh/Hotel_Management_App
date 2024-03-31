package Application;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
public class InterfaceGraphique {

public static void main(String[] args) {
SwingUtilities.invokeLater(() -> {
        	//Main frame
JFrame frame = new JFrame("Hotel app"); 
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setResizable(false);
frame.setSize(800, 650); 
         
JPanel paneltop = new JPanel();
paneltop.setLayout(new BorderLayout());
paneltop.setBackground(Color.white);
paneltop.setBounds(0, 0, 800, 70); 
frame.add(paneltop,BorderLayout.NORTH);

JPanel panelbottom = new JPanel();
            panelbottom.setLayout(new BorderLayout());
            panelbottom.setBackground(Color.white);
            panelbottom.setBounds(0, 550, 800, 70);
            frame.add(panelbottom,BorderLayout.SOUTH);
            
JPanel panel5 = new JPanel();
frame.add(panel5,BorderLayout.CENTER);

            //Icon of the main frame
ImageIcon image = new ImageIcon("icon.png");
frame.setIconImage(image.getImage());
            
            //Background Image
            ImageIcon imageIcon = new ImageIcon("thepic.jpeg"); 
            JLabel imageLabel = new JLabel(imageIcon);
            imageLabel.setBounds(0,70,800,510);

            // LOGIN AS ADMIN BUTTON
            JButton loginButton = new JButton("Login as Admin");
            loginButton.setBounds(600, 40, 100, 100);
 
            loginButton.setOpaque(true);
            loginButton.setBorderPainted(false);
            loginButton.setBackground(new Color(200,0,0)); 
            loginButton.setFocusable(false);
            loginButton.setFont(new Font("Georgia", Font.BOLD, 16));
            loginButton.setForeground(Color.white); //Pour changer couleur du texte
            
            loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    
                    JFrame loginFrame = new JFrame("Admin Login");
                    loginFrame.setSize(500, 200);
                    loginFrame.setLayout(new GridLayout(3, 2));
                    loginFrame.getContentPane().setBackground(new Color(0,50,0));
                    
                    JTextField usernameField = new JTextField();
                    //usernameField.setPreferredSize(new Dimension(40,10));
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
                        	JFrame frameAdmin = new JFrame();
                        	
                        	
                        	
                        	
                        	
                        	
                        	
                        
                        	JButton CheckRooms =new JButton();  //Bouton Consulter les chambres
                        	frameAdmin.add(CheckRooms);
                        	
                        	
                        	CheckRooms.addActionListener(new ActionListener() {
                        		public void actionPerformed(ActionEvent e) {
                        			
                        			
                        			
                        			
                        			
                        			
                        			
                        		}
                        	});
                        	
                        	JButton CheckClients = new JButton();
                        	
                        	
                        	
                        	
                        	
                        	
                        	
                        	frameAdmin.add(CheckClients);
                        	CheckClients.addActionListener(new ActionListener() {
                        		public void actionPerformed(ActionEvent e) {
                        			
                        			
                        			
                        			
                        			
                        			
                        			
                        			
                        			
                        		}
                        	});
                        	
                        	
                        	
                        	
                        	
                        	
                        }});
                }
            });
            
            
            // RENT BUTTON
            JButton rentButton = new JButton("Rent your rooms");
            rentButton.setBounds(170, 550, 400, 50); 
            rentButton.setOpaque(true);
            rentButton.setBorderPainted(false);
            rentButton.setFocusable(false);
            rentButton.setBackground(new Color(200,0,0)); 
            rentButton.setFont(new Font("Georgia", Font.BOLD, 16)); 
            rentButton.setForeground(Color.white);
            
            //OPEN RENT BUTTON
            rentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                JFrame rentFrame = new JFrame("Offers");
                rentFrame.setSize(600, 350);
                rentFrame.getContentPane().setBackground(new Color(0,50,0));
                
                Container contentPane = rentFrame.getContentPane();
                contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
                Container contentPane2 = rentFrame.getContentPane();
                contentPane2.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

                               
                JLabel labeltop = new JLabel("                          Si vous etes deja un client :");
                labeltop.setForeground(Color.white);    
                labeltop.setFont(new Font("Times New Roman", Font.BOLD, 20));

                JTextField usernameField = new JTextField();
                JPasswordField passwordField = new JPasswordField();
                
                JLabel username = new JLabel("Nom d'utilisateur: ");
                username.setFont(new Font("Georgia", Font.ROMAN_BASELINE, 20));
                username.setHorizontalAlignment(JLabel.CENTER);
                username.setForeground(Color.white);
   
                JLabel password = new JLabel("Mot de passe: ");
                password.setFont(new Font("Georgia", Font.ROMAN_BASELINE, 20));
                password.setHorizontalAlignment(JLabel.CENTER);
                password.setForeground(Color.white);
 
                
                JLabel labelbottom = new JLabel("                  Si vous n'etes pas un client :");
                labelbottom.setForeground(Color.white);    
                labelbottom.setFont(new Font("Times New Roman", Font.BOLD, 20));
                labelbottom.setHorizontalAlignment(JLabel.CENTER);

                JButton SubscribeButton = new JButton("Inscription");
                SubscribeButton.setForeground(Color.white);
                SubscribeButton.setFont(new Font("Georgia", Font.BOLD, 17));
                SubscribeButton.setOpaque(true);
                SubscribeButton.setBorderPainted(false);
                SubscribeButton.setBackground(new Color(200,0,0));
                
                JButton ValidateButton = new JButton("Continuer");
                ValidateButton.setForeground(Color.white);
                ValidateButton.setFont(new Font("Georgia", Font.BOLD, 17));
                ValidateButton.setOpaque(true);
                ValidateButton.setBorderPainted(false);
                ValidateButton.setBackground(new Color(200,0,0));
                
                String NomUtilisateur = usernameField.getText();
                String MotdePasse = usernameField.getText();
                //If(Authentification(String NomUtilisateur,String MotdePasse)==false){
                //JOptionPane.showMessageDialog(null,"Erreur dans la saisie","Authentification",JOptionPane.WARNING_MESSAGE);}
                
                SubscribeButton.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		//Exemple de JOptionPane
                		//JOptionPane.showMessageDialog(null,"Vous n'avez pas encore de réservation","New Client",JOptionPane.INFORMATION_MESSAGE);
                	}
                });
		    // le bouton continuer
              ValidateButton.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            	if(Authentification(String NomUtilisateur,String MotdePasse)==false){
            	       JOptionPane.showMessageDialog(null,"Erreur dans la saisie","Authentification",JOptionPane.WARNING_MESSAGE);}
            	else {
            		Jframe vframe= new Jframe();
            		vframe.setSize(400, 300);
                    vframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    vframe.setResizable(false);

                    // Création du panneau
                    JPanel vpanel = new JPanel(new GridLayout(3, 1, 5, 5));

                    // Boutons
                    consulterButton = new JButton("Consulter mes réservations");
                   
                    nouvelleReservationButton = new JButton("Faire une nouvelle réservation");
                   
                    modifierReservationButton = new JButton("Modifier mes réservations");
                   

                    // Ajout des boutons au panneau
                    vpanel.add(consulterButton);
                    vpanel.add(nouvelleReservationButton);
                    vpanel.add(modifierReservationButton);

                    vframe.add(vpanel);

                    vframe.setVisible(true);
                }
            	}
            });
            
                contentPane.add(labeltop);
                contentPane2.add(username);
                contentPane2.add(usernameField);
                contentPane2.add(password);
                contentPane2.add(passwordField);
                contentPane.add(ValidateButton);
                contentPane.add(labelbottom);
                contentPane.add(SubscribeButton);
        
                rentFrame.setVisible(true);
            }
        });

            frame.setLayout(null);
            //frame.add(label);
            paneltop.add(loginButton,BorderLayout.EAST);
            panelbottom.add(rentButton,BorderLayout.EAST);
            frame.add(imageLabel);
            frame.setVisible(true);
        });

	}

}
