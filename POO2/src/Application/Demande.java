package Application;

public class Demande {
	int ID;
	Datee debut;
	Datee fin;
	Chambre ch;
	
	public Demande(int ID,Datee debut, Datee fin,Chambre ch) {
		
			this.ID=ID;
			this.debut=debut;
			this.fin=fin;
			this.ch=ch;
		
		
	}
	public Chambre getchambredemandé() {
		return this.ch;
	}
	public Datee getdatedebut() {
		return this.debut;
	}
	
	public Datee getdatefin() {
		return this.fin;
	}
	public int getIDclient() {
		return ID;
	}
}
	
	
	
	
}
