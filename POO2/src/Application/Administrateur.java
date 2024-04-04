package Application;
import java.util.ArrayList;
import java.util.List;
public class Administrateur extends Utilisateur {
	public static boolean TraiterDemande(Demande d) {
	    int id = d.getIDclient();
	    Chambre c1 = d.getchambredemandé();
	    if (c1.getdisponibiltéchambre() == true) {
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
		//Hotel.listChambres.add(c);
		 try {Fichier.AddLineInFile("Chambres.txt",1,c.toString());}
		 catch (IOException e) {
			 System.out.println(e.getMessage());
		 }
	}
	}
	public void SupprimerChambre(Chambre c) {
		//Hotel.listChambres.remove(c);
		int a;
		try { a = Fichier.findLineNumberWithWord("Chambres.txt", c.toString());
		if(a!=-1)
		{
			try {
			Fichier.deleteLineContainingWord("Chambres.txt",c.toString());}
			 catch (IOException e) {
				 System.out.println(e.getMessage());
			 }
		}}
		 catch (IOException e) {
			 System.out.println(e.getMessage());
		 }
		
	}
	}
}
