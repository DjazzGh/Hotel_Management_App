package Application;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
public class ChambreTableModel extends AbstractTableModel {

    private ArrayList<Chambre> chambres;

    public ArrayList<Chambre> getChambres() {
        return chambres;
    }

    public ChambreTableModel(ArrayList<Chambre> chambres) {
        this.chambres = chambres;
    }

    @Override
    public int getRowCount() {
        return chambres.size();
    }

    @Override
    public int getColumnCount() {
        // Définir le nombre de colonnes en fonction des attributs de la classe Chambre
        return 4; // Par exemple, pour afficher le numéro, le nom, le type et le prix
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Chambre chambre = chambres.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return chambre.getnumerochambre();
            case 1:
                return chambre.gettypechambre();
            case 2:
                return chambre.getdisponibiltéchambre();
            case 3:
                return chambre.getprix();
            default:
                return null;
        }
    }
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // Empêcher la modification de la première colonne
        return true;
    }

    public void removeRow(int selectedRow) {
        if (selectedRow < 0 || selectedRow>= chambres.size()) {
            return;}
            chambres.remove(selectedRow);

            // Notifier les listeners du changement
            fireTableRowsDeleted(selectedRow, selectedRow);
    }
    public void setValueAt(Object value, int row, int column) {
        // Vérifier si la cellule est modifiable
        if (!isCellEditable(row, column)) {
            return;
        }

        // Obtenir la chambre à modifier
        Chambre chambre = chambres.get(row);

        // Mettre à jour la valeur de la chambre selon la colonne
        switch (column) {
            case 0:

                break;
            case 1:
                chambre.setTypeChambre((Type) value);
                break;
            case 2:
                chambre.setDisponibilité((boolean) value);
                break;
            case 3:
                chambre.setPrix((double) value);
                break;
        }

        // Mettre à jour le modèle de données
        fireTableCellUpdated(row, column); // Notifier le changement d'une seule cellule
    }
}
