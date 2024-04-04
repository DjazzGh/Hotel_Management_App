package Application;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RentButton extends JButton {
    public RentButton() {
    	 
        super("Rent your rooms");
        setBounds(170, 550, 400, 50);
        setOpaque(true);
        setBorderPainted(false);
        setFocusable(false);
        setBackground(new Color(200, 0, 0));
        setFont(new Font("Georgia", Font.BOLD, 16));
        setForeground(Color.white);
        
        addActionListener(new ActionListener() {
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
                
               
                
                
                SubscribeButton.addActionListener(new ActionListener() {
                	JTextField nomField, prenomField, telephoneField, EmailField ,dateField, utilisateurField, motDePasseField;
                	public void actionPerformed(ActionEvent e) {
 
                		JFrame inscriptionFrame = new JFrame("Inscription");
                        inscriptionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                          inscriptionFrame.setSize(400, 300);

                           JPanel panel = new JPanel();
                    		   panel.setLayout(new GridLayout(9, 2));

                           panel.add(new JLabel("Nom :"));
                            nomField = new JTextField();
                            panel.add(nomField);

                            panel.add(new JLabel("Prénom :"));
                            prenomField = new JTextField();
                            panel.add(prenomField);

                            panel.add(new JLabel("Numéro de téléphone :"));
                            telephoneField = new JTextField();
                            panel.add(telephoneField);

                            panel.add(new JLabel("l'email :"));
                            EmailField = new JTextField();
                            panel.add(EmailField);

                            panel.add(new JLabel("Date de naissance :"));
                            dateField = new JTextField();
                            panel.add(dateField);

                            panel.add(new JLabel("Nom utilisateur :"));
                            utilisateurField = new JTextField();
                            panel.add(utilisateurField);

                            panel.add(new JLabel("Mot de passe :"));
                            motDePasseField = new JTextField();
                            panel.add(motDePasseField);

                           JButton confirmerButton = new JButton("Confirmer");
                            confirmerButton.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {

                                    String nom = nomField.getText();
                                    String prenom = prenomField.getText();
                                    String telephone = telephoneField.getText();
                                    String  Email = EmailField.getText();
                                    String dateNaissance = dateField.getText();
                                    String utilisateur = utilisateurField.getText();
                                    String motDePasse = motDePasseField.getText();
                                   
                                   if( Utilisateur.SubscriptionCheck(nom,prenom,Email,telephone, dateNaissance,utilisateur, motDePasse)==false) {
                                	   JOptionPane.showMessageDialog(null, "Erreur dans la saisie", "Erreur", JOptionPane.ERROR_MESSAGE);
                                   }
                                   else {

                                	 try {
                                	   Fichier.AfficherContenuFichier("Clients");}
                                	   catch(FileNotFoundException exe) {
                                		   System.out.println("ce fichier n'existe pas");
                                	   }
                                	   inscriptionFrame.dispose(); // Fermer la fenêtre d'inscription après confirmation
                                   }
                                   }
                                   
                                }
                             });
                            panel.add(confirmerButton);

                            inscriptionFrame.add(panel);
                            inscriptionFrame.setVisible(true);
                        }
                      });

                
		    // le bouton continuer
              ValidateButton.addActionListener(new ActionListener() {
   
            	public void actionPerformed(ActionEvent e) {
            		String Utilisateurname = usernameField.getText().trim();
                    char [] clientpassword = passwordField.getPassword();
                    String passwordclient = new String(clientpassword).trim();
                	if(Utilisateur.AuthentificationClient(Utilisateurname,passwordclient)==false) {
            			
            			 JOptionPane.showMessageDialog(null, "Une erreur est survenue.", "Erreur", JOptionPane.ERROR_MESSAGE);
            		}
            		else {
            		JFrame vframe= new JFrame();
            		vframe.setSize(400, 300);
                    vframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    vframe.setResizable(false);

                    // Création du panneau
                    JPanel vpanel = new JPanel(new GridLayout(3, 1, 5, 5));

                    
                    consulterReservationButton bouton1= new consulterReservationButton();
                    vpanel.add(bouton1);
                   
                    nouvelleReservationButton bouton2= new nouvelleReservationButton();
                    vpanel.add(bouton2);
                   
                    modifierReservationButton bouton3 = new modifierReservationButton();
                    vpanel.add(bouton3);
    
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
    }
}
