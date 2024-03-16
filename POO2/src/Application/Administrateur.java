package Application;

public class Administrateur extends Utilisateur {
	public static boolean TraiterDemande(Demande d){
		Chambre c1=d.getchambredemandé();
		if(c1.getdisponibiltéchambre()==false) {
			Reservation r = new Reservation(d.getdatedebut(),d.getdatefin(),c1);
			int c2=d.getIDclient();
			//Ajouter au Hashmap le client et sa reservation
			Hotel.h.put(c2, r);
			return true;
		}
		else {
		 return false;
		}
	}
	public void AjouterChambre(int numero,Type t,boolean disponibilité) {
		Chambre c = new Chambre(numero, t ,disponibilité);
		//Ajouter la chambre a la arraylist
		Hotel.h2.add(c);
		
	}
	public void SupprimerChambre(Chambre c) {
		//Supprimer cette chambre de la arraylist
		Hotel.h2.remove(c);
	}
}
