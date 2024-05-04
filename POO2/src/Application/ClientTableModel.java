package Application;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ClientTableModel extends AbstractTableModel {
    private ArrayList<Client> clients =Hotel.getMyList();
    @Override
    public int getRowCount() {
        return clients.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Client c= clients.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.ID;
            case 1:
                return c.Nom;
            case 2:
                return c.Prenom;
            case 3:
                return c.Email;
            case 4:
                return c.NumeroTelephone;
            case 5:
                return c.datenaissance;
            default:
                return null;
        }
    }

    public ClientTableModel(ArrayList<Client> clients) {
        this.clients = clients;
    }
}
