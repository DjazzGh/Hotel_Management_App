package Application;
import java.util.ArrayList;
import java.util.List;
public class Administrateur extends Utilisateur {
	public static boolean TraiterDemande(Demande d) {
	    int id = d.getIDclient();
	    Chambre c1 = d.getchambredemandé();
	    if (c1.getdisponibiltéchambre() == false) {
	        Reservation r = new Reservation(d.getdatedebut(), d.getdatefin(), c1, id);
	        List<Reservation> reservations = Hotel.listClientsReservations.get(id);
	        if (reservations == null) {
	            reservations = new ArrayList<>();
	            Hotel.listClientsReservations.put(id, reservations);  
	        }
	        reservations.add(r);
	        return true;
	    } else {
	        return false;
	    }
	}

	public void AjouterChambre(int numero,Type t,boolean disponibilité,double prix) {
		Chambre c = new Chambre(numero, t ,disponibilité,prix);
		Hotel.listChambres.add(c);
	}
	public void SupprimerChambre(Chambre c) {
		Hotel.listChambres.remove(c);
	}
}
