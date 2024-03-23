package Application;

public class Client extends Utilisateur {
	int ID;
	String Nom;
	String Prenom;
	String Email;
	String NumeroTelephone;
	Date datenaissance;
	static int D=0;//pour le numero sequentiel de ID
	
	public Client(String Nom,String Prenom,String Email,String NumeroTelephone,Date datenaissance,int ID )throws Numerotelephone {
		this.Nom=Nom;
		this.Prenom=Prenom;
		this.Email=Email;
		if( NumeroTelephone.length()!= 10 || !NumeroTelephone.startsWith("0") )//si la taille de la chaine est 10 et commence par 0
		{
			throw new  Numerotelephone();
		}
		this.NumeroTelephone=NumeroTelephone;
		this.datenaissance=datenaissance;
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
