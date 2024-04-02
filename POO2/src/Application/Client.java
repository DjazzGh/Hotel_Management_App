package Application;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class Client extends Utilisateur {
	int ID;
	String Nom;
	String Prenom;
	String Email;
	String NumeroTelephone;
	Date datenaissance;
	static int D=1;//pour le numero sequentiel de ID
	
	public Client(String Nom,String Prenom,String Email,String NumeroTelephone,Date datenaissance,int ID )throws Numerotelephone ,ageverification{
		this.Nom=Nom;
		this.Prenom=Prenom;
		this.Email=Email;
		 this.ID=D;
                D++;
		if( NumeroTelephone.length()!= 10 || !NumeroTelephone.startsWith("0") )//si la taille de la chaine est 10 et commence par 0
		{
			throw new  Numerotelephone();
		}
		this.NumeroTelephone=NumeroTelephone;
		if (datenaissance.année-Hotel.annee !=18)
			{
			throw new ageverification;}
		this.datenaissance=datenaissance;
                
	}
		public Client(String Nom,String Prenom,String Email,String NumeroTelephone,Date datenaissance,String username,String password){
		this.Nom=Nom;
		this.Prenom=Prenom;
		this.Email=Email;
		this.NumeroTelephone=NumeroTelephone;
		this.datenaissance=datenaissance;
		super.NomUtilisateur=username;
		super.motdepasse=password;
		this.ID=D;
		D++;
	}
	
	public String DemandeReservation(int ID,Date debut, Date fin,Chambre ch) {
		Demande d1=new Demande(ID,debut, fin,ch);
		if(Administrateur.TraiterDemande(d1)==true) {
			return "Réservation confirmé";
		}
		else { return "Reservation impossible";}
	}
	
	public void ModifierDateReservation(int ID, Date debut, Date fin, Chambre c) {
	    Demande d2 = new Demande(ID, debut, fin, c);
	    if (Administrateur.TraiterDemande(d2) == true) {
	        List<Reservation> reservations = Hotel.listClientsReservations.get(ID);
	        if (reservations != null) {
	            for (Reservation r : reservations) {
	                // Check for matching reservation based on ID (assuming unique identifiers)
	                if (r.getId() == ID) {  
	                    r.debut = debut;
	                    r.fin = fin;
	                    return;  
	                }
	            }
	        }
	        System.out.println("Reservation not found for the specified ID.");
	    } else {
	        System.out.println("Reservation impossible");
	    }
	}
	public void ModifierChambreReservation(int ID, Date debut, Date fin, Chambre c) {
	    Demande d3 = new Demande(ID, debut, fin, c);
	    if (Administrateur.TraiterDemande(d3) == true) {
	        List<Reservation> reservations = Hotel.listClientsReservations.get(ID);
	        if (reservations != null) {
	            for (Reservation r : reservations) {
	                // Check for matching start and end dates to identify the correct reservation
	                if (r.debut.equals(debut) && r.fin.equals(fin)) {
	                    r.c = c;  // Modify the room for the specific reservation
	                    return;  // No need to continue iterating
	                }
	            }
	        }
	        System.out.println("Reservation not found for specified dates.");
	    } else {
	        System.out.println("Reservation impossible");
	    }
	}
	public void AnnulerReservation(int ID,Reservation r) {
List<Reservation> reservations = Hotel.listClientsReservations.get(ID); // Get the list of reservations for the given ID
	    if (reservations != null) {
	        reservations.remove(r);  // Remove the specific reservation from the list
	        
	        // If the list is now empty, remove the entire entry for that ID:
	        if (reservations.isEmpty()) {
	            Hotel.listClientsReservations.remove(ID);
	        }
	    }
	}

	public String Feedback() {
		Scanner sc = new Scanner(System.in);
		return sc.next();
		
	}
	public String toString() {
	return ID+" "+Nom+" "+Prenom+" "+Email+" "+NumeroTelephone+" "+datenaissance+" "+NomUtilisateur+" "+motdepasse;
}
}
