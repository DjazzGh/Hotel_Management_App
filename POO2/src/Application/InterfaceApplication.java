package Application;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
public class InterfaceApplication {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FenetreAcceuil frame = new FenetreAcceuil();
            frame.setVisible(true);
        });
    }
}
