package Application;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Administrateur extends Utilisateur{

	
	public static boolean TraiterDemande(Demande d) {
	    int id = d.getIDclient();
	    Datee debut = d.getdatedebut();
    	Datee fin = d.getdatefin();
	    Chambre c1 = d.getchambredemandé();
	    String lachambre=Fichier.findLinesWithPrefixCombined("Chambres", String.valueOf(c1.numero));
	    boolean b=Fichier.CheckAvailabilityofRoom(lachambre,debut.toString(), fin.toString());
	    if (b == true) {  

	        return true;
	    } else {
	        return false;
	    }
	}

	
	public static void AjouterChambre(Type t,double prix) {
		Chambre c = new Chambre(t,prix);
		 Fichier.addToFile("Chambres",c.toString1());

	}
	public static Chambre AjouterChambre1(Type t,double prix) {
		Chambre c = new Chambre(t ,prix);
		 return c;

	}
	
	
	public static void SupprimerChambre(int numero) {
		try {
			Fichier.deleteLineContainingWord("Chambres", String.valueOf(numero));
		}catch(IOException exe) {
			System.out.println("Erreur");
		}		
		
	}

}

