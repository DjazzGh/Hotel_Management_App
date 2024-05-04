package Application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class consulterReservationButton extends JButton {
    static String toutelesreservations;
    private javax.swing.JPanel BottomPanel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton RetourButton;
    private javax.swing.JPanel TopPanel;

    public consulterReservationButton() {

        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JFrame frame = new JFrame("Reservations");
                //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                frame.setResizable(true);
                frame.setLayout(new BorderLayout());
                frame.setPreferredSize(new java.awt.Dimension(700, 500));
                 MainPanel = new javax.swing.JPanel();
                 
                 TopPanel = new javax.swing.JPanel();
                 TopPanel.setBackground(new java.awt.Color(51, 102, 0));
                 frame.add(TopPanel,BorderLayout.NORTH);
                 TopPanel.setLayout(new BorderLayout());
                
                String a = RentButtonFrame.line_ID;
                char[] a2 = a.toCharArray();
                char IDchar = a2[0];
                String ID = String.valueOf(IDchar);

                try {
                    List<String> reservations = Fichier.findLinesWithPrefix("Reservations_Clients", ID);
                    
                    String filename = "Reservations_temporaires";

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                        for (String string : reservations) {
                            writer.write(string);
                            writer.newLine();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    String[] columnNames = {"Reservation ID", "Start Date", "End Date", "Room Number"};
                    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

                    try (BufferedReader br = new BufferedReader(new FileReader("Reservations_temporaires"))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            String[] data = line.split(" ");
                            tableModel.addRow(data);
                        }
                    }

                    JTable table = new JTable(tableModel);
                    JScrollPane scrollPane = new JScrollPane(table);

                    TopPanel.add(scrollPane,BorderLayout.CENTER);

                    Facture.calculer_la_facture_des_clients();
                    List<String >facture =Fichier.findLinesWithPrefix("Factures_Clients", ID);
                    float total_price = 0.0f; 


                 for (String line : facture) {
                     String[] parts = line.split(" ");
                     if (parts.length == 2) { 
                         try {
                             float price = Float.parseFloat(parts[1]);
                             total_price += price;
                         } catch (NumberFormatException ex) {
                             System.out.println("Error parsing price in line: " + line);
                         }
                     }
                 }

                 	JLabel facturelabel=new JLabel("Facture : "+ total_price+" dollars");
                    facturelabel.setForeground(Color.white);
                    facturelabel.setFont(new Font("Kannada MN", Font.BOLD, 16));
                    TopPanel.add(facturelabel,BorderLayout.SOUTH);
            
                    BottomPanel = new javax.swing.JPanel();
                    BottomPanel.setBackground(new java.awt.Color(51, 102, 0));
                    
                    BottomPanel.setLayout(new BorderLayout());
                    
                    RetourButton = new javax.swing.JButton();
                    RetourButton.setFont(new java.awt.Font("Myanmar MN", 1, 16)); 
                    RetourButton.setForeground(new java.awt.Color(51, 102, 0));
                    RetourButton.setText("Retour");
                    BottomPanel.add(RetourButton,BorderLayout.EAST);
                    frame.add(BottomPanel,BorderLayout.SOUTH);
                    frame.pack();
                    frame.setVisible(true);
                    RetourButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                        	frame.dispose();
                        }});

            }catch(IOException ex) {
            	System.out.println("Erreur");
            }
        }
    });
}
}
