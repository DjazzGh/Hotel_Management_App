package Application;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class RentButtonFrame extends javax.swing.JFrame {
    private javax.swing.JLabel BirthdateLabel;
    private javax.swing.JTextField EmailField;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JLabel FirstnameLabel;
    private javax.swing.JLabel LastnameLabel;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JLabel TopLabel;
    private javax.swing.JPanel TopPanel;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JButton confirmerButton;
    private javax.swing.JTextField dateField;
    private javax.swing.JPasswordField motDepasseField;
    private javax.swing.JTextField nomField;
    private javax.swing.JTextField prenomField;
    private javax.swing.JTextField telephoneField;
    private javax.swing.JLabel telephoneLabel;
    private javax.swing.JTextField utilisateurField;
    public RentButtonFrame() {
    	super("Inscription / connexion");
    	JButton SubscribeButton;
    	JButton ValidateButton;
    	JLabel jLabel1;
    	JLabel jLabel2;
    	JLabel jLabel3;
    	JLabel jLabel4;
    	JPanel jPanel1;
    	JPanel jPanel2;
    	JPasswordField jPasswordField1;
    	JTextField jTextField1;
    	
        jTextField1 = new javax.swing.JTextField();
        add(jTextField1);
        jLabel1 = new javax.swing.JLabel();
        add(jLabel1);
        jLabel2 = new javax.swing.JLabel();
        add(jLabel2);
        jPasswordField1 = new javax.swing.JPasswordField();
        add(jPasswordField1);
        jPanel1 = new javax.swing.JPanel();
        add(jPanel1);
        jLabel3 = new javax.swing.JLabel();
        add(jLabel3);
        jPanel2 = new javax.swing.JPanel();
        add(jPanel2);
        jLabel4 = new javax.swing.JLabel();
        add(jLabel4);
        
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);
        
        //Bouton Inscription
        SubscribeButton = new javax.swing.JButton();
        SubscribeButton .setBackground(new java.awt.Color(0, 50,0));
        SubscribeButton.setOpaque(true);
        SubscribeButton.setBorderPainted(false);
        SubscribeButton .setFont(new java.awt.Font("ITF Devanagari Marathi", 1, 18)); 
        SubscribeButton .setForeground(new java.awt.Color(255, 255, 255));
        SubscribeButton .setText("Sign up");
        add(SubscribeButton);
       

        SubscribeButton.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {

        		JFrame inscriptionFrame=new JFrame();
                TopPanel = new javax.swing.JPanel();
                TopLabel = new javax.swing.JLabel();
                FirstnameLabel = new javax.swing.JLabel();
                prenomField = new javax.swing.JTextField();
                LastnameLabel = new javax.swing.JLabel();
                telephoneLabel = new javax.swing.JLabel();
                EmailLabel = new javax.swing.JLabel();
                BirthdateLabel = new javax.swing.JLabel();
                UsernameLabel = new javax.swing.JLabel();
                PasswordLabel = new javax.swing.JLabel();
                telephoneField = new javax.swing.JTextField();
                EmailField = new javax.swing.JTextField();
                dateField = new javax.swing.JTextField();
                utilisateurField = new javax.swing.JTextField();
                nomField = new javax.swing.JTextField();
                motDepasseField = new javax.swing.JPasswordField();
                confirmerButton = new javax.swing.JButton();

                inscriptionFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                inscriptionFrame.setVisible(true);
                inscriptionFrame.setSize(450,500);
                TopPanel.setBackground(new java.awt.Color(0, 50,0));

                TopLabel.setFont(new java.awt.Font("Kannada MN", 1, 18)); // NOI18N
                TopLabel.setForeground(new java.awt.Color(255, 255, 255));
                TopLabel.setText("Enter your informations here :");

                javax.swing.GroupLayout TopPanelLayout = new javax.swing.GroupLayout(TopPanel);
                TopPanel.setLayout(TopPanelLayout);
                TopPanelLayout.setHorizontalGroup(
                    TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TopPanelLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(TopLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                TopPanelLayout.setVerticalGroup(
                    TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TopPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(TopLabel)
                        .addContainerGap(18, Short.MAX_VALUE))
                );

                FirstnameLabel.setFont(new java.awt.Font("Hoefler Text", 1, 22)); 
                FirstnameLabel.setText("First name :");

                LastnameLabel.setFont(new java.awt.Font("Hoefler Text", 1, 22)); 
                LastnameLabel.setText("Last name :");

                telephoneLabel.setFont(new java.awt.Font("Hoefler Text", 1, 22)); 
                telephoneLabel.setText("Phone number :");

                EmailLabel.setFont(new java.awt.Font("Hoefler Text", 1, 22)); 
                EmailLabel.setText("Email :");

                BirthdateLabel.setFont(new java.awt.Font("Hoefler Text", 1, 22)); 
                BirthdateLabel.setText("Date of birth :");

                UsernameLabel.setFont(new java.awt.Font("Hoefler Text", 1, 22)); 
                UsernameLabel.setText("Username :");

                PasswordLabel.setFont(new java.awt.Font("Hoefler Text", 1, 22)); 
                PasswordLabel.setText("Password :");

                confirmerButton.setBackground(new java.awt.Color(0, 50,0));
                confirmerButton.setFont(new java.awt.Font("ITF Devanagari Marathi", 1, 17)); 
                confirmerButton.setForeground(new java.awt.Color(255, 255, 255));
                confirmerButton.setText("Confirmer");
                confirmerButton.setOpaque(true);
                confirmerButton.setBorderPainted(false);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(inscriptionFrame.getContentPane());
                inscriptionFrame.getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(FirstnameLabel)
                                    .addComponent(LastnameLabel))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomField, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prenomField, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(104, 104, 104)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(UsernameLabel)
                                            .addComponent(PasswordLabel))
                                        .addGap(28, 28, 28))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(BirthdateLabel)
                                                    .addComponent(telephoneLabel))
                                                .addGap(18, 18, 18))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(EmailLabel)
                                                .addGap(59, 59, 59)))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(EmailField)
                                    .addComponent(dateField)
                                    .addComponent(utilisateurField)
                                    .addComponent(motDepasseField)
                                    .addComponent(telephoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(confirmerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(49, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FirstnameLabel)
                            .addComponent(prenomField, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LastnameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telephoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telephoneLabel))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmailLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BirthdateLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(utilisateurField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(motDepasseField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(confirmerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 39, Short.MAX_VALUE))
                );

                pack();
              

                    confirmerButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {

                            String nom = nomField.getText();
                            String prenom = prenomField.getText();
                            String telephone = telephoneField.getText();
                            String  Email = EmailField.getText();
                            String dateNaissance = dateField.getText();
                            String utilisateur = utilisateurField.getText();
                            char[] password = motDepasseField.getPassword();
                            String motDePasse = new String(password);

                           
                           if( Utilisateur.SubscriptionCheck(nom,prenom,Email,telephone,Datee.toDatee(dateNaissance),utilisateur, motDePasse)==false) {
                        	   JOptionPane.showMessageDialog(null, "Erreur dans la saisie", "Erreur", JOptionPane.ERROR_MESSAGE);
                           }
                           else {
                        	   try {
                        	   Fichier.AfficherContenuFichier("Clients");}
                        	   catch(FileNotFoundException exe) {
                        		   System.out.println("ce fichier n'existe pas");
                        	   }
                        	   inscriptionFrame.dispose(); 
                           }
                           
                        }
                     });
        	}
        });

    
        jLabel1.setFont(new java.awt.Font("Hiragino Mincho ProN", 1, 18));
        jLabel1.setText("Username :");

        jLabel2.setFont(new java.awt.Font("Hiragino Mincho ProN", 1, 18)); 
        jLabel2.setText("Password : ");

        jPanel1.setBackground(new java.awt.Color(0, 50,0));

        jLabel3.setFont(new java.awt.Font("Songti SC", 1, 20)); 
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("If you are already a client");

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

        jPanel2.setBackground(new java.awt.Color(0, 50,0));

        jLabel4.setFont(new java.awt.Font("Songti TC", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("If you are a new client");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        
        //Bouton continuer
        ValidateButton = new javax.swing.JButton();
        ValidateButton.setBackground(new java.awt.Color(0, 50,0));
        ValidateButton.setOpaque(true);
        ValidateButton.setBorderPainted(false);
        ValidateButton.setFont(new java.awt.Font("ITF Devanagari Marathi", 1, 18)); 
        ValidateButton.setForeground(new java.awt.Color(255, 255, 255));
        ValidateButton.setText("Continue");
        add(ValidateButton);
        ValidateButton.addActionListener(new ActionListener() {
        	   
        	public void actionPerformed(ActionEvent e) {
        		String Utilisateurname = jTextField1.getText().trim();
                char [] clientpassword = jPasswordField1.getPassword();
                String passwordclient = new String(clientpassword).trim();
            	if(Utilisateur.AuthentificationClient(Utilisateurname,passwordclient)==false) {
        			 JOptionPane.showMessageDialog(null, "Une erreur est survenue.", "Erreur", JOptionPane.ERROR_MESSAGE);
        		}
        		else {
        			
        			JFrame options = new JFrame();
        			options.setSize(500,400);
        	        options.setResizable(false);
        	        options.setVisible(true);
        	        
        	        JButton jButton1 = new javax.swing.JButton();
        	        JButton jButton2 = new javax.swing.JButton();
        	        JButton jButton3 = new javax.swing.JButton();

        	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        	        jButton1.setBackground(Color.white);
        	        jButton1.setFont(new java.awt.Font("Kannada MN", 1, 16)); 
        	        jButton1.setText("Make a new reservation");
        	        jButton1.setOpaque(true);
        	        jButton1.setBorderPainted(false);

        	        jButton2.setBackground(Color.white);
        	        jButton2.setFont(new java.awt.Font("Kannada MN", 1, 16)); 
        	        jButton2.setText("Change My Past Reservations");
        	        jButton2.setOpaque(true);
        	        jButton2.setBorderPainted(false);

        	        jButton3.setBackground(Color.white );
        	        jButton3.setFont(new java.awt.Font("Kannada MN", 1, 16)); 
        	        jButton3.setText("Check My Past Reservations");
        	        jButton3.setOpaque(true);
        	        jButton3.setBorderPainted(false);
        	        
        	        ImageIcon imageIcon = new ImageIcon("Logo.png");
        	        Image resizedImage = imageIcon.getImage().getScaledInstance(500, 400, Image.SCALE_SMOOTH);
        	        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
        	        JLabel imageLabel = new JLabel(resizedImageIcon);
        	        imageLabel.setBounds(0, 0, 500, 400);
        	        imageLabel.setOpaque(false);
  
        	        
        	        
        	        options.add(jButton2);
        	        options.add(jButton1);
        	        options.add(jButton3);
        	        options.add(imageLabel);
        	        dispose();
        	        
        	        
        	        javax.swing.GroupLayout layout2 = new javax.swing.GroupLayout(options.getContentPane());
        	        options.getContentPane().setLayout(layout2);
        	        layout2.setHorizontalGroup(
        	            layout2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        	            .addGroup(layout2.createSequentialGroup()
        	                .addGap(85, 85, 85)
        	                .addGroup(layout2.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
        	                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        	                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        	                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        	                .addContainerGap(92, Short.MAX_VALUE))
        	        );
        	        layout2.setVerticalGroup(
        	            layout2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout2.createSequentialGroup()
        	                .addContainerGap(83, Short.MAX_VALUE)
        	                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
        	                .addGap(26, 26, 26)
        	                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
        	                .addGap(29, 29, 29)
        	                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
        	                .addGap(84, 84, 84))
        	        );
        		}
        		}
            });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addGap(89, 89, 89))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(SubscribeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(ValidateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(ValidateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(SubscribeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();

    } } 
