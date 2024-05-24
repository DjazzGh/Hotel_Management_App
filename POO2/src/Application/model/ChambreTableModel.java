package Application.model;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ChambreTableModel extends AbstractTableModel {

    private ArrayList<Chambre> chambres =Hotel.getListChambres();

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
        return 3; // Par exemple, pour afficher le numéro, le nom, le type et le prix
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
            	return chambre.getprix();
            
            default:
                return null;
        }
    }
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // Empêcher la modification de la première colonne
        return true;
    }

    public void removeRow(Chambre chambreToRemove) {
        // Find the index of the chambre in the list
        int index = chambres.indexOf(chambreToRemove);

        // Check if the chambre exists in the list
        if (index < 0) {
            return;  // Do nothing if chambre not found
        }

        // Remove the chambre from the list
        chambres.remove(index);

        // Notify listeners of the change (fireTableRowsDeleted with the found index)
        fireTableRowsDeleted(index, index); // Deleted row at the found index
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
               chambre.setNumero((Integer) value);

                break;
            case 1:
                chambre.setTypeChambre((Type) value);
                break;
            case 2:
                
                chambre.setPrix((double) value);
                break;
        }

        // Mettre à jour le modèle de données
        fireTableCellUpdated(row, column); // Notifier le changement d'une seule cellule
    }
    public void addRow(Chambre chambre) {
        // Add the chambre to the list of chambres
        chambres.add(chambre);

        // Notify listeners of the change
        fireTableRowsInserted(chambres.size() - 1, chambres.size() - 1); // Insert a new row at the end
    }



}
