package Application;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Administrateur extends Utilisateur {
	public static boolean TraiterDemande(Demande d) {
	    int id = d.getIDclient();
	    Datee debut = d.getdatedebut();
    	Datee fin = d.getdatefin();
	    Chambre c1 = d.getchambredemandé();
	    if (c1.getdisponibiltéchambre(debut,fin) == true) {  
	    	c1.setDisponibilitéfalse(debut,fin);
	    	Reservation r= new Reservation(id,debut,fin,c1);			
			Fichier.addToFile("Reservations_Clients", r.toString());
	        return true;
	    } else {
	        return false;
	    }
	}

	public static void AjouterChambre(Type t,double prix) {
		Chambre c = new Chambre(t ,prix);
		 Fichier.addToFile("Chambres",c.toString());
	}
	}
	public static void SupprimerChambre(int numero) {
		try {
			Fichier.deleteLineContainingWord("Chambres", String.valueOf(numero));
		}catch(IOException exe) {
			System.out.println("Erreur");
		}	
		
	}
	
}
