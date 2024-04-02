public class FenetreAcceuil extends JFrame{
    public FenetreAcceuil() {
        super("Hotel app");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(800, 650);

        JPanel paneltop = new JPanel();
        paneltop.setLayout(new BorderLayout());
        paneltop.setBackground(Color.white);
        paneltop.setBounds(0, 0, 800, 70);
        add(paneltop, BorderLayout.NORTH);

        JPanel panelbottom = new JPanel();
        panelbottom.setLayout(new BorderLayout());
        panelbottom.setBackground(Color.white);
        panelbottom.setBounds(0, 550, 800, 70);
        add(panelbottom, BorderLayout.SOUTH);

        JPanel panel5 = new JPanel();
        add(panel5, BorderLayout.CENTER);

        // Icon of the main frame
        ImageIcon image = new ImageIcon("icon.png");
        setIconImage(image.getImage());

        // Background Image
        ImageIcon imageIcon = new ImageIcon("thepic.jpeg");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 70, 800, 510);

        // Add components
        LoginButton loginButton = new LoginButton();
        paneltop.add(loginButton, BorderLayout.EAST);

        RentButton rentButton = new RentButton();
        panelbottom.add(rentButton, BorderLayout.EAST);

        add(imageLabel);
    }
}
