package Application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class InterfaceApplication extends javax.swing.JFrame {
    private javax.swing.JPanel ImagePanel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel TopPanel;
    private javax.swing.JButton loginButton;
    private javax.swing.JButton rightButton;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton rentButton;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private JLabel imageLabel = new JLabel();    
    private int currentImage = 0;
    private String[] imagePaths = {"reception3.jpeg","entrance.jpeg","plage5.jpeg","chambre2.jpeg", "hotelpic2.jpeg"};
    
      
    public InterfaceApplication() {
    	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);


    	MainPanel = new javax.swing.JPanel();
    	 MainPanel.setLayout(new BorderLayout());
    	 
        //Bouton fleche droite
    	rightButton = new javax.swing.JButton();
        rightButton.setText(">");
        rightButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == rightButton) {
                    showNextImage();
                }
            }
        });
        showImage(currentImage);

        
        //Rent your rooms button
        rentButton = new javax.swing.JButton();
        rentButton.setFont(new java.awt.Font("Kannada MN", 1, 18)); // NOI18N
        rentButton.setText("Rent your rooms here");
        rentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	RentButtonFrame rentFrame = new RentButtonFrame();
            	
      
    } });
        
    	//Panel et ecriture de welcome to our hotel
  	  jPanel1 = new javax.swing.JPanel();
  	  jPanel1.setBackground(new java.awt.Color(0, 0, 153));
  	  jLabel1 = new javax.swing.JLabel();
        jLabel1.setFont(new java.awt.Font("PT Serif", 0, 21)); 
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome to Grandview palace hotel");
        
        
        // Create a JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(850, 500)); 
        MainPanel.setBounds(-20,-20,850,500);

        imageLabel.setBounds(-50, 0, 900, 600);
        layeredPane.add(imageLabel, Integer.valueOf(1)); 

        rightButton.setBounds(800, 225, 40, 100); 
        layeredPane.add(rightButton, Integer.valueOf(2)); 

        rentButton.setBounds(250, 440, 300, 50); 
        layeredPane.add(rentButton, Integer.valueOf(2)); 
        
        jPanel1.setBounds(200, 0, 360, 50); 
        jPanel1.setBackground(new Color(0,50,0));
        layeredPane.add(jPanel1, Integer.valueOf(2)); 
      

        MainPanel.add(layeredPane);
        

        
        //Icon dans le coin de l'image
    	 ImagePanel = new javax.swing.JPanel();
        ImageIcon imageIcon = new ImageIcon("Logo.png");
        Image resizedImage = imageIcon.getImage().getScaledInstance(100, 95, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
        JLabel imageLabel = new JLabel(resizedImageIcon);
        imageLabel.setBounds(-20, -10, 120, 100);  // Maintain same bounds for positioning
        ImagePanel.add(imageLabel);

        //Bouton Admin
        loginButton = new javax.swing.JButton();
        loginButton.setFont(new java.awt.Font("Kannada MN", 1, 14)); // NOI18N
        loginButton.setText("Login\nas Admin");
        
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        LoginButton frame = new LoginButton(); 
        frame.setVisible(true);}});

        //Top Panel
        TopPanel = new javax.swing.JPanel();
        TopPanel.setBackground(new java.awt.Color(0, 50,0));
        
        
        //Bouton Services
        jButton3 = new javax.swing.JButton();
        jButton3.setFont(new java.awt.Font("Kannada MN", 1, 13)); // NOI18N
        jButton3.setText("Services");

        
        //Bouton About
        jButton5 = new javax.swing.JButton();
        jButton5.setFont(new java.awt.Font("Kannada MN", 1, 13)); 
        jButton5.setText("About");

        
        javax.swing.GroupLayout ImagePanelLayout = new javax.swing.GroupLayout(ImagePanel);
        ImagePanel.setLayout(ImagePanelLayout);
        ImagePanelLayout.setHorizontalGroup(
            ImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );
        ImagePanelLayout.setVerticalGroup(
            ImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout TopPanelLayout = new javax.swing.GroupLayout(TopPanel);
        TopPanel.setLayout(TopPanelLayout);
        TopPanelLayout.setHorizontalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopPanelLayout.createSequentialGroup()
                .addComponent(ImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(26, 26, 26)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loginButton)
                .addContainerGap())
        );
        TopPanelLayout.setVerticalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TopPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(loginButton))
                    .addGroup(TopPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
            .addComponent(ImagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );



        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }    
    private void showNextImage() {
        currentImage = (currentImage + 1) % imagePaths.length;
        showImage(currentImage);
    }
    private void showImage(int index) {
        ImageIcon icon = new ImageIcon(imagePaths[index]);
        Image image = icon.getImage(); 
        Image newimg = image.getScaledInstance(900, 600,  java.awt.Image.SCALE_SMOOTH); 
        icon = new ImageIcon(newimg);         
        imageLabel.setIcon(icon);


    }


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfaceApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
            	
                new InterfaceApplication().setVisible(true);
            }
            });
        }
    }

