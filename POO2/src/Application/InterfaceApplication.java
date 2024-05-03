package Application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class InterfaceApplication extends javax.swing.JFrame {
	 private javax.swing.JPanel InsidePoolPanel;
	    private javax.swing.JLabel OurservicesLabel;
	    private javax.swing.JPanel OutsidePoolPanel;
	    private javax.swing.JPanel RestaurantsPanel;
	    private javax.swing.JPanel ShowsPanel;
	    private javax.swing.JPanel SpaPanel;
	    private javax.swing.JPanel SpaPanel1;
	    private javax.swing.JLabel SportLabel;
	    private javax.swing.JLabel SportLabel2;
	    private javax.swing.JLabel SportLabel3;
	    private javax.swing.JLabel insidepoollabel;
	    private javax.swing.JPanel middlepanel;
	    private javax.swing.JLabel outsidepoollabel;
	    private javax.swing.JPanel panelonthetop;
	    private javax.swing.JLabel restaurantslabel;
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
	   private javax.swing.JPanel FacebookPanel1;
	    private javax.swing.JPanel InstagramPanel;
	    private javax.swing.JPanel YoutubePanel;
	    private javax.swing.JLabel jLabel;
	    private javax.swing.JLabel jLabel10;
	    private javax.swing.JLabel jLabel11;
	    private javax.swing.JLabel jLabel12;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JLabel jLabel5;
	    private javax.swing.JLabel jLabel6;
	    private javax.swing.JLabel jLabel7;
	    private javax.swing.JLabel jLabel8;
	    private javax.swing.JLabel jLabel9;
	    private javax.swing.JPanel jPanel;
	    private javax.swing.JPanel jPanel2;
    private JLabel imageLabel = new JLabel();    
    private int currentImage = 0;
    private String[] imagePaths = {"reception3.jpeg","entrance.jpeg","plage5.jpeg","chambre2.jpeg", "hotelpic2.jpeg"};
    
      
    public InterfaceApplication() {
    	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        
        Fichier.removeDuplicates("Chambres");
        Fichier.removeDuplicates("Clients");
        Fichier.removeDuplicates("Reservations_Clients");
    	try {
    		Fichier.removeBlankLinesInPlace("Chambres");
    		Fichier.removeBlankLinesInPlace("Clients");
    		Fichier.removeBlankLinesInPlace("Reservations_Clients");
    		}catch(IOException ex) {
         		System.out.println("Erreur")  ;  	}


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
        rentButton.setFont(new java.awt.Font("Kannada MN", 1, 18)); 
        rentButton.setText("Rent your rooms here");
        //rentButton.setForeground(Color.white);
        //rentButton.setBackground(new Color(10,50,0));
        //rentButton.setOpaque(false);
        //rentButton.setBorderPainted(true);
        rentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	RentButtonFrame rentFrame = new RentButtonFrame();
            	
      
    } });
        
    	//Panel et ecriture de welcome to our hotel
  	  jPanel1 = new javax.swing.JPanel();
  	  jPanel1.setBackground(new java.awt.Color(0, 0, 0));
  	  jLabel1 = new javax.swing.JLabel();
        jLabel1.setFont(new java.awt.Font("Songti TC", 0, 23)); 
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome to Grandview palace hotel");
        
        
        // Create a JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(850, 500)); 
        MainPanel.setBounds(-20,-20,850,500);

        imageLabel.setBounds(-50, 0, 900, 600);
        layeredPane.add(imageLabel, Integer.valueOf(1)); 

        rightButton.setBounds(800, 200, 40, 150); 
        layeredPane.add(rightButton, Integer.valueOf(2)); 

        rentButton.setBounds(250, 440, 300, 50); 
        layeredPane.add(rentButton, Integer.valueOf(2)); 
        
        jPanel1.setBounds(200, 0, 410, 50); 
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
        jButton3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFrame frameservices = new JFrame();
            	frameservices.setSize(700, 540);    
            	frameservices.setResizable(false);
            	panelonthetop = new javax.swing.JPanel();
                OurservicesLabel = new javax.swing.JLabel();
                middlepanel = new javax.swing.JPanel();
                SportLabel = new javax.swing.JLabel();
                insidepoollabel = new javax.swing.JLabel();
                SportLabel2 = new javax.swing.JLabel();
                SportLabel3 = new javax.swing.JLabel();
                outsidepoollabel = new javax.swing.JLabel();
                restaurantslabel = new javax.swing.JLabel();
                ShowsPanel = new javax.swing.JPanel();
                SpaPanel = new javax.swing.JPanel();
                SpaPanel1 = new javax.swing.JPanel();
                InsidePoolPanel = new javax.swing.JPanel();
                RestaurantsPanel = new javax.swing.JPanel();
                OutsidePoolPanel = new javax.swing.JPanel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                panelonthetop.setBackground(new java.awt.Color(0, 50, 0));

                OurservicesLabel.setFont(new java.awt.Font("Krungthep", 2, 18)); // NOI18N
                OurservicesLabel.setForeground(new java.awt.Color(255, 255, 255));
                OurservicesLabel.setText("__ Our services __");

                javax.swing.GroupLayout panelonthetopLayout = new javax.swing.GroupLayout(panelonthetop);
                panelonthetop.setLayout(panelonthetopLayout);
                panelonthetopLayout.setHorizontalGroup(
                    panelonthetopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelonthetopLayout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(OurservicesLabel)
                        .addContainerGap(270, Short.MAX_VALUE))
                );
                panelonthetopLayout.setVerticalGroup(
                    panelonthetopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelonthetopLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(OurservicesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))
                );

                middlepanel.setBackground(new java.awt.Color(0, 50, 0));

                javax.swing.GroupLayout middlepanelLayout = new javax.swing.GroupLayout(middlepanel);
                middlepanel.setLayout(middlepanelLayout);
                middlepanelLayout.setHorizontalGroup(
                    middlepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, 27, Short.MAX_VALUE)
                );
                middlepanelLayout.setVerticalGroup(
                    middlepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, 0, Short.MAX_VALUE)
                );

                SportLabel.setFont(new java.awt.Font("Krungthep", 1, 14)); // NOI18N
                SportLabel.setText("Gym ");

                insidepoollabel.setFont(new java.awt.Font("Krungthep", 1, 14)); // NOI18N
                insidepoollabel.setText("Inside pool");

                SportLabel2.setFont(new java.awt.Font("Krungthep", 1, 14)); // NOI18N
                SportLabel2.setText("SPA");

                SportLabel3.setFont(new java.awt.Font("Krungthep", 1, 14)); // NOI18N
                SportLabel3.setText("Shows");

                outsidepoollabel.setFont(new java.awt.Font("Krungthep", 1, 14)); // NOI18N
                outsidepoollabel.setText("Outside pool");

                restaurantslabel.setFont(new java.awt.Font("Krungthep", 1, 14)); // NOI18N
                restaurantslabel.setText("Restaurants");

                ShowsPanel.setBackground(new java.awt.Color(153, 51, 255));
                ImageIcon imageshow = new ImageIcon("show.jpeg");
                Image resizedImageshow = imageshow.getImage().getScaledInstance(300, 190, Image.SCALE_SMOOTH);
                ImageIcon resizedImageIconshow = new ImageIcon(resizedImageshow);
                JLabel imageLabelshow = new JLabel(resizedImageIconshow);
                imageLabelshow.setBounds(-20, -20, 300, 190);  
                ShowsPanel.add(imageLabelshow);
                
                javax.swing.GroupLayout ShowsPanelLayout = new javax.swing.GroupLayout(ShowsPanel);
                ShowsPanel.setLayout(ShowsPanelLayout);
                ShowsPanelLayout.setHorizontalGroup(
                    ShowsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, 0, Short.MAX_VALUE)
                );
                ShowsPanelLayout.setVerticalGroup(
                    ShowsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, 144, Short.MAX_VALUE)
                );

                SpaPanel.setBackground(new java.awt.Color(204, 0, 0));
                ImageIcon imagegym = new ImageIcon("Gym.jpeg");
                Image resizedImagegym = imagegym.getImage().getScaledInstance(300, 150, Image.SCALE_SMOOTH);
                ImageIcon resizedImageIcongym = new ImageIcon(resizedImagegym);
                JLabel imageLabelgym = new JLabel(resizedImageIcongym);
                imageLabelgym.setBounds(0, 0, 300, 110);  
                SpaPanel.add(imageLabelgym);

                javax.swing.GroupLayout SpaPanelLayout = new javax.swing.GroupLayout(SpaPanel);
                SpaPanel.setLayout(SpaPanelLayout);
                SpaPanelLayout.setHorizontalGroup(
                    SpaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, 0, Short.MAX_VALUE)
                );
                SpaPanelLayout.setVerticalGroup(
                    SpaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, 105, Short.MAX_VALUE)
                );

                SpaPanel1.setBackground(new java.awt.Color(51, 0, 255));
                ImageIcon imagespa = new ImageIcon("spa.jpeg");
                Image resizedImagespa = imagespa.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
                ImageIcon resizedImageIconspa = new ImageIcon(resizedImagespa);
                JLabel imageLabelspa = new JLabel(resizedImageIconspa);
                imageLabelspa.setBounds(0, 0, 250, 130);  
                SpaPanel1.add(imageLabelspa);
                
                javax.swing.GroupLayout SpaPanel1Layout = new javax.swing.GroupLayout(SpaPanel1);
                SpaPanel1.setLayout(SpaPanel1Layout);
                SpaPanel1Layout.setHorizontalGroup(
                    SpaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, 0, Short.MAX_VALUE)
                );
                SpaPanel1Layout.setVerticalGroup(
                    SpaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, 116, Short.MAX_VALUE)
                );

                InsidePoolPanel.setBackground(new java.awt.Color(102, 204, 255));
                ImageIcon imageipool = new ImageIcon("insidePool2.jpeg");
                Image resizedImageipool = imageipool.getImage().getScaledInstance(390, 130, Image.SCALE_SMOOTH);
                ImageIcon resizedImageIconipool = new ImageIcon(resizedImageipool);
                JLabel imageLabelipool = new JLabel(resizedImageIconipool);
                imageLabelipool.setBounds(0, 0, 390, 130);  
                InsidePoolPanel.add(imageLabelipool);
                
                javax.swing.GroupLayout InsidePoolPanelLayout = new javax.swing.GroupLayout(InsidePoolPanel);
                InsidePoolPanel.setLayout(InsidePoolPanelLayout);
                InsidePoolPanelLayout.setHorizontalGroup(
                    InsidePoolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, 0, Short.MAX_VALUE)
                );
                InsidePoolPanelLayout.setVerticalGroup(
                    InsidePoolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, 125, Short.MAX_VALUE)
                );

                RestaurantsPanel.setBackground(new java.awt.Color(0, 102, 102));
                ImageIcon imagerest = new ImageIcon("restaurant.jpeg");
                Image resizedImagerest = imagerest.getImage().getScaledInstance(390, 130, Image.SCALE_SMOOTH);
                ImageIcon resizedImageIconrest = new ImageIcon(resizedImagerest);
                JLabel imageLabelrest = new JLabel(resizedImageIconrest);
                imageLabelrest.setBounds(0, 0, 390, 130);  
                RestaurantsPanel.add(imageLabelrest);
                
                javax.swing.GroupLayout RestaurantsPanelLayout = new javax.swing.GroupLayout(RestaurantsPanel);
                RestaurantsPanel.setLayout(RestaurantsPanelLayout);
                RestaurantsPanelLayout.setHorizontalGroup(
                    RestaurantsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, 0, Short.MAX_VALUE)
                );
                RestaurantsPanelLayout.setVerticalGroup(
                    RestaurantsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, 112, Short.MAX_VALUE)
                );

                OutsidePoolPanel.setBackground(new java.awt.Color(51, 51, 51));
                ImageIcon imageopool = new ImageIcon("OutsidePool.jpeg");
                Image resizedImageopool = imageopool.getImage().getScaledInstance(390, 130, Image.SCALE_SMOOTH);
                ImageIcon resizedImageIconopool = new ImageIcon(resizedImageopool);
                JLabel imageLabelopool = new JLabel(resizedImageIconopool);
                imageLabelopool.setBounds(0, 0, 390, 130);  
                OutsidePoolPanel.add(imageLabelopool);
                
                javax.swing.GroupLayout OutsidePoolPanelLayout = new javax.swing.GroupLayout(OutsidePoolPanel);
                OutsidePoolPanel.setLayout(OutsidePoolPanelLayout);
                OutsidePoolPanelLayout.setHorizontalGroup(
                    OutsidePoolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, 386, Short.MAX_VALUE)
                );
                OutsidePoolPanelLayout.setVerticalGroup(
                    OutsidePoolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, 125, Short.MAX_VALUE)
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frameservices.getContentPane());
                frameservices.getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelonthetop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(105, 105, 105)
                                                .addComponent(SportLabel))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(105, 105, 105)
                                                .addComponent(SportLabel3)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(SpaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(SpaPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ShowsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(12, 12, 12))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(SportLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(middlepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(InsidePoolPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(insidepoollabel)
                            .addComponent(outsidepoollabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(OutsidePoolPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(restaurantslabel)
                            .addComponent(RestaurantsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelonthetop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SportLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SpaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SportLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SpaPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SportLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ShowsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(insidepoollabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(InsidePoolPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(outsidepoollabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(OutsidePoolPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(restaurantslabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(RestaurantsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 15, Short.MAX_VALUE))
                                    .addComponent(middlepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())))
                );

                pack();
                frameservices.setVisible(true) ;
        	}
        });

        
        //Bouton About
        jButton5 = new javax.swing.JButton();
        jButton5.setFont(new java.awt.Font("Kannada MN", 1, 13)); 
        jButton5.setText("About");
        jButton5.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
        		 JFrame aboutframe = new JFrame();
        		 aboutframe.setSize(500,440);
        		 aboutframe.setResizable(false);
        		         jPanel = new javax.swing.JPanel();
        		         jLabel = new javax.swing.JLabel();
        		         jPanel2 = new javax.swing.JPanel();
        		         jLabel2 = new javax.swing.JLabel();
        		         jLabel3 = new javax.swing.JLabel();
        		         jLabel4 = new javax.swing.JLabel();
        		         jLabel5 = new javax.swing.JLabel();
        		         jLabel6 = new javax.swing.JLabel();
        		         jLabel7 = new javax.swing.JLabel();
        		         jLabel8 = new javax.swing.JLabel();
        		         jLabel9 = new javax.swing.JLabel();
        		         jLabel10 = new javax.swing.JLabel();
        		         jLabel11 = new javax.swing.JLabel();
        		         jLabel12 = new javax.swing.JLabel();
        		         YoutubePanel = new javax.swing.JPanel();
        		         InstagramPanel = new javax.swing.JPanel();
        		         FacebookPanel1 = new javax.swing.JPanel();

        		         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        		         jPanel.setBackground(new java.awt.Color(0, 50, 0));

        		         jLabel.setFont(new java.awt.Font("Mshtakan", 3, 24)); // NOI18N
        		         jLabel.setForeground(new java.awt.Color(255, 255, 255));
        		         jLabel.setText("-- For more informations --");

        		         javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel);
        		         jPanel.setLayout(jPanel1Layout);
        		         jPanel1Layout.setHorizontalGroup(
        		             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        		             .addGroup(jPanel1Layout.createSequentialGroup()
        		                 .addGap(96, 96, 96)
        		                 .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
        		                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        		         );
        		         jPanel1Layout.setVerticalGroup(
        		             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        		             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        		                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        		                 .addComponent(jLabel)
        		                 .addGap(15, 15, 15))
        		         );

        		         jPanel2.setBackground(new java.awt.Color(0, 50, 0));

        		         jLabel2.setFont(new java.awt.Font("Mshtakan", 3, 24)); // NOI18N
        		         jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        		         jLabel2.setText("-- Our social media --");

        		         javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        		         jPanel2.setLayout(jPanel2Layout);
        		         jPanel2Layout.setHorizontalGroup(
        		             jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        		             .addGroup(jPanel2Layout.createSequentialGroup()
        		                 .addGap(122, 122, 122)
        		                 .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
        		                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        		         );
        		         jPanel2Layout.setVerticalGroup(
        		             jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        		             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        		                 .addContainerGap(15, Short.MAX_VALUE)
        		                 .addComponent(jLabel2)
        		                 .addGap(15, 15, 15))
        		         );

        		         jLabel3.setFont(new java.awt.Font("Kannada MN", 1, 21)); // NOI18N
        		         jLabel3.setText("Email :");

        		         jLabel4.setFont(new java.awt.Font("Kannada MN", 1, 21)); // NOI18N
        		         jLabel4.setText("Instagram :");

        		         jLabel5.setFont(new java.awt.Font("Kannada MN", 1, 21)); // NOI18N
        		         jLabel5.setText("Phone Number :");

        		         jLabel6.setFont(new java.awt.Font("Kannada MN", 1, 21)); // NOI18N
        		         jLabel6.setText("Youtube :");

        		         jLabel7.setFont(new java.awt.Font("Kannada MN", 1, 21)); // NOI18N
        		         jLabel7.setText("Facebook :");

        		         jLabel8.setFont(new java.awt.Font("Hiragino Maru Gothic ProN", 0, 16)); // NOI18N
        		         jLabel8.setText("(800) 492-9520");

        		         jLabel9.setFont(new java.awt.Font("Hiragino Maru Gothic ProN", 0, 16)); // NOI18N
        		         jLabel9.setText("GrandviewPalace@gmail.com");

        		         jLabel10.setFont(new java.awt.Font("Hiragino Maru Gothic ProN", 0, 16)); // NOI18N
        		         jLabel10.setText("GrandView_Palace_Hotel");

        		         jLabel11.setFont(new java.awt.Font("Hiragino Maru Gothic ProN", 0, 16)); // NOI18N
        		         jLabel11.setText("GrandView Palace official");

        		         jLabel12.setFont(new java.awt.Font("Hiragino Maru Gothic ProN", 0, 16)); // NOI18N
        		         jLabel12.setText("GrandviewpalaceHotel");

        		         YoutubePanel.setBackground(new java.awt.Color(255, 51, 51));
        		         ImageIcon imageIcon1 = new ImageIcon("youtube_logo.jpeg");
        		         Image resizedImage1 = imageIcon1.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        		         ImageIcon resizedImageIcon1 = new ImageIcon(resizedImage1);
        		         JLabel imageLabel1 = new JLabel(resizedImageIcon1);
        		         imageLabel1.setBounds(0, 0, 50, 50);  
        		         YoutubePanel.add(imageLabel1);
        		         
        		         javax.swing.GroupLayout YoutubePanelLayout = new javax.swing.GroupLayout(YoutubePanel);
        		         YoutubePanel.setLayout(YoutubePanelLayout);
        		         YoutubePanelLayout.setHorizontalGroup(
        		             YoutubePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        		             .addGap(0, 53, Short.MAX_VALUE)
        		         );
        		         YoutubePanelLayout.setVerticalGroup(
        		             YoutubePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        		             .addGap(0, 42, Short.MAX_VALUE)
        		         );

        		         InstagramPanel.setBackground(new java.awt.Color(255, 51, 255));
        		         ImageIcon imageIcon2 = new ImageIcon("instagram_logo.jpeg");
        		         Image resizedImage2 = imageIcon2.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        		         ImageIcon resizedImageIcon2 = new ImageIcon(resizedImage2);
        		         JLabel imageLabel2 = new JLabel(resizedImageIcon2);
        		         imageLabel2.setBounds(0, -4, 50, 50);  
        		         InstagramPanel.add(imageLabel2);
        		         
        		         javax.swing.GroupLayout InstagramPanelLayout = new javax.swing.GroupLayout(InstagramPanel);
        		         InstagramPanel.setLayout(InstagramPanelLayout);
        		         InstagramPanelLayout.setHorizontalGroup(
        		             InstagramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        		             .addGap(0, 53, Short.MAX_VALUE)
        		         );
        		         InstagramPanelLayout.setVerticalGroup(
        		             InstagramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        		             .addGap(0, 42, Short.MAX_VALUE)
        		         );

        		         FacebookPanel1.setBackground(new java.awt.Color(59, 89, 152));
        		         ImageIcon imageIcon = new ImageIcon("facebook_logo.png");
        		         Image resizedImage = imageIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        		         ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
        		         JLabel imageLabel = new JLabel(resizedImageIcon);
        		         imageLabel.setBounds(0, 0, 40, 40);  
        		         FacebookPanel1.add(imageLabel);

        		         javax.swing.GroupLayout FacebookPanel1Layout = new javax.swing.GroupLayout(FacebookPanel1);
        		         FacebookPanel1.setLayout(FacebookPanel1Layout);
        		         FacebookPanel1Layout.setHorizontalGroup(
        		             FacebookPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        		             .addGap(0, 53, Short.MAX_VALUE)
        		         );
        		         FacebookPanel1Layout.setVerticalGroup(
        		             FacebookPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        		             .addGap(0, 42, Short.MAX_VALUE)
        		         );

        		         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(aboutframe.getContentPane());
        		         aboutframe.getContentPane().setLayout(layout);
        		         layout.setHorizontalGroup(
        		             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        		             .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        		             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        		                 .addContainerGap(77, Short.MAX_VALUE)
        		                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        		                     .addComponent(InstagramPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        		                     .addComponent(YoutubePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        		                     .addComponent(FacebookPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        		                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        		                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        		                     .addGroup(layout.createSequentialGroup()
        		                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        		                             .addComponent(jLabel7)
        		                             .addComponent(jLabel6))
        		                         .addGap(3, 3, 3))
        		                     .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
        		                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        		                     .addGroup(layout.createSequentialGroup()
        		                         .addGap(14, 14, 14)
        		                         .addComponent(jLabel11))
        		                     .addGroup(layout.createSequentialGroup()
        		                         .addGap(18, 18, 18)
        		                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        		                             .addComponent(jLabel10)
        		                             .addComponent(jLabel12))))
        		                 .addGap(66, 66, 66))
        		             .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        		             .addGroup(layout.createSequentialGroup()
        		                 .addContainerGap()
        		                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        		                     .addGroup(layout.createSequentialGroup()
        		                         .addComponent(jLabel5)
        		                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        		                         .addComponent(jLabel8))
        		                     .addGroup(layout.createSequentialGroup()
        		                         .addComponent(jLabel3)
        		                         .addGap(18, 18, 18)
        		                         .addComponent(jLabel9)))
        		                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        		         );
        		         layout.setVerticalGroup(
        		             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        		             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        		                 .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        		                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        		                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        		                     .addComponent(InstagramPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        		                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        		                         .addComponent(jLabel4)
        		                         .addComponent(jLabel10)))
        		                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        		                     .addGroup(layout.createSequentialGroup()
        		                         .addGap(7, 7, 7)
        		                         .addComponent(FacebookPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        		                     .addGroup(layout.createSequentialGroup()
        		                         .addGap(18, 18, 18)
        		                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        		                             .addComponent(jLabel7)
        		                             .addComponent(jLabel12))))
        		                 .addGap(5, 5, 5)
        		                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        		                     .addGroup(layout.createSequentialGroup()
        		                         .addGap(11, 11, 11)
        		                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        		                             .addComponent(jLabel6)
        		                             .addComponent(jLabel11)))
        		                     .addComponent(YoutubePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        		                 .addGap(18, 18, 18)
        		                 .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        		                 .addGap(18, 18, 18)
        		                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        		                     .addComponent(jLabel5)
        		                     .addComponent(jLabel8))
        		                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        		                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        		                     .addComponent(jLabel3)
        		                     .addComponent(jLabel9))
        		                 .addContainerGap(10, Short.MAX_VALUE))
        		         );

        		         pack();
        		         aboutframe.setVisible(true);
        	 }
        });

        
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
        Image newimg = image.getScaledInstance(1000, 800,  java.awt.Image.SCALE_SMOOTH); 
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

