package Application;

public class Client extends Utilisateur {
	int ID;
	String Nom;
	String Prenom;
	String Email;
	int NumeroTelephone;
	Date datenaissance;
	
	public Client(String Nom,String Prenom,String Email,int NumeroTelephone,Date datenaissance ){
		//this.ID=genererID();
		this.Nom=Nom;
		this.Prenom=Prenom;
		this.Email=Email;
		this.NumeroTelephone=NumeroTelephone;
		this.datenaissance=datenaissance;
	}
	
	public String DemandeReservation(int ID,Date debut, Date fin,Chambre ch) {
		Demande d1=new Demande(ID,debut, fin,ch);
		if(Administrateur.TraiterDemande(d1)==true) {
			return "Réservation confirmé";
		}
		else { return "Reservation impossible";}
	}
	
	public void ModifierDateReservation(int ID,Date debut,Date fin,Chambre c) {
		Demande d2=new Demande(ID,debut, fin,c);
		if(Administrateur.TraiterDemande(d2)==true) {
			//On a accede au Hashmap et on modifie date debut et date fin dans la reservation
		}
		else { System.out.println("Reservation impossible");}
		
	}
	public void ModifierChambreReservation(int ID,Date debut,Date fin,Chambre c) {
		Demande d3=new Demande(ID,debut, fin,c);
		if(Administrateur.TraiterDemande(d3)==true) {
			//On a accede au Hashmap et on modifie la chambre dans la reservation
		}
		else { System.out.println("Reservation impossible");}
		
	}
	public void AnnulerReservation(int ID,Reservation r) {
		//Supprimer l'element de hashmap
	}
}
