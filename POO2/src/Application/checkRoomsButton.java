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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class checkRoomsButton extends JButton{
public checkRoomsButton() {
	super("GERER LES CHAMBRES ");
	  setBounds(600, 50, 100, 100);
	  setHorizontalAlignment(JButton.CENTER);
	  setVerticalAlignment(JButton.BOTTOM);
	  setOpaque(true);
	  setBorderPainted(false);
	  setForeground(Color.white);
	  setFont(new Font("Georgia", Font.BOLD, 25));
	  setBackground(new Color(200, 0, 0));

	  addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {

			  JFrame frameChambre = new JFrame(" liste des chambres");
			  frameChambre.setVisible(true);
			  frameChambre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			  frameChambre.getContentPane().setBackground(new Color(255, 255, 255));
			  frameChambre.setSize(800, 400);


			  Chambre c1 = new Chambre(1, Type.Simple, true, 1200.09);
			  Chambre c2 = new Chambre(2, Type.Double, false, 120.0);
			  Chambre c3 = new Chambre(3, Type.Simple, true, 12.00);
			  Chambre c4 = new Chambre(4, Type.Simple, true, 12.00);
			  Hotel.getListChambres().add(c1);
			  Hotel.getListChambres().add(c2);
			  Hotel.getListChambres().add(c3);
			  Hotel.getListChambres().add(c4);

			  System.out.println("Affichage de la liste des chambres :");
			  for (Chambre chambre : Hotel.listChambres) {
				  System.out.println("(" + chambre.getprix() + ")" + "(" + chambre.getdisponibiltéchambre() + ")" + "(" + chambre.gettypechambre() + ")" + "(" + chambre.getnumerochambre() + ")");
			  }

			  String[] columnNames = {"Numéro de la chambre", "type de la chambre", "disponibilite", "Prix"};
			  JTable table = new JTable(new ChambreTableModel(Hotel.getListChambres()));
			  for (int i = 0; i < columnNames.length; i++) {
				  table.getColumnModel().getColumn(i).setHeaderValue(columnNames[i]);
			  }

//Ajouter le JTable à un JScrollPane
			  JScrollPane scrollPane = new JScrollPane(table);


			  JPanel panel11 = new JPanel();
			  panel11.setBounds(500, 500, 500, 500);
			  panel11.setBackground(Color.white);
			  panel11.setLayout(new BorderLayout());
			  panel11.add(scrollPane, BorderLayout.NORTH);
			  //frameChambre.getContentPane().add(panel11);


			  JPanel p1 = new JPanel(new GridLayout(1, 2));
			  for (int i = 0; i < 2; i++) {
				  JButton b1 = new JButton();
				  if (i == 0) {
					  b1.setText(" + ajouter des chambres");
					  b1.setBounds(250, 250, 250, 250);
					  b1.setOpaque(true);
					  b1.setBorderPainted(false);
					  b1.setForeground(Color.white);
					  b1.setFont(new Font("Georgia", Font.BOLD, 15));
					  b1.setBackground(new Color(200, 0, 0));
					  b1.addActionListener(new ActionListener() {
						  @Override
						  public void actionPerformed(ActionEvent e) {
							  JFrame frameAjouter = new JFrame("ajouter des chambres");
							  frameAjouter.setSize(450, 450);
							  frameAjouter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							  frameAjouter.setVisible(true);
							  frameAjouter.getContentPane().setBackground(new Color(255, 255, 255));

							  JLabel l1 = new JLabel(" numero de la chambre");
							  l1.setFont(new Font("Georgia", Font.ROMAN_BASELINE, 19));
							  l1.setForeground(Color.white);
							  JTextField j1 = new JTextField();
							  frameAjouter.setLayout(new GridLayout(5, 1));
							  frameAjouter.getContentPane().setBackground(new Color(0, 50, 0));
							  frameAjouter.add(l1);
							  frameAjouter.add(j1);

							  JLabel l2 = new JLabel(" type de la chambre");
							  l2.setFont(new Font("Georgia", Font.ROMAN_BASELINE, 19));
							  l2.setForeground(Color.white);
							  JTextField j2 = new JTextField();
							  frameAjouter.add(l2);
							  frameAjouter.add(j2);

							  JLabel l3 = new JLabel("   disponibilite");
							  l3.setFont(new Font("Georgia", Font.ROMAN_BASELINE, 19));
							  l3.setForeground(Color.white);
							  JTextField j3 = new JTextField();
							  frameAjouter.add(l3);
							  frameAjouter.add(j3);

							  JLabel l4 = new JLabel("       prix");
							  l4.setFont(new Font("Georgia", Font.ROMAN_BASELINE, 19));
							  l4.setForeground(Color.white);
							  JTextField j4 = new JTextField();
							  frameAjouter.add(l4);
							  frameAjouter.add(j4);

							  JButton b4 = new JButton();
							  b4.setText(" valider");
							  b4.setBounds(300, 300, 300, 300);
							  b4.setOpaque(true);
							  b4.setBorderPainted(false);
							  b4.setForeground(Color.white);
							  b4.setFont(new Font("Georgia", Font.BOLD, 30));
							  b4.setBackground(new Color(200, 0, 0));

							  frameAjouter.add(b4);
							  b4.addActionListener(new ActionListener() {
								  @Override
								  public void actionPerformed(ActionEvent e) {
									  JFrame frameValider = new JFrame("valider");
									  frameValider.setVisible(true);
									  frameValider.setSize(450, 450);
									  frameValider.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									  frameValider.setVisible(true);
									  frameValider.getContentPane().setBackground(new Color(255, 255, 255));
									  JComboBox<Type> choixType = new JComboBox<>(Type.values());
									  a1.AjouterChambre(Integer.parseInt(j1.getText()), (Type) choixType.getSelectedItem(), Boolean.parseBoolean(j3.getText()), Double.parseDouble(j4.getText()));
									  String[] columnNames = {"Numéro de la chambre", "type de la chambre", "disponibilite", "Prix"};
									  JTable table = new JTable(new ChambreTableModel(Hotel.getListChambres()));
									  for (int i = 0; i < columnNames.length; i++) {
										  table.getColumnModel().getColumn(i).setHeaderValue(columnNames[i]);
									  }

//Ajouter le JTable à un JScrollPane
									  JScrollPane scrollPane = new JScrollPane(table);
									  JPanel panel11 = new JPanel();
									  panel11.setBounds(500, 500, 500, 500);
									  panel11.setBackground(Color.white);
									  panel11.setLayout(new BorderLayout());
									  panel11.add(scrollPane, BorderLayout.NORTH);
									  frameValider.add(panel11);


								  }
							  });


						  }
					  });
				  }
				  if (i == 1) {

					  b1.setText("-supprimer des chambres");
					  b1.setBounds(250, 250, 250, 250);
					  b1.setOpaque(true);
					  b1.setBorderPainted(false);
					  b1.setForeground(Color.white);
					  b1.setFont(new Font("Georgia", Font.BOLD, 15));
					  b1.setBackground(new Color(200, 0, 0));
					  b1.addActionListener(new ActionListener() {
						  @Override
						  public void actionPerformed(ActionEvent e) {
							  JFrame frameSupprimer = new JFrame("supprimer des chambres");
							  frameSupprimer.setSize(450, 450);
							  frameSupprimer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							  frameSupprimer.setVisible(true);
							  frameSupprimer.getContentPane().setBackground(new Color(255, 255, 255));
							  frameSupprimer.setLayout(new GridLayout(2, 1));
							  String[] columnNames = {"Numéro de la chambre", "type de la chambre", "disponibilite", "Prix"};
							  JTable table = new JTable(new ChambreTableModel(Hotel.getListChambres()));
							  for (int i = 0; i < columnNames.length; i++) {
								  table.getColumnModel().getColumn(i).setHeaderValue(columnNames[i]);
							  }

//Ajouter le JTable à un JScrollPane
							  JScrollPane scrollPane = new JScrollPane(table);


							  JPanel panel11 = new JPanel();
							  panel11.setBounds(500, 500, 500, 500);
							  panel11.setBackground(Color.white);
							  panel11.setLayout(new BorderLayout());
							  panel11.add(scrollPane, BorderLayout.NORTH);
							  frameSupprimer.add(panel11);
							  table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

								  @Override
								  public void valueChanged(ListSelectionEvent e) {
									  // Supprimer la ligne sélectionnée
									  if (e.getValueIsAdjusting()) {
										  int selectedRow = table.getSelectedRow();
										  if (selectedRow != -1) {
											  if ((boolean) table.getValueAt(selectedRow, 2)) {
												  // Empêcher la suppression de la ligne
												  //table.getSelectionModel().clearSelection();
												  ((ChambreTableModel) table.getModel()).removeRow(selectedRow);
											  } else {
												  JDialog dialog = new JDialog();
												  dialog.add(new JLabel(" vous pouvez pas supprimer le chambre !! la chambre est reserver"));
												  dialog.setSize(450, 200);
												  dialog.setVisible(true);
											  }
										  }
									  }
								  }

							  });


JButton b = new JButton("valider");
  b.setBounds(250, 250, 250, 250);
	b.setOpaque(true);
 b.setBorderPainted(false);
 b.setForeground(Color.white);
 b.setFont(new Font("Georgia", Font.BOLD, 15));
 b.setBackground(new Color(200, 0, 0));
							  JPanel jS = new JPanel();
							  jS.setLayout(new BorderLayout());
							  jS.add(b, BorderLayout.SOUTH);
							  jS.setBounds(250, 250, 250, 250);

							  frameSupprimer.add(jS);
							  b.addActionListener(new ActionListener() {
								  @Override
								  public void actionPerformed(ActionEvent e) {
									  JFrame frameSV = new JFrame("valider ");
									  frameSV.setSize(450, 450);
									  frameSV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									  frameSV.setVisible(true);
									  frameSV.getContentPane().setBackground(new Color(255, 255, 255));
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


								  }
							  });
						  }
					  });

				  }
				  JButton b4 = new JButton();
				  b4.setText(" valider");
				  b4.setBounds(300, 300, 300, 300);
				  b4.setOpaque(true);
				  b4.setBorderPainted(false);
				  b4.setForeground(Color.white);
				  b4.setFont(new Font("Georgia", Font.BOLD, 30));
				  b4.setBackground(new Color(200, 0, 0));

				  p1.add(b1);
			  }


			  frameChambre.setLayout(new BorderLayout());
			  frameChambre.add(p1, BorderLayout.SOUTH);
			  frameChambre.getContentPane().add(panel11, BorderLayout.NORTH);


///liste des chambres


		  }

	  });
}
}
