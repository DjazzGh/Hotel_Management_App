 package Application;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class Client extends Utilisateur {
	int ID;
	String Nom;
	String Prenom;
	String Email;
	String NumeroTelephone;
	Datee datenaissance;
	static int D=1;//pour le numero sequentiel de ID
	
	public Client(String Nom,String Prenom,String Email,String NumeroTelephone,Datee datenaissance,String username,String password){
		this.Nom=Nom;
		this.Prenom=Prenom;
		this.Email=Email;
		this.NumeroTelephone=NumeroTelephone;
		this.datenaissance=datenaissance;
		this.NomUtilisateur=username;
		this.motdepasse=password;
		this.ID=D;
		D++;
	}
	
	/*public Client(String Nom,String Prenom,String Email,String NumeroTelephone,Datee datenaissance,int ID)throws NumeroTelephone{
		this.Nom=Nom;
		this.Prenom=Prenom;
		this.Email=Email;
		if( NumeroTelephone.length()!= 10 || !NumeroTelephone.startsWith("0") )
		{
			throw new  NumeroTelephone();
		}
		this.NumeroTelephone=NumeroTelephone;
		//l faut faire une exception
		//this.datenaissance=datenaissance;
		this.ID=D;
		D++;
	}*/
	
	public static boolean DemandeReservation(int ID,Datee debut, Datee fin,Chambre ch) {
		Demande d1=new Demande(ID,debut, fin,ch);
		if(Administrateur.TraiterDemande(d1)==true) {
			return true;			
		}else {
			return false;
		}
	}
	
	public static void ModifierDateReservation(int ID, Datee debut, Datee fin, Chambre c) {
	    Demande d2 = new Demande(ID, debut, fin, c);
	    if (Administrateur.TraiterDemande(d2) == true) {
	    	try {
	    	int a = Fichier.findLineNumberWithWord("Reservations_Clients", String.valueOf(ID));
	    	int b = Fichier.findLineNumberWithWord("Reservations_Clients", c.toString());
	    	if(a==b) {  	
	    	String line=Fichier.lireLigne(a, "Reservations_Clients");
	    	String nouvelleReservation= String.valueOf(ID)+" "+debut.toString()+" "+" "+fin.toString()+" "+c.toString();
	    	Fichier.replaceWordInFile("Reservations_Clients", line,nouvelleReservation );}}
	    	catch(IOException e) {
	    		System.out.println("Erreur");
	    	}
	        }
	     else {
	        System.out.println("Reservation impossible");
	    }
	}

	
	public static void ModifierChambreReservation(int ID, Datee debut, Datee fin, Chambre c) {
	    Demande d3 = new Demande(ID, debut, fin, c);
	    String reservation_a_changer=String.valueOf(ID)+" "+debut+" "+fin;
	    if (Administrateur.TraiterDemande(d3) == true) {   
	    	try {
	    	String line=Fichier.findLineContainingWord("Reservations_Clients",reservation_a_changer );	    	
	    	String nouvelleReservation= String.valueOf(ID)+" "+debut.toString()+" "+" "+fin.toString()+" "+c.toString();
	    	Fichier.replaceWordInFile("Reservations_Clients", line,nouvelleReservation );}
	    	catch(IOException e) {
	    		System.out.println("Erreur");
	    	}
	        }
	     else {
	        System.out.println("Reservation impossible");}}
	    
		public static Client creerClient(String[] champs) throws NumeroTelephone{
		  if (champs.length < 6) {
			    throw new IllegalArgumentException("Champs array must have at least 6 elements");
			  }
		  
		 String nom = champs[1];
		 String prenom = champs[2];
		 String email = champs[3];
		 String numeroTelephone = champs[4];

		  if (numeroTelephone == null || numeroTelephone.isEmpty()) {
		    throw new IllegalArgumentException("Numero de telephone cannot be null or empty");
		  }
		 String[] dateChamps = champs[5].split("/");
		 int jour = Integer.parseInt(dateChamps[0]);
		 int mois = Integer.parseInt(dateChamps[1]);
		 int annee = Integer.parseInt(dateChamps[2]);

		 Datee dateNaissance = new Datee(jour, mois, annee); // Adaptez la construction de la date si nécessaire
		 return new Client(nom, prenom, email, numeroTelephone, dateNaissance);
		}

	
	public void AnnulerReservation(Reservation r) {
		try {
		Fichier.deleteLineContainingWord("Reservations_Clients", r.toString());
		r.c.setDisponibilitétrue(r.debut, r.fin);
		}
		catch(IOException e) {
			System.out.println("Erreur");
		}
	}
	
	 public String getUsername() {
		return NomUtilisateur;}
		 public String getPassword() {
		  return motdepasse;}
		 public String toString() {
			 return ID+" "+Nom+" "+Prenom+" "+Email+" "+NumeroTelephone+" "+datenaissance+" "+NomUtilisateur+" "+motdepasse;
		 }}
