package Application;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Facture {
 	static HashMap<Integer,Double> hprix=new HashMap<>();
	public static void main(String [] args) {
	
	for (Map.Entry<Integer, List<Reservation>> entry : Hotel.listClientsReservations.entrySet()) {
	    // Récupérer l'ID du client
	    int idClient = entry.getKey();

	    // Initialiser le prix total pour le client
	    double prixTotal = 0.0;

	    // Récupérer la liste des réservations du client
	    List<Reservation> reservations = entry.getValue();

	    // Parcourir la liste des réservations et ajouter le prix de chaque chambre au prix total
	    for (Reservation reservation : reservations) {
	        prixTotal += reservation.getchambre().getprix();
	    }

	    // Ajouter l'ID du client et le prix total au HashMap des prix
	    hprix.put(idClient, prixTotal);
	    
	}}
}
