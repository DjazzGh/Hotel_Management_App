package Application;

public class Demande {
	int ID;
	Date debut;
	Date fin;
	Chambre ch;
	
	public Demande(int ID,Date debut, Date fin,Chambre ch) {
		if(Date.avant(debut,fin)==true) {
			this.ID=ID;
			this.debut=debut;
			this.fin=fin;
			this.ch=ch;
		}
		else {System.out.println("Date invalide");}
		
	}
	public Chambre getchambredemandé() {
		return this.ch;
	}
	public Date getdatedebut() {
		return this.debut;
	}
	
	public Date getdatefin() {
		return this.fin;
	}
	public int getIDclient() {
		return this.ID;
	}
	
	
	
	
}
